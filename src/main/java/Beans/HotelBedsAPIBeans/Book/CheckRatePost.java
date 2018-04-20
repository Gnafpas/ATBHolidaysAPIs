package Beans.HotelBedsAPIBeans.Book;

import java.util.List;

/**
 * Created by George on 22/03/2018.
 */
public class CheckRatePost {

    private List<RateKey> rooms;

    public List<RateKey> getRooms() {
        return rooms;
    }

    public void setRooms(List<RateKey> rooms) {
        this.rooms = rooms;
    }
}
