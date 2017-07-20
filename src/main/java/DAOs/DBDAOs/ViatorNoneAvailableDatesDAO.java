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

    private HibernateUtil helper;
    private Session session;

    public boolean addNoneAvailabilityDate(ViatorNoneAvailableDatesBean availabilityDatesBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
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

    public boolean deleteProductNoneAvailDates(String productCode){

        String hql = String.format("delete from ViatorNoneAvailableDatesBean WHERE productCode='"+productCode+"'");
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

    public List<CustomDate> getNoneAvailDatesOfProducts(List<ViatorProductDetailsBean> productsDetails){

        List<CustomDate> nonAvailDates=null;
        String hql=  " select  DISTINCT(nonAvailDates)" +
                     " from DBBeans.ViatorNoneAvailableDatesBean nonAvailDates";
        int i=0;
        for(ViatorProductDetailsBean productDetails:productsDetails){
            if(i==0)
              hql= hql + " where nonAvailDates.productCode= :code" + i;
            else
              hql= hql + " or nonAvailDates.productCode= :code" + i;
            i++;
        }

        try{
            session = helper.getSession();
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
