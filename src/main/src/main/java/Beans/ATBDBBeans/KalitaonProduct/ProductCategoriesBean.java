package Beans.ATBDBBeans.KalitaonProduct;

import javax.persistence.*;

/**
 * Created by George on 18/09/2017.
 */
@Entity
@Table(name = "product_categories", schema = "atb_DB", catalog = "")
public class ProductCategoriesBean {
    private int id;
    private String subCatId;
    private String categoryName;
    private String lng;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sub_cat_id")
    public String getSubCatId() {
        return subCatId;
    }

    public void setSubCatId(String subCatId) {
        this.subCatId = subCatId;
    }

    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "lng")
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategoriesBean that = (ProductCategoriesBean) o;

        if (id != that.id) return false;
        if (subCatId != null ? !subCatId.equals(that.subCatId) : that.subCatId != null) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;
        if (lng != null ? !lng.equals(that.lng) : that.lng != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subCatId != null ? subCatId.hashCode() : 0);
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (lng != null ? lng.hashCode() : 0);
        return result;
    }
}
