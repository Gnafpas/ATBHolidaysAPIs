package APIBeans.Taxonomy;

import APIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 04/06/17.
 */
public class TaxonomyDestinationsAPIJSON extends APIJSONMetada {

    private List<TaxonomyDestinationsData> data;

    public List<TaxonomyDestinationsData> getData() {
        return data;
    }

    public void setData(List<TaxonomyDestinationsData> data) {
        this.data = data;
    }
}
