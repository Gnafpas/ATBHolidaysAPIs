package Controller.MyViatorAPIController;

import DAOs.ViatorDBDAOs.*;
import Beans.ViatorDBBeans.ViatorCategoriesBean;
import Beans.ViatorDBBeans.ViatorProductTourGradesBean;
import APIJSONs.MyViatorAPIJSONs.ListingPage.GetProductsDAOParams;
import APIJSONs.MyViatorAPIJSONs.ProductDetailsPage.Category;
import APIJSONs.MyViatorAPIJSONs.ProductDetailsPage.ProductDetailsJSON;
import APIJSONs.MyViatorAPIJSONs.ProductDetailsPage.TourGrade;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Created by George on 13/07/2017.
 */
@RestController
public class ViatorProductDetailedPageController {
    @RequestMapping("/getViatorProductDetails")
    public ProductDetailsJSON getProductDetails(@RequestParam (value="productCode", defaultValue="") String productCode) {
        ProductDetailsJSON productDetailsJSON = new ProductDetailsJSON();
        List<ViatorProductTourGradesBean> tourGrades;
        TourGrade tourGrade;
        List<ViatorCategoriesBean> categories;
        Category category;
        GetProductsDAOParams params = new GetProductsDAOParams();
        params.setCode(productCode);

        productDetailsJSON.setAdditionalInfo(ViatorProductAdditionalInfoDAO.getAdditionalInfoByProductCode(productCode));
        productDetailsJSON.setAgeBands(ViatorProductAgeBandsDAO.getAgeBandsByProductCode(productCode));
        productDetailsJSON.setDetails(ViatorProductDetailsDAO.getProducts(params));
        productDetailsJSON.setExclusions(ViatorProductExclusionsDAO.getExclusionsByProductCode(productCode));
        productDetailsJSON.setInclusions(ViatorProductInclusionsDAO.getInclusionsByProductCode(productCode));
        productDetailsJSON.setPhotos(ViatorProductPhotosDAO.getPhotosByProductCode(productCode));
        productDetailsJSON.setPickupHotels(ViatorPickupHotelsDAO.getPickupHotelsByProductCode(productCode));
        productDetailsJSON.setReviews(ViatorProductReviewsDAO.getReviewsByProductCode(productCode));
        productDetailsJSON.setSalesPoints(ViatorProductSalesPointsDAO.getSalesPointsByProductCode(productCode));
        productDetailsJSON.setUserPhotos(ViatorProductUserPhotosDAO.getUserPhotosByProductCode(productCode));
        productDetailsJSON.setVideos(ViatorProductVideosDAO.getVideosByProductCode(productCode));


        categories = ViatorProductXCategoryDAO.getProductCategoriesByProductCode(productCode);
        if (categories != null) {
            for (ViatorCategoriesBean cat : categories) {
                category = new Category();
                category.setCategory(cat);
                category.setSubcategories(ViatorProductXSubcategoryDAO.getProductSubcategoriesByProductCode(productCode, cat.getId()));
                if (category.getSubcategories() == null)
                    productDetailsJSON.setDBError(true);
                else
                    productDetailsJSON.getProductCategories().add(category);
            }
        }else
            productDetailsJSON.setDBError(true);

        tourGrades=ViatorProductTourGradesDAO.getTourGradesByProductCode(productCode);
        if(tourGrades!=null) {
            for (ViatorProductTourGradesBean tourGrd : tourGrades) {
                tourGrade = new TourGrade();
                tourGrade.setTourGrade(tourGrd);
                tourGrade.setLanguageServices(ViatorProductTourGradeLanguageServicesDAO.getLanguageServicesByProductCodeAndTourGrade(productCode, tourGrd.getGradeCode()));
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
