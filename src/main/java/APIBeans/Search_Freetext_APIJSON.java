package APIBeans;

import java.util.List;

/**
 * Created by George on 29/05/17.
 */
public class Search_Freetext_APIJSON extends API_JSON_Metada {

    private List<Search_Freetext_Metadata> data;


    public List<Search_Freetext_Metadata> getData() {
        return data;
    }

    public void setData(List<Search_Freetext_Metadata> data) {
        this.data = data;
    }
}
