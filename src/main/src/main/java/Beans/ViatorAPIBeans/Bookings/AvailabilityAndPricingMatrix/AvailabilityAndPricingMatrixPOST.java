package Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix;

/**
 * Created by George on 26/07/2017.
 */
public class AvailabilityAndPricingMatrixPOST {

    private String productCode;
    private String month;
    private String year;
    private String currencyCode= Helper.ProjectProperties.defaultCurrencyCode;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
