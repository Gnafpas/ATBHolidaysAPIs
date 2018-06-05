package Updates.ATBDBUpdates.SunHotelsDBUpdates;


import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.GoogleAPIBeans.AddressComponent;
import Beans.GoogleAPIBeans.ReverseGeoCodeResponse;
import Beans.HereAPIBeans.ReverseGeocodeResponse;
import Beans.HereAPIBeans.View;
import Controller.AdminController.AdminController;
import DAOs.GoogleAPIDAOs.HereAPIDAO;
import DAOs.GoogleAPIDAOs.ReverseGeoCodeAPIDAO;
import DAOs.SunHotelsAPIDAOs.*;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DBConnection.SunHotelsHibernateUtil;
import DBConnection.SunHotelsMainServerHibernateUtil;
import Helper.ProjectProperties;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.xml.ws.WebServiceException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import static Controller.AdminController.AdminController.sunHotelsimidiateUpdateStop;
import static Controller.Application.errLogger;
import static Helper.ProjectProperties.localImagesURL;
import static Helper.ProjectProperties.sanHotelsProviderId;
import static Helper.StoreImage.saveImage;

/**
 * Created by George on 21/11/2017.
 */
public class UpdateSunHotelsDB {

    public static void updateHotelsContent(int StartingDestId,int StopDestId) {

        DestinationBean destinationBean;
        RoomtypeBean roomtypeBean=new RoomtypeBean();
        FacilityBean facilityBean=new FacilityBean();
        HotelfacilityBean hotelfacilityBean;
        List<PhotoBean> photos=new ArrayList<>();
        List<HotelfacilityBean> hotelfacilities=new ArrayList<>();
        List<RoomBean> rooms=new  ArrayList<>();


        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        TotalExpiredHotels totalExpiredHotels=new TotalExpiredHotels();
        int sunHotelsCommErrCounter = 0;
        int atbDBErrCommCounter = 0;
        int counter = 0;
        long timeElapsed=0;
        long totalProccessWaitingTime=0;
        try {
            AdminController.sunHotelsUpdateRunning = true;

            /**
             * Set up logger.
             */
            Logger logger = Logger.getLogger("UpdateSunHotels");
            FileHandler fh;
            try {
                for (Handler handler : logger.getHandlers()) {
                    logger.removeHandler(handler);
                }
                // This block configure the logger with handler and formatter
                fh = new FileHandler(ProjectProperties.logspath + "UpdateSunHotels.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
            } catch (SecurityException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
            } catch (IOException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
            }

            /**
             * Delete expired hotels
             */
            logger.info("********************** Starting delete expired hotels procedure... **********************");
           // totalExpiredHotels = DeleteExpiredHotels.deleteExpiredHotels(logger);
            logger.info("********************** Expired hotels procedure ended. **********************");

            //todo update meals
            /**
             * Retrieve features
             */
            try {
                NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
                NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();

                GetFeaturesResult features = nonStaticXMLAPISoap.getFeatures(ProjectProperties.sunhotelsUsername, ProjectProperties.sunhotelspass, "English");
                List<FacilityBean> facilities=null;
                if (features.getError() != null)
                    sunHotelsCommErrCounter++;
                else {
                    facilities=FacilityDAO.getFacilities(sanHotelsProviderId);
                    if (facilities==null)
                        atbDBErrCommCounter++;
                    else {
                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                        Transaction tx;
                        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                        Transaction tx2;
                        try {
                            tx = session.beginTransaction();
                            tx2 = session2.beginTransaction();
                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;
                            for (FeatureWithName feature : features.getFeatures().getFeature()) {
                                boolean newFacility=true;
                                for(FacilityBean facility:facilities){
                                    if(Integer.parseInt(facility.getFacilityId())==feature.getId()){
                                        facilityBean.setName(feature.getName());
                                        facilityBean.setId(facility.getId());
                                        facilityBean.setFacilityId(String.valueOf(feature.getId()));
                                        facilityBean.setProviderId(sanHotelsProviderId);
                                        if (FacilityDAO.updateFacilityBean(facilityBean, session, session2)) {
                                            atbDBErrCommCounter++;
                                        }
                                        newFacility=false;
                                        break;
                                    }
                                }
                                if(newFacility) {
                                    facilityBean = new FacilityBean();
                                    facilityBean.setName(feature.getName());
                                    facilityBean.setFacilityId(String.valueOf(feature.getId()));
                                    facilityBean.setProviderId(sanHotelsProviderId);
                                    if (FacilityDAO.addFacilityBean(facilityBean, session, session2)) {
                                        atbDBErrCommCounter++;
                                    }
                                }
                            }
                            if (currentAtbDBErrCommCounter == atbDBErrCommCounter) {
                                tx.commit();
                                tx2.commit();
                            } else {
                                tx.rollback();
                                tx2.rollback();
                            }
                        } catch (ExceptionInInitializerError e) {
                            StringWriter errors = new StringWriter();
                            e.printStackTrace(new PrintWriter(errors));
                            errLogger.info(errors.toString());
                            atbDBErrCommCounter++;
                        } catch (ClientTransportException e) {
                            StringWriter errors = new StringWriter();
                            e.printStackTrace(new PrintWriter(errors));
                            errLogger.info(errors.toString());
                            atbDBErrCommCounter++;
                        } catch (CJCommunicationsException e) {
                            StringWriter errors = new StringWriter();
                            e.printStackTrace(new PrintWriter(errors));
                            errLogger.info(errors.toString());
                            atbDBErrCommCounter++;
                        } finally {
                            session.close();
                            session2.close();
                        }
                    }
                }
            } catch (WebServiceException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
                sunHotelsCommErrCounter++;
            }

            /**
             * Retrieve RoomTypes
             */
            try {
                NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
                NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();

                GetRoomTypesResult roomtypes = nonStaticXMLAPISoap.getRoomTypes(ProjectProperties.sunhotelsUsername, ProjectProperties.sunhotelspass, "English");
                if (roomtypes.getError() != null)
                    sunHotelsCommErrCounter++;
                else {
                    StatelessSession session = SunHotelsHibernateUtil.getSession();
                    Transaction tx;
                    StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                    Transaction tx2;
                    try {
                        tx = session.beginTransaction();
                        tx2 = session2.beginTransaction();
                        int currentAtbDBErrCommCounter = atbDBErrCommCounter;
                        for (RoomType roomtype : roomtypes.getRoomTypes().getRoomType()) {
                            roomtypeBean = new RoomtypeBean();
                            roomtypeBean.setRoomType(roomtype.getName());
                            roomtypeBean.setProviderId(sanHotelsProviderId);
                            roomtypeBean.setRoomtypeId(String.valueOf(roomtype.getId()));
                            roomtypeBean.setRoomSize(0);
                            roomtypeBean.setSizeMeasurement("");
                            roomtypeBean.setDescription("");
                            if (roomtype.getSharedRoom() != 0)
                                roomtypeBean.setSharedRoom(true);
                            else
                                roomtypeBean.setSharedRoom(false);
                            RoomtypeBean existedroomType=RoomtypeDAO.getRoomsTypesbyId(roomtypeBean.getRoomtypeId(),sanHotelsProviderId,session);
                            if(existedroomType!=null && existedroomType.getId()!=0){
                                roomtypeBean.setId(existedroomType.getId());
                                if (RoomtypeDAO.updateRoomtypeBean(roomtypeBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                }
                            }else {
                                if (RoomtypeDAO.addRoomtypeBean(roomtypeBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                }
                            }
                        }
                        if (currentAtbDBErrCommCounter == atbDBErrCommCounter) {
                            tx.commit();
                            tx2.commit();
                        } else {
                            tx.rollback();
                            tx2.rollback();
                        }
                    } catch (ExceptionInInitializerError e) {
                        StringWriter errors = new StringWriter();
                        e.printStackTrace(new PrintWriter(errors));
                        errLogger.info(errors.toString());
                        atbDBErrCommCounter++;
                    } catch (ClientTransportException e) {
                        StringWriter errors = new StringWriter();
                        e.printStackTrace(new PrintWriter(errors));
                        errLogger.info(errors.toString());
                        atbDBErrCommCounter++;
                    } catch (CJCommunicationsException e) {
                        StringWriter errors = new StringWriter();
                        e.printStackTrace(new PrintWriter(errors));
                        errLogger.info(errors.toString());
                        atbDBErrCommCounter++;
                    } finally {
                        session.close();
                        session2.close();
                    }
                }
            } catch (WebServiceException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
                sunHotelsCommErrCounter++;
            }

            /**
             * Declare from which point in the destinations list start to retrieving destination's products and at which destination to stop.If  destIdToStartRetrieveProducts
             * is 0 and destIdToStopRetrieveProducts is 0 retrieve products from all destinations.Else retrieve products for the destinations in the list which are following the one
             * with destination Id "destIdToStartRetrieveProducts" and stop at destination with destination Id"destIdToStopRetrieveProducts".
             */
            boolean RetrieveProducts;
            if (StartingDestId == 0)
                RetrieveProducts = true;
            else
                RetrieveProducts = false;

            try {
                NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
                NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();

                /**
                 * Retrieve destinations
                 */
                DestinationList destinationList = nonStaticXMLAPISoap.getDestinations(ProjectProperties.sunhotelsUsername,
                        ProjectProperties.sunhotelspass, "English",
                        "", "", "", "");

                if (destinationList.getError() != null)
                    sunHotelsCommErrCounter++;
                else {


                    /**
                     * Update Hotels for each destination
                     */
                    for (Destination dest : destinationList.getDestinations().getDestination()) {

                        if (StartingDestId == dest.getDestinationId())
                            RetrieveProducts = true;

                        if (sunHotelsimidiateUpdateStop)
                            break;

                        /**
                         * Update Destinations
                         */
                        destinationBean = DestinationDAO.getDestinationBean(String.valueOf(dest.getDestinationId()), sanHotelsProviderId, null);
                        if (destinationBean != null) {
                            destinationBean.setDestinationId(dest.getDestinationId());
                            destinationBean.setCountryName(dest.getCountryName());
                            destinationBean.setName(dest.getDestinationName());
                            destinationBean.setProviderId(sanHotelsProviderId);
                            destinationBean.setProviderRef(0);
                            destinationBean.setTimezone(dest.getTimeZone());
                            destinationBean.setCountryCode(dest.getCountryCode());
                            if (DestinationDAO.updateDestinationBean(destinationBean))
                                atbDBErrCommCounter++;
                        } else {
                            destinationBean = new DestinationBean();
                            destinationBean.setDestinationId(dest.getDestinationId());
                            destinationBean.setCountryName(dest.getCountryName());
                            destinationBean.setName(dest.getDestinationName());
                            destinationBean.setProviderId(sanHotelsProviderId);
                            destinationBean.setProviderRef(0);
                            destinationBean.setTimezone(dest.getTimeZone());
                            destinationBean.setCountryCode(dest.getCountryCode());
                            if (DestinationDAO.deleteDestinationBeanSunhotelsId(dest.getDestinationId()))
                                atbDBErrCommCounter++;
                            if (DestinationDAO.addDestinationBean(destinationBean))
                                atbDBErrCommCounter++;
                        }


                        if (RetrieveProducts) {
                            try {
                                /**
                                 * Update Resorts
                                 */
                                ResortList resorts = nonStaticXMLAPISoap.getResorts(ProjectProperties.sunhotelsUsername, ProjectProperties.sunhotelspass,
                                        "English", "", String.valueOf(dest.getDestinationId()), "",
                                        "", "");
                                if (resorts.getError() != null)
                                    sunHotelsCommErrCounter++;
                                else {
                                    ResortBean resortBean = new ResortBean();
                                    for (Resort resort : resorts.getResorts().getResort()) {
                                        resortBean.setCountryCode(resort.getCountryCode());
                                        resortBean.setCountryName(resort.getCountryName());
                                        resortBean.setDestinationId(resort.getDestinationId());
                                        resortBean.setDestinationName(resort.getDestinationName());
                                        resortBean.setProviderId(sanHotelsProviderId);
                                        resortBean.setResortId(resort.getResortId());
                                        resortBean.setResortName(resort.getResortName());
                                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                                        Transaction tx;
                                        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                                        Transaction tx2;
                                        try {
                                            tx = session.beginTransaction();
                                            tx2 = session2.beginTransaction();
                                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;
                                            if (ResortDAO.deleteResortBean(resortBean.getResortId(), sanHotelsProviderId, session, session2)) {
                                                atbDBErrCommCounter++;
                                            } else {
                                                if (ResortDAO.addResortBean(resortBean, session, session2)) {
                                                    atbDBErrCommCounter++;
                                                } else {
                                                    if (ResortMappingDAO.getATBResortId(resortBean.getResortId(), sanHotelsProviderId, session) == 0) {
                                                        if (ResortMappingDAO.addResortMapping(String.valueOf(resortBean.getResortId()), sanHotelsProviderId, session, session2))
                                                            atbDBErrCommCounter++;
                                                    }
                                                }
                                            }
                                            if (currentAtbDBErrCommCounter == atbDBErrCommCounter) {
                                                tx.commit();
                                                tx2.commit();
                                            } else {
                                                tx.rollback();
                                                tx2.rollback();
                                            }
                                        } catch (ExceptionInInitializerError e) {
                                            StringWriter errors = new StringWriter();
                                            e.printStackTrace(new PrintWriter(errors));
                                            errLogger.info(errors.toString());
                                            atbDBErrCommCounter++;
                                        } catch (ClientTransportException e) {
                                            StringWriter errors = new StringWriter();
                                            e.printStackTrace(new PrintWriter(errors));
                                            errLogger.info(errors.toString());
                                            atbDBErrCommCounter++;
                                        } catch (CJCommunicationsException e) {
                                            StringWriter errors = new StringWriter();
                                            e.printStackTrace(new PrintWriter(errors));
                                            errLogger.info(errors.toString());
                                            atbDBErrCommCounter++;
                                        } finally {
                                            session.close();
                                            session2.close();
                                        }
                                    }
                                }


                                GetStaticHotelsAndRoomsResult getStaticHotelsAndRoomsResult = nonStaticXMLAPISoap.
                                        getStaticHotelsAndRooms(ProjectProperties.sunhotelsUsername,
                                                ProjectProperties.sunhotelspass,
                                                "English",
                                                String.valueOf(dest.getDestinationId()),
                                                "", "",
                                                "", "",
                                                "", "");
                                if (getStaticHotelsAndRoomsResult.getError() != null)
                                    sunHotelsCommErrCounter++;
                                else {
                                    for (StaticHotel hotel : getStaticHotelsAndRoomsResult.getHotels().getHotel()) {

                                        if (sunHotelsimidiateUpdateStop)
                                            break;

                                        HotelBean hotelBean = new HotelBean();
                                        hotelBean.setCity((hotel.getHotelAddrCity()));
                                        hotelBean.setHotelId(hotel.getHotelId());
                                        hotelBean.setName(hotel.getName());
                                        hotelBean.setAddress(hotel.getHotelAddress());
                                        hotelBean.setCountry(hotel.getHotelAddrCountry());
                                        hotelBean.setCountryCode(hotel.getHotelAddrCountrycode());
                                        hotelBean.setCurrencyId(0);//todo check this field
                                        hotelBean.setDescription(hotel.getDescription());
                                        hotelBean.setDestinationId(String.valueOf(hotel.getDestinationId()));
                                        hotelBean.setDistrict("");
                                        hotelBean.setAccommodationId("HOTEL");
                                        hotelBean.setAccommodationName("HOTEL");
                                        hotelBean.setActive(true);
                                        hotelBean.setResortId(hotel.getResortId());
                                        if (hotel.getCoordinates() != null && hotel.getCoordinates().getLatitude() != null && hotel.getCoordinates().getLongitude() != null) {
                                            hotelBean.setLatitude(hotel.getCoordinates().getLatitude().toString());
                                            hotelBean.setLongitude(hotel.getCoordinates().getLongitude().toString());
                                        }
                                        /**
                                         * Get District from google reverse geocode
                                         */
                                        if(hotelBean.getLatitude()!=null && !hotelBean.getLatitude().equals("") && hotelBean.getLongitude()!=null && !hotelBean.getLongitude().equals("")) {
                                            ReverseGeocodeResponse reverseGeocodeResponse = HereAPIDAO.getReverseGeoCode(hotelBean.getLatitude(), hotelBean.getLongitude());
                                            if (reverseGeocodeResponse != null ) {
                                                if(reverseGeocodeResponse.getResponse().getView()!=null && reverseGeocodeResponse.getResponse().getView().size()>0) {
                                                    for (View view : reverseGeocodeResponse.getResponse().getView()) {
                                                        if(view.getResult()!=null && view.getResult().size()>0) {
                                                            for (Beans.HereAPIBeans.Result res : view.getResult()) {
                                                                if(res.getLocation()!=null && res.getLocation().getAddress()!=null ){
                                                                    hotelBean.setDistrict(res.getLocation().getAddress().getDistrict());
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        hotelBean.setMapUrl(hotel.getHotelMapurl());
                                        hotelBean.setMealType("");
                                        hotelBean.setProviderId(sanHotelsProviderId);
                                        hotelBean.setProviderRef(0);
                                        hotelBean.setStarRating(hotel.getClassification());
                                        hotelBean.setState(hotel.getHotelAddrState());
                                        hotelBean.setZipCode(hotel.getHotelAddrZip());
                                        hotelBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
                                        hotelBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));

                                        for (HotelImage image : hotel.getImages().getImage()) {
                                            PhotoBean photoBean = new PhotoBean();
                                            photoBean.setHotelId(hotel.getHotelId());
                                            if (image.getFullSizeImage() != null && image.getFullSizeImage().getUrl() != null) {
                                                photoBean.setDescription("");
                                                photoBean.setFacilityId(0);
                                                photoBean.setHotelId(hotel.getHotelId());
                                                photoBean.setProviderId(sanHotelsProviderId);
                                                photoBean.setCoverPhoto(false);
                                                photoBean.setPhotoPath("");
                                                photoBean.setPhotoUrl(ProjectProperties.sanHotelsImageURL + image.getFullSizeImage().getUrl());
                                                photoBean.setRoomTypeId("0");
                                                photoBean.setTitle("");
                                                photos.add(photoBean);
                                            } else if (image.getSmallImage() != null && image.getSmallImage().getUrl() != null) {
                                                photoBean.setDescription("");
                                                photoBean.setFacilityId(0);
                                                photoBean.setHotelId(hotel.getHotelId());
                                                photoBean.setProviderId(sanHotelsProviderId);
                                                photoBean.setCoverPhoto(false);
                                                photoBean.setPhotoPath("");
                                                photoBean.setPhotoUrl(ProjectProperties.sanHotelsImageURL + image.getSmallImage().getUrl());
                                                photoBean.setRoomTypeId("0");
                                                photoBean.setTitle("");
                                                photos.add(photoBean);
                                            }
                                        }

                                        for (FeatureWithName feature : hotel.getFeatures().getFeature()) {
                                            hotelfacilityBean = new HotelfacilityBean();
                                            hotelfacilityBean.setHotelId(hotel.getHotelId());
                                            hotelfacilityBean.setProviderId(sanHotelsProviderId);
                                            hotelfacilityBean.setExplanation(feature.getName());
                                            hotelfacilityBean.setPrice(new BigDecimal(0.0));
                                            hotelfacilityBean.setFacilityId(String.valueOf(feature.getId()));
                                            hotelfacilities.add(hotelfacilityBean);
                                        }

                                        for (RoomTypeWithRooms roomtype : hotel.getRoomtypes().getRoomtype()) {

                                            for (Room room : roomtype.getRooms().getRoom()) {
                                                RoomBean roomBean = new RoomBean();
                                                roomBean.setRoomTypeId(String.valueOf(roomtype.getRoomtypeID()));
                                                roomBean.setDirty(false);
                                                roomBean.setHotelId(hotel.getHotelId());
                                                roomBean.setProviderId(sanHotelsProviderId);
                                                roomBean.setProviderRef(0);
                                                roomBean.setOriginalRoomId(String.valueOf(room.getId()));
                                                roomBean.setMinAdultOccupation(0);
                                                roomBean.setMinChildOccupation(0);
                                                roomBean.setMinInfantOccupation(0);
                                                roomBean.setMaxAdultOccupation(0);
                                                roomBean.setMaxChildOccupation(0);
                                                roomBean.setMaxInfantOccupation(0);
                                                rooms.add(roomBean);

                                            }

                                        }


                                        /**
                                         * Store hotel and hotel properties to DB.If something goes wrong rollback and not update anything to DB.
                                         */
                                        timeElapsed = System.currentTimeMillis();
                                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                                        Transaction tx;
                                        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                                        Transaction tx2;
                                        try {
                                            tx = session.beginTransaction();
                                            tx2 = session2.beginTransaction();
                                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;
                                            if (HotelDAO.deleteHotelBean(hotelBean.getHotelId(), session, session2, sanHotelsProviderId)) {
                                                atbDBErrCommCounter++;
                                            } else {
                                                if (HotelDAO.addHotelBean(hotelBean, session, session2)) {
                                                    atbDBErrCommCounter++;
                                                } else {
                                                    if (HotelmappingDAO.getATBHotelId(hotelBean.getHotelId(), sanHotelsProviderId, session) == 0) {
                                                        if (HotelmappingDAO.addHotelmapping(hotelBean.getHotelId(), sanHotelsProviderId, session, session2))
                                                            atbDBErrCommCounter++;
                                                    }
                                                    if (RoomDAO.addRoomBean(rooms, session, session2))
                                                        atbDBErrCommCounter++;
                                                    if (HotelfacilityDAO.addHotelfacilityBean(hotelfacilities, session, session2))
                                                        atbDBErrCommCounter++;
                                                    if (PhotoDAO.addPhotoBean(photos, session, session2))
                                                        atbDBErrCommCounter++;
                                                }
                                            }
                                            if (currentAtbDBErrCommCounter == atbDBErrCommCounter) {
                                                tx.commit();
                                                tx2.commit();
                                            } else {
                                                tx.rollback();
                                                tx2.rollback();
                                            }
                                        } catch (ExceptionInInitializerError e) {
                                            StringWriter errors = new StringWriter();
                                            e.printStackTrace(new PrintWriter(errors));
                                            errLogger.info(errors.toString());
                                            atbDBErrCommCounter++;
                                        } catch (ClientTransportException e) {
                                            StringWriter errors = new StringWriter();
                                            e.printStackTrace(new PrintWriter(errors));
                                            errLogger.info(errors.toString());
                                            atbDBErrCommCounter++;
                                        } catch (CJCommunicationsException e) {
                                            StringWriter errors = new StringWriter();
                                            e.printStackTrace(new PrintWriter(errors));
                                            errLogger.info(errors.toString());
                                            atbDBErrCommCounter++;
                                        } finally {
                                            session.close();
                                            session2.close();
                                        }
                                        totalProccessWaitingTime = totalProccessWaitingTime + (System.currentTimeMillis() - timeElapsed);
                                        rooms.clear();
                                        hotelfacilities.clear();
                                        photos.clear();
                                    }

                                }
                            } catch (WebServiceException e) {
                                StringWriter errors = new StringWriter();
                                e.printStackTrace(new PrintWriter(errors));
                                errLogger.info(errors.toString());
                                sunHotelsCommErrCounter++;
                            }
                        }
                        if (StopDestId != 0 && StopDestId == dest.getDestinationId())
                            RetrieveProducts = false;
                        counter++;
                        logger.info("*********************Total destinations completed :" + counter + "Added destination with id:" + dest.getDestinationId() + " ,Total communication time:" + totalProccessWaitingTime / 1000 + "*********************");
                    }
                }
            } catch (WebServiceException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
                sunHotelsCommErrCounter++;
            }

            SunhotelsUpdateInfoBean sunhotelsUpdateInfoBean = new SunhotelsUpdateInfoBean();
            sunhotelsUpdateInfoBean.setStartDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
            dateTime = new DateTime();
            sunhotelsUpdateInfoBean.setEndDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
            sunhotelsUpdateInfoBean.setAtbdbCommErrorCounter(atbDBErrCommCounter + totalExpiredHotels.getAtbDBErrCommCounter());
            sunhotelsUpdateInfoBean.setSunhotelsCommErrorCounter(sunHotelsCommErrCounter + totalExpiredHotels.getSunHotelsCommErrCounter());
            sunhotelsUpdateInfoBean.setTotalexpiredHotels(totalExpiredHotels.getTotalExpiredhotels());
            SunhotelsUpdateInfoDAO.addSunhotelsUpdateInfoBean(sunhotelsUpdateInfoBean);

            AdminController.sunHotelsUpdateRunning = false;
        }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }

    }
}
