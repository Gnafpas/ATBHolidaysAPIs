package Updates.ATBDBUpdates.ViatorContentUpdates;

import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;
import Controller.Application;
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
        logger.info("Start setting not available Expired Products...");
        ATBProducts = AProductTitleDAO.getAllViatorProductsCodes();
        viatorProducts = ViatorProductDetailsDAO.getAllProductsCodes();
        if (ATBProducts == null || viatorProducts == null) {
            totalExpiredProducts.setDbCommErrorsCounter(totalExpiredProducts.getDbCommErrorsCounter() + 1);
            totalExpiredProducts.setDbCommError(true);
        }
        else {
            if(viatorProducts.size()<30000){
                Application.agent.increment("app.web.error.updates.viatorATBUpdates",1,0);
                Application.agent.notice("***Setting not available  Expired Products Procedure didn't accomplished because develope_viator DB has less than 30000 products currently.***");
                logger.info("***Setting not available  Expired Products Procedure didn't accomplished because develope_viator DB has less than 30000 products currently.***");
                return totalExpiredProducts;
            }
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
                    if(product!=null && (product.getOnSale().equals("1") || product.getOnSale().equals("ON"))) {
                        product.setOnSale("0");
                        AProductTitleDAO.updateproduct(product);
                        //BProductDetailDAO.deleteProduct(String.valueOf(product.getId()));
                        //CProductOptionsDAO.deleteProductOption(String.valueOf(product.getId()));
                        //DProductPhotoDAO.deletePhoto(String.valueOf(product.getId()));
                        //EPickupPointDAO.deletePickupPoint(String.valueOf(product.getId()));
                        //FPricePlanDAO.deletePriceplan(String.valueOf(product.getId()));
                        //GPriceMatrixDAO.deletePriceMatrix(String.valueOf(product.getId()));
                        HAvailableDateDAO.deleteAvailableDate(String.valueOf(product.getId()));
                        HStopsaleDateDAO.deleteStopsaleDate(String.valueOf(product.getId()));
                        IAvailableTimeDAO.deleteavailableTime(String.valueOf(product.getId()));
                        totalExpiredProducts.setTotalExpiredProducts(totalExpiredProducts.getTotalExpiredProducts() + 1);
                        logger.info("Set Product with code:" + code + " not available ");
                    }
                }
            }
        }
        logger.info("Setting not available Expired Products Procedure ended.");
        return totalExpiredProducts;
    }
}
