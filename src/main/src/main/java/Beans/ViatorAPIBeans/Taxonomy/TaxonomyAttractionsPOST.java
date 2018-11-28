package Beans.ViatorAPIBeans.Taxonomy;

/**
 * Created by George on 06/06/17.
 */
public class TaxonomyAttractionsPOST {
    private int destId;
    private String topX;
    private String sortOrder;

    public int getDestId() {
        return destId;
    }

    public void setDestId(int destId) {
        this.destId = destId;
    }

    public String getTopX() {
        return topX;
    }

    public void setTopX(String topX) {
        this.topX = topX;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
