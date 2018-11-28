package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.HotelBean;
import Beans.ATBDBBeans.KalitaonHotel.RoomPolicyBean;
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
public class RoomPolicyDAO {

    public static List<RoomPolicyBean> getRoomPolicies(int hotelId, String roomId,int providerId) {

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        List<RoomPolicyBean> roomPolicies=null;
        String hql = "select roomPolicyBean from RoomPolicyBean roomPolicyBean  where roomPolicyBean.hotelId="+hotelId+" and roomPolicyBean.roomId="+roomId+" and roomPolicyBean.providerId="+providerId;

        try {
            session.beginTransaction();
            roomPolicies = session.createQuery(hql).getResultList();
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
            session.close();
        }

        return roomPolicies;
    }
}
