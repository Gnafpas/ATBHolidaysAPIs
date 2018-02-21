package Updates.ATBDBUpdates.HotelBedsDBUpdates;

import Beans.ATBDBBeans.KalitaonHotel.*;
import Beans.HotelBedsAPIBeans.Destiantions.Destination;
import Beans.HotelBedsAPIBeans.Destiantions.DestinationsAPIJSON;
import Beans.HotelBedsAPIBeans.Hotels.Hotel;
import Beans.HotelBedsAPIBeans.Hotels.HotelsAPIJSON;
import Controller.AdminController.AdminController;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.DestinationDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelmappingDAO;
import DAOs.HotelBedsAPIDAOs.DestinationsAPIDAO;
import DAOs.HotelBedsAPIDAOs.HotelAPIDAO;
import DBConnection.SunHotelsHibernateUtil;
import DBConnection.SunHotelsMainServerHibernateUtil;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.hotelBedsProviderId;


/**
 * Created by George on 15/01/2018.
 */
public class UpdateHotelBedsDB {


    public static void updateHotelsContent(int from,int to) {
        DestinationBean destinationBean;
        RoomtypeBean roomtypeBean = new RoomtypeBean();
        FacilityBean facilityBean = new FacilityBean();
        HotelfacilityBean hotelfacilityBean;
        List<PhotoBean> photos = new ArrayList<>();
        List<HotelfacilityBean> hotelfacilities = new ArrayList<>();
        List<RoomBean> rooms = new ArrayList<>();
        List<RoombedBean> roombeds = new ArrayList<>();
        int totalresults=0;


        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        //TotalExpiredHotels totalExpiredHotels=new TotalExpiredHotels();
        int sunHotelsCommErrCounter = 0;
        int atbDBErrCommCounter = 0;
        int counter = 0;
        long timeElapsed = 0;
        long totalProccessWaitingTime = 0;
        //AdminController.sunHotelsUpdateRunning = true;

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
        // totalExpiredHotels=DeleteExpiredHotels.deleteExpiredHotels(logger);
        logger.info("********************** Expired hotels procedure ended. **********************");
        List<DestinationBean> allDestinationBeans = DestinationDAO.getAllDestinations();
        int resultsCounter=0;
        while((totalresults==0 || resultsCounter<totalresults)) {
            DestinationsAPIJSON destinationsAPIJSON = DestinationsAPIDAO.destinations(resultsCounter, resultsCounter+800);
            resultsCounter=resultsCounter+1000;
            boolean destExists;
            if (destinationsAPIJSON != null) {
                totalresults=destinationsAPIJSON.getTotal();
                for (Destination dest : destinationsAPIJSON.getDestinations()) {

                    destExists = false;
                    if (allDestinationBeans != null) {
                        for (DestinationBean destBean : allDestinationBeans) {
                            if (destBean.getHotelBedsCode() != null && destBean.getHotelBedsCode().equals(dest.getCode())) {
                                destExists = true;
                                break;
                            }
                            if (!destExists) {

                                String[] dbDestName = destBean.getName().split("( )|(\\()|(\\))|(-)");
                                String[] hotelBedsDestName = dest.getName().getContent().split("( )|(\\()|(\\))|(-)");

                                boolean wordExists = false;
                                if (dbDestName != null && hotelBedsDestName != null) {
                                    for (int i = 0; i < dbDestName.length; i++) {
                                        if (dbDestName.equals(""))
                                            continue;
                                        wordExists = false;
                                        for (int j = 0; j < hotelBedsDestName.length; j++) {

                                            if (dbDestName[i].equals(hotelBedsDestName[j]))
                                                wordExists = true;
                                        }
                                        if (!wordExists)
                                            break;
                                    }
                                    if (wordExists && destBean.getCountryCode().equals(dest.getIsoCode())) {
                                        destBean.setHotelBedsCode(dest.getCode());
                                        if (DestinationDAO.updateDestinationBean(destBean))
                                            atbDBErrCommCounter++;
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
                        }

                    }
                }

            }
        }

//
//
//        int i=0;
//        while((totalHotels==0 || from<totalHotels) && i<2 ) {
//            i++;
//            HotelBean hotelBean = new HotelBean();
//            HotelsAPIJSON hotelsAPIJSON = HotelAPIDAO.hotels(from, to);
//            if (hotelsAPIJSON != null && hotelsAPIJSON.getHotels() != null) {
//                totalHotels = hotelsAPIJSON.getTotal();
//                for (Hotel hotel : hotelsAPIJSON.getHotels()) {
//                    hotelBean.setCity((hotel.getCity().getContent()));
//                    hotelBean.setHotelId(hotel.getCode());
//                    hotelBean.setName(hotel.getName().getContent());
//                    hotelBean.setAddress(hotel.getAddress().getContent());
//                    hotelBean.setCountry(hotel.getCountryCode());//todo
//                    hotelBean.setCountryCode(hotel.getCountryCode());
//                    hotelBean.setCurrencyId(0);//todo check this field
//                    hotelBean.setDescription(hotel.getDescription().getContent());
//                    //hotelBean.setDestinationId(hotel.getDestinationCode());
//                    hotelBean.setDistrict("");//todo check this field
//                    hotelBean.setActive(true);
//                    hotelBean.setResortId(0);
//                    if (hotel.getCoordinates() != null && hotel.getCoordinates().getLatitude() != null && hotel.getCoordinates().getLongitude() != null) {
//                        hotelBean.setLatitude(hotel.getCoordinates().getLatitude().toString());
//                        hotelBean.setLongitude(hotel.getCoordinates().getLongitude().toString());
//                    }
//                    hotelBean.setMapUrl("");
//                    hotelBean.setMealType("");
//                    hotelBean.setProviderId(hotelBedsProviderId);
//                    hotelBean.setProviderRef(0);
//                    hotelBean.setStarRating(hotel.getS2C());//todo check if i have to move '*'
//                    hotelBean.setState("");
//                    hotelBean.setZipCode(hotel.getPostalCode());
//                    hotelBean.setCreatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
//                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
//                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
//                    hotelBean.setUpdatedAt(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:00",
//                            dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
//                            dateTime.getHourOfDay(), dateTime.getMinuteOfHour())));
//
//                    StatelessSession session = SunHotelsHibernateUtil.getSession();
//                    Transaction tx;
//                    StatelessSession session2=null; //SunHotelsMainServerHibernateUtil.getSession();
//                    Transaction tx2;
//                    try {
//                        tx = session.beginTransaction();
//                        //tx2 = session2.beginTransaction();
//                        int currentAtbDBErrCommCounter = atbDBErrCommCounter;
//                        if (HotelDAO.deleteHotelBean(hotelBean.getHotelId(), session,session2,hotelBedsProviderId)) {
//                            atbDBErrCommCounter++;
//                        } else {
//                            if (HotelDAO.addHotelBean(hotelBean, session,session2)) {
//                                atbDBErrCommCounter++;
//                            } else {
//                                if (HotelmappingDAO.getATBHotelId(hotelBean.getHotelId(), hotelBedsProviderId, session) == 0) {
//                                    if (HotelmappingDAO.addHotelmapping(hotelBean.getHotelId(), hotelBedsProviderId, session, session2))
//                                        atbDBErrCommCounter++;
//                                }
//                            }
//                        }
//                        if (currentAtbDBErrCommCounter == atbDBErrCommCounter) {
//                            tx.commit();
//                          //  tx2.commit();
//                        }
//                        else {
//                            tx.rollback();
//                          //  tx2.rollback();
//                        }
//                    } catch (ExceptionInInitializerError e) {
//                        StringWriter errors = new StringWriter();
//                        e.printStackTrace(new PrintWriter(errors));
//                        errLogger.info(errors.toString());
//                        atbDBErrCommCounter++;
//                    } catch (ClientTransportException e) {
//                        StringWriter errors = new StringWriter();
//                        e.printStackTrace(new PrintWriter(errors));
//                        errLogger.info(errors.toString());
//                        atbDBErrCommCounter++;
//                    } catch (CJCommunicationsException e) {
//                        StringWriter errors = new StringWriter();
//                        e.printStackTrace(new PrintWriter(errors));
//                        errLogger.info(errors.toString());
//                        atbDBErrCommCounter++;
//                    } finally {
//                        session.close();
//                       // session2.close();
//                    }
//                }



           // }
        //}
    }
}
