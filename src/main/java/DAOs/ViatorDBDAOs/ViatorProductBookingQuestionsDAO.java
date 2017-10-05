package DAOs.ViatorDBDAOs;

import Beans.ViatorDBBeans.ViatorProductBookingQuestionsBean;
import DBConnection.HibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 21/08/2017.
 */
public class ViatorProductBookingQuestionsDAO {

    public static boolean addBookingQuestion(ViatorProductBookingQuestionsBean viatorProductBookingQuestionsBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{

            tx=session.beginTransaction();
            session.save(viatorProductBookingQuestionsBean);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static boolean deleteBookingQuestion(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductBookingQuestionsBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public static List<ViatorProductBookingQuestionsBean> getBookingQuestionsByProductCode(String productCode){

        Session session = HibernateUtil.getSession();
        List<ViatorProductBookingQuestionsBean> bookingQuestions=null;
        String hql ="Select bookingQuestions FROM ViatorProductBookingQuestionsBean bookingQuestions " +
                    "WHERE bookingQuestions.productCode like :productCode " +
                    "order by bookingQuestions.sortOrder";
        try{
            session.beginTransaction();
            bookingQuestions=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return bookingQuestions;
    }

}

