package Beans.HotelBedsAPIBeans.Types;

import Beans.HotelBedsAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 11/03/2018.
 */
public class FacilitiesAPIJSON extends APIJSONMetada {

    private List<Facility> facilities;

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
}
