package APIBeans;

import java.util.List;

/**
 * Created by George on 29/05/17.
 */
public class Destination_Search_Freetext_APIJSON extends API_JSON_Metada {

    private List<Search_Freetext_Destination_MetaData> data;

    public List<Search_Freetext_Destination_MetaData> getData() {
        return data;
    }

    public void setData(List<Search_Freetext_Destination_MetaData> data) {
        this.data = data;
    }
}
