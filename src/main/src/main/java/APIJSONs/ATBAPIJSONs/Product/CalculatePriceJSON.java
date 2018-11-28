package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 02/03/2018.
 */
public class CalculatePriceJSON extends StandardJSON {
    private List<CalculatePriceItem> items;
    private BigDecimal totalPrice;
    private String currencyCode;


    public List<CalculatePriceItem> getItems() {
        return items;
    }

    public void setItems(List<CalculatePriceItem> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
