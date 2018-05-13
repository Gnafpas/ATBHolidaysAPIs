package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.HotelBean;
import Beans.ATBDBBeans.KalitaonHotel.RoomAvailableBean;
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
import static Helper.ProjectProperties.hotelBedsProviderId;
import static Helper.ProjectProperties.sanHotelsProviderId;

/**
 * Created by George on 06/05/2018.
 */
public class RoomAvailableDAO {

    public static List<RoomAvailableBean> getRoomAvailable(List<HotelBean> hotels, String startDate, String endDate, int mealId) {

        StatelessSession session =SunHotelsHibernateUtil.getSession();
        List<RoomAvailableBean> rooms=null;
        if(hotels!=null && hotels.size()>0) {
            String hql = "select roomAvailable from RoomAvailableBean roomAvailable where (roomAvailable.hotelId=" + hotels.get(0).getHotelId();
            for (HotelBean hotel : hotels) {
                hql = hql + " or roomAvailable.hotelId=" + hotel.getHotelId();
            }
            hql = hql + " )";
            hql=hql + " and roomAvailable.startDate<='" + startDate + "'" +
                      " and roomAvailable.endDate>='" + endDate + "'" ;
            if (mealId != 0) {
                hql = hql + " and roomAvailable.mealType=" + mealId;//todo change mealtype with meal id in db
            }
            try {
                session.beginTransaction();
                rooms = session.createQuery(hql).list();
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
        }
        return rooms;
    }
}
