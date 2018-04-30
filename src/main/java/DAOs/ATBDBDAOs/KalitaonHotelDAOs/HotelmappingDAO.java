package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.HotelBean;
import Beans.ATBDBBeans.KalitaonHotel.HotelmappingBean;
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
 * Created by George on 05/12/2017.
 */
public class HotelmappingDAO {

    public static boolean addHotelmapping(int hotelId,int providerId, StatelessSession session, StatelessSession session2){

        HotelmappingBean hotelmappingBean=new HotelmappingBean();
        hotelmappingBean.setHotelId(hotelId);
        hotelmappingBean.setProviderId(providerId);
        boolean err=false;
        try{
            session.insert(hotelmappingBean);
         //   session2.insert(hotelmappingBean);
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
        }catch (ClientTransportException e) {
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

    public static boolean deleteHotelmapping(int hotelId,int providerId,StatelessSession session,StatelessSession session2){

        String hql = String.format("DELETE FROM HotelmappingBean WHERE hotelId='"+hotelId+"' and providerId='"+providerId+"'");
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
        }catch (ClientTransportException e) {
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

    public static int getATBHotelId(int hotelId,int providerId,StatelessSession session) {

        boolean incomingSession=true;

        int atbHotelId = 0;
        String hql = "select id from HotelmappingBean hotelmappin where providerId='" + providerId + "' and hotelId='" + hotelId + "'";
        try {
            if(session==null) {
                session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();
                incomingSession=false;
            }
            atbHotelId = (int) session.createQuery(hql).getSingleResult();
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
        }catch (NoResultException e){
            atbHotelId = 0;
        }finally {
            if(!incomingSession)
              session.close();
        }
        return atbHotelId;
    }

    public static List<HotelmappingBean> getHotelsMapping(List<HotelBean> hotels, int providerId) {


        StatelessSession session = SunHotelsHibernateUtil.getSession();
        List<HotelmappingBean> hotelsmapping = null;
        String hql = "select hotelmapping from HotelmappingBean hotelmapping where providerId='" + providerId + "' and (hotelId='" + hotels.get(0).getHotelId() + "'";
        for(HotelBean hotel:hotels){
            hql=hql+" or hotelId='" + hotel.getHotelId() + "'";
        }
        hql=hql+")";
        try {
            session.beginTransaction();
            hotelsmapping =  session.createQuery(hql).list();
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
        }catch (NoResultException e){
        }finally {
            session.close();
        }
        return hotelsmapping;
    }

    public static HotelmappingBean getHotelMappingbyATBId(int aTBId) {


        StatelessSession session = SunHotelsHibernateUtil.getSession();
        HotelmappingBean hotelsmapping = null;
        String hql = "select hotelmapping from HotelmappingBean hotelmapping where  id='" +aTBId + "'";
        try {
            session.beginTransaction();
            hotelsmapping =  (HotelmappingBean)session.createQuery(hql).getSingleResult();
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
        }catch (NoResultException e){
        }finally {
            session.close();
        }
        return hotelsmapping;
    }

    public static List<HotelmappingBean> getAllProviderHotelsMapping(int providerId) {


        StatelessSession session = SunHotelsHibernateUtil.getSession();
        List<HotelmappingBean> hotelsmapping = null;
        String hql = "select hotelmapping from HotelmappingBean hotelmapping where providerId='" + providerId +"'";
        try {
            session.beginTransaction();
            hotelsmapping =  session.createQuery(hql).list();
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
        }catch (NoResultException e){
        }finally {
            session.close();
        }
        return hotelsmapping;
    }



    public static int getOriginalHotelId(int atbhotelId,StatelessSession session) {

        boolean incomingSession=true;

        int atbHotelId = 0;
        String hql = "select hotelId from HotelmappingBean hotelmappin where id='" + atbhotelId + "'";
        try {
            if(session==null) {
                session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();
                incomingSession=false;
            }
            atbHotelId = (int) session.createQuery(hql).getSingleResult();
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
        }catch (NoResultException e){
            atbHotelId = 0;
        }finally {
            if(!incomingSession)
                session.close();
        }
        return atbHotelId;
    }

}
