package APIJSONs.ATBAPIJSONs.Product;

import java.util.List;

/**
 * Created by George on 02/03/2018.
 */
public class CalculatePricePOST{

    private List<CalculatePriceItemPOST> items;

    public List<CalculatePriceItemPOST> getItems() {
        return items;
    }

    public void setItems(List<CalculatePriceItemPOST> items) {
        this.items = items;
    }
}
