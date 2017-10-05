package Controller.ATBAPIController;

import APIJSONs.ATBAPIJSONs.GetProductsSrvcParams;
import APIJSONs.ATBAPIJSONs.ProductDetailsJSON;
import DAOs.ATBDBDAOs.KalitaonProductDAOs.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by George on 27/09/2017.
 */
@RestController
public class ProductDetailedPageController {

    @RequestMapping("/getProductDetails")
    public ProductDetailsJSON getProductDetails(@RequestParam(value = "productId", defaultValue = "") String productId) {

        ProductDetailsJSON productDetailsJSON = new ProductDetailsJSON();
        GetProductsSrvcParams params = new GetProductsSrvcParams();
        params.setCode(productId);

        productDetailsJSON.setaProductTitleBean(AProductTitleDAO.getProducts(params));
        productDetailsJSON.setbProductDetailBean(BProductDetailDAO.getBProductDetailsByProductId(productId));
        productDetailsJSON.setcProductOptionsBean(CProductOptionsDAO.getcProductOptionsByProductId(productId));
        productDetailsJSON.setdProductPhotoBean(DProductPhotoDAO.getdProductPhotosByProductId(productId));
        productDetailsJSON.setePickupPointBean(EPickupPointDAO.getePickupPointsByProductId(productId));
        productDetailsJSON.setfPricePlanBean(FPricePlanDAO.getfPricePlansByProductId(productId));
        productDetailsJSON.setgPriceMatrixBean(GPriceMatrixDAO.getgPriceMatrixesByProductId(productId));
        productDetailsJSON.sethAvailableDateBean(HAvailableDateDAO.gethAvailableDatesByProductId(productId));
        productDetailsJSON.setHSpecialDateBean(HSpecialDateDAO.getSpecialDatesByProductId(productId));
        productDetailsJSON.setJProductQuestionsBean(JProductQuestionsDAO.getProductByCode(productId));
        productDetailsJSON.sethStopsaleDateBean(HStopsaleDateDAO.gethStopsaleDatesByProductId(productId));
        productDetailsJSON.setiAvailableTimeBean(IAvailableTimeDAO.getiAvailableTimesByProductId(productId));

        if (productDetailsJSON.getaProductTitleBean() == null || productDetailsJSON.getbProductDetailBean() == null ||
                productDetailsJSON.getcProductOptionsBean() == null || productDetailsJSON.getdProductPhotoBean() == null ||
                productDetailsJSON.getePickupPointBean() == null || productDetailsJSON.getfPricePlanBean() == null ||
                productDetailsJSON.getgPriceMatrixBean() == null || productDetailsJSON.gethAvailableDateBean() == null ||
                productDetailsJSON.gethStopsaleDateBean() == null || productDetailsJSON.getiAvailableTimeBean() == null ||
                productDetailsJSON.getHSpecialDateBean() == null || productDetailsJSON.getJProductQuestionsBean() == null) {
            productDetailsJSON.setDBError(true);
        } else
            productDetailsJSON.setDBError(false);

        return productDetailsJSON;
    }
}
