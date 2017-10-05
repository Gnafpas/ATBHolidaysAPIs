package Beans.ViatorAPIBeans.ProductsByDestIDSeoID;

/**
 * Created by George on 12/06/17.
 */
public class ProductsByAttractionPOST {

    private String startDate;
    private String endDate;
    private String topX;
    private int seoId;
    private String currencyCode;
    private int catId;
    private int subCatId;
    private boolean dealsOnly;
    private String sortOrder;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTopX() {
        return topX;
    }

    public void setTopX(String topX) {
        this.topX = topX;
    }

    public int getSeoId() {
        return seoId;
    }

    public void setSeoId(int seoId) {
        this.seoId = seoId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(int subCatId) {
        this.subCatId = subCatId;
    }

    public boolean isDealsOnly() {
        return dealsOnly;
    }

    public void setDealsOnly(boolean dealsOnly) {
        this.dealsOnly = dealsOnly;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
