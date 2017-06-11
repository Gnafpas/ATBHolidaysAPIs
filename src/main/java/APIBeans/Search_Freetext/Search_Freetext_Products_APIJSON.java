package APIBeans.Search_Freetext;

import APIBeans.API_JSON_Metada;

import java.util.List;

/**
 * Created by George on 31/05/17.
 */
public class Search_Freetext_Products_APIJSON extends API_JSON_Metada {

    private List<Search_Freetext_Product_Metadata> data;

    public List<Search_Freetext_Product_Metadata> getData() {
        return data;
    }

    public void setData(List<Search_Freetext_Product_Metadata> data) {
        this.data = data;
    }
}
