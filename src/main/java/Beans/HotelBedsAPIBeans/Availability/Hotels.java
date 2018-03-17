package Beans.HotelBedsAPIBeans.Availability;

import java.util.List;

/**
 * Created by George on 16/03/2018.
 */
public class Hotels {

    private String checkIn;
    private int total;
    private String checkOut;
    private List<Hotel> hotels;

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
