package DAOs.DBDAOs;

import DBBeans.ViatorNoneAvailableDatesBean;
import DBBeans.ViatorProductDetailsBean;
import DBConnection.HibernateUtil;
import Helper.CustomDate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;

import java.util.List;

/**
 * Created by George on 07/07/2017.
 */
public class ViatorNoneAvailableDatesDAO {

    public static boolean addNoneAvailabilityDate(ViatorNoneAvailableDatesBean availabilityDatesBean){
        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{

            tx=session.beginTransaction();
            session.save(availabilityDatesBean);
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

    public static boolean deleteProductNoneAvailDates(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("delete from ViatorNoneAvailableDatesBean WHERE productCode='"+productCode+"'");
        boolean err=false;
        try{
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

    public static List<ViatorNoneAvailableDatesBean> getNoneAvailDatesOfProducts(List<ViatorProductDetailsBean> productsDetails){

        Session session = HibernateUtil.getSession();
        List<ViatorNoneAvailableDatesBean> nonAvailDates=null;
        String hql=  " select  DISTINCT(nonAvailDates)" +
                     " from DBBeans.ViatorNoneAvailableDatesBean nonAvailDates ";
        int i=0;
        for(ViatorProductDetailsBean productDetails:productsDetails){
            if(i==0)
              hql= hql + " where nonAvailDates.productCode= :code" + i;
            else
              hql= hql + " or nonAvailDates.productCode= :code" + i;
            i++;
        }
        hql= hql + " order by nonAvailDates.year asc,nonAvailDates.month asc,nonAvailDates.day asc";
        try{
            session.beginTransaction();
            Query query=session.createQuery(hql);
            i=0;
            for(ViatorProductDetailsBean productDetails:productsDetails){
                query.setParameter("code"+i,productDetails.getCode());
                i++;
            }
            nonAvailDates=query.getResultList();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }

        return nonAvailDates;
    }


}
