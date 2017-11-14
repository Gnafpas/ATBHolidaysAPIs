package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.ProductCategoriesBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;

import java.util.List;

/**
 * Created by George on 18/09/2017.
 */
public class ProductCategoriesDAO {

    public static List<ProductCategoriesBean> getAllCategories(){

        StatelessSession session = ATBHibernateUtil.getSession();
        List <ProductCategoriesBean> categories=null;
        String hql = "select categories from ProductCategoriesBean categories ";
        try{
            session.beginTransaction();
            categories=session.createQuery(hql).list();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e) {
            e.printStackTrace();
        }finally {
                session.close();
            }
        return categories;
    }
}
