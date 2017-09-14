package APIBeans.Bookings.Cancel;

import APIBeans.APIJSONMetada;

/**
 * Created by George on 03/08/2017.
 */
public class CancelAPIJSON extends APIJSONMetada {

    private CancelData data;

    public CancelData getData() {
        return data;
    }

    public void setData(CancelData data) {
        this.data = data;
    }
}
