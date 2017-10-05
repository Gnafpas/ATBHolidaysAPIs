package Beans.ViatorAPIBeans.Bookings.Book;

/**
 * Created by George on 02/08/2017.
 */
public class TravellerAgeBand {
    private int sortOrder;
    private int count;
    private String pluralDescription;
    private String description;
    private int ageBandId;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPluralDescription() {
        return pluralDescription;
    }

    public void setPluralDescription(String pluralDescription) {
        this.pluralDescription = pluralDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAgeBandId() {
        return ageBandId;
    }

    public void setAgeBandId(int ageBandId) {
        this.ageBandId = ageBandId;
    }
}
