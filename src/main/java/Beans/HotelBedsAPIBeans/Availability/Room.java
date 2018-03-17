package Beans.HotelBedsAPIBeans.Availability;

import java.util.List;

/**
 * Created by George on 16/03/2018.
 */
public class Room {

    private String code;
    private String name;
    private List<Rate> rates;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
