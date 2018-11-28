package APIJSONs.ATBAPIJSONs.Product;

/**
 * Created by George on 31/03/2018.
 */
public class PriceMatrix {

    private int id;
    private String productId;
    private String planId;
    private String personType;
    private String ageFrom;
    private String ageTo;
    private int minCountRequired;
    private int maxCountRequired;
    private String priceNet;
    private String currencyCode;
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(String ageFrom) {
        this.ageFrom = ageFrom;
    }

    public String getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(String ageTo) {
        this.ageTo = ageTo;
    }

    public int getMinCountRequired() {
        return minCountRequired;
    }

    public void setMinCountRequired(int minCountRequired) {
        this.minCountRequired = minCountRequired;
    }

    public int getMaxCountRequired() {
        return maxCountRequired;
    }

    public void setMaxCountRequired(int maxCountRequired) {
        this.maxCountRequired = maxCountRequired;
    }

    public String getPriceNet() {
        return priceNet;
    }

    public void setPriceNet(String priceNet) {
        this.priceNet = priceNet;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
