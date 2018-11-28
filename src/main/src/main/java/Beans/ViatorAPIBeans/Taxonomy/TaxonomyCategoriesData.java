package Beans.ViatorAPIBeans.Taxonomy;

import java.util.List;

/**
 * Created by George on 19/06/17.
 */
public class TaxonomyCategoriesData {

    private int sortOrder;
    private String thumbnailURL;
    private List<TaxonomySubcategory> subcategories;
    private String thumbnailHiResURL;
    private int productCount;
    private String groupName;
    private String groupUrlName;
    private int id;

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public List<TaxonomySubcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<TaxonomySubcategory> subcategories) {
        this.subcategories = subcategories;
    }

    public String getThumbnailHiResURL() {
        return thumbnailHiResURL;
    }

    public void setThumbnailHiResURL(String thumbnailHiResURL) {
        this.thumbnailHiResURL = thumbnailHiResURL;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupUrlName() {
        return groupUrlName;
    }

    public void setGroupUrlName(String groupUrlName) {
        this.groupUrlName = groupUrlName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
