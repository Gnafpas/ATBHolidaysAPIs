package APIBeans.Taxonomy;

import APIBeans.API_JSON_Metada;

import java.util.List;

/**
 * Created by George on 04/06/17.
 */
public class Taxonomy_Destinations_APIJSON extends API_JSON_Metada {

    private List<Taxonomy_Destinations_Data> data;

    public List<Taxonomy_Destinations_Data> getData() {
        return data;
    }

    public void setData(List<Taxonomy_Destinations_Data> data) {
        this.data = data;
    }
}
