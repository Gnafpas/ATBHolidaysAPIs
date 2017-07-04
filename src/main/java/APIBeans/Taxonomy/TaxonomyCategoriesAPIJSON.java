package APIBeans.Taxonomy;

import APIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 19/06/17.
 */
public class TaxonomyCategoriesAPIJSON extends APIJSONMetada {

    private List<TaxonomyCategoriesData> data;

    public List<TaxonomyCategoriesData> getData() {
        return data;
    }

    public void setData(List<TaxonomyCategoriesData> data) {
        this.data = data;
    }
}
