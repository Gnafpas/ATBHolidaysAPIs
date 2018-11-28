package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd;

import APIJSONs.ATBAPIJSONs.StandardJSON;
import DAOs.SunHotelsAPIDAOs.*;

/**
 * Created by George on 14/12/2017.
 */
public class SunHotelsBookJSON extends StandardJSON {

    private Booking bookResult;
    private String errorType;

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public Booking getBookResult() {
        return bookResult;
    }

    public void setBookResult(Booking bookResult) {
        this.bookResult = bookResult;
    }
}
