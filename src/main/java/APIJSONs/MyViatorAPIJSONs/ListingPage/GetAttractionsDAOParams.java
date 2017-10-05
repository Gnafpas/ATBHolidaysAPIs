package APIJSONs.MyViatorAPIJSONs.ListingPage;

import Helper.SortOrderType;

/**
 * Created by George on 18/07/2017.
 */
public class GetAttractionsDAOParams {

    private String title="";
    private Integer firstAttraction=0;
    private Integer lastAttraction=0;
    private String sortOrder= SortOrderType.alphabetical;
    private Integer destId=0;
    private String city="";
    private int seoId=0;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getFirstAttraction() {
        return firstAttraction;
    }

    public void setFirstAttraction(Integer firstAttraction) {
        this.firstAttraction = firstAttraction;
    }

    public Integer getLastAttraction() {
        return lastAttraction;
    }

    public void setLastAttraction(Integer lastAttraction) {
        this.lastAttraction = lastAttraction;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getDestId() {
        return destId;
    }

    public void setDestId(Integer destId) {
        this.destId = destId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSeoId() {
        return seoId;
    }

    public void setSeoId(int seoId) {
        this.seoId = seoId;
    }
}
