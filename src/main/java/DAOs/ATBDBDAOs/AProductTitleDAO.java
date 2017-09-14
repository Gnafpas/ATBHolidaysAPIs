package DAOs.ATBDBDAOs;

import ATBDBBeans.AProductTitleBean;
import DBConnection.ATBHibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by George on 08/08/2017.
 */
public class AProductTitleDAO {

    public static boolean addproduct(AProductTitleBean product){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.insert(product);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
            session.close();
        }
        return err;
    }

    public static boolean deleteProduct(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM AProductTitleBean WHERE productCode='"+code+"' AND main_supplier_name = 'Viator'");
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
            session.close();
        }
        return err;
    }


    public static List<String> getAllViatorProductsCodes(){

        StatelessSession session = ATBHibernateUtil.getSession();
        List <String> products=null;
        String hql = "select productCode from AProductTitleBean  where main_supplier_name = 'Viator'";
        try{
            session.beginTransaction();
            products=session.createQuery(hql).list();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
            session.close();
        }
        return products;
    }


    public static  AProductTitleBean getProductByCode(String productCode){

        StatelessSession session = ATBHibernateUtil.getSession();
        AProductTitleBean pricePlanBean=null;
        String hql ="Select a FROM AProductTitleBean a WHERE a.productCode='"+ productCode +"'";
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            pricePlanBean=(AProductTitleBean)query.getSingleResult();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException nre){

        }
        return pricePlanBean;
    }

    public static AProductTitleBean getLastRecord(){
        StatelessSession session = ATBHibernateUtil.getSession();
        String hql=     " select  a"
                      + " from ATBDBBeans.AProductTitleBean a"
                      + " order by a.id DESC";
        AProductTitleBean product=null;
        try{
        Query query= session.createQuery(hql);
        query.setMaxResults(1);
            product=(AProductTitleBean)query.getSingleResult();
        session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException e) {
            e.printStackTrace();
        }

        return product;
    }

}
