package APIBeans.ProductsByCodes;

import APIBeans.APIJSONMetada;
import APIBeans.SearchFreetext.SearchFreetextProductData;

import java.util.List;

/**
 * Created by George on 31/05/17.
 */
public class ProductsByCodesAPIJSON extends APIJSONMetada {

    private List<SearchFreetextProductData> data;

    public List<SearchFreetextProductData> getData() {
        return data;
    }

    public void setData(List<SearchFreetextProductData> data) {
        this.data = data;
    }
}
