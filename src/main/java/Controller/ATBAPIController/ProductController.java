package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.*;
import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;
import Beans.ATBDBBeans.KalitaonProduct.ProductCategoriesBean;
import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 27/09/2017.
 */
@RestController
public class ProductController {


    /**
     * Retrieving products by code,title,country,city,region,destination id,primary destination id or
     * a combination of those attributes.Capability of filtering by categories and sort by REVIEW_AVG_RATING_D,
     * REVIEW_AVG_RATING_A, POPULARITY, PRICE_D, PRICE_a, DURATION_D, DURATION_A.Also filtering by dates.Returns
     * all categories and how many products has each category for the specific search.
     */
    @RequestMapping(value = "/product/search", method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public ProductsAndCategoriesJSON getATBProductsAndCategories(@RequestBody ProductsAndCategoriesPOST params){
//todo send only max 500 products
        ProductsAndCategoriesJSON productsAndCategoriesJSON =new ProductsAndCategoriesJSON();
        List <AProductTitleBean>  products;
        int i=0;
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        productsAndCategoriesJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        /**
         * Limit Max products per request.
         */
        if(params.getLastProduct()==0)
            params.setLastProduct(params.getFirstProduct()+500);
        else if(params.getLastProduct()-params.getFirstProduct()>500)
            params.setLastProduct(params.getFirstProduct()+500);
//        ZonedDateTime startDate;//todo remove dates
//        ZonedDateTime endDate;
//        endDate=ZonedDateTime.of ( LocalDate.of ( 2017 , 9 , 29 ) ,//todo remove this code
//                                   LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
//        startDate=ZonedDateTime.of (LocalDate.of ( 2017 , 9 , 29 ) ,
//                                    LocalTime.of ( 9 , 30 ) , ZoneId.of ( "America/New_York" ) );
//        params.setEndDate(endDate);
//        params.setStartDate(startDate);

        /**
         * Get products
         */
        productsAndCategoriesJSON.getData().setProducts(AProductTitleDAO.getProducts(params));

        /**
         * Get all categories and Find products count for each category
         */
        List<ProductCategoriesBean> categories;
        List<String> categoryNames=new ArrayList<>();
        List<Category> categoriesInJSON=new ArrayList<>();
        Category category;
        categories=ProductCategoriesDAO.getAllCategories();
        if(categories!=null) {
            for (ProductCategoriesBean cat : categories) {
                category = new Category();
                category.setCategory(cat);
                categoryNames.clear();
                categoryNames.add(cat.getCategoryName());
                params.setCategories(categoryNames);
                products = AProductTitleDAO.getProducts(params);
                if (products != null)
                    category.setProductCount(products.size());
                categoriesInJSON.add(category);
            }
        }else {
            productsAndCategoriesJSON.setSuccess(false);
            productsAndCategoriesJSON.setErrorMessageText("Database Communication Error.");
        }
        productsAndCategoriesJSON.getData().setCategories(categoriesInJSON);

        if(productsAndCategoriesJSON.getData().getProducts()==null) {
            productsAndCategoriesJSON.setSuccess(false);
            productsAndCategoriesJSON.setErrorMessageText("Database Communication Error.");
        }else
            productsAndCategoriesJSON.setTotalCount(productsAndCategoriesJSON.getData().getProducts().size());
        return productsAndCategoriesJSON;
    }


    @RequestMapping("/product/productDetails")
    public ProductDetailsJSON getProductDetails(@RequestParam(value = "productId", defaultValue = "") String productId) {

        ProductDetailsJSON productDetailsJSON = new ProductDetailsJSON();
        DateTime dateTime =new DateTime( DateTimeZone.UTC);
        productDetailsJSON.setDateStamp(Timestamp.valueOf(String.format("%04d-%02d-%02d %02d:%02d:%02d",
                dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(),
                dateTime.getHourOfDay(), dateTime.getMinuteOfHour(),dateTime.getSecondOfMinute())).toString()+"+0000");
        ProductsAndCategoriesPOST params = new ProductsAndCategoriesPOST();
        params.setProductId(Integer.valueOf(productId));

        productDetailsJSON.getData().setProductTitle(AProductTitleDAO.getProducts(params));
        productDetailsJSON.getData().setProductDetails(BProductDetailDAO.getBProductDetailsByProductId(productId));
        productDetailsJSON.getData().setProductOptions(CProductOptionsDAO.getcProductOptionsByProductId(productId));
        productDetailsJSON.getData().setProductPhotos(DProductPhotoDAO.getdProductPhotosByProductId(productId));
        productDetailsJSON.getData().setPickupPoints(EPickupPointDAO.getePickupPointsByProductId(productId));
        productDetailsJSON.getData().setPricePlans(FPricePlanDAO.getfPricePlansByProductId(productId));
        productDetailsJSON.getData().setBookingQuestions(JProductQuestionsDAO.getProductByCode(productId));
        productDetailsJSON.setTotalCount(1);
        if (productDetailsJSON.getData().getProductTitle() == null || productDetailsJSON.getData().getProductDetails() == null ||
            productDetailsJSON.getData().getProductOptions() == null || productDetailsJSON.getData().getProductPhotos() == null ||
            productDetailsJSON.getData().getPickupPoints() == null || productDetailsJSON.getData().getPricePlans() == null ||
            productDetailsJSON.getData().getBookingQuestions() == null) {
            productDetailsJSON.setSuccess(false);
            productDetailsJSON.setErrorMessageText("Database Communication Error.");
        }
        return productDetailsJSON;
    }
}
