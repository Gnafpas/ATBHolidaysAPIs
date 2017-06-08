package WebServicesBeans;

import java.util.List;

/**
 * Created by George on 07/06/17.
 */
public class Products_List {
    private List<Product_Summary> products;
    private boolean viator_error=false;

    public List<Product_Summary> getProducts() {
        return products;
    }

    public void setProducts(List<Product_Summary> products) {
        this.products = products;
    }

    public boolean isViator_error() {
        return viator_error;
    }

    public void setViator_error(boolean viator_error) {
        this.viator_error = viator_error;
    }
}
