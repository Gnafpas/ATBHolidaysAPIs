package WebServicesBeans.ListingPage;

import DBBeans.ViatorCategoriesBean;
import DBBeans.ViatorSubcategoriesBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 11/07/2017.
 */
public class Category {
    ViatorCategoriesBean category;
    List<ViatorSubcategoriesBean> subcategories=new ArrayList<>();

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
