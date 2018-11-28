package Beans.HotelBedsAPIBeans.Book;

import Beans.HotelBedsAPIBeans.APIJSONMetada;

/**
 * Created by George on 25/04/2018.
 */
public class CheckRateAPIJSON extends APIJSONMetada {

    private Beans.HotelBedsAPIBeans.Availability.Hotel hotel;

    public Beans.HotelBedsAPIBeans.Availability.Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Beans.HotelBedsAPIBeans.Availability.Hotel hotel) {
        this.hotel = hotel;
    }
}
