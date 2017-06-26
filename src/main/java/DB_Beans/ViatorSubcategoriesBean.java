package DB_Beans;

import javax.persistence.*;

/**
 * Created by George on 19/06/17.
 */
@Entity
@Table(name = "viator_subcategories", schema = "develope_viator", catalog = "")
public class ViatorSubcategoriesBean {
    private int rid;
    private Integer sortOrder;
    private int id;
    private String subcategoryName;
    private String subcategoryUrlName;
    private Integer categoryId;

    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "sort_order")
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Basic
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "subcategoryName")
    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    @Basic
    @Column(name = "subcategoryUrlName")
    public String getSubcategoryUrlName() {
        return subcategoryUrlName;
    }

    public void setSubcategoryUrlName(String subcategoryUrlName) {
        this.subcategoryUrlName = subcategoryUrlName;
    }

    @Basic
    @Column(name = "categoryId")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViatorSubcategoriesBean that = (ViatorSubcategoriesBean) o;

        if (rid != that.rid) return false;
        if (id != that.id) return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (subcategoryName != null ? !subcategoryName.equals(that.subcategoryName) : that.subcategoryName != null)
            return false;
        if (subcategoryUrlName != null ? !subcategoryUrlName.equals(that.subcategoryUrlName) : that.subcategoryUrlName != null)
            return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (subcategoryName != null ? subcategoryName.hashCode() : 0);
        result = 31 * result + (subcategoryUrlName != null ? subcategoryUrlName.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        return result;
    }
}
