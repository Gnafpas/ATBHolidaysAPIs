package DAOs.ATBDBDAOs.KalitaonProductDAOs;

import APIJSONs.ATBAPIJSONs.Product.ProductsAndCategoriesPOST;
import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;
import DBConnection.ATBHibernateUtil;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.HibernateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import static Controller.Application.errLogger;

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
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
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
        }catch (CJCommunicationsException e){
            err=true;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
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
        return products;
    }


    public static  AProductTitleBean getProductByCode(String productCode){

        StatelessSession session = ATBHibernateUtil.getSession();
        AProductTitleBean product=null;
        String hql ="Select a FROM Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean a WHERE a.productCode='"+ productCode +"' and a.mainSupplierName='Viator'";
        try{
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            product=(AProductTitleBean)query.getSingleResult();
        }catch (HibernateException e) {
            errLogger.info(e.toString());
        }catch (ExceptionInInitializerError e) {
            errLogger.info(e.toString());
        }catch (NoResultException e){

        }catch (CJCommunicationsException e){
            errLogger.info(e.toString());
        }finally {
            session.close();
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
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (NoResultException e) {
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
        return product;
    }


    /**
     * Function for retrieve products by code,title,country,city,region,destination id,primary destination id or
     * a combination of those attributes.Capability of filtering by categories and sort by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, POPULARITY, PRICE_D, PRICE_a, DURATION_D, DURATION_A.Also filtering by dates.
     */
    public static List <AProductTitleBean> getProducts(ProductsAndCategoriesPOST params,ZonedDateTime startDate,ZonedDateTime endDate){

        List <AProductTitleBean> products=null;
        int i;
        String hql=     " select  DISTINCT(productDetails)"
                + " from AProductTitleBean productDetails";


        /**
         * Filters
         */
        hql=hql + " where productDetails.productTitle LIKE :title "
                + " and productDetails.cityName LIKE :city "
                + " and productDetails.countryName LIKE :country ";
        if(!params.getCityCode().equals(""))
            hql=hql + " and productDetails.cityCode LIKE :cityCode ";
        if(!params.getCountryCode().equals(""))
            hql=hql + " and productDetails.countryCode LIKE :countryCode ";
        if(params.getProductId()!=0)
            hql=hql + " and productDetails.id = :productId ";
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
                if(i==0)
                  hql = hql+ " and  (productDetails.categoriesTag like :categories"+i;
                else
                    hql = hql+ " or  productDetails.categoriesTag like :categories"+i;
                i++;
            }
            if(i!=0)
              hql = hql+ ")";
        }

        /**
         * Dates filter hql restrictions
         */
        if(startDate!=null && endDate!=null && startDate.isBefore(endDate)){
            i=0;
            for (ZonedDateTime date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1))
            {
                hql = hql + " and not exists (select stopsaleDate from HStopsaleDateBean stopsaleDate " +
                        " where stopsaleDate.stopDate = :date" + i +
                        " and stopsaleDate.productId = productDetails.id)";
                i++;
            }//todo check stopsale dates to let products show up when there is even only one day available from the selected dates
        }


//        /**
//         * Sort order hql code
//         */
//        if(params.getSortOrder().equals(SortOrderType.alphabetical)){
//            hql = hql + " order by productDetails.titleEn";
//        }else if(params.getSortOrder().equals(SortOrderType.avgRatingD)){
//            hql = hql + " order by productDetails.rating DESC";
//        }else if(params.getSortOrder().equals(SortOrderType.avgRatingA)){
//            hql = hql + " order by productDetails.rating ASC";
//        }else if(params.getSortOrder().equals(SortOrderType.popularity)) {
//            hql = hql + " order by productDetails.reviewCount + productDetails.rating1Count " +
//                    " +   productDetails.rating2Count + productDetails.rating3Count " +
//                    " +   productDetails.rating4Count + productDetails.rating5Count DESC ";
//        }else if(params.getSortOrder().equals(SortOrderType.priceD)) {
//            hql = hql + " order by productDetails.price DESC";
//        }else if(params.getSortOrder().equals(SortOrderType.priceA)) {
//            hql = hql + " order by productDetails.price ASC";
//        }else if(params.getSortOrder().equals(SortOrderType.durationD)) {
//            hql = hql + " order by productDetails.duration DESC";
//        }else if(params.getSortOrder().equals(SortOrderType.durationA)) {
//            hql = hql + " order by productDetails.duration ASC";
//        }

        StatelessSession session = ATBHibernateUtil.getSession();
        try{
            Query query= session.createQuery(hql)
                    .setParameter("title", "%" + params.getTitle() + "%")
                    .setParameter("city", "%" + params.getCity() + "%")
                    .setParameter("country", "%" + params.getCountry() + "%");
            if(!params.getCityCode().equals(""))
                query.setParameter("cityCode",  params.getCityCode());
            if(!params.getCountryCode().equals(""))
                query.setParameter("countryCode", params.getCountryCode());
            if(params.getProductId()!=0)
                query.setParameter("productId", params.getProductId());
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
            if(startDate!=null && endDate!=null && startDate.isBefore(endDate)){
                i=0;
                for (ZonedDateTime date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1))
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
        }catch (HibernateException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }//todo integrade sortorders
        return products;
    }

}
