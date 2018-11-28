package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 30/06/2017.
 */
@Entity
@Table(name = "viator_categories", schema = "develope_viator", catalog = "")
public class ViatorCategoriesBean {
    private int id;
    private Integer sortOrder;
    private String groupname;
    private String thumbnailUrl;
    private int productCount;
    private String groupUrlname;
    private String thumbnailHiResUrl;
    private Timestamp updatedAt;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "groupname")
    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @Basic
    @Column(name = "thumbnail_URL")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Basic
    @Column(name = "product_count")
    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Basic
    @Column(name = "groupUrlname")
    public String getGroupUrlname() {
        return groupUrlname;
    }

    public void setGroupUrlname(String groupUrlname) {
        this.groupUrlname = groupUrlname;
    }

    @Basic
    @Column(name = "thumbnailHiResURL")
    public String getThumbnailHiResUrl() {
        return thumbnailHiResUrl;
    }

    public void setThumbnailHiResUrl(String thumbnailHiResUrl) {
        this.thumbnailHiResUrl = thumbnailHiResUrl;
    }

    @Basic
    @Column(name = "updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViatorCategoriesBean that = (ViatorCategoriesBean) o;

        if (id != that.id) return false;
        if (productCount != that.productCount) return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (groupname != null ? !groupname.equals(that.groupname) : that.groupname != null) return false;
        if (thumbnailUrl != null ? !thumbnailUrl.equals(that.thumbnailUrl) : that.thumbnailUrl != null) return false;
        if (groupUrlname != null ? !groupUrlname.equals(that.groupUrlname) : that.groupUrlname != null) return false;
        if (thumbnailHiResUrl != null ? !thumbnailHiResUrl.equals(that.thumbnailHiResUrl) : that.thumbnailHiResUrl != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (groupname != null ? groupname.hashCode() : 0);
        result = 31 * result + (thumbnailUrl != null ? thumbnailUrl.hashCode() : 0);
        result = 31 * result + productCount;
        result = 31 * result + (groupUrlname != null ? groupUrlname.hashCode() : 0);
        result = 31 * result + (thumbnailHiResUrl != null ? thumbnailHiResUrl.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
