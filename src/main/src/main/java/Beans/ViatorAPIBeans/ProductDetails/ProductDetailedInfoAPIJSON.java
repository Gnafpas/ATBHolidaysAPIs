package Beans.ViatorAPIBeans.ProductDetails;

import Beans.ViatorAPIBeans.APIJSONMetada;

/**
 * Created by George on 10/06/17.
 */
public class ProductDetailedInfoAPIJSON extends APIJSONMetada {

    private ProductDetailedInfoData data;

    public ProductDetailedInfoData getData() {
        return data;
    }

    public void setData(ProductDetailedInfoData data) {
        this.data = data;
    }
}
