package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.BookingsAllBean;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 26/01/2018.
 */
public class BookingsAllDAO {

    public static int storeBooking(BookingsAllBean bookingsAllBean){

        Integer bookingId=0;
        Session session = ATBSysHibernateUtil.getSession();
        BookingsAllBean booking=null;
        String hql = "select booking from BookingsAllBean booking  order by booking.id DESC";
        try{
            session.beginTransaction();
            session.save(bookingsAllBean);
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            booking=(BookingsAllBean)query.getSingleResult();
            bookingId=booking.getId();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {

        }finally{
            session.close();
        }
        return bookingId;
    }

    public static boolean updateBooking(BookingsAllBean bookingsAllBean) {

        Session session = ATBSysHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            tx = session.beginTransaction();
            session.update(bookingsAllBean);
            tx.commit();
        } catch (HibernateException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (CJCommunicationsException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } finally {
            session.close();
        }
        return err;
    }

    public static BookingsAllBean getBookingsAllBeanById(int bookingId,int agentId){

        Session session = ATBSysHibernateUtil.getSession();
        BookingsAllBean booking=null;
        String hql = "select booking from BookingsAllBean booking " +
                "where booking.id =:bookingId and booking.agentId ='"+agentId+"'";
        try{
            session.beginTransaction();
            booking=(BookingsAllBean)session.createQuery(hql).setParameter("bookingId",bookingId ).getSingleResult();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return booking;
    }

    public static  List<BookingsAllBean> getBookingsAllByBookingId(String bookingId,int agentId){

        Session session = ATBSysHibernateUtil.getSession();
        List<BookingsAllBean>  bookings=null;
        String hql = "select booking from BookingsAllBean booking " +
                "where booking.bookingId like :bookingId and booking.agentId ='"+agentId+"'";
        try{
            session.beginTransaction();
            bookings=session.createQuery(hql).setParameter("bookingId", "%" +bookingId + "%" ).list();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return bookings;
    }

    public static List<BookingsAllBean> getAllHotelBookingsByDate(ZonedDateTime dateFrom,ZonedDateTime dateTo,int agentId){

        Session session = ATBSysHibernateUtil.getSession();
        List<BookingsAllBean> bookings=null;
        String hql = "select booking from BookingsAllBean booking " +
                     "where booking.agentId ='"+agentId+"' and booking.productType='HTL' and booking.bookingDate  between :dateFrom and :dateTo";

        try{
            session.beginTransaction();
            bookings=session.createQuery(hql).setParameter("dateFrom", Date.from(dateFrom.toInstant()), TemporalType.DATE).
                                              setParameter("dateTo", Date.from(dateTo.toInstant()), TemporalType.DATE).getResultList();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return bookings;
    }

    public static List<BookingsAllBean> getAllProductBookingsByDate(ZonedDateTime dateFrom,ZonedDateTime dateTo,int agentId){

        Session session = ATBSysHibernateUtil.getSession();
        List<BookingsAllBean> bookings=null;
        String hql = "select booking from BookingsAllBean booking " +
                "where booking.agentId ='"+agentId+"' and booking.productType!='HTL' and booking.bookingDate  between :dateFrom and :dateTo";

        try{
            session.beginTransaction();
            bookings=session.createQuery(hql).setParameter("dateFrom", Date.from(dateFrom.toInstant()), TemporalType.DATE).
                    setParameter("dateTo", Date.from(dateTo.toInstant()), TemporalType.DATE).getResultList();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return bookings;
    }
}
