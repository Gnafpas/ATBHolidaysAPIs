package APIBeans.Bookings;

import APIBeans.APIJSONMetada;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

/**
 * Created by George on 07/07/2017.
 */
public class AvailabilityDatesAPIJSON extends APIJSONMetada {

    private HashMap<String,List<Integer>> data;

    public HashMap<String, List<Integer>> getData() {
        return data;
    }

    public void setData(HashMap<String, List<Integer>> data) {
        this.data = data;
    }
}
