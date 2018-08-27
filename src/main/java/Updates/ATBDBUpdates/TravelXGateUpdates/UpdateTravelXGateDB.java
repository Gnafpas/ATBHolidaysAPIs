package Updates.ATBDBUpdates.TravelXGateUpdates;

import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.TravelGateXBeans.Amenity;
import Beans.TravelGateXBeans.Edge;
import Beans.TravelGateXBeans.Media;
import Beans.TravelGateXBeans.ResponseAPIJSON;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.TravelGateXDAOs.StaticContentDAOs;
import DBConnection.SunHotelsHibernateUtil;
import Helper.ProjectProperties;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.travelXGateProviderId;

/**
 * Created by George on 09/07/2018.
 */
public class UpdateTravelXGateDB {


    public static void test() {


        try {
            /**
             * Set up logger.
             */
            Logger logger = Logger.getLogger("UpdateTravelXGate");
            FileHandler fh;
            try {
                for (Handler handler : logger.getHandlers()) {
                    logger.removeHandler(handler);
                }
                // This block configure the logger with handler and formatter
                fh = new FileHandler(ProjectProperties.logspath + "UpdateTravelXGate.log");
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
            // totalExpiredHotels = Updates.ATBDBUpdates.HotelBedsDBUpdates.DeleteExpiredHotels.deleteExpiredHotels(logger);
            logger.info("********************** Expired hotels procedure ended. **********************");


            int totalresults = 0;
            logger.info("********************** Starting Destinations Update... **********************");
            ResponseAPIJSON destinations = StaticContentDAOs.destinations();
            int atbDBErrCommCounter = 0;
            int entityCounter = 0;
            int travelXGateCommErrCounter = 0;
            List<String> allDestinationCodes = new ArrayList<>();


            List<DestinationBean> allDestinationBeans = DestinationDAO.getAllDestinations();
            DestinationBean destinationBean;
            if (destinations != null && destinations.getData() != null && destinations.getData().getHotelX() != null && destinations.getData().getHotelX().getDestinations() != null && destinations.getData().getHotelX().getDestinations().getEdges() != null) {

                if (allDestinationBeans != null) {
                    boolean destExists;
                    for (Beans.TravelGateXBeans.Edge edge : destinations.getData().getHotelX().getDestinations().getEdges()) {

                        destExists = false;

                        if (edge.getNode() != null && edge.getNode().getDestinationData() != null && edge.getNode().getDestinationData().getParent() != null && edge.getNode().getDestinationData().getTexts() != null && edge.getNode().getDestinationData().getTexts().size() > 0 && edge.getNode().getDestinationData().getType().equals("CITY")) {

                            allDestinationCodes.add(edge.getNode().getDestinationData().getCode());

                            // System.out.print(edge.getNode().getDestinationData().getTexts().get(0).getText());
                            for (DestinationBean destBean : allDestinationBeans) {
                                if (destBean.getTravelXGateCode() != null && destBean.getTravelXGateCode().equals(edge.getNode().getDestinationData().getCode())) {
                                    destExists = true;
                                    break;
                                }
                                if (!destExists) {

                                    String[] dbDestName = null;
                                    String[] travelXGateDestName = null;
                                    if (destBean.getName() != null)
                                        dbDestName = destBean.getName().split("( )|(\\()|(\\))|(-)");
                                    if (edge.getNode().getDestinationData().getTexts().get(0).getText() != null)
                                        travelXGateDestName = edge.getNode().getDestinationData().getTexts().get(0).getText().split("( )|(\\()|(\\))|(-)");


                                    boolean wordExists = false;
                                    if (dbDestName != null && travelXGateDestName != null) {
                                        for (int k = 0; k < dbDestName.length; k++) {
                                            if (dbDestName.equals(""))
                                                continue;
                                            wordExists = false;
                                            for (int j = 0; j < travelXGateDestName.length; j++) {

                                                if (dbDestName[k].equals(travelXGateDestName[j]))
                                                    wordExists = true;
                                            }
                                            if (!wordExists)
                                                break;
                                        }
                                        if (wordExists && destBean.getCountryCode().equals(edge.getNode().getDestinationData().getParent())) {
                                            destBean.setTravelXGateCode(edge.getNode().getDestinationData().getCode());
                                            if (DestinationDAO.updateDestinationBean(destBean))
                                                atbDBErrCommCounter++;
                                            else
                                                entityCounter++;
                                            destExists = true;
                                            break;
                                        }
                                    } else {
                                        destExists = true;
                                        break;
                                    }
                                }
                            }


                            if (!destExists) {
                                destinationBean = new DestinationBean();
                                destinationBean.setTravelXGateCode(edge.getNode().getDestinationData().getCode());
                                destinationBean.setCountryName(edge.getNode().getDestinationData().getParent());
                                destinationBean.setName(edge.getNode().getDestinationData().getTexts().get(0).getText());
                                destinationBean.setProviderId(travelXGateProviderId);
                                destinationBean.setProviderRef(0);
                                destinationBean.setTimezone("");
                                destinationBean.setCountryCode(edge.getNode().getDestinationData().getParent());
                                if (DestinationDAO.addDestinationBean(destinationBean))
                                    atbDBErrCommCounter++;
                                else
                                    entityCounter++;
                            }
                        }
                    }
                } else
                    atbDBErrCommCounter++;
            } else
                travelXGateCommErrCounter++;
            logger.info("********************** Destinations Update ended. " + entityCounter + " destinations updated/added **********************");


            logger.info("********************** Starting RoomTypes Update... **********************");
            totalresults = 0;
            entityCounter = 0;
            RoomtypeBean roomtypeBean;
            ResponseAPIJSON roomTypesAPIJSON = StaticContentDAOs.roomtypes();

            if (roomTypesAPIJSON != null && roomTypesAPIJSON.getData() != null && roomTypesAPIJSON.getData().getHotelX() != null && roomTypesAPIJSON.getData().getHotelX().getRooms() != null && roomTypesAPIJSON.getData().getHotelX().getRooms().getEdges() != null) {
                totalresults = roomTypesAPIJSON.getData().getHotelX().getRooms().getEdges().size();
                for (Edge edge : roomTypesAPIJSON.getData().getHotelX().getRooms().getEdges()) {

                    if (edge.getNode().getRoomData().getTexts() != null && edge.getNode().getRoomData().getTexts().size() > 0) {

                        roomtypeBean = new RoomtypeBean();
                        roomtypeBean.setRoomtypeId(edge.getNode().getRoomData().getRoomCode());
                        roomtypeBean.setDescription("");
                        roomtypeBean.setProviderId(travelXGateProviderId);
                        roomtypeBean.setRoomSize(0);
                        roomtypeBean.setRoomType(edge.getNode().getRoomData().getTexts().get(0).getText());
                        roomtypeBean.setSharedRoom(false);
                        roomtypeBean.setSizeMeasurement("");
                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                        Transaction tx;
                        try {
                            tx = session.beginTransaction();
                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;

                            RoomtypeBean existedroomType = RoomtypeDAO.getRoomsTypesbyId(roomtypeBean.getRoomtypeId(), travelXGateProviderId, session);
                            if (existedroomType != null && existedroomType.getId() != 0) {
                                roomtypeBean.setId(existedroomType.getId());
                                if (RoomtypeDAO.updateRoomtypeBean(roomtypeBean, session, null)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
                            } else {
                                if (RoomtypeDAO.addRoomtypeBean(roomtypeBean, session, null)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
                            }
                            if (currentAtbDBErrCommCounter == atbDBErrCommCounter) {
                                tx.commit();
                            } else {
                                tx.rollback();
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
                        }
                    }
                }
            } else
                travelXGateCommErrCounter++;

            logger.info("********************** RoomTypes Update ended. " + entityCounter + " roomTypes added/updated **********************");

            logger.info("********************** Starting Meals Update... **********************");
            totalresults = 0;
            entityCounter = 0;

            MealBean mealBean = new MealBean();
            ResponseAPIJSON boardsAPIJSON = StaticContentDAOs.boards();
            if (boardsAPIJSON != null && boardsAPIJSON.getData() != null && boardsAPIJSON.getData().getHotelX() != null && boardsAPIJSON.getData().getHotelX().getBoards() != null && boardsAPIJSON.getData().getHotelX().getBoards().getEdges() != null) {
                totalresults = boardsAPIJSON.getData().getHotelX().getBoards().getEdges().size();
                for (Edge edge : boardsAPIJSON.getData().getHotelX().getBoards().getEdges()) {


                    if (edge.getNode().getBoardData().getTexts() != null && edge.getNode().getBoardData().getTexts().size() > 0) {
                        mealBean = new MealBean();
                        mealBean.setName(edge.getNode().getBoardData().getTexts().get(0).getText());
                        mealBean.setProviderId(travelXGateProviderId);
                        mealBean.setMealId(edge.getNode().getBoardData().getBoardCode());

                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                        Transaction tx;
                        try {
                            tx = session.beginTransaction();

                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;

                            MealBean existedMeal = MealDAO.getMealByMealId(mealBean.getMealId(), travelXGateProviderId, session);
                            if (existedMeal != null && existedMeal.getId() != 0) {
                                mealBean.setId(existedMeal.getId());
                                if (MealDAO.updateMealBean(mealBean, session, null)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
                            } else {
                                if (MealDAO.addMealBean(mealBean, session, null)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
                            }
                            if (currentAtbDBErrCommCounter == atbDBErrCommCounter) {
                                tx.commit();
                            } else {
                                tx.rollback();
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
                        }
                    }
                }
            } else
                travelXGateCommErrCounter++;

            logger.info("********************** Meals Update ended. " + entityCounter + " meals added/updated **********************");


            logger.info("********************** Starting Hotels Update... **********************");
            totalresults = 0;
            entityCounter = 0;
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            for (String destinationCode : allDestinationCodes) {

                HotelBean hotelBean;//todo see if It's better t add last updated dates
                ResponseAPIJSON hotelsAPIJSON = StaticContentDAOs.hotels(destinationCode);

                if (hotelsAPIJSON != null && hotelsAPIJSON.getData() != null && hotelsAPIJSON.getData().getHotelX() != null && hotelsAPIJSON.getData().getHotelX().getHotels() != null && hotelsAPIJSON.getData().getHotelX().getHotels().getEdges() != null) {
                    totalresults = totalresults + hotelsAPIJSON.getData().getHotelX().getHotels().getEdges().size();
                    logger.info("********************** Adding hotels from " + totalresults + " **********************");
                    for (Edge edge : hotelsAPIJSON.getData().getHotelX().getHotels().getEdges()) {
                        hotelBean = new HotelBean();
                        hotelBean.setCity((edge.getNode().getHotelData().getLocation().getCity()));
                        hotelBean.setHotelId(Integer.parseInt(edge.getNode().getHotelData().getHotelCode()));
                        hotelBean.setName(edge.getNode().getHotelData().getHotelName());
                        hotelBean.setAddress(edge.getNode().getHotelData().getLocation().getAddress());
                        hotelBean.setCountry(edge.getNode().getHotelData().getLocation().getCountry());//todo
                        hotelBean.setCountryCode(edge.getNode().getHotelData().getLocation().getCountry());
                        hotelBean.setAccommodationId("HOTEL");
                        hotelBean.setAccommodationName("HOTEL");

                        hotelBean.setCurrencyId(0);//todo check this field
                        if (edge.getNode().getHotelData().getDescriptions() != null && edge.getNode().getHotelData().getDescriptions().size() > 0 && edge.getNode().getHotelData().getDescriptions().get(0).getTexts().size() > 0)
                            hotelBean.setDescription(edge.getNode().getHotelData().getDescriptions().get(0).getTexts().get(0).getText());
                        else
                            hotelBean.setDescription("");
                        hotelBean.setDestinationId(edge.getNode().getHotelData().getLocation().getClosestDestination().getCode());
                        hotelBean.setDistrict("");
                        hotelBean.setActive(true);
                        hotelBean.setResortId(0);
                        if (edge.getNode().getHotelData().getLocation().getCoordinates() != null && edge.getNode().getHotelData().getLocation().getCoordinates().getLatitude().toString() != null && edge.getNode().getHotelData().getLocation().getCoordinates().getLongitude().toString() != null) {
                            hotelBean.setLatitude(edge.getNode().getHotelData().getLocation().getCoordinates().getLatitude().toString());
                            hotelBean.setLongitude(edge.getNode().getHotelData().getLocation().getCoordinates().getLongitude().toString());
                        }

                        /**
                         * Get District from google reverse geocode
                         */
//                        if(hotelBean.getLatitude()!=null && !hotelBean.getLatitude().equals("") && hotelBean.getLongitude()!=null && !hotelBean.getLongitude().equals("")) {
//                            ReverseGeocodeResponse reverseGeocodeResponse = HereAPIDAO.getReverseGeoCode(hotelBean.getLatitude(), hotelBean.getLongitude());
//                            if (reverseGeocodeResponse != null ) {
//                                if(reverseGeocodeResponse.getResponse().getView()!=null && reverseGeocodeResponse.getResponse().getView().size()>0) {
//                                    for (View view : reverseGeocodeResponse.getResponse().getView()) {
//                                        if(view.getResult()!=null && view.getResult().size()>0) {
//                                            for (Beans.HereAPIBeans.Result res : view.getResult()) {
//                                                if(res.getLocation()!=null && res.getLocation().getAddress()!=null ){
//                                                    hotelBean.setDistrict(res.getLocation().getAddress().getDistrict());
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }//todo

                        hotelBean.setMapUrl("");
                        hotelBean.setMealType("");
                        hotelBean.setProviderId(travelXGateProviderId);
                        hotelBean.setProviderRef(0);
//                    String[] split = "".split("");
//                    if (hotel.getS2C() != null)
//                        split = hotel.getS2C().split("\\*");
                        if (edge.getNode().getHotelData().getCategoryCode().equals("5"))//todo check if ever the category codes will change at travel gate
                            hotelBean.setStarRating("4");
                        else if (edge.getNode().getHotelData().getCategoryCode().equals("6"))
                            hotelBean.setStarRating("5");
                        else
                            hotelBean.setStarRating(edge.getNode().getHotelData().getCategoryCode());
                        hotelBean.setState("");
                        hotelBean.setZipCode("");
                        hotelBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
                        hotelBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));


                        List<FacilityBean> allreadyExistedFacilities = FacilityDAO.getFacilities(travelXGateProviderId);
                        FacilityBean facilityBean;
                        List<FacilityBean> facilityBeans = new ArrayList<>();
                        HotelfacilityBean hotelfacilityBean;
                        List<HotelfacilityBean> hotelFacilities = new ArrayList<>();
                        if (edge.getNode().getHotelData().getAmenities() != null) {
                            for (Amenity amenity : edge.getNode().getHotelData().getAmenities()) {
                                if (amenity.getTexts() != null && amenity.getTexts().size() > 0) {
                                    boolean existed = false;
                                    for (FacilityBean facility : allreadyExistedFacilities) {
                                        if (facility.getFacilityId().equals(amenity.getCode()))
                                            existed = true;
                                    }
                                    if (!existed) {
                                        facilityBean = new FacilityBean();
                                        facilityBean.setProviderId(travelXGateProviderId);
                                        facilityBean.setName(amenity.getTexts().get(0).getText());
                                        facilityBean.setFacilityId(amenity.getCode());
                                        facilityBeans.add(facilityBean);
                                    }
                                }

                                hotelfacilityBean = new HotelfacilityBean();
                                hotelfacilityBean.setExplanation("");
                                hotelfacilityBean.setFacilityId(amenity.getCode());
                                hotelfacilityBean.setHotelId(Integer.parseInt(edge.getNode().getHotelData().getHotelCode()));
                                hotelfacilityBean.setPrice(new BigDecimal(0));
                                hotelfacilityBean.setProviderId(travelXGateProviderId);
                                hotelFacilities.add(hotelfacilityBean);
                            }
                        }


                        List<PhotoBean> photos = new ArrayList<>();
                        PhotoBean photoBean;
                        if (edge.getNode().getHotelData().getMedias() != null) {
                            for (Media media : edge.getNode().getHotelData().getMedias()) {
                                photoBean = new PhotoBean();
                                photoBean.setPhotoUrl(media.getUrl());
                                photoBean.setCoverPhoto(false);
                                photoBean.setDescription("");
                                photoBean.setFacilityId(null);
                                photoBean.setHotelId(Integer.parseInt(edge.getNode().getHotelData().getHotelCode()));
                                photoBean.setPhotoPath("");
                                photoBean.setProviderId(travelXGateProviderId);
                                photoBean.setRoomTypeId("");
                                photoBean.setTitle("");
                                photos.add(photoBean);
                            }
                        }


                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                        Transaction tx;
                        try {
                            tx = session.beginTransaction();
                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;
                            if (HotelDAO.deleteHotelBean(hotelBean.getHotelId(), session, null, travelXGateProviderId)) {
                                atbDBErrCommCounter++;
                            } else {
                                if (HotelDAO.addHotelBean(hotelBean, session, null)) {
                                    atbDBErrCommCounter++;
                                } else {
                                    if (HotelmappingDAO.getATBHotelId(hotelBean.getHotelId(), travelXGateProviderId, session) == 0) {
                                        if (HotelmappingDAO.addHotelmapping(hotelBean.getHotelId(), travelXGateProviderId, session, null))
                                            atbDBErrCommCounter++;
                                    }
                                    entityCounter++;
                                }
                                if (PhotoDAO.addPhotoBean(photos, session, null)) {
                                    atbDBErrCommCounter++;
                                }
                                if (FacilityDAO.addFacilities(facilityBeans, session, null)) {
                                    atbDBErrCommCounter++;
                                }
                                if (HotelfacilityDAO.addHotelfacilityBean(hotelFacilities, session, null)) {
                                    atbDBErrCommCounter++;
                                }
                            }
                            if (currentAtbDBErrCommCounter == atbDBErrCommCounter) {
                                tx.commit();
                            } else {
                                tx.rollback();
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
                        }
                    }
                } else
                    travelXGateCommErrCounter++;

            }
            logger.info("********************** Hotels Update ended. " + entityCounter + " hotels added/updated **********************");

            SunhotelsUpdateInfoBean sunhotelsUpdateInfoBean = new SunhotelsUpdateInfoBean();
            sunhotelsUpdateInfoBean.setStartDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
            dateTime = new DateTime();
            sunhotelsUpdateInfoBean.setEndDateTime(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                    dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                    dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
            sunhotelsUpdateInfoBean.setAtbdbCommErrorCounter(atbDBErrCommCounter);
            sunhotelsUpdateInfoBean.setSunhotelsCommErrorCounter(travelXGateCommErrCounter);
            sunhotelsUpdateInfoBean.setTotalexpiredHotels(0);
            SunhotelsUpdateInfoDAO.addSunhotelsUpdateInfoBean(sunhotelsUpdateInfoBean);
        }catch(Exception e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }

    }
}
