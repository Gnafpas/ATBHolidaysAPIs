package Helper;

import java.util.HashMap;

/**
 * Created by George on 01/03/2018.
 */
public class CurrencyJSON {

    private String base;
    private String date;
    private HashMap rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HashMap getRates() {
        return rates;
    }

    public void setRates(HashMap rates) {
        this.rates = rates;
    }
}
