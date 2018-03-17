package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 02/03/2018.
 */
public class BookingInfoJSON extends StandardJSON {
    private List<BookingInfoData> bookingInfo;

    public List<BookingInfoData> getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(List<BookingInfoData> bookingInfo) {
        this.bookingInfo = bookingInfo;
    }
}
