package APIJSONs.ATBAPIJSONs.Product;

import Beans.ATBDBBeans.KalitaonProduct.AProductTitleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
public class ProductsAndCategories {

    private List<Category> categories=new ArrayList<>();
    private List<AProductTitleBean> products=new ArrayList<>();

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<AProductTitleBean> getProducts() {
        return products;
    }

    public void setProducts(List<AProductTitleBean> products) {
        this.products = products;
    }
}
