package Beans.HotelBedsAPIBeans.Hotels;

import Beans.HotelBedsAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 12/01/2018.
 */
public class HotelsAPIJSON extends APIJSONMetada {

    private List<Hotel> hotels;

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}

