package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.StandardJSON;
import Beans.ViatorAPIBeans.APIJSONMetada;

/**
 * Created by George on 02/08/2017.
 */
public class BookAPIJSON extends StandardJSON {

    private BookResult bookingInfo;

    public BookResult getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(BookResult bookingInfo) {
        this.bookingInfo = bookingInfo;
    }
}
