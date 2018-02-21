package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.StandardJSON;
import DAOs.SunHotelsAPIDAOs.Booking;

/**
 * Created by George on 14/12/2017.
 */
public class BookJSON extends StandardJSON {

    private BookResult bookResult;
    private String errorType;
    private boolean testBooking;

    public boolean isTestBooking() {
        return testBooking;
    }

    public void setTestBooking(boolean testBooking) {
        this.testBooking = testBooking;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public BookResult getBookResult() {
        return bookResult;
    }

    public void setBookResult(BookResult bookResult) {
        this.bookResult = bookResult;
    }
}

