package APIBeans.Product;


/**
 * Created by George on 29/05/17.
 */
public class Search_Freetext_Product_Metadata {

    private int sortOrder;
    private String searchType;
    private Search_Freetext_Product_Data data;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public Search_Freetext_Product_Data getData() {
        return data;
    }

    public void setData(Search_Freetext_Product_Data data) {
        this.data = data;
    }
}
