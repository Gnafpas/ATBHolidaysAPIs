package APIBeans.Taxonomy;

import APIBeans.API_JSON_Metada;

import java.util.List;

/**
 * Created by George on 19/06/17.
 */
public class Taxonomy_Categories_APIJSON extends API_JSON_Metada {

    private List<Taxonomy_Categories_Data> data;

    public List<Taxonomy_Categories_Data> getData() {
        return data;
    }

    public void setData(List<Taxonomy_Categories_Data> data) {
        this.data = data;
    }
}
