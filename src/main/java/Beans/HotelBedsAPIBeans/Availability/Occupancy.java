package Beans.HotelBedsAPIBeans.Availability;

import java.util.List;

/**
 * Created by George on 16/03/2018.
 */
public class Occupancy {
    private int rooms;
    private int adults;
    private int children;
    private List<Pax> paxes;

    public List<Pax> getPaxes() {
        return paxes;
    }

    public void setPaxes(List<Pax> paxes) {
        this.paxes = paxes;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }
}
