package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.FPricePlanBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

/**
 * Created by George on 20/08/2017.
 */
public class FPricePlanDAO {

    public static int addPriceplan(FPricePlanBean pricePlanBean){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        String hql = "select fPricePlanBean from FPricePlanBean fPricePlanBean  order by fPricePlanBean.id DESC";
        int id=0;
        try{
            session = ATBHibernateUtil.getSession();
            tx=session.beginTransaction();
            session.insert(pricePlanBean);
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            pricePlanBean=(FPricePlanBean)query.getSingleResult();
            id=pricePlanBean.getId();
            tx.commit();
        }catch (HibernateException e) {
            id=0;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            id=0;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            id=0;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch(NoResultException e){

        }finally {
            session.close();
        }
        return id;
    }


    public static FPricePlanBean saveOrUpdatePriceplanViatorProductsOnly(FPricePlanBean pricePlanBean){
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        String hql ="Select fPricePlans.id FROM FPricePlanBean fPricePlans " +
                "WHERE fPricePlans.tourGradeCode like :tourGradeCode  and  fPricePlans.productId like :productId " +
                "and  fPricePlans.minParticipants like :minParticipants";
        int id=0;
        try{
            tx=session.beginTransaction();
            try {
                id = (int) session.createQuery(hql).setParameter("tourGradeCode", pricePlanBean.getTourGradeCode())
                                                   .setParameter("productId", pricePlanBean.getProductId())
                                                   .setParameter("minParticipants", pricePlanBean.getMinParticipants())
                                                   .getSingleResult();
            }catch(NoResultException e){
                id=0;
            }
            if(id!=0) {
                pricePlanBean.setId(id);
                session.update(pricePlanBean);
            }else {
                pricePlanBean.setId(0);
                session.insert(pricePlanBean);
                id=(int)session.createQuery(hql).setParameter("tourGradeCode", pricePlanBean.getTourGradeCode())
                                                .setParameter("productId", pricePlanBean.getProductId())
                                                .setParameter("minParticipants", pricePlanBean.getMinParticipants())
                                                .getSingleResult();
                if(id!=0)
                    pricePlanBean.setId(id);
                else
                    return null;
            }
            tx.commit();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            return null;
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            return null;
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
            return null;
        }catch(NoResultException e){

        }finally {
            session.close();
        }
        return pricePlanBean;
    }

    public static boolean deletePriceplan(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM FPricePlanBean WHERE productId='"+code+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
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
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }
        return err;
    }


    public static List<FPricePlanBean> getfPricePlansByProductId(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<FPricePlanBean> fPricePlans=null;
        String hql ="Select fPricePlans FROM FPricePlanBean fPricePlans " +
                "WHERE fPricePlans.productId like :productId ";
        try{
            session.beginTransaction();
            fPricePlans=session.createQuery(hql).setParameter("productId",   productId ).getResultList();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
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
        return fPricePlans;
    }

    public static FPricePlanBean getfPricePlansById(int planId){

        StatelessSession session = ATBHibernateUtil.getSession();
        FPricePlanBean fPricePlan=null;
        String hql ="Select fPricePlans FROM FPricePlanBean fPricePlans " +
                "WHERE fPricePlans.id =:planId ";
        try{
            session.beginTransaction();
            fPricePlan=(FPricePlanBean)session.createQuery(hql).setParameter("planId",   planId ).getSingleResult();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch(NoResultException e) {

        }finally {
            session.close();
        }
        return fPricePlan;
    }
}
