package Beans.HereAPIBeans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by George on 13/05/2018.
 */
public class Result {

    @JsonProperty(value="Location")
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
