package Beans.HotelBedsAPIBeans.Availability;

import java.util.List;

/**
 * Created by George on 16/03/2018.
 */
public class AvailabilityPOST {
    private Stay stay;
    private List<Occupancy> occupancies;
    private HotelPost hotels;
    private Board boards;
    private Filter filter;

    public Board getBoards() {
        return boards;
    }

    public void setBoards(Board boards) {
        this.boards = boards;
    }

    public Stay getStay() {
        return stay;
    }

    public void setStay(Stay stay) {
        this.stay = stay;
    }

    public List<Occupancy> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(List<Occupancy> occupancies) {
        this.occupancies = occupancies;
    }

    public HotelPost getHotels() {
        return hotels;
    }

    public void setHotels(HotelPost hotels) {
        this.hotels = hotels;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
}
