package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
public class PricingmatrixJSON extends StandardJSON {

    private List<PricingmatrixWithPlanId> data=new ArrayList<>();

    public List<PricingmatrixWithPlanId> getData() {
        return data;
    }

    public void setData(List<PricingmatrixWithPlanId> data) {
        this.data = data;
    }
}
