package APIJSONs.ATBAPIJSONs.Product;

import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
public class ProductsAndCategories {

    private List<Product> products=new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
