package APIBeans.Product_Details;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by George on 10/06/17.
 */
public class Product_Detail_tourGrades {

    private int sortOrder;
    private String currencyCode;
    private HashMap langServices;//todo Put correct type of atribute/
    private String priceFromFormatted;
    private BigDecimal priceFrom;
    private String gradeDepartureTime;
    private String gradeCode;
    private String gradeTitle;
    private String gradeDescription;
    private String defaultLanguageCode;
    private BigDecimal merchantNetPriceFrom;
    private String merchantNetPriceFromFormatted;

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

    public HashMap getLangServices() {
        return langServices;
    }

    public void setLangServices(HashMap langServices) {
        this.langServices = langServices;
    }

    public String getPriceFromFormatted() {
        return priceFromFormatted;
    }

    public void setPriceFromFormatted(String priceFromFormatted) {
        this.priceFromFormatted = priceFromFormatted;
    }

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
    }

    public String getGradeDepartureTime() {
        return gradeDepartureTime;
    }

    public void setGradeDepartureTime(String gradeDepartureTime) {
        this.gradeDepartureTime = gradeDepartureTime;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getGradeTitle() {
        return gradeTitle;
    }

    public void setGradeTitle(String gradeTitle) {
        this.gradeTitle = gradeTitle;
    }

    public String getGradeDescription() {
        return gradeDescription;
    }

    public void setGradeDescription(String gradeDescription) {
        this.gradeDescription = gradeDescription;
    }

    public String getDefaultLanguageCode() {
        return defaultLanguageCode;
    }

    public void setDefaultLanguageCode(String defaultLanguageCode) {
        this.defaultLanguageCode = defaultLanguageCode;
    }

    public BigDecimal getMerchantNetPriceFrom() {
        return merchantNetPriceFrom;
    }

    public void setMerchantNetPriceFrom(BigDecimal merchantNetPriceFrom) {
        this.merchantNetPriceFrom = merchantNetPriceFrom;
    }

    public String getMerchantNetPriceFromFormatted() {
        return merchantNetPriceFromFormatted;
    }

    public void setMerchantNetPriceFromFormatted(String merchantNetPriceFromFormatted) {
        this.merchantNetPriceFromFormatted = merchantNetPriceFromFormatted;
    }
}
