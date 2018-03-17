package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.RoomBean;
import DBConnection.SunHotelsHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.sanHotelsProviderId;

/**
 * Created by George on 23/11/2017.
 */
public class RoomDAO {

    public static boolean addRoomBean(List<RoomBean> rooms,StatelessSession session,StatelessSession session2){

        boolean err=false;
        try{
            for(RoomBean room:rooms) {
                session.insert(room);
                session2.insert(room);
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

    public static boolean deleteRoomBean(int hotelId,int providerId,StatelessSession session,StatelessSession session2){

        String hql = String.format("DELETE FROM RoomBean WHERE hotelId='"+hotelId+"' and providerId='"+providerId+"'");
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

    public static List<RoomBean> getRoomsByHotelId(int hotelId,int providerId,StatelessSession session){

        boolean externalSession=false;
        if(session==null) {
            session = SunHotelsHibernateUtil.getSession();
            externalSession =true;
        }
        List<RoomBean> rooms=null;
        String hql = "select room from RoomBean room where  room.hotelId='"+hotelId+"' and room.providerId='"+providerId+"'";
        try{
            if(externalSession)
               session.beginTransaction();
            rooms=session.createQuery(hql).list();
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

        }catch (PersistenceException e){

        }finally {
            if(externalSession)
               session.close();
        }
        return rooms;
    }

    public static RoomBean getRoomBeanByOriginalId(String roomId,int hotelId,int providerId,StatelessSession session) {

        boolean incomingSession=true;

        RoomBean roomBean = null;
        String hql = "select room from RoomBean room where room.originalRoomId='" + roomId + "' and room.hotelId='"+hotelId+"' and room.providerId='"+providerId+"'";
        try {
            if(session==null) {
                session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();
                incomingSession=false;
            }
            roomBean = (RoomBean) session.createQuery(hql).getSingleResult();
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
            roomBean = null;
        }finally {
            if(!incomingSession)
                session.close();
        }
        return roomBean;
    }

    public static String getOriginalRoomId(String atbroomId,StatelessSession session) {

        boolean incomingSession=true;

        String originalRoomId = null;
        String hql = "select room.originalRoomId from RoomBean room where room.atbRoomId='" + atbroomId + "'";
        try {
            if(session==null) {
                session = SunHotelsHibernateUtil.getSession();
                session.beginTransaction();
                incomingSession=false;
            }
            originalRoomId = (String) session.createQuery(hql).getSingleResult();
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
            originalRoomId = null;
        }finally {
            if(!incomingSession)
                session.close();
        }
        return originalRoomId;
    }
}
