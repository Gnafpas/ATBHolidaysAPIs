package APIJSONs.ATBAPIJSONs.Product;

import APIJSONs.ATBAPIJSONs.StandardJSON;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George on 11/07/2017.
 */
public class CategoriesJson extends StandardJSON {
    private Categories data=new Categories();


    public Categories getData() {
        return data;
    }

    public void setData(Categories data) {
        this.data = data;
    }
}
