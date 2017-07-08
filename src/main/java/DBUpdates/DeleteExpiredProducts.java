package DBUpdates;

import APIBeans.ProductsByCodes.ProductsByCodesAPIJSON;
import APIBeans.ProductsByCodes.ProductsByCodesPOST;
import DAOs.APIDAOs.ProductAPIDAO;
import DAOs.DBDAOs.*;
import WebServicesBeans.UpdateDBJSONs.TotalExpiredProducts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 27/06/2017.
 */
public class DeleteExpiredProducts {

    public TotalExpiredProducts deleteExpiredProducts(){

        /**
         * Statistic Values/Information/Results in JSON for Admin.
         */
        TotalExpiredProducts totalExpiredProducts=new TotalExpiredProducts();
        totalExpiredProducts.setTotalExpiredProducts(0);
        totalExpiredProducts.setViatorError(false);
        totalExpiredProducts.setDbCommError(false);
        List<String> totalExpiredProductsList=new ArrayList<>();
        List<String> products;
        List<String> chunk=new ArrayList<>();/** Separate all DB products into chunks of size 1000 per chunk*/

        ProductAPIDAO productAPIDAO = new ProductAPIDAO();
        ProductsByCodesPOST productsByCodesPOST = new ProductsByCodesPOST();
        ProductsByCodesAPIJSON productsByCodesAPIJSON;

        ViatorProductDetailsDAO viatorProductDetailsDAO = new ViatorProductDetailsDAO();
        ViatorProductAdditionalInfoDAO viatorProductAdditionalInfoDAO = new ViatorProductAdditionalInfoDAO();
        ViatorProductAgeBandsDAO viatorProductAgeBandsDAO = new ViatorProductAgeBandsDAO();
        ViatorProductExclusionsDAO viatorProductExclusionsDAO = new ViatorProductExclusionsDAO();
        ViatorProductInclusionsDAO viatorProductInclusionsDAO = new ViatorProductInclusionsDAO();
        ViatorProductPhotosDAO viatorProductPhotosDAO = new ViatorProductPhotosDAO();
        ViatorProductReviewsDAO viatorProductReviewsDAO = new ViatorProductReviewsDAO();
        ViatorProductSalesPointsDAO viatorProductSalesPointsDAO = new ViatorProductSalesPointsDAO();
        ViatorProductTourGradeLanguageServicesDAO viatorProductTourGradeLanguageServicesDAO = new ViatorProductTourGradeLanguageServicesDAO();
        ViatorProductTourGradesDAO viatorProductTourGradesDAO = new ViatorProductTourGradesDAO();
        ViatorProductUserPhotosDAO viatorProductUserPhotosDAO = new ViatorProductUserPhotosDAO();
        ViatorProductVideosDAO viatorProductVideosDAO = new ViatorProductVideosDAO();
        ViatorProductXCategoryDAO viatorProductXCategoryDAO = new ViatorProductXCategoryDAO();
        ViatorProductXSubcategoryDAO viatorProductXSubcategoryDAO = new ViatorProductXSubcategoryDAO();

        /**
         * retrieve all codes of the products in DB
         */
        products=viatorProductDetailsDAO.getAllProductsCodes();
        if(products==null){
            totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
            totalExpiredProducts.setDbCommError(true);
        }else {
            /**
             * Divide products into chunks
             */
            for (int j = 0; j < products.size(); j++) {
                chunk.add(products.get(j));
                if (chunk.size() > 500 || j == products.size() - 1) {
                    /**
                     * Call viator service to check if any products of it's chunk are expired.A product is considered expired
                     * if the service of viator returns product code=null
                     */
                    productsByCodesPOST.setProductCodes(chunk);
                    productsByCodesAPIJSON = productAPIDAO.getproductsByCodes(productsByCodesPOST);
                    if(productsByCodesAPIJSON.isSuccess() && productsByCodesAPIJSON.getData()!=null) {
                        /**
                         *If a product is expired delete related records of all tables in DB.
                         */
                        for (int i = 0; i < productsByCodesAPIJSON.getData().size(); i++) {
                            if (productsByCodesAPIJSON.getData().get(i).getCode() == null) {
                                if(viatorProductDetailsDAO.deleteProduct(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductAdditionalInfoDAO.deleteProductAdditionalInfo(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductAgeBandsDAO.deleteProductAgeBands(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductExclusionsDAO.deleteProductExlusions(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductInclusionsDAO.deleteProductInclusions(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductPhotosDAO.deleteProductPhotos(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductReviewsDAO.deleteProductReviews(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductSalesPointsDAO.deleteProductSalesPoints(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductTourGradeLanguageServicesDAO.deleteProductTourGradeLanguageServices(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductTourGradesDAO.deleteProductTourGrades(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductUserPhotosDAO.deleteProductUserPhotos(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductVideosDAO.deleteProductVideos(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductXCategoryDAO.deleteProductXCategory(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(viatorProductXSubcategoryDAO.deleteProductXSubctegory(chunk.get(i))){
                                    totalExpiredProducts.setDbCommErrorCounter(totalExpiredProducts.getDbCommErrorCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                System.out.println("********************** Deleting expired product with code: "+chunk.get(i)+" **********************");
                                totalExpiredProductsList.add(chunk.get(i));
                                totalExpiredProducts.setTotalExpiredProducts(totalExpiredProducts.getTotalExpiredProducts()+1);
                            }
                        }
                    }else{
                        System.out.println("********************** Communication ERROR with Viator server while deleting expired products. **********************");
                        totalExpiredProducts.setViatorError(true);
                        totalExpiredProducts.setViatorErrorInfo("Communication ERROR with Viator server while deleting expired products.");
                    }
                    chunk.clear();
                }
            }
        }
        totalExpiredProducts.setTotalExpiredProductsList(totalExpiredProductsList);
        return totalExpiredProducts;

    }
}
