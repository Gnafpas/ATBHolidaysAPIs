package DAOs.ATBDBDAOs.KalitaonHotelDAOs;

import Beans.ATBDBBeans.KalitaonHotel.PhotoBean;
import DBConnection.SunHotelsHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.hibernate.AssertionFailure;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;

import javax.persistence.NoResultException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import static Controller.Application.errLogger;
import static Helper.ProjectProperties.sanHotelsProviderId;

/**
 * Created by George on 23/11/2017.
 */
public class PhotoDAO {

    public static boolean addPhotoBean(List<PhotoBean> photos,StatelessSession session,StatelessSession session2){

        boolean err=false;
        try{
            for(PhotoBean photo:photos) {
                session.insert(photo);
           //     session2.insert(photo);
            }
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }
        return err;
    }

    public static boolean deletePhotoBean(int hotelId,int providerId,StatelessSession session,StatelessSession session2){

        String hql = String.format("DELETE FROM PhotoBean WHERE hotelId='"+hotelId+"' and providerId='"+providerId+"'");
        boolean err=false;
        try{
            session.createQuery(hql).executeUpdate();
        //    session2.createQuery(hql).executeUpdate();
        }catch (HibernateException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        } catch (ClientTransportException e) {
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }
        return err;
    }

    public static List<PhotoBean> getPhotosByHotelId(int hotelId,int providerId,StatelessSession session){

        boolean externalSession=false;
        if(session==null) {
            session = SunHotelsHibernateUtil.getSession();
            externalSession =true;
        };
        List<PhotoBean> photos=null;
        String hql = "select photo from PhotoBean photo where  photo.hotelId='"+hotelId+"' and providerId='"+providerId+"'";
        try{
            if(externalSession)
                session.beginTransaction();
            photos=session.createQuery(hql).list();
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ClientTransportException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e){

        }finally {
            if(externalSession)
                session.close();
        }
        return photos;
    }
}
