package APIJSONs.ATBAPIJSONs;

import org.joda.time.DateTime;

/**
 * Created by George on 22/10/2017.
 */
public class StandardJSON {

    private String errorMessageText=null;
    private boolean success=true;
    private int totalCount=0;
    private String dateStamp;

    public String getErrorMessageText() {
        return errorMessageText;
    }

    public void setErrorMessageText(String errorMessageText) {
        this.errorMessageText = errorMessageText;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(String dateStamp) {
        this.dateStamp = dateStamp;
    }
}
