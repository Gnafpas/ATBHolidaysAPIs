package APIJSONs.ATBAPIJSONs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 23/10/2017.
 */
public class AvailabilityJSON extends StandardJSON {

    private List<Availability> data=new ArrayList<>();

    public List<Availability> getData() {
        return data;
    }

    public void setData(List<Availability> data) {
        this.data = data;
    }
}
