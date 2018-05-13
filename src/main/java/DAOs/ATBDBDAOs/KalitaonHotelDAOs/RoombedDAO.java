package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.RoombedBean;
import DBConnection.SunHotelsHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.sanHotelsProviderId;

/**
 * Created by George on 23/11/2017.
 */
public class RoombedDAO {

    public static boolean addRoombedBean(List<RoombedBean> roombeds,StatelessSession session,StatelessSession session2){


        boolean err=false;
        try{
            for(RoombedBean roombed :roombeds) {
                session.insert(roombed);
             //   session2.insert(roombed);
            }
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }
        return err;
    }

    public static boolean deleteRoombedBean(int hotelId,int providerId,StatelessSession session,StatelessSession session2){

        String hql = String.format("DELETE FROM RoombedBean WHERE hotelId='"+hotelId+"' and providerId='"+providerId+"'");
        boolean err=false;
        try{
            session.createQuery(hql).executeUpdate();
         //   session2.createQuery(hql).executeUpdate();
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }
        return err;
    }


    public static RoombedBean getRoombed(int hotelId, String roomId,int providerId) {

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        RoombedBean roombed=null;
        String hql = "select roombedBean from RoombedBean roombedBean  where roombedBean.hotelId="+hotelId+" and roombedBean.roomId="+roomId+" and roombedBean.providerId="+providerId;

        try {
            session.beginTransaction();
            roombed = (RoombedBean)session.createQuery(hql).getSingleResult();
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

        return roombed;
    }
}
