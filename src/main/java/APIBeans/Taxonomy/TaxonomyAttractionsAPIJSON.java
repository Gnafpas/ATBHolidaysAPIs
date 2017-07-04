package APIBeans.Taxonomy;

import APIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 06/06/17.
 */
public class TaxonomyAttractionsAPIJSON extends APIJSONMetada {
    private List<TaxonomyAttractionsData> data;

    public List<TaxonomyAttractionsData> getData() {
        return data;
    }

    public void setData(List<TaxonomyAttractionsData> data) {
        this.data = data;
    }
}
