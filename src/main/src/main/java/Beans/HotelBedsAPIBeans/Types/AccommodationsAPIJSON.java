package Beans.HotelBedsAPIBeans.Types;

import Beans.HotelBedsAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 10/03/2018.
 */
public class AccommodationsAPIJSON extends APIJSONMetada {

    private List<Accommodation> accommodations;

    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }
}
