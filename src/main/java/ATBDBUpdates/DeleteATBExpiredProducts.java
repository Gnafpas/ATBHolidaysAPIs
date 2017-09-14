package ATBDBUpdates;

import ATBDBBeans.AProductTitleBean;
import DAOs.ATBDBDAOs.*;
import DAOs.DBDAOs.*;
import WebServicesBeans.UpdateDBJSONs.TotalExpiredProducts;

import java.util.List;

/**
 * Created by George on 08/09/2017.
 */
public class DeleteATBExpiredProducts {

    public static TotalExpiredProducts deleteATBExpiredProducts() {

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

                    product=AProductTitleDAO.getProductByCode(code);
                    AProductTitleDAO.deleteProduct(code);
                    BProductDetailDAO.deleteProduct(String.valueOf(product.getId()));
                    CProductOptionsDAO.deleteProductOption(String.valueOf(product.getId()));
                    DProductPhotoDAO.deletePhoto(String.valueOf(product.getId()));
                    EPickupPointDAO.deletePickupPoint(String.valueOf(product.getId()));
                    FPricePlanDAO.deletePriceplan(String.valueOf(product.getId()));
                    GPriceMatrixDAO.deletePriceMatrix(String.valueOf(product.getId()));
                    HAvailableDateDAO.deleteAvailableDate(String.valueOf(product.getId()));
                    HStopsaleDateDAO.deleteStopsaleDate(String.valueOf(product.getId()));
                    System.out.println("Deleting Product with code:" + code + " from ATBDB");
                }
            }
        }
        System.out.println("Deleting Expired Products Procedure ended.");
        return totalExpiredProducts;
    }
}
