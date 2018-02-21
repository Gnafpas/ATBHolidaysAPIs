package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 09/01/2018.
 */
public class HotelStaticContentJSON extends StandardJSON {

    private List<HotelResponse> data;

    public List<HotelResponse> getData() {
        return data;
    }

    public void setData(List<HotelResponse> data) {
        this.data = data;
    }
}
