package APIBeans;

import java.util.List;

/**
 * Created by George on 06/06/17.
 */
public class Attractions_Taxonomy_APIJSON extends API_JSON_Metada{
    private List<Attractions_Taxonomy_Data> data;

    public List<Attractions_Taxonomy_Data> getData() {
        return data;
    }

    public void setData(List<Attractions_Taxonomy_Data> data) {
        this.data = data;
    }
}
