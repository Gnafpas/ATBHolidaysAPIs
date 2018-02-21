package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.CancelationPolicyResponse;
import Beans.ATBDBBeans.KalitaonSystem.TravellerInfoBean;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 29/01/2018.
 */
public class BookResult {

    private String errorType;
    private String errorMessage;
    private String errorAttributes;
    private String bookingnumber;
    private int hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String numberofrooms;
    private String roomType;
    private int mealId;
    private String meal;
    private XMLGregorianCalendar checkindate;
    private XMLGregorianCalendar checkoutdate;
    private BigDecimal price;
    private String currency;
    private XMLGregorianCalendar bookingdate;
    private String bookingdateTimezone;
    private List<CancelationPolicyResponse> cancellationpolicies;
    private XMLGregorianCalendar earliestNonFreeCancellationDateUTC;
    private String voucher;
    private String paymentmethod;
    private List<Note> hotelNotes;
    private List<Note> roomNotes;
    private String invoiceref;
    private String bookingStatus;
    private List<TravellerInfoBean> travellerInfo;

    public List<TravellerInfoBean> getTravellerInfo() {
        return travellerInfo;
    }

    public void setTravellerInfo(List<TravellerInfoBean> travellerInfo) {
        this.travellerInfo = travellerInfo;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorAttributes() {
        return errorAttributes;
    }

    public void setErrorAttributes(String errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    public String getBookingnumber() {
        return bookingnumber;
    }

    public void setBookingnumber(String bookingnumber) {
        this.bookingnumber = bookingnumber;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getNumberofrooms() {
        return numberofrooms;
    }

    public void setNumberofrooms(String numberofrooms) {
        this.numberofrooms = numberofrooms;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public XMLGregorianCalendar getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(XMLGregorianCalendar checkindate) {
        this.checkindate = checkindate;
    }

    public XMLGregorianCalendar getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(XMLGregorianCalendar checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public XMLGregorianCalendar getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(XMLGregorianCalendar bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getBookingdateTimezone() {
        return bookingdateTimezone;
    }

    public void setBookingdateTimezone(String bookingdateTimezone) {
        this.bookingdateTimezone = bookingdateTimezone;
    }

    public List<CancelationPolicyResponse> getCancellationpolicies() {
        return cancellationpolicies;
    }

    public void setCancellationpolicies(List<CancelationPolicyResponse> cancellationpolicies) {
        this.cancellationpolicies = cancellationpolicies;
    }

    public XMLGregorianCalendar getEarliestNonFreeCancellationDateUTC() {
        return earliestNonFreeCancellationDateUTC;
    }

    public void setEarliestNonFreeCancellationDateUTC(XMLGregorianCalendar earliestNonFreeCancellationDateUTC) {
        this.earliestNonFreeCancellationDateUTC = earliestNonFreeCancellationDateUTC;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public List<Note> getHotelNotes() {
        return hotelNotes;
    }

    public void setHotelNotes(List<Note> hotelNotes) {
        this.hotelNotes = hotelNotes;
    }

    public List<Note> getRoomNotes() {
        return roomNotes;
    }

    public void setRoomNotes(List<Note> roomNotes) {
        this.roomNotes = roomNotes;
    }

    public String getInvoiceref() {
        return invoiceref;
    }

    public void setInvoiceref(String invoiceref) {
        this.invoiceref = invoiceref;
    }
}
