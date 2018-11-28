package Beans.ViatorAPIBeans.ProductsByCodes;

import java.util.List;

/**
 * Created by George on 29/05/17.
 */
public class ProductsByCodesPOST {

    private String currencyCode;
    private List<String> productCodes;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<String> getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(List<String> productCodes) {
        this.productCodes = productCodes;
    }
}
