package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 05/12/2017.
 */
public class HotelSearchJSON extends StandardJSON {

    private List<HotelResponse> data;
    private int searchId;

    public int getSearchId() {
        return searchId;
    }

    public void setSearchId(int searchId) {
        this.searchId = searchId;
    }

    public List<HotelResponse> getData() {
        return data;
    }

    public void setData(List<HotelResponse> data) {
        this.data = data;
    }
}
