package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.StandardJSON;
import Beans.ATBDBBeans.KalitaonSystem.CountryCodeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 17/07/2017.
 */
public class CountriesJSON extends StandardJSON {
    private List<CountryCodeBean> data=new ArrayList<>();

    public List<CountryCodeBean> getData() {
        return data;
    }

    public void setData(List<CountryCodeBean> data) {
        this.data = data;
    }
}
