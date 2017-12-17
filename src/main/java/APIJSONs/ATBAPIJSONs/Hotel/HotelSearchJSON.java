package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 05/12/2017.
 */
public class HotelSearchJSON extends StandardJSON {

    List<HotelResponse> results;

    public List<HotelResponse> getResults() {
        return results;
    }

    public void setResults(List<HotelResponse> results) {
        this.results = results;
    }
}
