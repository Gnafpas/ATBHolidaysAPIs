package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.HotelBean;
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
 * Created by George on 22/11/2017.
 */
public class HotelDAO {

    public static boolean addHotelBean(HotelBean hotelBean, StatelessSession session,StatelessSession session2){

        boolean err=false;
        try{
            session.insert(hotelBean);
            session2.insert(hotelBean);
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



    public static boolean deleteHotelBean(int hotelId,StatelessSession session,StatelessSession session2,int provider ){

        String hql = String.format("DELETE FROM HotelBean WHERE hotelId='"+hotelId+"' and providerId='"+provider+"'");
        boolean err=false;
        try{
            session.createQuery(hql).executeUpdate();
            session2.createQuery(hql).executeUpdate();
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

    public static List<Integer> getAllHotelsIds(int provider){

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        List <Integer> hotelIds=null;
        String hql = "select hotelId from HotelBean hotel where providerId='"+provider+"'";
        try{
            session.beginTransaction();
            hotelIds=session.createQuery(hql).list();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ClientTransportException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }
        return hotelIds;
    }



    public static List<HotelBean> getHotelByHotelId(int hotelId,int providerId,StatelessSession session) {

        boolean incomingSession=true;
        List<HotelBean> hotels=null;
        String hql = "select hotel from HotelBean hotel where  hotel.hotelId='"+hotelId+"' and providerId='"+providerId+"'";
        try{
            if(session==null) {
                session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();
                incomingSession=false;
            }
            hotels=session.createQuery(hql).list();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ClientTransportException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e){

        }finally {
            if(!incomingSession)
                session.close();
        }
        return hotels;
    }

    public static List<HotelBean> getHotelByHotelIds(List<Integer> hotelIds,int providerId,StatelessSession session) {

        boolean incomingSession=true;
        List<HotelBean> hotels=null;
        if(hotelIds!=null && hotelIds.size()>0) {
            String hql = "select hotel from HotelBean hotel where  providerId='" + providerId + "' and (hotel.hotelId='" + hotelIds.get(0)+"'";
            for (int id : hotelIds) {
                hql = hql + " or hotel.hotelId='" + id + "'";
            }
            hql= hql+")";
            try {
                if (session == null) {
                    session = SunHotelsHibernateUtil.getSession();
                    session.beginTransaction();
                    incomingSession = false;
                }
                hotels = session.createQuery(hql).list();
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
                if (!incomingSession)
                    session.close();
            }
        }
        return hotels;
    }

    public static List<HotelBean> getHotelByDestId(int destId,int providerId) {

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        List<HotelBean> hotels=null;
        String hql = "select hotel from HotelBean hotel where  hotel.destinationId='"+destId+"' and providerId='"+providerId+"'";
        try{
            session.beginTransaction();
            hotels=session.createQuery(hql).list();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ClientTransportException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e){

        }finally {
            session.close();
        }
        return hotels;
    }


}
