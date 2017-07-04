package APIBeans.SearchFreetext;

import APIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 29/05/17.
 */
public class SearchFreetextDestinationsAPIJSON extends APIJSONMetada {

    private List<SearchFreetextDestinationMetaData> data;

    public List<SearchFreetextDestinationMetaData> getData() {
        return data;
    }

    public void setData(List<SearchFreetextDestinationMetaData> data) {
        this.data = data;
    }
}
