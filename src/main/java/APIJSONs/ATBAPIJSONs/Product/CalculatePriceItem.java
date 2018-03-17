package APIJSONs.ATBAPIJSONs.Product;

import java.math.BigDecimal;

/**
 * Created by George on 02/03/2018.
 */
public class CalculatePriceItem {
    private BigDecimal price;
    private String travelDate;
    private String productId;
    private String planId;
    private String currency;


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }
}
