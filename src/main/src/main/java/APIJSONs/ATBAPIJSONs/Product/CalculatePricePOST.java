package APIJSONs.ATBAPIJSONs.Product;

import java.util.List;

/**
 * Created by George on 02/03/2018.
 */
public class CalculatePricePOST{

    private List<CalculatePriceItemPOST> items;
    private String currencyCode="";


    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<CalculatePriceItemPOST> getItems() {
        return items;
    }

    public void setItems(List<CalculatePriceItemPOST> items) {
        this.items = items;
    }
}
