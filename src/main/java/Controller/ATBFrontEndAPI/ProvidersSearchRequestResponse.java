package Controller.ATBFrontEndAPI;

import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.SunHotelsResponse;

import java.util.List;

/**
 * Created by George on 20/03/2018.
 */
public class ProvidersSearchRequestResponse {

    private List<SunHotelsResponse> hotelsResponse;
    private long dbTransactionTimeElapsed;
    private long prepareResponseTimeElapsed;
    private long requestTimeElapsed;

    public List<SunHotelsResponse> getHotelsResponse() {
        return hotelsResponse;
    }

    public void setHotelsResponse(List<SunHotelsResponse> hotelsResponse) {
        this.hotelsResponse = hotelsResponse;
    }

    public long getDbTransactionTimeElapsed() {
        return dbTransactionTimeElapsed;
    }

    public void setDbTransactionTimeElapsed(long dbTransactionTimeElapsed) {
        this.dbTransactionTimeElapsed = dbTransactionTimeElapsed;
    }

    public long getPrepareResponseTimeElapsed() {
        return prepareResponseTimeElapsed;
    }

    public void setPrepareResponseTimeElapsed(long prepareResponseTimeElapsed) {
        this.prepareResponseTimeElapsed = prepareResponseTimeElapsed;
    }

    public long getRequestTimeElapsed() {
        return requestTimeElapsed;
    }

    public void setRequestTimeElapsed(long requestTimeElapsed) {
        this.requestTimeElapsed = requestTimeElapsed;
    }
}
