package Beans.HotelBedsAPIBeans.Destiantions;

import Beans.HotelBedsAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 15/01/2018.
 */
public class DestinationsAPIJSON extends APIJSONMetada{

    private List<Destination> destinations;

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
