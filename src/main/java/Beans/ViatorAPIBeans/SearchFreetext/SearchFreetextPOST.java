package Beans.ViatorAPIBeans.SearchFreetext;

import Helper.ProjectProperties;

import java.util.List;

/**
 * Created by George on 29/05/17.
 */
public class SearchFreetextPOST {

    private String topX="";
    private int destId;
    private String currencyCode= ProjectProperties.defaultCurrencyCode;
    private List<String> searchTypes;
    private String  text;

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

    public List<String> getSearchTypes() {
        return searchTypes;
    }

    public void setSearchTypes(List<String> searchTypes) {
        this.searchTypes = searchTypes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
