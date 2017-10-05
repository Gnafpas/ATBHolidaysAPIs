package Beans.ViatorAPIBeans.SearchFreetext;


/**
 * Created by George on 29/05/17.
 */
public class SearchFreetextProductMetadata {

    private int sortOrder;
    private String searchType;
    private SearchFreetextProductData data;

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

    public SearchFreetextProductData getData() {
        return data;
    }

    public void setData(SearchFreetextProductData data) {
        this.data = data;
    }
}
