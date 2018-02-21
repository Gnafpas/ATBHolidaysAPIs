package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 04/01/2018.
 */
public class ResortJSON  extends StandardJSON {

    private List<Resort> data;

    public List<Resort> getData() {
        return data;
    }

    public void setData(List<Resort> data) {
        this.data = data;
    }
}
