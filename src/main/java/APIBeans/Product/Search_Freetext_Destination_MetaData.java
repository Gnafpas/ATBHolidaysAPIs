package APIBeans.Product;

/**
 * Created by George on 31/05/17.
 */
public class Search_Freetext_Destination_MetaData {

    private int sortOrder;
    private String searchType;
    private Search_Freetext_Destination_Data data;

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

    public Search_Freetext_Destination_Data getData() {
        return data;
    }

    public void setData(Search_Freetext_Destination_Data data) {
        this.data = data;
    }
}
