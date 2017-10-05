package Beans.ViatorAPIBeans.ProductsByDestIDSeoID;

import Beans.ViatorAPIBeans.APIJSONMetada;
import Beans.ViatorAPIBeans.SearchFreetext.SearchFreetextProductData;

import java.util.List;

/**
 * Created by George on 12/06/17.
 */
public class ProductsByDestIdSeoIdAPIJSON extends APIJSONMetada {

    private List<SearchFreetextProductData> data; /**Same JSON data with search freetext product.*/

    public List<SearchFreetextProductData> getData() {
        return data;
    }

    public void setData(List<SearchFreetextProductData> data) {
        this.data = data;
    }
}
