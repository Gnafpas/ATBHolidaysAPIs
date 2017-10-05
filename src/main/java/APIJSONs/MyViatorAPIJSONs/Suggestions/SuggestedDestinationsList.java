package APIJSONs.MyViatorAPIJSONs.Suggestions;

import java.util.List;

/**
 * Created by George on 04/06/17.
 */
public class SuggestedDestinationsList {

    private List<Country> countries;
    private List<City> cities;
    private List<Region> regions;
    private boolean dbCommError=false;

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

    public boolean isDbCommError() {
        return dbCommError;
    }

    public void setDbCommError(boolean dbCommError) {
        this.dbCommError = dbCommError;
    }
}
