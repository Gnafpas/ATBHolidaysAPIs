package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.ResortBean;
import Beans.ATBDBBeans.KalitaonHotel.ResortMappingBean;
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

/**
 * Created by George on 29/12/2017.
 */
public class ResortMappingDAO {

    public static boolean addResortMapping(String resortId, int providerId, StatelessSession session, StatelessSession session2){

        ResortMappingBean resortMappingBean=new ResortMappingBean();
        resortMappingBean.setResortId(resortId);
        resortMappingBean.setProviderId(providerId);
        boolean err=false;
        try{
            session.insert(resortMappingBean);
          //  session2.insert(resortMappingBean);
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

    public static boolean deleteResortMapping(int resortId,int providerId,StatelessSession session,StatelessSession session2){

        String hql = String.format("DELETE FROM ResortMappingBean WHERE resortId='"+resortId+"' and providerId='"+providerId+"'");
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

    public static int getATBResortId(int resortId,int providerId,StatelessSession session) {

        boolean incomingSession=true;

        int atbHotelId = 0;
        String hql = "select resortMapping.id from ResortMappingBean resortMapping where resortMapping.providerId='" + providerId + "' and resortMapping.resortId='" + resortId + "'";
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

    public static List<ResortMappingBean> getResortsMapping(List<ResortBean> resorts, int providerId) {


        StatelessSession session = SunHotelsHibernateUtil.getSession();
        List<ResortMappingBean> resortsMapping = null;
        String hql = "select resortMapping from ResortMappingBean resortMapping where providerId='" + providerId + "' and (hotelId='" + resorts.get(0).getResortId() + "'";
        for(ResortBean resort:resorts){
            hql=hql+" or resortId='" + resort.getResortId() + "'";
        }
        hql=hql+")";
        try {
            session.beginTransaction();
            resortsMapping =  session.createQuery(hql).list();
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
        return resortsMapping;
    }

    public static List<ResortMappingBean> getAllProviderResortMapping(int providerId) {


        StatelessSession session = SunHotelsHibernateUtil.getSession();
        List<ResortMappingBean> resortMapping = null;
        String hql = "select resortMapping from ResortMappingBean resortMapping where providerId='" + providerId +"'";
        try {
            session.beginTransaction();
            resortMapping =  session.createQuery(hql).list();
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
        return resortMapping;
    }



    public static int getOriginalResortId(int atbresortId,StatelessSession session) {

        boolean incomingSession=true;

        int resortId = 0;
        String hql = "select resortMapping.resortId from ResortMappingBean resortMapping where resortMapping.id='" + atbresortId + "'";
        try {
            if(session==null) {
                session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();
                incomingSession=false;
            }
            resortId = (int) session.createQuery(hql).getSingleResult();
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
            resortId = 0;
        }finally {
            if(!incomingSession)
                session.close();
        }
        return resortId;
    }

}
