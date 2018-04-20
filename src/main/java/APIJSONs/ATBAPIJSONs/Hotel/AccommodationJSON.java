package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 10/04/2018.
 */
public class AccommodationJSON extends StandardJSON {

    private List<Accommodation>  data;

    public List<Accommodation> getData() {
        return data;
    }

    public void setData(List<Accommodation> data) {
        this.data = data;
    }
}
