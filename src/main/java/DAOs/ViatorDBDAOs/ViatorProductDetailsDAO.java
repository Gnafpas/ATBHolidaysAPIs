package DAOs.ViatorDBDAOs;


import Beans.ViatorDBBeans.ViatorProductDetailsBean;
import DBConnection.HibernateUtil;
import Helper.SortOrderType;
import APIJSONs.MyViatorAPIJSONs.ListingPage.GetProductsDAOParams;
import com.mysql.cj.core.exceptions.CJCommunicationsException;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.exception.GenericJDBCException;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by George on 15/06/2017.
 */
public class ViatorProductDetailsDAO {

    public static boolean addproduct(ViatorProductDetailsBean product){

        Session session = HibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.save(product);
            tx.commit();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;
    }

    public static boolean deleteProduct(String code){

        Session session = HibernateUtil.getSession();
        String hql = String.format("DELETE FROM ViatorProductDetailsBean WHERE code='"+code+"'");
        boolean err=false;
        try{
            session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
        }catch (HibernateException e) {
            err=true;
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            err=true;
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            err=true;
            e.printStackTrace();
        }finally {
            session.close();
        }
        return err;
    }

    public static List<String> getAllProductsCodes(){

        Session session = HibernateUtil.getSession();
        List <String> products=null;
        String hql = "select code from ViatorProductDetailsBean a order by a.code desc" ;
        try{
            session.beginTransaction();
            products=session.createQuery(hql).list();
        }catch (HibernateException e) {
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return products;
    }

    /**
     * Function for retrieve products by code,title,country,city,region,destination id,primary destination id or
     * a combination of those attributes.Capability of filtering by categories and sort by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, POPULARITY, PRICE_D, PRICE_a, DURATION_D, DURATION_A.Also filtering by dates.
     */
    public static List <ViatorProductDetailsBean> getProducts(GetProductsDAOParams params){

        List <ViatorProductDetailsBean> products=null;
        int i;
        String hql=     " select  DISTINCT(productDetails)"
                      + " from Beans.ViatorDBBeans.ViatorProductDetailsBean productDetails";

        /**
         * Categories filter hql tables
         */
        if(params.getCategories()!=null && params.getCategories().size()!=0) {
            hql = hql + ", DBBeans.ViatorProductXCategoryBean prodHasCategory";
        }
        if(params.getSubcategories()!=null && params.getSubcategories().size()!=0) {
            hql = hql + ",  DBBeans.ViatorProductXSubcategoryBean prodHasSubcategory";
        }

        /**
         * Dates filter hql tables
         */
        if(params.getStartDate()!=null && params.getEndDate()!=null){
            hql = hql + " ,DBBeans.ViatorNoneAvailableDatesBean";
        }

        /**
         * Filters
         */
        hql=hql + " where productDetails.titleEn LIKE :title "
                + " and productDetails.cityEn LIKE :city "
                + " and productDetails.regionEn LIKE :region "
                + " and productDetails.countryEn LIKE :country ";
        if(!params.getCode().equals(""))
            hql=hql + " and productDetails.code LIKE :code ";
        if(params.getDestId()!=0)
            hql=hql + " and productDetails.destinationId = :destId ";
        if(params.getPrimaryDestId()!=0)
            hql=hql + " and productDetails.primaryDestinationId = :primaryDestId ";
        if(params.getPriceFrom()!=0)
            hql=hql + " and productDetails.price >= :priceFrom ";
        if(params.getPriceTo()!=0)
            hql=hql + " and productDetails.price <= :priceTo ";
        if(params.isDiscount())
            hql=hql + " and productDetails.specialOfferAvailable = 1 ";

        /**
         * Categories filter hql restrictions
         */
        if(params.getCategories()!=null && params.getCategories().size()!=0) {
            hql = hql+ " and productDetails.code=prodHasCategory.productCode "
                     + " and prodHasCategory.categoryId in :categories";
        }

        if(params.getSubcategories()!=null && params.getSubcategories().size()!=0) {
            hql = hql+ " and productDetails.code=prodHasSubcategory.productCode "
                     + " and prodHasSubcategory.subcategoryId in :subcategories";
        }

        /**
         * Dates filter hql restrictions
         */
        if(params.getStartDate()!=null && params.getEndDate()!=null){
            i=0;
            for (ZonedDateTime date = params.getStartDate(); date.isBefore(params.getEndDate().plusDays(1)); date = date.plusDays(1))
            {
                hql = hql + " and not exists (select date from DBBeans.ViatorNoneAvailableDatesBean date " +
                                                        " where date.day = :day" + i +
                                                        " and date.month = :month" + i +
                                                        " and date.year = :year" + i +
                                                        " and date.productCode LIKE productDetails.code)";
                i++;
            }

        }

        /**
         * Sort order hql code
         */
        if(params.getSortOrder().equals(SortOrderType.alphabetical)){
            hql = hql + " order by productDetails.titleEn";
        }else if(params.getSortOrder().equals(SortOrderType.avgRatingD)){
            hql = hql + " order by productDetails.rating DESC";
        }else if(params.getSortOrder().equals(SortOrderType.avgRatingA)){
            hql = hql + " order by productDetails.rating ASC";
        }else if(params.getSortOrder().equals(SortOrderType.popularity)) {
            hql = hql + " order by productDetails.reviewCount + productDetails.rating1Count " +
                    " +   productDetails.rating2Count + productDetails.rating3Count " +
                    " +   productDetails.rating4Count + productDetails.rating5Count DESC ";
        }else if(params.getSortOrder().equals(SortOrderType.priceD)) {
            hql = hql + " order by productDetails.price DESC";
        }else if(params.getSortOrder().equals(SortOrderType.priceA)) {
            hql = hql + " order by productDetails.price ASC";
        }else if(params.getSortOrder().equals(SortOrderType.durationD)) {
            hql = hql + " order by productDetails.duration DESC";
        }else if(params.getSortOrder().equals(SortOrderType.durationA)) {
            hql = hql + " order by productDetails.duration ASC";
        }

        Session session = HibernateUtil.getSession();
        try{
            Query query= session.createQuery(hql)
                    .setParameter("title", "%" + params.getTitle() + "%")
                    .setParameter("city", "%" + params.getCity() + "%")
                    .setParameter("region", "%" + params.getRegion() + "%")
                    .setParameter("country", "%" + params.getCountry() + "%");

            if(!params.getCode().equals(""))
                query.setParameter("code", params.getCode());
            if(params.getDestId()!=0)
                query.setParameter("destId",  params.getDestId() );
            if(params.getPrimaryDestId()!=0)
                query.setParameter("primaryDestId",  params.getPrimaryDestId() );
            if(params.getPriceFrom()!=0)
                query.setParameter("priceFrom",   new BigDecimal(Integer.toString(params.getPriceFrom())));
            if(params.getPriceTo()!=0)
                query.setParameter("priceTo",  new BigDecimal(Integer.toString(params.getPriceTo())));

            if(params.getCategories()!=null && params.getCategories().size()!=0)
                query.setParameter("categories",  params.getCategories() );
            if(params.getSubcategories()!=null && params.getSubcategories().size()!=0)
                query.setParameter("subcategories",  params.getSubcategories() );

            if(params.getStartDate()!=null && params.getEndDate()!=null){
                i=0;
                for (ZonedDateTime date = params.getStartDate(); date.isBefore(params.getEndDate().plusDays(1)); date = date.plusDays(1))
                {
                    query.setParameter("day"+i,date.getDayOfMonth());
                    query.setParameter("month"+i,date.getMonthValue());
                    query.setParameter("year"+i,date.getYear());
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
            e.printStackTrace();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }catch (CJCommunicationsException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return products;
    }
}
