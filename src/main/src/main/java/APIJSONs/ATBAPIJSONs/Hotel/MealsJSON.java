package APIJSONs.ATBAPIJSONs.Hotel;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.List;

/**
 * Created by George on 04/01/2018.
 */
public class MealsJSON extends StandardJSON {

    private List<Meal> data;

    public List<Meal> getData() {
        return data;
    }

    public void setData(List<Meal> data) {
        this.data = data;
    }
}

