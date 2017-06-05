package WebServicesBeans;

import java.util.List;

/**
 * Created by George on 04/06/17.
 */
public class Search_Destinations_JSON {
    private List<String> countries;
    private List<String> cities;
    private List<String> regions;

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }
}
