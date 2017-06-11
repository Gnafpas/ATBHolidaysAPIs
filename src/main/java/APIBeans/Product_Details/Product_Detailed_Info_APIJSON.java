package APIBeans.Product_Details;

import APIBeans.API_JSON_Metada;

/**
 * Created by George on 10/06/17.
 */
public class Product_Detailed_Info_APIJSON extends API_JSON_Metada {

    private Product_Detailed_Info_Data data;

    public Product_Detailed_Info_Data getData() {
        return data;
    }

    public void setData(Product_Detailed_Info_Data data) {
        this.data = data;
    }
}
