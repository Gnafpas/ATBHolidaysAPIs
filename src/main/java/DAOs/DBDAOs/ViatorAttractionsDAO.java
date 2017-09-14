package DAOs.DBDAOs;

import DBBeans.ViatorAttractionsBean;
import DBConnection.HibernateUtil;
import Helper.SortOrderType;
import WebServicesBeans.ListingPage.GetAttractionsDAOParams;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by George on 17/07/2017.
 */
public class ViatorAttractionsDAO {

    public static boolean addAttraction(ViatorAttractionsBean viatorAttractionsBean){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(viatorAttractionsBean);
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

    public static boolean deleteAttraction(int seoId){

        Session session = HibernateUtil.getSession();
        String hql = String.format("delete from ViatorAttractionsBean WHERE seoId='"+seoId+"'");
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

    /**
     * Function for retrieve attractions by seoId,title,city,destination id or
     * a combination of those attributes.Capability of sorting by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, ALPHABETICAL.
     */
    public static List<ViatorAttractionsBean> getAttractions(GetAttractionsDAOParams params){

        Session session = HibernateUtil.getSession();
        List <ViatorAttractionsBean> attractions=null;
        int i;
        String hql=     " select  DISTINCT(attractions)"
                + " from DBBeans.ViatorAttractionsBean attractions";

        /**
         * Filters
         */
        hql=hql + " where attractions.title LIKE :title "
                + " and attractions.attractionCity LIKE :city ";
        if(params.getSeoId()!=0)
            hql=hql + " and attractions.seoId = :seoId ";
        if(params.getDestId()!=0)
            hql=hql + " and attractions.destinationId = :destId ";

        /**
         * Sort order hql code
         */
        if(params.getSortOrder().equals(SortOrderType.alphabetical)){
            hql = hql + " order by attractions.title";
        }else if(params.getSortOrder().equals(SortOrderType.avgRatingD)){
            hql = hql + " order by attractions.rating DESC";
        }else if(params.getSortOrder().equals(SortOrderType.avgRatingA)){
            hql = hql + " order by attractions.rating ASC";
        }

        try{
            Query query= session.createQuery(hql)
                    .setParameter("title", "%" + params.getTitle() + "%")
                    .setParameter("city", "%" + params.getCity() + "%");
            if(params.getSeoId()!=0)
                query.setParameter("seoId",   params.getSeoId() );
            if(params.getDestId()!=0)
                query.setParameter("destId",  params.getDestId() );


            /**Decreasing by 1 because the first product is at position 0.*/
            if(params.getFirstAttraction()!=0)
                query.setFirstResult(params.getFirstAttraction()-1);
            if(params.getLastAttraction()!=0)
                query.setMaxResults(params.getLastAttraction());

            attractions=query.getResultList();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }

        return attractions;
    }
}
