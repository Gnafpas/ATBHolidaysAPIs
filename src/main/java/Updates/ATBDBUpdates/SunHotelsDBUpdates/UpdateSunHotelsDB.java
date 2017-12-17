package Updates.ATBDBUpdates.SunHotelsDBUpdates;


import Beans.ATBDBBeans.KalitaonHotel.*;
import Controller.AdminController.AdminController;
import DAOs.SunHotelsAPIDAOs.*;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DBConnection.SunHotelsHibernateUtil;
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
        List<RoombedBean> roombeds=new  ArrayList<>();


        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        TotalExpiredHotels totalExpiredHotels=new TotalExpiredHotels();
        int sunHotelsCommErrCounter = 0;
        int atbDBErrCommCounter = 0;
        int counter = 0;
        long timeElapsed=0;
        long totalProccessWaitingTime=0;
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
        //totalExpiredHotels=DeleteExpiredHotels.deleteExpiredHotels(logger);
        logger.info("********************** Expired hotels procedure ended. **********************");

        //todo update meals
        /**
         * Retrieve features
         */
        try {
            NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
            NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();

            GetFeaturesResult features=nonStaticXMLAPISoap.getFeatures(ProjectProperties.sunhotelsUsername, ProjectProperties.sunhotelspass, "English");
            if (features.getError() != null)
                sunHotelsCommErrCounter++;
            else {
                if(FacilityDAO.deleteAllFacilities())
                    atbDBErrCommCounter++;
                else {
                    for (FeatureWithName feature : features.getFeatures().getFeature()) {
                        facilityBean.setName(feature.getName());
                        facilityBean.setFacilityId(feature.getId());
                        facilityBean.setProviderId(sanHotelsProviderId);
                        if (FacilityDAO.addFacilityBean(facilityBean)){
                            atbDBErrCommCounter++;
                        }
                    }
                }
            }
        }catch(WebServiceException e) {
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

            GetRoomTypesResult roomtypes=nonStaticXMLAPISoap.getRoomTypes(ProjectProperties.sunhotelsUsername, ProjectProperties.sunhotelspass, "English");
            if (roomtypes.getError() != null)
                sunHotelsCommErrCounter++;
            else {
                if(RoomtypeDAO.deleteAllRoomtypes())
                    atbDBErrCommCounter++;
                else {
                    for (RoomType roomtype : roomtypes.getRoomTypes().getRoomType()) {
                        roomtypeBean.setRoomType(roomtype.getName());
                        roomtypeBean.setProviderId(sanHotelsProviderId);
                        roomtypeBean.setRoomtypeId(roomtype.getId());
                        if(roomtype.getSharedRoom()!=0)
                            roomtypeBean.setSharedRoom(true);
                        else
                            roomtypeBean.setSharedRoom(false);
                        if (RoomtypeDAO.addRoomtypeBean(roomtypeBean)){
                            atbDBErrCommCounter++;
                        }
                    }
                }
            }
        }catch(WebServiceException e) {
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
                    destinationBean=DestinationDAO.getDestinationBean(dest.getDestinationId(),sanHotelsProviderId);
                    if(destinationBean!=null){
                        destinationBean.setDestinationId(dest.getDestinationId());
                        destinationBean.setCountryName(dest.getCountryName());
                        destinationBean.setName(dest.getDestinationName());
                        destinationBean.setProviderId(sanHotelsProviderId);
                        destinationBean.setProviderRef(0);
                        destinationBean.setTimezone(dest.getTimeZone());
                        destinationBean.setCountryCode(dest.getCountryCode());
                        if(DestinationDAO.updateDestinationBean(destinationBean))
                            atbDBErrCommCounter++;
                    }else{
                        destinationBean=new DestinationBean();
                        destinationBean.setDestinationId(dest.getDestinationId());
                        destinationBean.setCountryName(dest.getCountryName());
                        destinationBean.setName(dest.getDestinationName());
                        destinationBean.setProviderId(sanHotelsProviderId);
                        destinationBean.setProviderRef(0);
                        destinationBean.setTimezone(dest.getTimeZone());
                        destinationBean.setCountryCode(dest.getCountryCode());
                        if(DestinationDAO.deleteDestinationBean(dest.getDestinationId()))
                            atbDBErrCommCounter++;
                        if(DestinationDAO.addDestinationBean(destinationBean))
                            atbDBErrCommCounter++;
                    }


                    if (RetrieveProducts) {
                        try {
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
                                    hotelBean.setDestinationId(hotel.getDestinationId());
                                    hotelBean.setDistrict("");//todo check this field
                                    hotelBean.setActive(true);
                                    if (hotel.getCoordinates() != null && hotel.getCoordinates().getLatitude() != null && hotel.getCoordinates().getLongitude() != null) {
                                        hotelBean.setLatitude(hotel.getCoordinates().getLatitude().toString());
                                        hotelBean.setLongitude(hotel.getCoordinates().getLongitude().toString());
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
                                            photoBean.setRoomId(0);
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
                                            photoBean.setRoomId(0);
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
                                        hotelfacilityBean.setFacilityId(feature.getId());
                                        hotelfacilities.add(hotelfacilityBean);
                                    }

                                    for (RoomTypeWithRooms roomtype : hotel.getRoomtypes().getRoomtype()) {

                                        for (Room room : roomtype.getRooms().getRoom()) {
                                            RoomBean roomBean = new RoomBean();
                                            roomBean.setRoomTypeId(roomtype.getRoomtypeID());
                                            roomBean.setDescription("");
                                            roomBean.setDirty(false);
                                            roomBean.setHotelId(hotel.getHotelId());
                                            roomBean.setMaxAdultOccupation(0);
                                            roomBean.setMinAdultOccupation(0);
                                            roomBean.setMaxChildOccupation(0);
                                            roomBean.setMinChildOccupation(0);
                                            roomBean.setMaxInfantOccupation(0);
                                            roomBean.setMinInfantOccupation(0);
                                            roomBean.setProviderId(sanHotelsProviderId);
                                            roomBean.setProviderRef(0);
                                            roomBean.setRoomSize(0);
                                            roomBean.setSizeMeasurement("");
                                            roomBean.setOriginalRoomId(room.getId());
                                            rooms.add(roomBean);


                                            RoombedBean roombedBean = new RoombedBean();
                                            roombedBean.setBedCount(room.getBeds());
                                            roombedBean.setBedType("");
                                            roombedBean.setExtraBedCount(0);
                                            roombedBean.setHotelId(hotel.getHotelId());
                                            roombedBean.setRoomId(room.getId());
                                            roombedBean.setProviderId(sanHotelsProviderId);
                                            roombeds.add(roombedBean);
                                        }

                                    }


                                    /**
                                     * Store hotel and hotel properties to DB.If something goes wrong rollback and not update anything to DB.
                                     */
                                    timeElapsed = System.currentTimeMillis();
                                    StatelessSession session = SunHotelsHibernateUtil.getSession();
                                    Transaction tx;
                                    try {
                                        tx = session.beginTransaction();
                                        int currentAtbDBErrCommCounter = atbDBErrCommCounter;
                                        if (HotelDAO.deleteHotelBean(hotelBean.getHotelId(), session)) {
                                            atbDBErrCommCounter++;
                                        } else {
                                            if (HotelDAO.addHotelBean(hotelBean, session)) {
                                                atbDBErrCommCounter++;
                                            } else {
                                                if(HotelmappingDAO.getATBHotelId(hotelBean.getHotelId(),sanHotelsProviderId,session)==0) {
                                                    if (HotelmappingDAO.addHotelmapping(hotelBean.getHotelId(), sanHotelsProviderId, session))
                                                        atbDBErrCommCounter++;
                                                }
                                                if (RoomDAO.addRoomBean(rooms, session))
                                                    atbDBErrCommCounter++;
                                                if (RoombedDAO.addRoombedBean(roombeds, session))
                                                    atbDBErrCommCounter++;
                                                if (HotelfacilityDAO.addHotelfacilityBean(hotelfacilities, session))
                                                    atbDBErrCommCounter++;
                                                if (PhotoDAO.addPhotoBean(photos, session))
                                                    atbDBErrCommCounter++;
                                            }
                                        }
                                        if (currentAtbDBErrCommCounter == atbDBErrCommCounter)
                                            tx.commit();
                                        else
                                            tx.rollback();
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
                                    }
                                    totalProccessWaitingTime = totalProccessWaitingTime + (System.currentTimeMillis() - timeElapsed);
                                    rooms.clear();
                                    roombeds.clear();
                                    hotelfacilities.clear();
                                    photos.clear();
                                }

                            }
                        }catch(WebServiceException e){
                            StringWriter errors = new StringWriter();
                            e.printStackTrace(new PrintWriter(errors));
                            errLogger.info(errors.toString());
                            sunHotelsCommErrCounter++;
                        }
                    }
                    if (StopDestId != 0 && StopDestId == dest.getDestinationId())
                        RetrieveProducts = false;
                    counter++;
                    logger.info("*********************Total destinations completed :" + counter + "Added destination with id:" + dest.getDestinationId()+" ,Total communication time:"+totalProccessWaitingTime/1000+ "*********************");
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
        sunhotelsUpdateInfoBean.setAtbdbCommErrorCounter(atbDBErrCommCounter+totalExpiredHotels.getAtbDBErrCommCounter());
        sunhotelsUpdateInfoBean.setSunhotelsCommErrorCounter(sunHotelsCommErrCounter+totalExpiredHotels.getSunHotelsCommErrCounter());
        sunhotelsUpdateInfoBean.setTotalexpiredHotels(totalExpiredHotels.getTotalExpiredhotels());
        SunhotelsUpdateInfoDAO.addSunhotelsUpdateInfoBean(sunhotelsUpdateInfoBean);

        AdminController.sunHotelsUpdateRunning = false;

    }
}
