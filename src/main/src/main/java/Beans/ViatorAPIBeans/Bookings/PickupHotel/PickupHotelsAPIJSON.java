package Beans.ViatorAPIBeans.Bookings.PickupHotel;

import Beans.ViatorAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 12/07/2017.
 */
public class PickupHotelsAPIJSON extends APIJSONMetada {
   private List<PickupHotel> data;

    public List<PickupHotel> getData() {
        return data;
    }

    public void setData(List<PickupHotel> data) {
        this.data = data;
    }
}
