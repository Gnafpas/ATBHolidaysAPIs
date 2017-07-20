package DAOs.DBDAOs;

import DBBeans.ViatorProductReviewsBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 20/06/17.
 */
public class ViatorProductReviewsDAO {
//todo Add table to DB for travel agents reviews
    private HibernateUtil helper;
    private Session session;

    public boolean addproductreviews(ViatorProductReviewsBean viatorproductreviewsBean ){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorproductreviewsBean);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public boolean deleteProductReviews(String productCode){

        String hql = String.format("DELETE FROM ViatorProductReviewsBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
            session = helper.getSession();
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }
        return err;
    }

    public List<ViatorProductReviewsBean> getReviewsByProductCode(String productCode){

        List<ViatorProductReviewsBean> productReviewsBean=null;
        String hql ="Select reviews FROM ViatorProductReviewsBean reviews " +
                                   "WHERE reviews.productCode like :productCode " +
                                   "order by reviews.sortOrder " ;
        try{
            session = helper.getSession();
            session.beginTransaction();
            productReviewsBean=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return productReviewsBean;
    }

}
