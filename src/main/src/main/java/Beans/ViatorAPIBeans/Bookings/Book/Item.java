package Beans.ViatorAPIBeans.Bookings.Book;

import java.util.List;

/**
 * Created by George on 02/08/2017.
 */
public class Item {

    private PartnerItemDetail partnerItemDetail=new PartnerItemDetail();
    private String hotelId;
    private String pickupPoint;
    private String travelDate;
    private String productCode;
    private String tourGradeCode;
    private String languageOptionCode;
    private List<BookingQuestionAnswer> bookingQuestionAnswers;
    private String specialRequirements;
    private List<Traveller> travellers;

    public PartnerItemDetail getPartnerItemDetail() {
        return partnerItemDetail;
    }

    public void setPartnerItemDetail(PartnerItemDetail partnerItemDetail) {
        this.partnerItemDetail = partnerItemDetail;
    }

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

    public String getLanguageOptionCode() {
        return languageOptionCode;
    }

    public void setLanguageOptionCode(String languageOptionCode) {
        this.languageOptionCode = languageOptionCode;
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

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }
}
