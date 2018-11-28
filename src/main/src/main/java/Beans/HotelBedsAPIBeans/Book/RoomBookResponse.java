package Beans.HotelBedsAPIBeans.Book;

import java.util.List;

/**
 * Created by George on 27/04/2018.
 */
public class RoomBookResponse {
    private String status;
    private int id;
    private String code;
    private String name;
    private List<Pax> paxes;
    private List<Rate> rates;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Pax> getPaxes() {
        return paxes;
    }

    public void setPaxes(List<Pax> paxes) {
        this.paxes = paxes;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
