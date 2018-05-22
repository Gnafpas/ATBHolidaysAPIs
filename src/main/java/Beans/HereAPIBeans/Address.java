package Beans.HereAPIBeans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by George on 13/05/2018.
 */
public class Address {

    @JsonProperty(value="District")
    private String district;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
