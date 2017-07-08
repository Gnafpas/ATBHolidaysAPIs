package DAOs.DBDAOs;


import DBBeans.ViatorProductDetailsBean;
import DBConnection.HibernateUtil;
import Helper.SortOrderType;
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by George on 15/06/2017.
 */
public class ViatorProductDetailsDAO {
    private HibernateUtil helper;
    private Session session;

    public boolean addproduct(ViatorProductDetailsBean bid){

        Transaction tx;
        boolean err=false;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            session.save(bid);
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

    public boolean deleteProduct(String code){

        String hql = String.format("DELETE FROM ViatorProductDetailsBean WHERE code='"+code+"'");
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

    public List<String> getAllProductsCodes(){
        List <String> products=null;
        String hql = "select code from ViatorProductDetailsBean";
        try{
            session = helper.getSession();
            session.beginTransaction();
            products=session.createQuery(hql).list();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }
        return products;
    }

    /**
     * Function for retrieve products by code,title,country,city,region,destination id,primary destination id or
     * a combination of those attributes.Capability of filtering by categories and sort by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, POPULARITY, PRICE_D, PRICE_a, DURATION_D, DURATION_A.Also filtering by dates.
     */
    public List <ViatorProductDetailsBean> getProducts(String code, String title, String country,
                                                       String city, String region, int destId,
                                                       int primaryDestId, String sortOrder,
                                                       int firstProduct,
                                                       int lastProduct,
                                                       List<Integer> categories,
                                                       List<Integer> subcategories,
                                                       ZonedDateTime startDate,
                                                       ZonedDateTime endDate){

        List <ViatorProductDetailsBean> products=null;
        int i;
        String hql=     " select  DISTINCT(productDetails)"
                      + " from DBBeans.ViatorProductDetailsBean productDetails";

        /**
         * Categories filter hql tables
         */
        if(categories!=null && categories.size()!=0) {
            hql = hql + " ,DBBeans.ViatorCategoriesBean categories,"
                      + " DBBeans.ViatorProductXCategoryBean prodHasCategory";
        }
        if(subcategories!=null && subcategories.size()!=0) {
            hql = hql + ", DBBeans.ViatorSubcategoriesBean subcategories,"
                      + " DBBeans.ViatorProductXSubcategoryBean prodHasSubcategory";
        }

        /**
         * Dates filter hql tables
         */
        if(startDate!=null && endDate!=null){
            hql = hql + " ,DBBeans.ViatorAvailabilityDatesBean";
        }

        hql=hql + " where productDetails.code LIKE :code "
                + " and productDetails.titleEn LIKE :title "
                + " and productDetails.cityEn LIKE :city "
                + " and productDetails.regionEn LIKE :region "
                + " and productDetails.countryEn LIKE :country ";
        if(destId!=0)
            hql=hql + " and productDetails.destinationId = :destId ";
        if(primaryDestId!=0)
            hql=hql + " and productDetails.primaryDestinationId = :primaryDestId ";

        /**
         * Categories filter hql restrictions
         */
        if(categories!=null && categories.size()!=0) {
            hql = hql+ " and productDetails.code=prodHasCategory.productCode "
                     + " and categories.id=prodHasCategory.categoryId ";
            hql = hql+ " and categories.id in :categories";
        }

        if(subcategories!=null && subcategories.size()!=0) {
            hql = hql+ " and productDetails.code=prodHasSubcategory.productCode "
                     + " and subcategories.id=prodHasSubcategory.subcategoryId ";
            hql = hql+ " and subcategories.id in :subcategories";
        }

        /**
         * Dates filter hql restrictions
         */
        if(startDate!=null && endDate!=null){
            i=0;
            for (ZonedDateTime date = startDate; date.isBefore(endDate); date = date.plusDays(1))
            {
                hql = hql + " and exists (select date from DBBeans.ViatorAvailabilityDatesBean date " +
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
        if(sortOrder.equals(SortOrderType.alphabetical)){
            hql = hql + " order by productDetails.titleEn";
        }else if(sortOrder.equals(SortOrderType.avgRatingD)){
            hql = hql + " order by productDetails.rating DESC";
        }else if(sortOrder.equals(SortOrderType.avgRatingA)){
            hql = hql + " order by productDetails.rating ASC";
        }else if(sortOrder.equals(SortOrderType.popularity)) {
            hql = hql + " order by productDetails.reviewCount + productDetails.rating1Count " +
                    " +   productDetails.rating2Count + productDetails.rating3Count " +
                    " +   productDetails.rating4Count + productDetails.rating5Count DESC ";
        }else if(sortOrder.equals(SortOrderType.priceD)) {
            hql = hql + " order by productDetails.price DESC";
        }else if(sortOrder.equals(SortOrderType.priceA)) {
            hql = hql + " order by productDetails.price ASC";
        }else if(sortOrder.equals(SortOrderType.durationD)) {
            hql = hql + " order by productDetails.duration DESC";
        }else if(sortOrder.equals(SortOrderType.durationA)) {
            hql = hql + " order by productDetails.duration ASC";
        }

        Transaction tx = null;
        try{
            session = helper.getSession();
            tx=session.beginTransaction();
            Query query= session.createQuery(hql)
                    .setParameter("code", "%" + code + "%")
                    .setParameter("title", "%" + title + "%")
                    .setParameter("city", "%" + city + "%")
                    .setParameter("region", "%" + region + "%")
                    .setParameter("country", "%" + country + "%");

            if(destId!=0)
                query.setParameter("destId",  destId );
            if(primaryDestId!=0)
                query.setParameter("primaryDestId",  primaryDestId );

            if(categories!=null && categories.size()!=0)
                query.setParameter("categories",  categories );
            if(subcategories!=null && subcategories.size()!=0)
                query.setParameter("subcategories",  subcategories );

            if(startDate!=null && endDate!=null){
                i=0;
                for (ZonedDateTime date = startDate; date.isBefore(endDate); date = date.plusDays(1))
                {
                    query.setParameter("day"+i,date.getDayOfMonth());
                    query.setParameter("month"+i,date.getMonthValue());
                    query.setParameter("year"+i,date.getYear());
                    i++;
                }
            }

            /**Decreasing by 1 because the first product is at position 0.*/
            if(firstProduct!=0)
                query.setFirstResult(firstProduct-1);
            if(lastProduct!=0)
                query.setMaxResults(lastProduct);

            products=query.getResultList();
            session.close();
        }catch (HibernateException e) {
            e.printStackTrace();
            session.close();
        }catch (ExceptionInInitializerError e) {
            e.printStackTrace();
        }

        return products;
    }
}
