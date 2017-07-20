package WebServicesBeans.ListingPage;

import DBBeans.ViatorProductDetailsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 11/07/2017.
 */
public class ProductsCategoriesListingPageJSON {
    CategoriesJson categories=new CategoriesJson();
    List<ViatorProductDetailsBean> products=new ArrayList<>();
    private boolean DBError=false;

    public boolean isDBError() {
        return DBError;
    }

    public void setDBError(boolean DBError) {
        this.DBError = DBError;
    }

    public CategoriesJson getCategories() {
        return categories;
    }

    public void setCategories(CategoriesJson categories) {
        this.categories = categories;
    }

    public List<ViatorProductDetailsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ViatorProductDetailsBean> products) {
        this.products = products;
    }
}
