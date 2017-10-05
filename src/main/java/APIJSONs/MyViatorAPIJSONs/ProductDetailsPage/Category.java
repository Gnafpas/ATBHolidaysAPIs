package APIJSONs.MyViatorAPIJSONs.ProductDetailsPage;

import Beans.ViatorDBBeans.ViatorCategoriesBean;
import Beans.ViatorDBBeans.ViatorSubcategoriesBean;

import java.util.List;

/**
 * Created by George on 13/07/2017.
 */
public class Category {
    ViatorCategoriesBean category;
    List<ViatorSubcategoriesBean> subcategories;

    public ViatorCategoriesBean getCategory() {
        return category;
    }

    public void setCategory(ViatorCategoriesBean category) {
        this.category = category;
    }

    public List<ViatorSubcategoriesBean> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<ViatorSubcategoriesBean> subcategories) {
        this.subcategories = subcategories;
    }
}
