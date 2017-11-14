package APIJSONs.ATBAPIJSONs;

import Beans.ATBDBBeans.KalitaonProduct.ProductCategoriesBean;

/**
 * Created by George on 20/10/2017.
 */
public class Category {
    private ProductCategoriesBean category;
    private int productCount=0;

    public ProductCategoriesBean getCategory() {
        return category;
    }

    public void setCategory(ProductCategoriesBean category) {
        this.category = category;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
