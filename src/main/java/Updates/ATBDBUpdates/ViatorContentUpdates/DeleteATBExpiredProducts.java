package Updates.ATBDBUpdates.ViatorContentUpdates;

import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import DAOs.ViatorDBDAOs.*;
import Beans.ViatorDBBeans.UpdateDBBeans.TotalExpiredProducts;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by George on 08/09/2017.
 */
public class DeleteATBExpiredProducts {

    public static TotalExpiredProducts deleteATBExpiredProducts(Logger logger) {

        /**
         * Statistic Values/Information/Results in JSON for Admin.
         */
        TotalExpiredProducts totalExpiredProducts = new TotalExpiredProducts();
        totalExpiredProducts.setTotalExpiredProducts(0);
        totalExpiredProducts.setViatorError(false);
        totalExpiredProducts.setDbCommError(false);
        List<String> ATBProducts;
        List<String> viatorProducts;
        AProductTitleBean product;
        boolean expired;


        /**
         * retrieve all codes of the products in DB
         */
        logger.info("Start Deleting Expired Products...");
        ATBProducts = AProductTitleDAO.getAllViatorProductsCodes();
        viatorProducts = ViatorProductDetailsDAO.getAllProductsCodes();
        if (ATBProducts == null || viatorProducts == null) {
            totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter() + 1);
            totalExpiredProducts.setDbCommError(true);
        }
        else {
            for (String code : ATBProducts) {

                /**
                 *If a product is expired delete related records of all tables in DB.
                 */
                expired = true;
                for (String vcode : viatorProducts) {
                    if (vcode.equals(code))
                        expired = false;
                }
                if (expired) {

                    product=AProductTitleDAO.getProductByCode(code,"Viator");
                    AProductTitleDAO.deleteProduct(code,"Viator");
                    BProductDetailDAO.deleteProduct(String.valueOf(product.getId()));
                    CProductOptionsDAO.deleteProductOption(String.valueOf(product.getId()));
                    DProductPhotoDAO.deletePhoto(String.valueOf(product.getId()));
                    EPickupPointDAO.deletePickupPoint(String.valueOf(product.getId()));
                    FPricePlanDAO.deletePriceplan(String.valueOf(product.getId()));
                    GPriceMatrixDAO.deletePriceMatrix(String.valueOf(product.getId()));
                    HAvailableDateDAO.deleteAvailableDate(String.valueOf(product.getId()));
                    HStopsaleDateDAO.deleteStopsaleDate(String.valueOf(product.getId()));
                    totalExpiredProducts.setTotalExpiredProducts(totalExpiredProducts.getTotalExpiredProducts()+1);
                    logger.info("Deleting Product with code:" + code + " from ATBDB");
                }
            }
        }
        logger.info("Deleting Expired Products Procedure ended.");
        return totalExpiredProducts;
    }
}
