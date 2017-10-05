package Beans.ViatorAPIBeans.SearchFreetext;

/**
 * Created by George on 31/05/17.
 */
public class SearchFreetextDestinationMetaData {

    private int sortOrder;
    private String searchType;
    private SearchFreetextDestinationData data;

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

    public SearchFreetextDestinationData getData() {
        return data;
    }

    public void setData(SearchFreetextDestinationData data) {
        this.data = data;
    }
}
