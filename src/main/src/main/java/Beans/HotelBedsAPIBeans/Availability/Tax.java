package Beans.HotelBedsAPIBeans.Availability;

/**
 * Created by George on 16/03/2018.
 */
public class Tax {

    private boolean included;
    private String amount;
    private String currency;

    public boolean isIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
