package Beans.HotelBedsAPIBeans.Book;

import java.util.List;

/**
 * Created by George on 22/03/2018.
 */
public class BookPost {

    private Holder holder;
    private List<Room> rooms;
    private String clientReference;

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getClientReference() {
        return clientReference;
    }

    public void setClientReference(String clientReference) {
        this.clientReference = clientReference;
    }
}





