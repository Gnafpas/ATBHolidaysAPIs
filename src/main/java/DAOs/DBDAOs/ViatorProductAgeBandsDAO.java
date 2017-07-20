package DAOs.DBDAOs;

import DBBeans.ViatorProductAgeBandsBean;
import DBConnection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by George on 20/06/17.
 */
public class ViatorProductAgeBandsDAO {

    private HibernateUtil helper;
    private Session session;

    public boolean addproductagebandsBean(ViatorProductAgeBandsBean viatorproductagebandsBean){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(viatorproductagebandsBean);
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

    public boolean deleteProductAgeBands(String productCode){

        String hql = String.format("DELETE FROM ViatorProductAgeBandsBean WHERE productCode='"+productCode+"'");
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

    public List<ViatorProductAgeBandsBean> getAgeBandsByProductCode(String productCode){

        List<ViatorProductAgeBandsBean> ageBands=null;
        String hql ="Select ageBands FROM ViatorProductAgeBandsBean ageBands " +
                                    "WHERE ageBands.productCode like :productCode " +
                                    "order by ageBands.sortOrder";
        try{
            session = helper.getSession();
            session.beginTransaction();
            ageBands=session.createQuery(hql).setParameter("productCode",   productCode ).getResultList();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return ageBands;
    }
}
