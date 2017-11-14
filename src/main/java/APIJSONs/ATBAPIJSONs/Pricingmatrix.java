package APIJSONs.ATBAPIJSONs;

import Beans.ATBDBBeans.KalitaonProduct.GPriceMatrixBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
public class Pricingmatrix {

    private List<GPriceMatrixBean> priceMatrix=new ArrayList<>();
    private String planId;

    public List<GPriceMatrixBean> getPriceMatrix() {
        return priceMatrix;
    }

    public void setPriceMatrix(List<GPriceMatrixBean> priceMatrix) {
        this.priceMatrix = priceMatrix;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }
}
