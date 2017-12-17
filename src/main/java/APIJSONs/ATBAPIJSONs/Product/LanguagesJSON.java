package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.StandardJSON;
import Beans.ATBDBBeans.KalitaonSystem.AllLanguageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 27/10/2017.
 */
public class LanguagesJSON  extends StandardJSON {

    List<AllLanguageBean> data=new ArrayList<>();

    public List<AllLanguageBean> getData() {
        return data;
    }

    public void setData(List<AllLanguageBean> data) {
        this.data = data;
    }
}
