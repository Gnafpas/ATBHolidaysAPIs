package Beans.HotelBedsAPIBeans.Destiantions;

import Beans.HotelBedsAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 15/01/2018.
 */
public class CountriesAPIJSON extends APIJSONMetada{

    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
