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

    private HibernateUtil helper;
    private Session session;

    public boolean addprodactXsubcategory(ViatorProductXSubcategoryBean viatorproductxsubcategoryBean ){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
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

    public boolean deleteProductXSubctegory(String productCode){

        String hql = String.format("DELETE FROM ViatorProductXSubcategoryBean WHERE productCode='"+productCode+"'");
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

    public List<ViatorSubcategoriesBean> getProductSubcategoriesByProductCode(String productCode,int categoryId){

        List<ViatorSubcategoriesBean> subcategory=null;
        String hql ="Select subcategory FROM ViatorProductXSubcategoryBean productXSubcategory ,ViatorCategoriesBean category ,ViatorSubcategoriesBean subcategory " +
                                       "WHERE productXSubcategory.productCode like :productCode " +
                                       "AND   subcategory.id = productXSubcategory.subcategoryId " +
                                       "AND   category.id = subcategory.categoryId " +
                                       "AND   category.id = :categoryId " +
                                       "order by subcategory.sortOrder ";
        try{
            session = helper.getSession();
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
