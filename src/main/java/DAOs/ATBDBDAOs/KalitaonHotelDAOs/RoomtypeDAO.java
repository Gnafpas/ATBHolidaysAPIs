package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.RoomBean;
import Beans.ATBDBBeans.KalitaonHotel.RoomtypeBean;
import DBConnection.SunHotelsHibernateUtil;
import DBConnection.SunHotelsMainServerHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.sanHotelsProviderId;

/**
 * Created by George on 23/11/2017.
 */
public class RoomtypeDAO {

    public static boolean addRoomtypeBean(RoomtypeBean roomtypeBean){

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
        Transaction tx;
        Transaction tx2;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.insert(roomtypeBean);
            tx.commit();
            tx2=session2.beginTransaction();
            session2.insert(roomtypeBean);
            tx2.commit();
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
        }finally {
            session.close();
            session2.close();
        }
        return err;
    }

    public static boolean deleteAllRoomtypes(){

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        StatelessSession session2 = SunHotelsMainServerHibernateUtil.getSession();
        String hql = String.format("DELETE FROM RoomtypeBean WHERE providerId='"+sanHotelsProviderId+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session2.beginTransaction();
            session2.createQuery(hql).executeUpdate();
            session2.getTransaction().commit();
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
        }finally {
            session.close();
            session2.close();
        }
        return err;
    }

    public static List<RoomtypeBean> getRoomsTypes(int providerId){

        StatelessSession session = SunHotelsHibernateUtil.getSession();
        List<RoomtypeBean> roomTypes=null;
        String hql = "select roomtype from RoomtypeBean roomtype where   roomtype.providerId='"+providerId+"'";
        try{
            session.beginTransaction();
            roomTypes=session.createQuery(hql).list();
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
        return roomTypes;
    }

    public static RoomtypeBean getRoomsTypesbyId(int roomtypeId,int providerId,StatelessSession session){

        boolean externalSession=false;
        if(session==null) {
            session = SunHotelsHibernateUtil.getSession();
            externalSession =true;
        }
        RoomtypeBean roomType=null;
        String hql = "select roomtype from RoomtypeBean roomtype where   roomtype.providerId='"+providerId+"' and roomtype.roomtypeId='"+roomtypeId+"'";
        try{
            if(externalSession)
                session.beginTransaction();
            roomType=(RoomtypeBean)session.createQuery(hql).getSingleResult();
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
            if(externalSession)
                session.close();
        }
        return roomType;
    }

    public static int getOriginalRoomtypeId(String atbRoomtypeId) {

        StatelessSession session;
        session = SunHotelsHibernateUtil.getSession();
        int originalRoomtypeId = 0;
        String hql = "select roomType.roomtypeId from RoomtypeBean roomType where roomType.id='" + atbRoomtypeId + "'";
        try {
            session.beginTransaction();
            originalRoomtypeId = (int) session.createQuery(hql).getSingleResult();
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
        return originalRoomtypeId;
    }
}
