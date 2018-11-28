package APIJSONs.ATBAPIJSONs.Product;

import Beans.ViatorAPIBeans.Bookings.Book.Booker;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 14/02/2018.
 */
public class BookResult {

    private String bookingStatus;
    private List<ResponseItem> items;
    private String voucher;
    private String bookingId;
    private String bookingDate;
    private BigDecimal totalPrice;
    private String currencyCode;
    private Booker booker;

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public List<ResponseItem> getItems() {
        return items;
    }

    public void setItems(List<ResponseItem> items) {
        this.items = items;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Booker getBooker() {
        return booker;
    }

    public void setBooker(Booker booker) {
        this.booker = booker;
    }
}