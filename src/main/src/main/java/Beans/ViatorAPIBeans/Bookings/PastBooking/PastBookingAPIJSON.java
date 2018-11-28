package Beans.ViatorAPIBeans.Bookings.PastBooking;

import Beans.ViatorAPIBeans.APIJSONMetada;

/**
 * Created by George on 04/08/2017.
 */
public class PastBookingAPIJSON extends APIJSONMetada {

    private PastBookingData data;

    public PastBookingData getData() {
        return data;
    }

    public void setData(PastBookingData data) {
        this.data = data;
    }
}
