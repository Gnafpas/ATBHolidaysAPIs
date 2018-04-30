package Updates.ATBDBUpdates.HotelBedsDBUpdates;

import Beans.ATBDBBeans.KalitaonHotel.HotelBean;
import Beans.HotelBedsAPIBeans.Hotels.HotelsAPIJSON;
import Controller.Application;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelDAO;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.HotelmappingDAO;
import DAOs.HotelBedsAPIDAOs.HotelAPIDAO;
import DBConnection.SunHotelsHibernateUtil;
import DBConnection.SunHotelsMainServerHibernateUtil;
import Helper.ProjectProperties;
import Updates.ATBDBUpdates.SunHotelsDBUpdates.TotalExpiredHotels;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static Helper.ProjectProperties.hotelBedsProviderId;

/**
 * Created by George on 25/11/2017.
 */
public class DeleteExpiredHotels {


    public static TotalExpiredHotels  deleteExpiredHotels(Logger logger) {

        /**
         * Time between viator server requests.There is a limit for the number of requests per
         * 10 seconds that we can make at viator's server(15req/10sec for prelive and 35req/10sec for live).
         * Process may sleep for an amount of time to stay in the limits.
         */
        long timeElapsed=0;

        /**
         * Statistic Values/Information/Results in JSON for Admin.
         */
        TotalExpiredHotels totalExpiredHotels=new TotalExpiredHotels();
        List<Integer> totalExpiredHotelsList = new ArrayList<>();

        List<Integer> hotelIdsTemp = new ArrayList<>();/** Separate all DB hotels into chunks of size 1000 hotelIds per chunk*/
        String reqHotelIds = "";
        boolean expired;

        /**
         * retrieve all codes of the hotels in DB
         */
        List<Integer> hotelIds = HotelDAO.getAllHotelsIds(hotelBedsProviderId);
        if (hotelIds == null) {
            totalExpiredHotels.setAtbDBErrCommCounter(totalExpiredHotels.getAtbDBErrCommCounter()+1);
        } else {
            /**
             * Divide hotels into chunks
             */
            for (int j = 0; j < hotelIds.size(); j++) {
                hotelIdsTemp.add(hotelIds.get(j));
                if (hotelIdsTemp.size()>=400 || j == hotelIds.size() - 1) {
                    /**
                     * Call sunhotels service to check if any hotels of it's chunk are expired.A hotel is considered expired
                     * if the service of sunhotels doesn't returns this exact hotel.
                     */

                    /**
                     * HotelIds are passed to service as a string
                     */
                    reqHotelIds = hotelIdsTemp.get(0)+"";
                    for (int hotelId : hotelIdsTemp) {
                        reqHotelIds = reqHotelIds + "," + hotelId;
                    }

                    timeElapsed = System.currentTimeMillis() - timeElapsed;
                    if (ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed > 0) {
                        try {
                            Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    HotelsAPIJSON hotels= HotelAPIDAO.activeHotels(reqHotelIds);
                    timeElapsed=System.currentTimeMillis();
                    if (hotels != null && hotels.getError()==null) {

                        /**
                         *If a hotel is expired delete related records of all tables in DB.
                         */
                        for (int hotelId : hotelIdsTemp) {
                            expired = true;
                            for (int i = 0; i < hotels.getHotels().size(); i++) {
                                if (hotels.getHotels().get(i).getCode() == hotelId)
                                    expired = false;
                            }
                            if (expired) {
                                List<HotelBean> hotelbeans=HotelDAO.getHotelByHotelId(hotelId,hotelBedsProviderId,null);
                                if (hotelbeans!=null && hotelbeans.size()>0 && hotelbeans.get(0).isActive()){

                                    hotelbeans.get(0).setActive(false);
                                    StatelessSession session = SunHotelsHibernateUtil.getSession();
                                    Transaction tx;
                                  //  StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                                   // Transaction tx2;
                                    tx = session.beginTransaction();
                                   // tx2 = session2.beginTransaction();
                                    if(HotelDAO.updateHotelBean(hotelbeans.get(0),session,null))
                                        totalExpiredHotels.setAtbDBErrCommCounter(totalExpiredHotels.getAtbDBErrCommCounter() + 1);
                                    tx.commit();
                                   // tx2.commit();
                                    session.close();
                                  //  session2.close();
                                    logger.info("********************** Deleting expired hotel with id: " + hotelId + " **********************");
                                    totalExpiredHotelsList.add(hotelId);
                                    totalExpiredHotels.setTotalExpiredhotels(totalExpiredHotels.getTotalExpiredhotels() + 1);
                                }
                            }
                        }
                    } else {
                        Application.agent.increment("app.web.error.updates.hotelBeds",1,0);
                        Application.agent.notice("********************** Communication ERROR with sunHotels server while deleting expired products. **********************");
                        logger.info("********************** Communication ERROR with sunHotels server while deleting expired products. **********************");
                        totalExpiredHotels.setSunHotelsCommErrCounter(totalExpiredHotels.getSunHotelsCommErrCounter()+1);
                    }
                    hotelIdsTemp.clear();
                }
            }
        }
        totalExpiredHotels.setTotalExpiredHotelsList(totalExpiredHotelsList);
        return totalExpiredHotels;
    }
}
