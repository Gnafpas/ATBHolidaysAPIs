package APIBeans;

/**
 * Created by George on 29/05/17.
 */
public class Search_Freetext_Metadata {


    private int sortOrder;
    private Search_Freetext_Data data;
    private String searchType;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Search_Freetext_Data getData() {
        return data;
    }

    public void setData(Search_Freetext_Data data) {
        this.data = data;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
}
