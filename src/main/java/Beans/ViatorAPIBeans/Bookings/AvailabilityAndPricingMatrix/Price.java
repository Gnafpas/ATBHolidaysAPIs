package Beans.ViatorAPIBeans.Bookings.AvailabilityAndPricingMatrix;

import java.math.BigDecimal;

/**
 * Created by George on 26/07/2017.
 */
public class Price {

    private int sortOrder;
    private String currencyCode;
    private BigDecimal price;
    private int minNoOfTravellersRequiredForPrice;
    private String priceFormatted;
    private BigDecimal merchantNetPrice;
    private String merchantNetPriceFormatted;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getMinNoOfTravellersRequiredForPrice() {
        return minNoOfTravellersRequiredForPrice;
    }

    public void setMinNoOfTravellersRequiredForPrice(int minNoOfTravellersRequiredForPrice) {
        this.minNoOfTravellersRequiredForPrice = minNoOfTravellersRequiredForPrice;
    }

    public String getPriceFormatted() {
        return priceFormatted;
    }

    public void setPriceFormatted(String priceFormatted) {
        this.priceFormatted = priceFormatted;
    }

    public BigDecimal getMerchantNetPrice() {
        return merchantNetPrice;
    }

    public void setMerchantNetPrice(BigDecimal merchantNetPrice) {
        this.merchantNetPrice = merchantNetPrice;
    }

    public String getMerchantNetPriceFormatted() {
        return merchantNetPriceFormatted;
    }

    public void setMerchantNetPriceFormatted(String merchantNetPriceFormatted) {
        this.merchantNetPriceFormatted = merchantNetPriceFormatted;
    }
}
