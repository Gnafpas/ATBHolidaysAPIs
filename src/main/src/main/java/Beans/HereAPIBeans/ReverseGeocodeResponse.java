package Beans.HereAPIBeans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by George on 13/05/2018.
 */
public class ReverseGeocodeResponse {

    @JsonProperty(value="Response")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}