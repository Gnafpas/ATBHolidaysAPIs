package Beans.ViatorAPIBeans.Bookings.CalculatePrice;

import java.util.List;

/**
 * Created by George on 03/08/2017.
 */
public class Item {

    private boolean specialReservation;
    private String travelDate;
    private String productCode;
    private String tourGradeCode;
    private List<Traveller> travellers;

    public boolean isSpecialReservation() {
        return specialReservation;
    }

    public void setSpecialReservation(boolean specialReservation) {
        this.specialReservation = specialReservation;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getTourGradeCode() {
        return tourGradeCode;
    }

    public void setTourGradeCode(String tourGradeCode) {
        this.tourGradeCode = tourGradeCode;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }
}
