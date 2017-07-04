package WebServicesBeans.PagingList;

import java.util.List;

/**
 * Created by George on 09/06/17.
 */
public class ProductsPagingListJSON {

    private List<ProductSummary> products;
    private boolean viatorΕrror=false;         /**Communication error or Viator error.*/
    private int totalCount;                     /**Count of receiving attractions for paging assistance.*/

    public List<ProductSummary> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSummary> products) {
        this.products = products;
    }

    public boolean isViatorΕrror() {
        return viatorΕrror;
    }

    public void setViatorΕrror(boolean viatorError) {
        this.viatorΕrror = viatorΕrror;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
