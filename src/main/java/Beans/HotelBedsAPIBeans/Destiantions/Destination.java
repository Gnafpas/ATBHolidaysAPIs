package Beans.HotelBedsAPIBeans.Destiantions;

import Beans.HotelBedsAPIBeans.Hotels.Name;

/**
 * Created by George on 15/01/2018.
 */
public class Destination {

    private String code;
    private Name name;
    private String countryCode;
    private String isoCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
}
