package APIJSONs.ATBAPIJSONs.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George on 02/03/2018.
 */
public class BookingInfoData {

    private List<BookingInfoItem> items;
    private String voucher;
    private String bookingId;
    private String bookingDate;
    private BigDecimal totalPrice;
    private String currencyCode;


    public List<BookingInfoItem> getItems() {
        return items;
    }

    public void setItems(List<BookingInfoItem> items) {
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
}
