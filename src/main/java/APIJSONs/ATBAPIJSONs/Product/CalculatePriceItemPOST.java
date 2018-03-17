package APIJSONs.ATBAPIJSONs.Product;

import java.util.List;

/**
 * Created by George on 02/03/2018.
 */
public class CalculatePriceItemPOST {
    private String travelDate;
    private String productId;
    private String planId;
    private List<CalculatePriceTraveller> travellers;

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

    public List<CalculatePriceTraveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<CalculatePriceTraveller> travellers) {
        this.travellers = travellers;
    }
}
