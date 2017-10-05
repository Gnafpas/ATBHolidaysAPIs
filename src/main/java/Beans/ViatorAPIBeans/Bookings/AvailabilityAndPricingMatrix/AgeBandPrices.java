package Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix;


import java.util.List;

/**
 * Created by George on 26/07/2017.
 */
public class AgeBandPrices {

    private int bandId;
    private List<Price> prices;
    private int sortOrder;
    private Object maximumCountRequired=null;
    private Object minimumCountRequired=null;

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Object getMaximumCountRequired() {
        return maximumCountRequired;
    }

    public void setMaximumCountRequired(Object maximumCountRequired) {
        this.maximumCountRequired = maximumCountRequired;
    }

    public Object getMinimumCountRequired() {
        return minimumCountRequired;
    }

    public void setMinimumCountRequired(Object minimumCountRequired) {
        this.minimumCountRequired = minimumCountRequired;
    }
}
