package APIBeans.Bookings.CalculatePrice;

import APIBeans.APIJSONMetada;

/**
 * Created by George on 03/08/2017.
 */
public class CalculatePriceAPIJSON extends APIJSONMetada {

    private CalculatePriceData data;

    public CalculatePriceData getData() {
        return data;
    }

    public void setData(CalculatePriceData data) {
        this.data = data;
    }
}
