package Beans.HotelBedsAPIBeans.Book;

import Beans.HotelBedsAPIBeans.APIJSONMetada;

/**
 * Created by George on 22/03/2018.
 */
public class BookAPIJSON extends APIJSONMetada {

    private Booking booking;


    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
