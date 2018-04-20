package Beans.HotelBedsAPIBeans.Book;

import java.util.List;

/**
 * Created by George on 22/03/2018.
 */
public class Room {

    private String rateKey;
    private List<Pax> paxes;

    public String getRateKey() {
        return rateKey;
    }

    public void setRateKey(String rateKey) {
        this.rateKey = rateKey;
    }

    public List<Pax> getPaxes() {
        return paxes;
    }

    public void setPaxes(List<Pax> paxes) {
        this.paxes = paxes;
    }
}
