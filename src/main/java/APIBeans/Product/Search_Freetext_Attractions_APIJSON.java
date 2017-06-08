package APIBeans.Product;

import APIBeans.API_JSON_Metada;

import java.util.List;

/**
 * Created by George on 07/06/17.
 */
public class Search_Freetext_Attractions_APIJSON extends API_JSON_Metada {

    private List<Search_Freetext_Attraction_MetaData> data;

    public List<Search_Freetext_Attraction_MetaData> getData() {
        return data;
    }

    public void setData(List<Search_Freetext_Attraction_MetaData> data) {
        this.data = data;
    }
}
