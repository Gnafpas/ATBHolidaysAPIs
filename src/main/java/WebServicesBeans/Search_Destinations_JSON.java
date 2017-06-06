package WebServicesBeans;

import java.util.List;

/**
 * Created by George on 04/06/17.
 */
public class Search_Destinations_JSON {

    private List<String> countries;
    private List<City> cities;
    private List<Region> regions;

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
