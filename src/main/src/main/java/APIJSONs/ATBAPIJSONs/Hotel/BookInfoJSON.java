package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 03/02/2018.
 */
public class BookInfoJSON extends StandardJSON {

    private List<BookResult> bookingInfo;
    private String errorType;


    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public List<BookResult> getBookingInfo() {
        return bookingInfo;
    }

    public void setBookingInfo(List<BookResult> bookingInfo) {
        this.bookingInfo = bookingInfo;
    }
}
