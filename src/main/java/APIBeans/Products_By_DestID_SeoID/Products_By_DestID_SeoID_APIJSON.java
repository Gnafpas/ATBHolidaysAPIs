package APIBeans.Products_By_DestID_SeoID;

import APIBeans.API_JSON_Metada;
import APIBeans.Search_Freetext.Search_Freetext_Product_Data;

import java.util.List;

/**
 * Created by George on 12/06/17.
 */
public class Products_By_DestID_SeoID_APIJSON extends API_JSON_Metada {

    private List<Search_Freetext_Product_Data> data; /**Same JSON data with search freetext product.*/

    public List<Search_Freetext_Product_Data> getData() {
        return data;
    }

    public void setData(List<Search_Freetext_Product_Data> data) {
        this.data = data;
    }
}
