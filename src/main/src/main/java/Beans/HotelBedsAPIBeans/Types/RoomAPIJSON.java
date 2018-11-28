package Beans.HotelBedsAPIBeans.Types;

import Beans.HotelBedsAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 11/03/2018.
 */
public class RoomAPIJSON extends APIJSONMetada {

    private List<Room> rooms;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
