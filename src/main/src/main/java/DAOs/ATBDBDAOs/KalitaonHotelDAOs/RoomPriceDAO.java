package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.RoomPriceBean;
import DBConnection.SunHotelsHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 08/05/2018.
 */
public class RoomPriceDAO {

    public static List<RoomPriceBean> getRoomPricesbyRoomId(String roomId, int providerId, List<String> dates,int availableId, StatelessSession session){

        boolean externalSession=false;
        if(session==null) {
            session = SunHotelsHibernateUtil.getSession();
            externalSession =true;
        }
        List<RoomPriceBean> roomPriceBeans=null;
        String hql = "select roomPriceBean from RoomPriceBean roomPriceBean where   roomPriceBean.providerId="+providerId+" and roomPriceBean.roomId="+roomId + " and roomPriceBean.availableId="+availableId;

        if(dates.size()>0) {
            hql = hql + " and (roomPriceBean.date='" + dates.get(0) + "'";
            for (String date : dates) {
                hql = hql + " or roomPriceBean.date='" + date + "'";
            }
            hql = hql + ")";

            try {
                if (externalSession)
                    session.beginTransaction();
                roomPriceBeans = session.createQuery(hql).getResultList();
            } catch (HibernateException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
            } catch (ExceptionInInitializerError e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
            } catch (ClientTransportException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
            } catch (CJCommunicationsException e) {
                StringWriter errors = new StringWriter();
                e.printStackTrace(new PrintWriter(errors));
                errLogger.info(errors.toString());
            } catch (NoResultException e) {

            } finally {
                if (externalSession)
                    session.close();
            }
        }
        return roomPriceBeans;
    }
}
