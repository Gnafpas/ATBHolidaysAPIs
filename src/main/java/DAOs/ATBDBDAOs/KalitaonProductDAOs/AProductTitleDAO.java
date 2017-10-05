package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import APIJSONs.ATBAPIJSONs.GetProductsSrvcParams;
import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.net.ConnectException;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by George on 08/08/2017.
 */
public class AProductTitleDAO {

    public static boolean addproduct(AProductTitleBean product){

        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.insert(product);
            tx.commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return err;
    }

    public static boolean deleteProduct(String code){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM AProductTitleBean WHERE productCode='"+code+"' AND main_supplier_name = 'Viator'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return err;
    }


    public static List<String> getAllViatorProductsCodes(){

        StatelessSession session = ATBHibernateUtil.getSession();
        List <String> products=null;
        String hql = "select productCode from AProductTitleBean  where main_supplier_name = 'Viator'";
        try{
            session.beginTransaction();
            products=session.createQuery(hql).list();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return products;
    }


    public static  AProductTitleBean getProductByCode(String productCode){

        StatelessSession session = ATBHibernateUtil.getSession();
        AProductTitleBean product=null;
        String hql ="Select a FROM Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean a WHERE a.productCode='"+ productCode +"'";
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            product=(AProductTitleBean)query.getSingleResult();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException e){

        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }
        return product;
    }

    public static AProductTitleBean getLastRecord(){
        StatelessSession session = ATBHibernateUtil.getSession();
        String hql=     " select  a"
                      + " from AProductTitleBean a"
                      + " order by a.id DESC";
        AProductTitleBean product=null;
        try{
        Query query= session.createQuery(hql);
        query.setMaxResults(1);
            product=(AProductTitleBean)query.getSingleResult();
        session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (NoResultException e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){//todo handle exception when turn of mysql server
            e.printStackTrace();
        }

        return product;
    }


    /**
     * Function for retrieve products by code,title,country,city,region,destination id,primary destination id or
     * a combination of those attributes.Capability of filtering by categories and sort by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, POPULARITY, PRICE_D, PRICE_a, DURATION_D, DURATION_A.Also filtering by dates.
     */
    public static List <AProductTitleBean> getProducts(GetProductsSrvcParams params){

        List <AProductTitleBean> products=null;
        int i;
        String hql=     " select  DISTINCT(productDetails)"
                + " from AProductTitleBean productDetails";


        /**
         * Filters
         */
        hql=hql + " where productDetails.productTitle LIKE :title "
                + " and productDetails.cityName LIKE :city "
                + " and productDetails.countryName LIKE :country "
                + " and productDetails.cityCode LIKE :cityCode "
                + " and productDetails.countryCode LIKE :countryCode ";
        if(!params.getCode().equals(""))
            hql=hql + " and productDetails.id = :code ";
        if(params.getPriceFrom()!=0)
            hql=hql + " and cast(productDetails.marchandNetPrice as int) >= :priceFrom ";
        if(params.getPriceTo()!=0)
            hql=hql + " and cast(productDetails.marchandNetPrice as int) <= :priceTo ";

        /**
         * Categories filter hql restrictions
         */
        if(params.getCategories()!=null && params.getCategories().size()!=0) {
            i = 0;
            for (String cat : params.getCategories()) {
                hql = hql+ " and  productDetails.categoriesTag like :categories"+i;
                i++;
            }
        }

        /**
         * Dates filter hql restrictions
         */
        if(params.getStartDate()!=null && params.getEndDate()!=null){
            i=0;
            for (ZonedDateTime date = params.getStartDate(); date.isBefore(params.getEndDate().plusDays(1)); date = date.plusDays(1))
            {
                hql = hql + " and not exists (select stopsaleDate from HStopsaleDateBean stopsaleDate " +
                        " where stopsaleDate.stopDate = :date" + i +
                        " and stopsaleDate.productId = productDetails.id)";
                i++;
            }
        }

        StatelessSession session = ATBHibernateUtil.getSession();
        try{
            Query query= session.createQuery(hql)
                    .setParameter("title", "%" + params.getTitle() + "%")
                    .setParameter("city", "%" + params.getCity() + "%")
                    .setParameter("cityCode","%" + params.getCityCode() +"%")
                    .setParameter("countryCode", "%" +params.getCountryCode() +"%")
                    .setParameter("country", "%" + params.getCountry() + "%");

            if(!params.getCode().equals(""))
                query.setParameter("code", Integer.parseInt(params.getCode()));
            if(params.getPriceFrom()!=0)
                query.setParameter("priceFrom", params.getPriceFrom());
            if(params.getPriceTo()!=0)
                query.setParameter("priceTo", params.getPriceTo());

            if(params.getCategories()!=null && params.getCategories().size()!=0) {
                i = 0;
                for (String cat : params.getCategories()) {
                    query.setParameter("categories" + i, "%" + cat + "%");
                    i++;
                }
            }
            if(params.getStartDate()!=null && params.getEndDate()!=null){
                i=0;
                for (ZonedDateTime date = params.getStartDate(); date.isBefore(params.getEndDate().plusDays(1)); date = date.plusDays(1))
                {
                    query.setParameter("date"+i, Date.from(date.toInstant()), TemporalType.DATE);
                    i++;
                }
            }

            /**Decreasing by 1 because the first product is at position 0.*/
            if(params.getFirstProduct()!=0)
                query.setFirstResult(params.getFirstProduct()-1);
            if(params.getLastProduct()!=0)
                query.setMaxResults(params.getLastProduct());

            products=query.getResultList();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }

        return products;
    }

}
