package APIJSONs.ATBAPIJSONs.Product;

import Beans.ATBDBBeans.KalitaonProduct.GPriceMatrixBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
public class PricingmatrixWithPlanId {

    private List<PriceMatrix> priceMatrix=new ArrayList<>();
    private String planId;

    public List<PriceMatrix> getPriceMatrix() {
        return priceMatrix;
    }

    public void setPriceMatrix(List<PriceMatrix> priceMatrix) {
        this.priceMatrix = priceMatrix;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }
}
