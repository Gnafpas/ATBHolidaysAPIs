package Beans.ViatorAPIBeans.SearchFreetext;

import Beans.ViatorAPIBeans.APIJSONMetada;

import java.util.List;

/**
 * Created by George on 07/06/17.
 */
public class SearchFreetextAttractionsAPIJSON extends APIJSONMetada {

    private List<SearchFreetextAttractionMetaData> data;

    public List<SearchFreetextAttractionMetaData> getData() {
        return data;
    }

    public void setData(List<SearchFreetextAttractionMetaData> data) {
        this.data = data;
    }
}
