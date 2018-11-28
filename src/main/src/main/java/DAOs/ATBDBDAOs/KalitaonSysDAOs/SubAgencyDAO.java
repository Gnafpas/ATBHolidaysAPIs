package DAOs.ATBDBDAOs.KalitaonSysDAOs;

import Beans.ATBDBBeans.KalitaonSystem.SubAgencyBean;
import DBConnection.ATBSysHibernateUtil;
import DBConnection.SunHotelsHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static Controller.Application.errLogger;

/**
 * Created by George on 30/09/2017.
 */
public class SubAgencyDAO {

    public static boolean updateSubAgentByName(SubAgencyBean subAgencyBean) {

        Session session = ATBSysHibernateUtil.getSession();
        Transaction tx;
        boolean err = false;
        try {
            tx = session.beginTransaction();
            session.update(subAgencyBean);
            tx.commit();
        } catch (HibernateException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ExceptionInInitializerError e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (CJCommunicationsException e) {
            err = true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } finally {
            session.close();
        }
        return err;
    }

    public static SubAgencyBean getSubAgentByName(String agentName){

        Session session = ATBSysHibernateUtil.getSession();
        SubAgencyBean subAgency=null;
        String hql = "select subAgency from SubAgencyBean subAgency " +
                     "where subAgency.agentName like :agentName";
        try{
            session.beginTransaction();
            subAgency=(SubAgencyBean)session.createQuery(hql).setParameter("agentName",agentName ).getSingleResult();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return subAgency;
    }

    public static SubAgencyBean getSubAgentByStoreKey(String stroreKey){

        Session session = ATBSysHibernateUtil.getSession();
        SubAgencyBean subAgency=null;
        String hql = "select subAgency from SubAgencyBean subAgency " +
                "where subAgency.xmlStorekey like :stroreKey";
        try{
            session.beginTransaction();
            subAgency=(SubAgencyBean)session.createQuery(hql).setParameter("stroreKey",stroreKey ).getSingleResult();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return subAgency;
    }

    public static int storeAgentAPIKey(String agentName,String xmlStorekey){


        SubAgencyBean  subAgencyBean=null;
        subAgencyBean=getSubAgentByName(agentName);
        if(subAgencyBean==null){
            subAgencyBean=new SubAgencyBean();
            subAgencyBean.setAgentName(agentName);
            subAgencyBean.setXmlStorekey(xmlStorekey);
            subAgencyBean.setLastName("");
            subAgencyBean.setFirstName("");
            subAgencyBean.setTypeOfAgency("");
            subAgencyBean.setActivation("");
            subAgencyBean.setAccountNumber("");
            subAgencyBean.setAccountName("");
            subAgencyBean.setAsta("");
            subAgencyBean.setBankAddress("");
            subAgencyBean.setBankCity("");
            subAgencyBean.setBankCountry("");
            subAgencyBean.setBankName("");
            subAgencyBean.setBankState("");
            subAgencyBean.setBillingAddress("");
            subAgencyBean.setBillingEmail("");
            subAgencyBean.setCityCode("");
            subAgencyBean.setCityName("");
            subAgencyBean.setClia("");
            subAgencyBean.setCommission("");
            subAgencyBean.setCountryCode("");
            subAgencyBean.setCountryName("");
            subAgencyBean.setCreatedDate("");
            subAgencyBean.setCurrency("");
            subAgencyBean.setDeposit("");
            subAgencyBean.setGsaId("");
            subAgencyBean.setEmail("");
            subAgencyBean.setIata("");
            subAgencyBean.setIban("");
            subAgencyBean.setJobTitle("");
            subAgencyBean.setLogo("");
            subAgencyBean.setMarkup("");
            subAgencyBean.setMobile("");
            subAgencyBean.setNotes("");
            subAgencyBean.setSwift("");
            subAgencyBean.setOther("");
            subAgencyBean.setTaxNo("");
            subAgencyBean.setTaxOffice("");
            subAgencyBean.setTelephone("");
            subAgencyBean.setTursab("");
            subAgencyBean.setXmlStatus("");
            subAgencyBean.setWeb("");//todo add "" to new fields also



        }
        else
            subAgencyBean.setXmlStorekey(xmlStorekey);

        int subAgency=0;

        Session session = ATBSysHibernateUtil.getSession();
        try{
            session.beginTransaction();
            session.saveOrUpdate(subAgencyBean);
            session.getTransaction().commit();
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
        return subAgency;
    }

}
