package Updates.ATBDBUpdates.HotelBedsDBUpdates;

import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.HotelBedsAPIBeans.Destiantions.Destination;
import Beans.HotelBedsAPIBeans.Destiantions.DestinationsAPIJSON;
import Beans.HotelBedsAPIBeans.Hotels.Hotel;
import Beans.HotelBedsAPIBeans.Hotels.HotelsAPIJSON;
import Beans.HotelBedsAPIBeans.Hotels.Image;
import Beans.HotelBedsAPIBeans.Types.*;
import Controller.AdminController.AdminController;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.HotelBedsAPIDAOs.DestinationsAPIDAO;
import DAOs.HotelBedsAPIDAOs.HotelAPIDAO;
import DAOs.HotelBedsAPIDAOs.TypesAPIDAO;
import DBConnection.SunHotelsHibernateUtil;
import DBConnection.SunHotelsMainServerHibernateUtil;
import Helper.ProjectProperties;
import Updates.ATBDBUpdates.SunHotelsDBUpdates.TotalExpiredHotels;
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

import static Controller.AdminController.AdminController.hotelBedsUpdateRunning;
import static Controller.AdminController.AdminController.hotelBedsimidiateUpdateStop;
import static Controller.Application.errLogger;
import static Helper.ProjectProperties.hotelBedsImageURL;
import static Helper.ProjectProperties.hotelBedsProviderId;


/**
 * Created by George on 15/01/2018.
 */
public class UpdateHotelBedsDB {


    public static void updateHotelsContent() {

        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        TotalExpiredHotels totalExpiredHotels=new TotalExpiredHotels();
        int hotelBedsCommErrCounter = 0;
        int atbDBErrCommCounter = 0;
        try {
            AdminController.hotelBedsUpdateRunning = true;

            /**
             * Set up logger.
             */
            Logger logger = Logger.getLogger("UpdateHotelBeds");
            FileHandler fh;
            try {
                for (Handler handler : logger.getHandlers()) {
                    logger.removeHandler(handler);
                }
                // This block configure the logger with handler and formatter
                fh = new FileHandler(ProjectProperties.logspath + "UpdateHotelBeds.log");
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
            int resultsCounter = 0;
            int entityCounter = 0;


            logger.info("********************** Starting Destinations Update... **********************");
            List<DestinationBean> allDestinationBeans = DestinationDAO.getAllDestinations();
            DestinationBean destinationBean;
            while ((totalresults == 0 || resultsCounter < totalresults) && !hotelBedsimidiateUpdateStop) {
                DestinationsAPIJSON destinationsAPIJSON = DestinationsAPIDAO.destinations(resultsCounter, resultsCounter + 800);
                logger.info("********************** Adding destiantions from " + resultsCounter + " **********************");
                resultsCounter = resultsCounter + 1000;
                boolean destExists;
                if (destinationsAPIJSON != null && destinationsAPIJSON.getError() == null && destinationsAPIJSON.getDestinations() != null) {
                    totalresults = destinationsAPIJSON.getTotal();
                    for (Destination dest : destinationsAPIJSON.getDestinations()) {

                        destExists = false;
                        if (allDestinationBeans != null) {
                            for (DestinationBean destBean : allDestinationBeans) {
                                if (destBean.getHotelBedsCode() != null && destBean.getHotelBedsCode().equals(dest.getCode())) {
                                    destExists = true;
                                    break;
                                }
                                if (!destExists) {
                                    String[] dbDestName = null;
                                    String[] hotelBedsDestName = null;
                                    if (destBean.getName() != null)
                                        dbDestName = destBean.getName().split("( )|(\\()|(\\))|(-)");
                                    if (dest.getName() != null && dest.getName().getContent() != null)
                                        hotelBedsDestName = dest.getName().getContent().split("( )|(\\()|(\\))|(-)");

                                    boolean wordExists = false;
                                    if (dbDestName != null && hotelBedsDestName != null) {
                                        for (int k = 0; k < dbDestName.length; k++) {
                                            if (dbDestName.equals(""))
                                                continue;
                                            wordExists = false;
                                            for (int j = 0; j < hotelBedsDestName.length; j++) {

                                                if (dbDestName[k].equals(hotelBedsDestName[j]))
                                                    wordExists = true;
                                            }
                                            if (!wordExists)
                                                break;
                                        }
                                        if (wordExists && destBean.getCountryCode().equals(dest.getIsoCode())) {
                                            destBean.setHotelBedsCode(dest.getCode());
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
                                destinationBean.setDestinationId(0);
                                destinationBean.setCountryName(dest.getCountryCode());
                                destinationBean.setName(dest.getName().getContent());
                                destinationBean.setProviderId(hotelBedsProviderId);
                                destinationBean.setProviderRef(0);
                                destinationBean.setTimezone("");
                                destinationBean.setCountryCode(dest.getCountryCode());
                                destinationBean.setHotelBedsCode(dest.getCode());
                                if (DestinationDAO.addDestinationBean(destinationBean))
                                    atbDBErrCommCounter++;
                                else
                                    entityCounter++;
                            }
                        }
                    }
                } else
                    hotelBedsCommErrCounter++;
            }
            logger.info("********************** Destinations Update ended. " + entityCounter + " destinations updated/added **********************");


            logger.info("********************** Starting RoomTypes Update... **********************");
            totalresults = 0;
            resultsCounter = 0;
            entityCounter = 0;
            while ((totalresults == 0 || resultsCounter < totalresults) && !hotelBedsimidiateUpdateStop) {
                RoomtypeBean roomtypeBean;
                RoomAPIJSON roomAPIJSON = TypesAPIDAO.rooms(resultsCounter, resultsCounter + 800);
                logger.info("********************** Adding roomTypes from " + resultsCounter + " **********************");
                resultsCounter = resultsCounter + 1000;

                if (roomAPIJSON != null && roomAPIJSON.getError() == null && roomAPIJSON.getRooms() != null) {
                    totalresults = roomAPIJSON.getTotal();
                    for (Room room : roomAPIJSON.getRooms()) {

                        roomtypeBean = new RoomtypeBean();
                        roomtypeBean.setRoomtypeId(room.getCode());
                        roomtypeBean.setDescription(room.getDescription());
                        roomtypeBean.setMaxAdultOccupation(Integer.parseInt(room.getMaxAdults()));
                        roomtypeBean.setMaxChildOccupation(Integer.parseInt(room.getMaxChildren()));
                        roomtypeBean.setMaxInfantOccupation(0);
                        roomtypeBean.setMinAdultOccupation(Integer.parseInt(room.getMinAdults()));
                        roomtypeBean.setMinChildOccupation(Integer.parseInt(room.getMaxChildren()));
                        roomtypeBean.setMinInfantOccupation(0);
                        roomtypeBean.setProviderId(hotelBedsProviderId);
                        roomtypeBean.setRoomSize(0);
                        roomtypeBean.setRoomType(room.getTypeDescription().getContent());
                        roomtypeBean.setSharedRoom(false);
                        roomtypeBean.setSizeMeasurement("");
                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                        Transaction tx;
                        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                        Transaction tx2;
                        try {
                            tx = session.beginTransaction();
                            tx2 = session2.beginTransaction();
                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;

                            RoomtypeBean existedroomType = RoomtypeDAO.getRoomsTypesbyId(roomtypeBean.getRoomtypeId(), hotelBedsProviderId, session);
                            if (existedroomType != null && existedroomType.getId()!=0) {
                                roomtypeBean.setId(existedroomType.getId());
                                if (RoomtypeDAO.updateRoomtypeBean(roomtypeBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
                            } else {
                                if (RoomtypeDAO.addRoomtypeBean(roomtypeBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
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
                } else
                    hotelBedsCommErrCounter++;
            }
            logger.info("********************** RoomTypes Update ended. " + entityCounter + " roomTypes added/updated **********************");


            logger.info("********************** Starting Facilities Update... **********************");
            totalresults = 0;
            resultsCounter = 0;
            entityCounter = 0;
            while ((totalresults == 0 || resultsCounter < totalresults) && !hotelBedsimidiateUpdateStop) {
                FacilityBean facilityBean;
                FacilitiesAPIJSON facilitiesAPIJSON = TypesAPIDAO.facilities(resultsCounter, resultsCounter + 800);
                logger.info("********************** Adding facilities from " + resultsCounter + " **********************");
                resultsCounter = resultsCounter + 1000;
                if (facilitiesAPIJSON != null && facilitiesAPIJSON.getError() == null && facilitiesAPIJSON.getFacilities() != null) {
                    totalresults = facilitiesAPIJSON.getTotal();
                    for (Facility facility : facilitiesAPIJSON.getFacilities()) {

                        facilityBean = new FacilityBean();
                        facilityBean.setFacilityId(facility.getCode() + "-" + facility.getFacilityGroupCode());
                        facilityBean.setName(facility.getDescription().getContent());
                        facilityBean.setProviderId(hotelBedsProviderId);

                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                        Transaction tx;
                        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                        Transaction tx2;
                        try {
                            tx = session.beginTransaction();
                            tx2 = session2.beginTransaction();
                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;

                            FacilityBean existedFacility = FacilityDAO.getFacilityByFacilityId(facilityBean.getFacilityId(), hotelBedsProviderId, session);
                            if (existedFacility != null && existedFacility.getId()!=0) {
                                facilityBean.setId(existedFacility.getId());
                                if (FacilityDAO.updateFacilityBean(facilityBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
                            } else {
                                if (FacilityDAO.addFacilityBean(facilityBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
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
                } else
                    hotelBedsCommErrCounter++;
            }
            logger.info("********************** Facilities Update ended. " + entityCounter + " facilities added/updated **********************");

            logger.info("********************** Starting Meals Update... **********************");
            totalresults = 0;
            resultsCounter = 0;
            entityCounter = 0;
            while ((totalresults == 0 || resultsCounter < totalresults) && !hotelBedsimidiateUpdateStop) {
                MealBean mealBean = new MealBean();
                BoardsAPIJSON boardsAPIJSON = TypesAPIDAO.boards(resultsCounter, resultsCounter + 800);
                logger.info("********************** Adding meals from " + resultsCounter + " **********************");
                resultsCounter = resultsCounter + 1000;
                if (boardsAPIJSON != null && boardsAPIJSON.getError() == null && boardsAPIJSON.getBoards() != null) {
                    totalresults = boardsAPIJSON.getTotal();
                    for (Board board : boardsAPIJSON.getBoards()) {

                        mealBean = new MealBean();
                        mealBean.setName(board.getDescription().getContent());
                        mealBean.setProviderId(hotelBedsProviderId);
                        mealBean.setMealId(board.getCode());

                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                        Transaction tx;
                        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                        Transaction tx2;
                        try {
                            tx = session.beginTransaction();
                            tx2 = session2.beginTransaction();
                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;

                            MealBean existedMeal = MealDAO.getMealByMealId(mealBean.getMealId(), hotelBedsProviderId, session);
                            if (existedMeal != null && existedMeal.getId()!=0) {
                                mealBean.setId(existedMeal.getId());
                                if (MealDAO.updateMealBean(mealBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
                            } else {
                                if (MealDAO.addMealBean(mealBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
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
                } else
                    hotelBedsCommErrCounter++;
            }
            logger.info("********************** Meals Update ended. " + entityCounter + " meals added/updated **********************");


            logger.info("********************** Starting Accommodations Update... **********************");
            totalresults = 0;
            resultsCounter = 0;
            entityCounter = 0;
            while ((totalresults == 0 || resultsCounter < totalresults) && !hotelBedsimidiateUpdateStop) {
                AccommodationsBean accommodationsBean;
                AccommodationsAPIJSON accommodationsAPIJSON = TypesAPIDAO.accommodations(resultsCounter, resultsCounter + 800);
                logger.info("********************** Adding accommodations from " + resultsCounter + " **********************");
                resultsCounter = resultsCounter + 1000;
                if (accommodationsAPIJSON != null && accommodationsAPIJSON.getError() == null && accommodationsAPIJSON.getAccommodations() != null) {
                    totalresults = accommodationsAPIJSON.getTotal();
                    for (Accommodation accommodation : accommodationsAPIJSON.getAccommodations()) {

                        accommodationsBean = new AccommodationsBean();
                        accommodationsBean.setAccommodationId(accommodation.getCode());
                        accommodationsBean.setName(accommodation.getTypeDescription());
                        accommodationsBean.setProviderId(hotelBedsProviderId);

                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                        Transaction tx;
                        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                        Transaction tx2;
                        try {
                            tx = session.beginTransaction();
                            tx2 = session2.beginTransaction();
                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;

                            AccommodationsBean existedAccommodation = AccommodationsDAO.getAccommodationByAccommodationId(accommodationsBean.getAccommodationId(), hotelBedsProviderId, session);
                            if (existedAccommodation != null  && existedAccommodation.getId()!=0) {
                                accommodationsBean.setId(existedAccommodation.getId());
                                if (AccommodationsDAO.updateAccommodationsBean(accommodationsBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
                            } else {
                                if (AccommodationsDAO.addAccommodationsBean(accommodationsBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                } else
                                    entityCounter++;
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
                } else
                    hotelBedsCommErrCounter++;
            }
            logger.info("********************** Accommodations Update ended. " + entityCounter + " accommodations added/updated **********************");

            logger.info("********************** Starting Hotels Update... **********************");
            totalresults = 0;
            resultsCounter = 0;//todo move resorts to resort table
            entityCounter = 0;
            while ((totalresults == 0 || resultsCounter < totalresults) && !hotelBedsimidiateUpdateStop) {
                HotelBean hotelBean;//todo see if It's better t add last updated dates
                HotelsAPIJSON hotelsAPIJSON = HotelAPIDAO.hotels(resultsCounter, resultsCounter + 800);
                logger.info("********************** Adding hotels from " + resultsCounter + " **********************");
                resultsCounter = resultsCounter + 1000;
                if (hotelsAPIJSON != null && hotelsAPIJSON.getError() == null && hotelsAPIJSON.getHotels() != null) {
                    totalresults = hotelsAPIJSON.getTotal();
                    for (Hotel hotel : hotelsAPIJSON.getHotels()) {
                        hotelBean = new HotelBean();
                        hotelBean.setCity((hotel.getCity().getContent()));
                        hotelBean.setHotelId(hotel.getCode());
                        hotelBean.setName(hotel.getName().getContent());
                        hotelBean.setAddress(hotel.getAddress().getContent());
                        hotelBean.setCountry(hotel.getCountryCode());//todo
                        hotelBean.setCountryCode(hotel.getCountryCode());
                        hotelBean.setAccommodationId(hotel.getAccommodationTypeCode());

                        AccommodationsDAO.getAccommodationByAccommodationId(hotel.getAccommodationTypeCode(), hotelBedsProviderId, null);

                        hotelBean.setCurrencyId(0);//todo check this field
                        if (hotel.getDescription() != null)
                            hotelBean.setDescription(hotel.getDescription().getContent());
                        else
                            hotelBean.setDescription("");
                        hotelBean.setDestinationId(hotel.getDestinationCode());
                        hotelBean.setDistrict("");//todo check this field
                        hotelBean.setActive(true);
                        hotelBean.setResortId(0);
                        if (hotel.getCoordinates() != null && hotel.getCoordinates().getLatitude() != null && hotel.getCoordinates().getLongitude() != null) {
                            hotelBean.setLatitude(hotel.getCoordinates().getLatitude().toString());
                            hotelBean.setLongitude(hotel.getCoordinates().getLongitude().toString());
                        }
                        hotelBean.setMapUrl("");
                        hotelBean.setMealType("");
                        hotelBean.setProviderId(hotelBedsProviderId);
                        hotelBean.setProviderRef(0);
                        String[] split = "".split("");
                        if (hotel.getS2C() != null)
                            split = hotel.getS2C().split("\\*");
                        hotelBean.setStarRating(split[0]);
                        hotelBean.setState("");
                        hotelBean.setZipCode(hotel.getPostalCode());
                        hotelBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
                        hotelBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
                                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                                dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));

                        HotelfacilityBean hotelfacilityBean;
                        List<HotelfacilityBean> hotelFacilities = new ArrayList<>();
                        if (hotel.getFacilities() != null) {
                            for (Beans.HotelBedsAPIBeans.Hotels.Facility facility : hotel.getFacilities()) {
                                hotelfacilityBean = new HotelfacilityBean();
                                hotelfacilityBean.setExplanation("");
                                hotelfacilityBean.setFacilityId(facility.getFacilityCode() + "-" + facility.getFacilityGroupCode());
                                hotelfacilityBean.setHotelId(hotel.getCode());
                                hotelfacilityBean.setPrice(new BigDecimal(0));
                                hotelfacilityBean.setProviderId(hotelBedsProviderId);
                                hotelFacilities.add(hotelfacilityBean);
                            }
                        }


                        List<PhotoBean> photos = new ArrayList<>();
                        PhotoBean photoBean;
                        if (hotel.getImages() != null) {
                            for (Image img : hotel.getImages()) {
                                photoBean = new PhotoBean();
                                photoBean.setPhotoUrl(hotelBedsImageURL + img.getPath());
                                photoBean.setCoverPhoto(false);
                                photoBean.setDescription("");
                                photoBean.setFacilityId(null);
                                photoBean.setHotelId(hotel.getCode());
                                photoBean.setPhotoPath("");
                                photoBean.setProviderId(hotelBedsProviderId);
                                photoBean.setRoomTypeId(img.getRoomCode());
                                photoBean.setTitle("");
                                photos.add(photoBean);
                            }
                        }


                        List<RoomBean> rooms = new ArrayList<>();
                        RoomBean room;
                        if (hotel.getRooms() != null) {
                            for (Beans.HotelBedsAPIBeans.Hotels.Room r : hotel.getRooms()) {
                                room = new RoomBean();
                                room.setOriginalRoomId(r.getRoomCode());
                                room.setDirty(false);
                                room.setHotelId(hotel.getCode());
                                room.setProviderId(hotelBedsProviderId);
                                room.setProviderRef(0);
                                room.setRoomTypeId(r.getRoomType());
                                rooms.add(room);
                            }
                        }

                        StatelessSession session = SunHotelsHibernateUtil.getSession();
                        Transaction tx;
                        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                        Transaction tx2;
                        try {
                            tx = session.beginTransaction();
                            tx2 = session2.beginTransaction();
                            int currentAtbDBErrCommCounter = atbDBErrCommCounter;
                            if (HotelDAO.deleteHotelBean(hotelBean.getHotelId(), session, session2, hotelBedsProviderId)) {
                                atbDBErrCommCounter++;
                            } else {
                                if (HotelDAO.addHotelBean(hotelBean, session, session2)) {
                                    atbDBErrCommCounter++;
                                } else {
                                    if (HotelmappingDAO.getATBHotelId(hotelBean.getHotelId(), hotelBedsProviderId, session) == 0) {
                                        if (HotelmappingDAO.addHotelmapping(hotelBean.getHotelId(), hotelBedsProviderId, session, session2))
                                            atbDBErrCommCounter++;
                                    }
                                    entityCounter++;
                                }
                                if (RoomDAO.addRoomBean(rooms, session, session2)) {
                                    atbDBErrCommCounter++;
                                }
                                if (PhotoDAO.addPhotoBean(photos, session, session2)) {
                                    atbDBErrCommCounter++;
                                }
                                if (HotelfacilityDAO.addHotelfacilityBean(hotelFacilities, session, session2)) {
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
                    }
                } else
                    hotelBedsCommErrCounter++;

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
            sunhotelsUpdateInfoBean.setAtbdbCommErrorCounter(atbDBErrCommCounter + totalExpiredHotels.getAtbDBErrCommCounter());
            sunhotelsUpdateInfoBean.setSunhotelsCommErrorCounter(hotelBedsCommErrCounter + totalExpiredHotels.getSunHotelsCommErrCounter());
            sunhotelsUpdateInfoBean.setTotalexpiredHotels(totalExpiredHotels.getTotalExpiredhotels());
            SunhotelsUpdateInfoDAO.addSunhotelsUpdateInfoBean(sunhotelsUpdateInfoBean);

            AdminController.hotelBedsUpdateRunning = false;
        }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }
    }
}
