package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 04/01/2018.
 */
public class RoomTypesJSON  extends StandardJSON {

    private List<RoomType> data;

    public List<RoomType> getData() {
        return data;
    }

    public void setData(List<RoomType> data) {
        this.data = data;
    }
}
