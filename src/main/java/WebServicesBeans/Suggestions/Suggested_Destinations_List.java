package WebServicesBeans.Suggestions;

import java.util.List;

/**
 * Created by George on 04/06/17.
 */
public class Suggested_Destinations_List {

    private List<Country> countries;
    private List<City> cities;
    private List<Region> regions;
    private boolean viator_error=false;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
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

    public boolean isViator_error() {
        return viator_error;
    }

    public void setViator_error(boolean viator_error) {
        this.viator_error = viator_error;
    }
}
