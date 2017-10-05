package Beans.ViatorAPIBeans.SearchFreetext;

/**
 * Created by George on 07/06/17.
 */
public class SearchFreetextAttractionMetaData {

    private int sortOrder;
    private String searchType;
    private SearchFreetextAttractionData data;

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

    public SearchFreetextAttractionData getData() {
        return data;
    }

    public void setData(SearchFreetextAttractionData data) {
        this.data = data;
    }
}
