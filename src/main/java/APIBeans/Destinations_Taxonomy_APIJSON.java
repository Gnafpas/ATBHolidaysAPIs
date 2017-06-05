package APIBeans;

import java.util.List;

/**
 * Created by George on 04/06/17.
 */
public class Destinations_Taxonomy_APIJSON extends API_JSON_Metada {

    private List<Destinations_Taxonomy_Data> data;

    public List<Destinations_Taxonomy_Data> getData() {
        return data;
    }

    public void setData(List<Destinations_Taxonomy_Data> data) {
        this.data = data;
    }
}
