package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book.ViatorTraveller;
import Beans.ViatorAPIBeans.Bookings.Book.BookingQuestionAnswer;

import java.util.List;

/**
 * Created by George on 02/08/2017.
 */
public class Item {

    private String hotelId;
    private String pickupPoint;
    private String travelDate;
    private String productId;
    private String planId;
    private String language;
    private String serviceOption;
    private List<BookingQuestionAnswer> bookingQuestionAnswers;
    private String specialRequirements;
    private List<Traveller> Travellers;


    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getServiceOption() {
        return serviceOption;
    }

    public void setServiceOption(String serviceOption) {
        this.serviceOption = serviceOption;
    }

    public List<BookingQuestionAnswer> getBookingQuestionAnswers() {
        return bookingQuestionAnswers;
    }

    public void setBookingQuestionAnswers(List<BookingQuestionAnswer> bookingQuestionAnswers) {
        this.bookingQuestionAnswers = bookingQuestionAnswers;
    }

    public String getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(String specialRequirements) {
        this.specialRequirements = specialRequirements;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public List<Traveller> getTravellers() {
        return Travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        Travellers = travellers;
    }
}
