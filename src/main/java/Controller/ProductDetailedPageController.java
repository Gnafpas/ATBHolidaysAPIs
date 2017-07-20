package Controller;

import DAOs.DBDAOs.*;
import DBBeans.ViatorCategoriesBean;
import DBBeans.ViatorProductTourGradesBean;
import WebServicesBeans.ListingPage.GetProductsDAOParams;
import WebServicesBeans.ProductDetailsPage.Category;
import WebServicesBeans.ProductDetailsPage.ProductDetailsJSON;
import WebServicesBeans.ProductDetailsPage.TourGrade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by George on 13/07/2017.
 */
@RestController
public class ProductDetailedPageController {
    @RequestMapping("/getProductDetails")
    public ProductDetailsJSON getProductDetails(@RequestParam (value="productCode", defaultValue="") String productCode) {
        ProductDetailsJSON productDetailsJSON = new ProductDetailsJSON();
        ViatorProductDetailsDAO productDetailsDAO = new ViatorProductDetailsDAO();
        ViatorPickupHotelsDAO pickupHotelsDAO = new ViatorPickupHotelsDAO();
        ViatorProductAdditionalInfoDAO additionalInfoDAO = new ViatorProductAdditionalInfoDAO();
        ViatorProductAgeBandsDAO ageBandsDAO = new ViatorProductAgeBandsDAO();
        ViatorProductExclusionsDAO exclusionsDAO = new ViatorProductExclusionsDAO();
        ViatorProductInclusionsDAO inclusionsDAO = new ViatorProductInclusionsDAO();
        ViatorProductPhotosDAO photosDAO = new ViatorProductPhotosDAO();
        ViatorProductReviewsDAO reviewsDAO = new ViatorProductReviewsDAO();
        ViatorProductSalesPointsDAO salesPointsDAO = new ViatorProductSalesPointsDAO();
        ViatorProductTourGradeLanguageServicesDAO tourGradeLanguageServicesDAO = new ViatorProductTourGradeLanguageServicesDAO();
        ViatorProductTourGradesDAO tourGradesDAO = new ViatorProductTourGradesDAO();
        List<ViatorProductTourGradesBean> tourGrades;
        TourGrade tourGrade;
        ViatorProductUserPhotosDAO userPhotosDAO = new ViatorProductUserPhotosDAO();
        ViatorProductVideosDAO videosDAO = new ViatorProductVideosDAO();
        ViatorProductXCategoryDAO productXCategoryDAO = new ViatorProductXCategoryDAO();
        List<ViatorCategoriesBean> categories;
        Category category;
        ViatorProductXSubcategoryDAO productXSubcategoryDAO = new ViatorProductXSubcategoryDAO();
        GetProductsDAOParams params = new GetProductsDAOParams();
        params.setCode(productCode);

        productDetailsJSON.setAdditionalInfo(additionalInfoDAO.getAdditionalInfoByProductCode(productCode));
        productDetailsJSON.setAgeBands(ageBandsDAO.getAgeBandsByProductCode(productCode));
        productDetailsJSON.setDetails(productDetailsDAO.getProducts(params));
        productDetailsJSON.setExclusions(exclusionsDAO.getExclusionsByProductCode(productCode));
        productDetailsJSON.setInclusions(inclusionsDAO.getInclusionsByProductCode(productCode));
        productDetailsJSON.setPhotos(photosDAO.getPhotosByProductCode(productCode));
        productDetailsJSON.setPickupHotels(pickupHotelsDAO.getPickupHotelsByProductCode(productCode));
        productDetailsJSON.setReviews(reviewsDAO.getReviewsByProductCode(productCode));
        productDetailsJSON.setSalesPoints(salesPointsDAO.getSalesPointsByProductCode(productCode));
        productDetailsJSON.setUserPhotos(userPhotosDAO.getUserPhotosByProductCode(productCode));
        productDetailsJSON.setVideos(videosDAO.getVideosByProductCode(productCode));


        categories = productXCategoryDAO.getProductCategoriesByProductCode(productCode);
        if (categories != null) {
            for (ViatorCategoriesBean cat : categories) {
                category = new Category();
                category.setCategory(cat);
                category.setSubcategories(productXSubcategoryDAO.getProductSubcategoriesByProductCode(productCode, cat.getId()));
                if (category.getSubcategories() == null)
                    productDetailsJSON.setDBError(true);
                else
                    productDetailsJSON.getProductCategories().add(category);
            }
        }else
            productDetailsJSON.setDBError(true);

        tourGrades=tourGradesDAO.getTourGradesByProductCode(productCode);
        if(tourGrades!=null) {
            for (ViatorProductTourGradesBean tourGrd : tourGrades) {
                tourGrade = new TourGrade();
                tourGrade.setTourGrade(tourGrd);
                tourGrade.setLanguageServices(tourGradeLanguageServicesDAO.getLanguageServicesByProductCodeAndTourGrade(productCode, tourGrd.getGradeCode()));
                if (tourGrade.getLanguageServices() == null)
                    productDetailsJSON.setDBError(true);
                else
                    productDetailsJSON.getTourGrades().add(tourGrade);
            }
        }else
            productDetailsJSON.setDBError(true);

        if     ( productDetailsJSON.getAdditionalInfo()==null || productDetailsJSON.getAgeBands()==null ||
                 productDetailsJSON.getDetails()==null || productDetailsJSON.getExclusions()==null ||
                 productDetailsJSON.getInclusions()==null || productDetailsJSON.getPhotos()==null ||
                 productDetailsJSON.getPickupHotels()==null || productDetailsJSON.getReviews()==null ||
                 productDetailsJSON.getSalesPoints()==null || productDetailsJSON.getUserPhotos()==null ||
                 productDetailsJSON.getVideos()==null )
           productDetailsJSON.setDBError(true);

        return  productDetailsJSON;
    }
}
