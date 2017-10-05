package Beans.ViatorAPIBeans.ProductDetails;

/**
 * Created by George on 10/06/17.
 */
public class ProductDetailAgeBands {

    private int sortOrder;
    private boolean treatAsAdult;
    private int ageFrom;
    private int ageTo;
    private boolean adult;
    private String pluralDescription;
    private int bandId;
    private int count;
    private String description;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isTreatAsAdult() {
        return treatAsAdult;
    }

    public void setTreatAsAdult(boolean treatAsAdult) {
        this.treatAsAdult = treatAsAdult;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getPluralDescription() {
        return pluralDescription;
    }

    public void setPluralDescription(String pluralDescription) {
        this.pluralDescription = pluralDescription;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

