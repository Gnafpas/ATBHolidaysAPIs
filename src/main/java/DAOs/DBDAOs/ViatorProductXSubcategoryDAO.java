package DAOs.DBDAOs;

import DBBeans.ViatorCategoriesBean;
import DBBeans.ViatorProductXSubcategoryBean;
import DBBeans.ViatorSubcategoriesBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 20/06/17.
 */
public class ViatorProductXSubcategoryDAO {

    public static boolean addprodactXsubcategory(ViatorProductXSubcategoryBean viatorproductxsubcategoryBean ){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorproductxsubcategoryBean);
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

    public static boolean deleteProductXSubctegory(String productCode){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductXSubcategoryBean WHERE productCode='"+productCode+"'");
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

    public static List<ViatorSubcategoriesBean> getProductSubcategoriesByProductCode(String productCode,int categoryId){

        Session session = HibernateUtil.getSession();
        List<ViatorSubcategoriesBean> subcategory=null;
        String hql ="Select subcategory FROM ViatorProductXSubcategoryBean productXSubcategory ,ViatorCategoriesBean category ,ViatorSubcategoriesBean subcategory " +
                                       "WHERE productXSubcategory.productCode like :productCode " +
                                       "AND   subcategory.id = productXSubcategory.subcategoryId " +
                                       "AND   category.id = subcategory.categoryId " +
                                       "AND   category.id = :categoryId " +
                                       "order by subcategory.sortOrder ";
        try{
            session.beginTransaction();
            subcategory=session.createQuery(hql).setParameter("productCode",   productCode )
                                                .setParameter("categoryId",   categoryId )
                                                .getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return subcategory;
    }
}
