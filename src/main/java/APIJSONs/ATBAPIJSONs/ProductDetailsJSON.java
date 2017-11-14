package APIJSONs.ATBAPIJSONs;

import Beans.ATBDBBeans.KalitaonProduct.*;

import java.util.List;

/**
 * Created by George on 27/09/2017.
 */
public class ProductDetailsJSON extends StandardJSON{

    private ProductDetails data=new ProductDetails();

    public ProductDetails getData() {
        return data;
    }

    public void setData(ProductDetails data) {
        this.data = data;
    }
}
