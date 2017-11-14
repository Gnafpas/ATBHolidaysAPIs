package APIJSONs.ATBAPIJSONs;

import Beans.ATBDBBeans.KalitaonProduct.GPriceMatrixBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
public class PricingmatrixJSON extends StandardJSON{

    private List<Pricingmatrix> data=new ArrayList<>();

    public List<Pricingmatrix> getData() {
        return data;
    }

    public void setData(List<Pricingmatrix> data) {
        this.data = data;
    }
}
