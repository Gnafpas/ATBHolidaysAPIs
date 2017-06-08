package WebServicesBeans;

import java.util.List;

/**
 * Created by George on 07/06/17.
 */
public class Products_Search {
    private List<Product> products;
    private boolean viator_error=false;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isViator_error() {
        return viator_error;
    }

    public void setViator_error(boolean viator_error) {
        this.viator_error = viator_error;
    }
}
