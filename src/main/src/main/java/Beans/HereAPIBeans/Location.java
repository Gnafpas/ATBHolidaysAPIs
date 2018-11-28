package Beans.HereAPIBeans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by George on 13/05/2018.
 */
public class Location {

    @JsonProperty(value="Address")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
