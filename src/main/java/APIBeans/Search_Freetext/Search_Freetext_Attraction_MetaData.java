package APIBeans.Search_Freetext;

/**
 * Created by George on 07/06/17.
 */
public class Search_Freetext_Attraction_MetaData {

    private int sortOrder;
    private String searchType;
    private Search_Freetext_Attraction_Data data;

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

    public Search_Freetext_Attraction_Data getData() {
        return data;
    }

    public void setData(Search_Freetext_Attraction_Data data) {
        this.data = data;
    }
}
