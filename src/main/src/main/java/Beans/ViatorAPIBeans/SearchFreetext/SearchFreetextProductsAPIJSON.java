package Beans.ViatorAPIBeans.SearchFreetext;

import Beans.ViatorAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 31/05/17.
 */
public class SearchFreetextProductsAPIJSON extends APIJSONMetada {

    private List<SearchFreetextProductMetadata> data;

    public List<SearchFreetextProductMetadata> getData() {
        return data;
    }

    public void setData(List<SearchFreetextProductMetadata> data) {
        this.data = data;
    }
}
