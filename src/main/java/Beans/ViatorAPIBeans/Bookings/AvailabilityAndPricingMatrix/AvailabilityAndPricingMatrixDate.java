package Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix;


import java.util.List;

/**
 * Created by George on 26/07/2017.
 */
public class AvailabilityAndPricingMatrixDate {

    private int sortOrder;
    private String bookingDate;
    private List<TourGrade> tourGrades;
    private boolean callForLastMinAvailability;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public List<TourGrade> getTourGrades() {
        return tourGrades;
    }

    public void setTourGrades(List<TourGrade> tourGrades) {
        this.tourGrades = tourGrades;
    }

    public boolean isCallForLastMinAvailability() {
        return callForLastMinAvailability;
    }

    public void setCallForLastMinAvailability(boolean callForLastMinAvailability) {
        this.callForLastMinAvailability = callForLastMinAvailability;
    }
}
