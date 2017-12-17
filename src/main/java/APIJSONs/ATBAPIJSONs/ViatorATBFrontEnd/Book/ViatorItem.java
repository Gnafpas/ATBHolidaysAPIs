package APIJSONs.ATBAPIJSONs.ViatorATBFrontEnd.Book;

import Beans.ViatorAPIBeans.Bookings.Book.BookingQuestionAnswer;

import java.util.List;

/**
 * Created by George on 02/08/2017.
 */
public class ViatorItem {

    private String hotelId;
    private String pickupPoint;
    private String travelDate;
    private String productCode;
    private String tourGradeCode;
    private String language;
    private String serviceOption;
    private List<BookingQuestionAnswer> bookingQuestionAnswers;
    private String specialRequirements;
    private List<ViatorTraveller> Travellers;


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

    public List<ViatorTraveller> getTravellers() {
        return Travellers;
    }

    public void setTravellers(List<ViatorTraveller> travellers) {
        Travellers = travellers;
    }
}
