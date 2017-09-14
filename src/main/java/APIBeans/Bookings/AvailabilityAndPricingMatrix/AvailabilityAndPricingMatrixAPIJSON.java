package APIBeans.Bookings.AvailabilityAndPricingMatrix;

import APIBeans.APIJSONMetada;

/**
 * Created by George on 26/07/2017.
 */
public class AvailabilityAndPricingMatrixAPIJSON extends APIJSONMetada {

    private AvailabilityAndPricingMatrixData data;

    public AvailabilityAndPricingMatrixData getData() {
        return data;
    }

    public void setData(AvailabilityAndPricingMatrixData data) {
        this.data = data;
    }
}
