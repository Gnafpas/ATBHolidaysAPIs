package Updates.ViatorDBUpdates;

import Beans.ViatorAPIBeans.ProductsByCodes.ProductsByCodesAPIJSON;
import Beans.ViatorAPIBeans.ProductsByCodes.ProductsByCodesPOST;
import DAOs.ViatorAPIDAOs.ProductAPIDAO;
import DAOs.ViatorDBDAOs.*;
import Helper.ProjectProperties;
import Beans.ViatorDBBeans.UpdateDBBeans.TotalExpiredProducts;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by George on 27/06/2017.
 */
public class DeleteExpiredProducts {

    public static TotalExpiredProducts deleteExpiredProducts(Logger logger){

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
        boolean expired;

        ProductsByCodesPOST productsByCodesPOST = new ProductsByCodesPOST();
        ProductsByCodesAPIJSON productsByCodesAPIJSON;

        /**
         * Time between viator server requests.There is a limit for the number of requests per
         * 10 seconds that we can make at viator's server(15req/10sec for prelive and 35req/10sec for live).
         * Process may sleep for an amount of time to stay in the limits.
         */
        long timeElapsed=0;

        /**
         * retrieve all codes of the products in DB
         */
        products=ViatorProductDetailsDAO.getAllProductsCodes();
        if(products==null){
            totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
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
                     * if the service of viator doesn't returns this exact product.
                     */
                    productsByCodesPOST.setProductCodes(chunk);

                    /**
                     * Process may sleep for an amount of time to stay in the limits.
                     */
                    timeElapsed = System.currentTimeMillis() - timeElapsed;
                    if (ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed > 0) {
                        try {
                            Thread.sleep(ProjectProperties.minElapsedTimeBetweenViatorRequests - timeElapsed);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    productsByCodesAPIJSON = ProductAPIDAO.getproductsByCodes(productsByCodesPOST);
                    timeElapsed=System.currentTimeMillis();

                    if(productsByCodesAPIJSON.isSuccess() && productsByCodesAPIJSON.getData()!=null) {
                        /**
                         *If a product is expired delete related records of all tables in DB.
                         */
                        for (String code:chunk) {
                            expired=true;
                            for (int i = 0; i < productsByCodesAPIJSON.getData().size(); i++) {
                                if(productsByCodesAPIJSON.getData().get(i).getCode().equals(code))
                                    expired=false;
                            }
                            if (expired) {
                                if(ViatorProductDetailsDAO.deleteProduct(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductAdditionalInfoDAO.deleteProductAdditionalInfo(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductAgeBandsDAO.deleteProductAgeBands(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductExclusionsDAO.deleteProductExlusions(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductInclusionsDAO.deleteProductInclusions(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductPhotosDAO.deleteProductPhotos(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductReviewsDAO.deleteProductReviews(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductSalesPointsDAO.deleteProductSalesPoints(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductTourGradeLanguageServicesDAO.deleteProductTourGradeLanguageServices(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductTourGradesDAO.deleteProductTourGrades(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductUserPhotosDAO.deleteProductUserPhotos(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductVideosDAO.deleteProductVideos(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductXCategoryDAO.deleteProductXCategory(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorProductXSubcategoryDAO.deleteProductXSubctegory(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorPickupHotelsDAO.deleteProductPickupHotels(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                if(ViatorNoneAvailableDatesDAO.deleteProductNoneAvailDates(code)){
                                    totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter()+1);
                                    totalExpiredProducts.setDbCommError(true);
                                }
                                logger.info("********************** Deleting expired product with code: "+code+" **********************");
                                totalExpiredProductsList.add(code);
                                totalExpiredProducts.setTotalExpiredProducts(totalExpiredProducts.getTotalExpiredProducts()+1);
                            }
                        }
                    }else{
                        logger.info("********************** Communication ERROR with Viator server while deleting expired products. **********************");
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
