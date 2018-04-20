package Updates.ATBDBUpdates.SunHotelsDBUpdates;

import Beans.ATBDBBeans.KalitaonHotel.HotelBean;
import Controller.Application;
import DAOs.ATBDBDAOs.KalitaonHotelDAOs.*;
import DAOs.SunHotelsAPIDAOs.GetStaticHotelsAndRoomsResult;
import DAOs.SunHotelsAPIDAOs.NonStaticXMLAPI;
import DAOs.SunHotelsAPIDAOs.NonStaticXMLAPISoap;
import DBConnection.SunHotelsHibernateUtil;
import DBConnection.SunHotelsMainServerHibernateUtil;
import Helper.ProjectProperties;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static Helper.ProjectProperties.sanHotelsProviderId;

/**
 * Created by George on 25/11/2017.
 */
public class DeleteExpiredHotels {


    public static TotalExpiredHotels  deleteExpiredHotels(Logger logger) {
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
        List<Integer> hotelIds = HotelDAO.getAllHotelsIds(sanHotelsProviderId);
        if (hotelIds == null) {
            totalExpiredHotels.setAtbDBErrCommCounter(totalExpiredHotels.getAtbDBErrCommCounter()+1);
        } else {
            /**
             * Divide hotels into chunks
             */
            for (int j = 0; j < hotelIds.size(); j++) {
                hotelIdsTemp.add(hotelIds.get(j));
                if (hotelIdsTemp.size() > 400 || j == hotelIds.size() - 1) {
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
                    NonStaticXMLAPI nonStaticXMLAPI = new NonStaticXMLAPI();
                    NonStaticXMLAPISoap nonStaticXMLAPISoap = nonStaticXMLAPI.getNonStaticXMLAPISoap();
                    GetStaticHotelsAndRoomsResult getStaticHotelsAndRoomsResult = nonStaticXMLAPISoap.getStaticHotelsAndRooms(ProjectProperties.sunhotelsUsername, ProjectProperties.sunhotelspass, "English", "", reqHotelIds, "", "", "", "", "");
                    if (getStaticHotelsAndRoomsResult.getError() == null) {

                        /**
                         *If a hotel is expired delete related records of all tables in DB.
                         */
                        for (int hotelId : hotelIdsTemp) {
                            expired = true;
                            for (int i = 0; i < getStaticHotelsAndRoomsResult.getHotels().getHotel().size(); i++) {
                                if (getStaticHotelsAndRoomsResult.getHotels().getHotel().get(i).getHotelId() == hotelId)
                                    expired = false;
                            }
                            if (expired) {
                                StatelessSession session = SunHotelsHibernateUtil.getSession();
                                Transaction tx;
                                StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
                                Transaction tx2;
                                tx = session.beginTransaction();
                                tx2 = session2.beginTransaction();
                                List<HotelBean> hotels=HotelDAO.getHotelByHotelId(hotelId,sanHotelsProviderId,session);
                                if (hotels!=null && hotels.size()>0 && hotels.get(0).isActive()){
                                    hotels.get(0).setActive(false);
                                    if(HotelDAO.saveOrUpdateHotelBean(hotels.get(0),session,session2))
                                        totalExpiredHotels.setAtbDBErrCommCounter(totalExpiredHotels.getAtbDBErrCommCounter() + 1);
                                }
                                tx.commit();
                                tx2.commit();
                                session.close();
                                session2.close();
                                logger.info("********************** Deleting expired hotel with id: " + hotelId + " **********************");
                                totalExpiredHotelsList.add(hotelId);
                                totalExpiredHotels.setTotalExpiredhotels(totalExpiredHotels.getTotalExpiredhotels() + 1);
                            }
                        }
                    } else {
                        Application.agent.increment("app.web.error.updates.sunhotels",1,0);
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
