package APIJSONs.MyViatorAPIJSONs.Suggestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 27/07/2017.
 */
public class LastMonthWithAvailabilityInfoPOST {
    private List<String> productCodes=new ArrayList();

    public List<String> getProductCodes() {
        return productCodes;
    }

    public void setProductCodes(List<String> productCodes) {
        this.productCodes = productCodes;
    }
}
