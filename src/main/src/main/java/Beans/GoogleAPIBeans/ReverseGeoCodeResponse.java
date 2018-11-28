package Beans.GoogleAPIBeans;

import java.util.List;

/**
 * Created by George on 13/05/2018.
 */
public class ReverseGeoCodeResponse {

    private List<Result> results;
    private String status;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
