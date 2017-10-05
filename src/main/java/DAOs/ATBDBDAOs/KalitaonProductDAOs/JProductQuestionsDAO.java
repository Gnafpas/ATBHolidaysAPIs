package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.JProductQuestionsBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by George on 05/10/2017.
 */
public class JProductQuestionsDAO {

    public static boolean addpProductQuestion(List<JProductQuestionsBean> productQuestions){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            for(JProductQuestionsBean productQuestion:productQuestions)
               session.insert(productQuestion);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return err;
    }

    public static boolean deleteProductQuestions(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM JProductQuestionsBean WHERE productId='"+productId+"'");
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
            e.printStackTrace();
        }
        return err;
    }

    public static  List<JProductQuestionsBean> getProductByCode(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<JProductQuestionsBean> productQuestions=null;
        String hql ="Select a FROM JProductQuestionsBean a WHERE a.productId like :productId";
        try{
            session.beginTransaction();
            productQuestions=session.createQuery(hql).setParameter("productId",   productId ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException e){
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return productQuestions;
    }

}
