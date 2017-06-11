package WebServicesBeans.Paging_List;

import java.util.List;

/**
 * Created by George on 09/06/17.
 */
public class Products_Paging_List_JSON {

    private List<Product_Summary> products;
    private boolean viator_error=false;         /**Communication error or Viator error.*/
    private int totalCount;                     /**Count of receiving attractions for paging assistance.*/

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

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
