package Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix;


import java.util.List;

/**
 * Created by George on 26/07/2017.
 */
public class PricingMatrix {

    private int sortOrder;
    private String pricingUnit;
    private String bookingDate;
    private List<AgeBandPrices> ageBandPrices;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getPricingUnit() {
        return pricingUnit;
    }

    public void setPricingUnit(String pricingUnit) {
        this.pricingUnit = pricingUnit;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public List<AgeBandPrices> getAgeBandPrices() {
        return ageBandPrices;
    }

    public void setAgeBandPrices(List<AgeBandPrices> ageBandPrices) {
        this.ageBandPrices = ageBandPrices;
    }
}
