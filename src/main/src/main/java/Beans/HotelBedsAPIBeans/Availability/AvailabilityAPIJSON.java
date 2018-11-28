package Beans.HotelBedsAPIBeans.Availability;

import Beans.HotelBedsAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 16/03/2018.
 */
public class AvailabilityAPIJSON extends APIJSONMetada {

    private Hotels hotels;

    public Hotels getHotels() {
        return hotels;
    }

    public void setHotels(Hotels hotels) {
        this.hotels = hotels;
    }
}
