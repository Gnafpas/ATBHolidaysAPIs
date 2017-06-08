package APIBeans.Taxonomy;

import APIBeans.API_JSON_Metada;

import java.util.List;

/**
 * Created by George on 06/06/17.
 */
public class Taxonomy_Attractions_APIJSON extends API_JSON_Metada {
    private List<Taxonomy_Attractions_Data> data;

    public List<Taxonomy_Attractions_Data> getData() {
        return data;
    }

    public void setData(List<Taxonomy_Attractions_Data> data) {
        this.data = data;
    }
}
