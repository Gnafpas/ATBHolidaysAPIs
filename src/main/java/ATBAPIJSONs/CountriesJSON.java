package ATBAPIBeans;

import ATBSysDBBeans.CityCodeBean;
import ATBSysDBBeans.CountryCodeBean;
import DBBeans.ViatorDestinationsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 17/07/2017.
 */
public class CountriesJSON {
    List<CountryCodeBean> countries=new ArrayList<>();
    private boolean DBError=false;

    public List<CountryCodeBean> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryCodeBean> countries) {
        this.countries = countries;
    }

    public boolean isDBError() {
        return DBError;
    }

    public void setDBError(boolean DBError) {
        this.DBError = DBError;
    }
}
