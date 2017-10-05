package ATBAPIBeans;

import ATBSysDBBeans.CityCodeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 18/09/2017.
 */
public class CitiesJSON {

    List<CityCodeBean> countries=new ArrayList<>();
    private boolean DBError=false;

    public List<CityCodeBean> getCountries() {
        return countries;
    }

    public void setCountries(List<CityCodeBean> countries) {
        this.countries = countries;
    }

    public boolean isDBError() {
        return DBError;
    }

    public void setDBError(boolean DBError) {
        this.DBError = DBError;
    }
}
