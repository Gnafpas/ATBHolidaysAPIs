package Beans.ViatorAPIBeans.SearchFreetext;


import java.math.BigDecimal;

/**
 * Created by George on 30/05/17.
 */
public class SearchFreetextDestinationData {

    private int sortOrder;
    private boolean selectable;
    private String destinationUrlName;
    private String defaultCurrencyCode;
    private String lookupId;
    private int parentId;
    private String timeZone;
    private String iataCode;
    private int destinationId;
    private String destinationType;
    private String destinationName;
    private BigDecimal latitude;
    private BigDecimal longitude;


    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public String getDestinationUrlName() {
        return destinationUrlName;
    }

    public void setDestinationUrlName(String destinationUrlName) {
        this.destinationUrlName = destinationUrlName;
    }

    public String getDefaultCurrencyCode() {
        return defaultCurrencyCode;
    }

    public void setDefaultCurrencyCode(String defaultCurrencyCode) {
        this.defaultCurrencyCode = defaultCurrencyCode;
    }

    public String getLookupId() {
        return lookupId;
    }

    public void setLookupId(String lookupId) {
        this.lookupId = lookupId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(String destinationType) {
        this.destinationType = destinationType;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}


