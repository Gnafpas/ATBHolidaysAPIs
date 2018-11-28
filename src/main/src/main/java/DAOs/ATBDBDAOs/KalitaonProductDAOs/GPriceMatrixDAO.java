package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.GPriceMatrixBean;
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
public class GPriceMatrixDAO {
    public static boolean addPriceMatrix(List<GPriceMatrixBean> priceMatrixes){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            for(GPriceMatrixBean priceMatrix:priceMatrixes)
                session.insert(priceMatrix);
            tx.commit();
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

    public static boolean saveOrUpdatePriceMatrix(List<GPriceMatrixBean> priceMatrixes){
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            for(GPriceMatrixBean priceMatrix:priceMatrixes) {
                String hql ="Select gPriceMatrix.id FROM GPriceMatrixBean gPriceMatrix " +
                        "WHERE gPriceMatrix.planId like :planId  and  gPriceMatrix.productId like :productId " +
                        "and  gPriceMatrix.ageFrom like :ageFrom and  gPriceMatrix.ageTo like :ageTo " +
                        "and  gPriceMatrix.minCountRequired= :minCountRequired and  gPriceMatrix.maxCountRequired= :maxCountRequired";
                int id;
                try {
                    id = (int) session.createQuery(hql).setParameter("planId", priceMatrix.getPlanId())
                            .setParameter("productId", priceMatrix.getProductId())
                            .setParameter("ageFrom", priceMatrix.getAgeFrom())
                            .setParameter("ageTo", priceMatrix.getAgeTo())
                            .setParameter("minCountRequired", priceMatrix.getMinCountRequired())
                            .setParameter("maxCountRequired", priceMatrix.getMaxCountRequired())
                            .getSingleResult();
                } catch (NoResultException e) {
                    id = 0;
                }
                if (id != 0) {
                    priceMatrix.setId(id);
                    session.update(priceMatrix);
                } else {
                    priceMatrix.setId(0);
                    session.insert(priceMatrix);
                }
            }
            tx.commit();
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
        }catch(NoResultException e){
            err=true;
        }finally {
            session.close();
        }
        return err;
    }

    public static boolean deletePriceMatrix(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM GPriceMatrixBean WHERE productId='"+code+"'");
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

    public static List<GPriceMatrixBean> getgPriceMatrixesByProductIdAndPlanId(String productId,String planId){

        StatelessSession session = ATBHibernateUtil.getSession();
        List<GPriceMatrixBean> gPriceMatrixes=null;
        String hql ="Select gPriceMatrixes FROM GPriceMatrixBean gPriceMatrixes " +
                "WHERE gPriceMatrixes.productId like :productId " +
                "AND   gPriceMatrixes.planId like :planId";
        try{
            session.beginTransaction();
            gPriceMatrixes=session.createQuery(hql).setParameter("productId",   productId )
                                                   .setParameter("planId",   "%"+planId+"%" )
                                                   .getResultList();
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
        return gPriceMatrixes;
    }
}
