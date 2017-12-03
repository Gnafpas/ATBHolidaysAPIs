package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import Beans.ATBDBBeans.KalitaonProduct.SupplierPhotoPathBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import java.io.PrintWriter;
import java.io.StringWriter;

import static Controller.Application.errLogger;

/**
 * Created by George on 05/10/2017.
 */
public class SupplierPhotoPathDAO {

    public static SupplierPhotoPathBean getSupplierPhotoPathBySupplierId(String supplierId){

        StatelessSession session = ATBHibernateUtil.getSession();
        SupplierPhotoPathBean supplierPhotoPath=null;
        String hql ="Select a FROM SupplierPhotoPathBean a WHERE a.supplierId='"+ supplierId +"'";
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            supplierPhotoPath=(SupplierPhotoPathBean)query.getSingleResult();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e){
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
        return supplierPhotoPath;
    }
}
