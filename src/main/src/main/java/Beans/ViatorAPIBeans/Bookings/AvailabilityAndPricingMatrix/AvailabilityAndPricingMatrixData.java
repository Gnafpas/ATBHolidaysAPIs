package Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix;


import java.util.List;

/**
 * Created by George on 26/07/2017.
 */
public class AvailabilityAndPricingMatrixData {

    private String bookingMonth;
    private String pricingUnit;
    private List<AvailabilityAndPricingMatrixDate> dates;

    public String getBookingMonth() {
        return bookingMonth;
    }

    public void setBookingMonth(String bookingMonth) {
        this.bookingMonth = bookingMonth;
    }

    public String getPricingUnit() {
        return pricingUnit;
    }

    public void setPricingUnit(String pricingUnit) {
        this.pricingUnit = pricingUnit;
    }

    public List<AvailabilityAndPricingMatrixDate> getDates() {
        return dates;
    }

    public void setDates(List<AvailabilityAndPricingMatrixDate> dates) {
        this.dates = dates;
    }
}
