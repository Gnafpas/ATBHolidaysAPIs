package Beans.ViatorAPIBeans.Taxonomy;

/**
 * Created by George on 19/06/17.
 */
public class TaxonomySubcategory {

    private int sortOrder;
    private int categoryId;
    private String subcategoryName;
    private String subcategoryUrlName;
    private int subcategoryId;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public String getSubcategoryUrlName() {
        return subcategoryUrlName;
    }

    public void setSubcategoryUrlName(String subcategoryUrlName) {
        this.subcategoryUrlName = subcategoryUrlName;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
}
