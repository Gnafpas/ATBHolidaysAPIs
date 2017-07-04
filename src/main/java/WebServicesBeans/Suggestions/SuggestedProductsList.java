package WebServicesBeans.Suggestions;

import java.util.List;

/**
 * Created by George on 07/06/17.
 */
public class SuggestedProductsList {
    private List<SuggestedProduct> products;
    private boolean dbCommError=false;

    public List<SuggestedProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SuggestedProduct> products) {
        this.products = products;
    }

    public boolean isDbCommError() {
        return dbCommError;
    }

    public void setDbCommError(boolean dbCommError) {
        this.dbCommError = dbCommError;
    }
}