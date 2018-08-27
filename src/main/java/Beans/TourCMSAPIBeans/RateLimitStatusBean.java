package Beans.TourCMSAPIBeans;

/**
 * Created by George on 13/06/2018.
 */
public class RateLimitStatusBean {

    private String request;
    private String error;
    private int remaining_hits;
    private int hourly_limit;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getRemaining_hits() {
        return remaining_hits;
    }

    public void setRemaining_hits(int remaining_hits) {
        this.remaining_hits = remaining_hits;
    }

    public int getHourly_limit() {
        return hourly_limit;
    }

    public void setHourly_limit(int hourly_limit) {
        this.hourly_limit = hourly_limit;
    }
}
