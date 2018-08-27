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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static Controller.Application.errLogger;

/**
 * Created by George on 08/08/2017.
 */
public class AProductTitleDAO {

    public static int addproduct(AProductTitleBean product){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = "select aProductTitleBean from AProductTitleBean aProductTitleBean  order by aProductTitleBean.id DESC";
        Transaction tx;
        int id=0;
        try{
            tx=session.beginTransaction();
            session.insert(product);
            Query query= session.createQuery(hql);
            query.setMaxResults(1);
            product=(AProductTitleBean)query.getSingleResult();
            id=product.getId();
            tx.commit();
        }catch (HibernateException e) {
            id=0;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (ExceptionInInitializerError e) {
            id=0;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }catch (CJCommunicationsException e){
            id=0;
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            errLogger.info(errors.toString());
        }finally {
            session.close();
        }
        return id;
    }

    public static boolean updateproduct(AProductTitleBean product){
        StatelessSession session = ATBHibernateUtil.getSession();
        Transaction tx;
        boolean err=false;
        try{
            tx=session.beginTransaction();
            session.update(product);
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

    public static boolean deleteProduct(String code, String supplierName){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM AProductTitleBean WHERE productCode='"+code+"' AND main_supplier_name = '"+supplierName+"'");
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


    public static boolean deleteProductById(int id){

        StatelessSession session = ATBHibernateUtil.getSession();
        String hql = String.format("DELETE FROM AProductTitleBean WHERE id="+id);
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

    public static  AProductTitleBean getProductByCode(String productCode, String supplierName){

        StatelessSession session = ATBHibernateUtil.getSession();
        AProductTitleBean product=null;
        String hql ="Select a FROM Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean a WHERE a.productCode='"+ productCode +"' and a.mainSupplierName='"+supplierName+"'";
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

    public static List<AProductTitleBean> getOutdatedProducts(String supplierName, String timestamp, String subId){

        StatelessSession session = ATBHibernateUtil.getSession();
        AProductTitleBean product=null;
        List<AProductTitleBean> products = new ArrayList<>();
        String hql ="Select a FROM Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean a WHERE a.createdAt not like '"+ timestamp +"' and a.mainSupplierName='"+supplierName+"' and a.subId='"+subId+"'";
        try{
            Query query= session.createQuery(hql);
            //query.setMaxResults(1);
            products = query.getResultList();
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
        return products;
    }

    public static  AProductTitleBean getProductById(String productId){

        StatelessSession session = ATBHibernateUtil.getSession();
        AProductTitleBean product=null;
        String hql ="Select a FROM Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean a WHERE a.id='"+ productId +"'";
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
    public static List<String> getAllViatorProductsCodes(){

        StatelessSession session = ATBHibernateUtil.getSession();
        List <String> products=null;
        String hql = "select productCode from AProductTitleBean  where mainSupplierName = 'Viator'";
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

    public static List<String> getAllBannedViatorProductsCodes(){

        StatelessSession session = ATBHibernateUtil.getSession();
        List <String> products=null;
        String hql = "select productCode from AProductTitleBean  where mainSupplierName = 'Viator' and updatable=0";
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
    public static List <AProductTitleBean> getProducts(ProductsAndCategoriesPOST params,ZonedDateTime startDate,ZonedDateTime endDate,StatelessSession session){

        List <AProductTitleBean> products=null;
        int i;
        String hql=     " select  DISTINCT(productDetails)"
                + " from AProductTitleBean productDetails";

        if(startDate!=null && endDate!=null && (startDate.isBefore(endDate) || startDate.equals(endDate))){
            hql=  hql + " , HAvailableDateBean hAvailableDateBean";
        }


        /**
         * Filters
         */
        hql=hql + " where productDetails.productTitle LIKE :title "
                + " and productDetails.cityName LIKE :city "
                + " and productDetails.countryName LIKE :country ";
        if(params.getCityCode()!=null && !params.getCityCode().equals(""))
            hql=hql + " and productDetails.cityCode LIKE :cityCode ";
        if(params.getCountryCode()!=null && !params.getCountryCode().equals(""))
            hql=hql + " and productDetails.countryCode LIKE :countryCode ";
        if(params.getProductId()!=0)
            hql=hql + " and productDetails.id = :productId ";
        if(params.getTypeOfProduct()!=0)
            hql=hql + " and productDetails.typeOfProduct = :typeOfProduct ";
        if(params.getPriceFrom()!=0)
            hql=hql + " and cast(productDetails.marchandNetPrice as int) >= :priceFrom ";
        if(params.getPriceTo()!=0)
            hql=hql + " and cast(productDetails.marchandNetPrice as int) <= :priceTo ";
        if(params.isOnlyOnsaleProducts())
            hql=hql + " and  productDetails.onSale = 1";

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
        if(startDate!=null && endDate!=null && (startDate.isBefore(endDate) || startDate.equals(endDate))){

            hql = hql + " and hAvailableDateBean.productId= productDetails.id and ( (:startDate >= hAvailableDateBean.startDate and :startDate <= hAvailableDateBean.endDate)  or " +
                    " (:endDate >= hAvailableDateBean.startDate and :endDate <= hAvailableDateBean.endDate) ) ";

//            i=0;
//
//            for (ZonedDateTime date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1))
//            {
//                String[] splitDate=date.toString().split("T");
//                String d=splitDate[0].replace("-","");
//                if(i==0) {
//                    hql = hql + " and (not exists (select stopsaleDate from HStopsaleDateBean stopsaleDate " +
//                            " where stopsaleDate.stopDate = '"+d+"'"+
//                            " and stopsaleDate.productId = productDetails.id)";
//                    atLeastoneEntry=true;
//                }else{
//                    hql = hql + " or not exists (select stopsaleDate from HStopsaleDateBean stopsaleDate " +
//                            " where stopsaleDate.stopDate = '"+d+"'"+
//                            " and stopsaleDate.productId = productDetails.id)";
//                }
//                i++;
//            }
//            if(atLeastoneEntry)
//                hql = hql +")";
            boolean atLeastoneEntry=false;
            i=0;
            atLeastoneEntry=false;
            for (ZonedDateTime date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1))
            {
                String[] splitDate=date.toString().split("T");
                String d=splitDate[0].replace("-","");
                if(i==0) {
                    hql = hql + " and ( exists (select hSpecialDateBean from HSpecialDateBean hSpecialDateBean " +
                            " where hSpecialDateBean.serviceDate = '"+d+"'"+
                            " and hSpecialDateBean.productId = productDetails.id)";
                    atLeastoneEntry=true;
                }else{
                    hql = hql + " or  exists (select hSpecialDateBean from HSpecialDateBean hSpecialDateBean " +
                            " where hSpecialDateBean.serviceDate = '"+d+"'"+
                            " and hSpecialDateBean.productId = productDetails.id)";
                }
                i++;
            }
            if(atLeastoneEntry)
                hql = hql +" or not exists (select hSpecialDateBean from HSpecialDateBean hSpecialDateBean " +
                        " where hSpecialDateBean.productId = productDetails.id and hSpecialDateBean.planId = hAvailableDateBean.planId) )";



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



        boolean incomingSession=true;
        if(session==null) {
            session = ATBHibernateUtil.getSession();
            incomingSession=false;
        }
        try{
            org.hibernate.query.Query query= session.createQuery(hql)
                    .setParameter("title", "%" + params.getTitle() + "%")
                    .setParameter("city", "%" + params.getCity() + "%")
                    .setParameter("country", "%" + params.getCountry() + "%");
            if(params.getCityCode()!=null && !params.getCityCode().equals(""))
                query.setParameter("cityCode",  params.getCityCode());
            if(params.getCountryCode()!=null && !params.getCountryCode().equals(""))
                query.setParameter("countryCode", params.getCountryCode());
            if(params.getProductId()!=0)
                query.setParameter("productId", params.getProductId());
            if(params.getTypeOfProduct()!=0)
                query.setParameter("typeOfProduct", String.valueOf(params.getTypeOfProduct()));
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
            if(startDate!=null && endDate!=null && (startDate.isBefore(endDate) || startDate.equals(endDate))){
                query.setParameter("startDate", Date.from(startDate.toInstant()), TemporalType.DATE);
                query.setParameter("endDate", Date.from(endDate.toInstant()), TemporalType.DATE);
            }

            /**Decreasing by 1 because the first product is at position 0.*/
//            if(params.getFirstProduct()!=0)
//                query.setFirstResult(params.getFirstProduct()-1);
//            if(params.getLastProduct()!=0)
//                query.setMaxResults(params.getLastProduct());

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
            if(!incomingSession)
                session.close();
        }//todo integrade sortorders
        return products;
    }


}
