package DAOs.DBDAOs;


import DBBeans.ViatorProductDetailsBean;
import DBConnection.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by George on 15/06/2017.
 */
public class ViatorProductDetailsDAO {
    private HibernateUtil helper;
    private Session session;

    public boolean addproduct(ViatorProductDetailsBean bid){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(bid);
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

    public boolean deleteProduct(String code){

        String hql = String.format("DELETE FROM ViatorProductDetailsBean WHERE code='"+code+"'");
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

    public List<String> getAllProductsCodes(){
        List <String> products=null;
        String hql = "select code from ViatorProductDetailsBean";
        try{
            session = helper.getSession();
            session.beginTransaction();
            products=session.createQuery(hql).list();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return products;
    }


    public List <ViatorProductDetailsBean> getProducts(String code){
        List <ViatorProductDetailsBean> products=null;

        String hql =   " select DISTINCT(i) "
                +   " from DBBeans.ViatorProductDetailsBean i "
                +   " where i.code LIKE :code ";
        Transaction tx = null;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            products = session.createQuery(hql)
                    .setParameter("code", "%" + code + "%").list();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }

        return products;






//        Transaction tx = null;
//        try{
//            session = helper.getSession();
//            tx=session.beginTransaction();
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<ViatorProductDetailsBean> criteria = builder.createQuery(ViatorProductDetailsBean.class);
//            Root<ViatorProductDetailsBean> product = criteria.from(ViatorProductDetailsBean.class);
//            criteria.select(product);
//            criteria.where(
//                    builder.a
//            );
//            products = session.createQuery(criteria).getResultList();
//            session.close();
//        }catch (HibernateException e) {
//            e.printStackTrace();
//            session.close();
//        }catch (ExceptionInInitializerError e) {
//            e.printStackTrace();
//        }


    }
}
