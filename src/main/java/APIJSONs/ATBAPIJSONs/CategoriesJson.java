package APIJSONs.ATBAPIJSONs;

import Beans.ATBDBBeans.KalitaonProduct.ProductCategoriesBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 11/07/2017.
 */
public class CategoriesJson extends StandardJSON {
    private List<Category> data=new ArrayList<>();

    public List<Category> getData() {
        return data;
    }

    public void setData(List<Category> data) {
        this.data = data;
    }
}
