package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd;

import java.util.List;

/**
 * Created by George on 05/12/2017.
 */
public class SunHotelsSearchJSON  {

    private List<SunHotelsResponse> results;
    private String search_ref;
    private int totalHotelsCount;

    public int getTotalHotelsCount() {
        return totalHotelsCount;
    }

    public void setTotalHotelsCount(int totalHotelsCount) {
        this.totalHotelsCount = totalHotelsCount;
    }

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
