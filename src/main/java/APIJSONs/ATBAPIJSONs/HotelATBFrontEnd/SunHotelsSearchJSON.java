package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 05/12/2017.
 */
public class SunHotelsSearchJSON  {

    private List<SunHotelsResponse> results;
    private String search_ref;

    public List<SunHotelsResponse> getResults() {
        return results;
    }

    public void setResults(List<SunHotelsResponse> results) {
        this.results = results;
    }

    public String getSearch_ref() {
        return search_ref;
    }

    public void setSearch_ref(String search_ref) {
        this.search_ref = search_ref;
    }
}
