package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.StandardJSON;

/**
 * Created by George on 11/07/2017.
 */
public class ProductsAndCategoriesJSON  extends StandardJSON {
   private ProductsAndCategories data=new ProductsAndCategories();

    public ProductsAndCategories getData() {
        return data;
    }

    public void setData(ProductsAndCategories data) {
        this.data = data;
    }
}
