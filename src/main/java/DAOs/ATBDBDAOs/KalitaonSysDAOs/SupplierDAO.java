package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;
import DBConnection.ATBHibernateUtil;
import DBConnection.ATBSysHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import Beans.ATBDBBeans.KalitaonSystem.SupplierBean;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;

public class SupplierDAO {



    public static int getSupplierId(String supplierName){

        //String hql = String.format("SELECT id FROM SupplierBean WHERE supplier_name='"+supplierName+"'");
        Session session = ATBSysHibernateUtil.getSession();
        SupplierBean supplier=null;
        int id = 0;
        String hql = "SELECT id FROM SupplierBean WHERE supplierName like :supplierName";
        try{
            session.beginTransaction();
            id = (int) session.createQuery(hql).setParameter("supplierName",  supplierName ).getSingleResult();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
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
        return id;
    }
}

