package Beans.HotelBedsAPIBeans.Availability;

import java.util.List;

/**
 * Created by George on 16/03/2018.
 */
public class Taxes {

    private List<Tax> taxes;
    private boolean allIncluded;

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }

    public boolean isAllIncluded() {
        return allIncluded;
    }

    public void setAllIncluded(boolean allIncluded) {
        this.allIncluded = allIncluded;
    }
}
