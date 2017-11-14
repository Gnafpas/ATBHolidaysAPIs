package APIJSONs.ATBAPIJSONs;

import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 11/07/2017.
 */
public class ProductsAndCategoriesJSON  extends StandardJSON{
   private ProductsAndCategories data=new ProductsAndCategories();

    public ProductsAndCategories getData() {
        return data;
    }

    public void setData(ProductsAndCategories data) {
        this.data = data;
    }
}
