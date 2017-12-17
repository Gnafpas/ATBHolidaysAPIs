package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.StandardJSON;
import Beans.ATBDBBeans.KalitaonSystem.CityCodeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 18/09/2017.
 */
public class CitiesJSON extends StandardJSON {

    List<CityCodeBean> data=new ArrayList<>();

    public List<CityCodeBean> getData() {
        return data;
    }

    public void setData(List<CityCodeBean> data) {
        this.data = data;
    }
}
