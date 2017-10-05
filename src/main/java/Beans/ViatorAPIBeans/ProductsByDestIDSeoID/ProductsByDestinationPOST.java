package Beans.ViatorAPIBeans.ProductsByDestIDSeoID;

/**
 * Created by George on 11/06/17.
 */
public class ProductsByDestinationPOST {

    private String startDate;
    private String endDate;
    private String topX;
    private int destId;
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

    public int getDestId() {
        return destId;
    }

    public void setDestId(int destId) {
        this.destId = destId;
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
