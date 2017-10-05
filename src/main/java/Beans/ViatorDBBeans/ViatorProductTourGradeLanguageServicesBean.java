package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 23/06/17.
 */
@Entity
@Table(name = "viator_product_tour_grade_language_services", schema = "develope_viator", catalog = "")
public class ViatorProductTourGradeLanguageServicesBean {
    private int rid;
    private String productCode;
    private String gradeCode;
    private String languageCodeAndService;
    private String languageCode;
    private String languageService;
    private String languageServiceDescription;
    private Timestamp updatedAt;

    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "grade_code")
    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    @Basic
    @Column(name = "language_code_and_service")
    public String getLanguageCodeAndService() {
        return languageCodeAndService;
    }

    public void setLanguageCodeAndService(String languageCodeAndService) {
        this.languageCodeAndService = languageCodeAndService;
    }

    @Basic
    @Column(name = "language_code")
    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Basic
    @Column(name = "language_service")
    public String getLanguageService() {
        return languageService;
    }

    public void setLanguageService(String languageService) {
        this.languageService = languageService;
    }

    @Basic
    @Column(name = "language_service_description")
    public String getLanguageServiceDescription() {
        return languageServiceDescription;
    }

    public void setLanguageServiceDescription(String languageServiceDescription) {
        this.languageServiceDescription = languageServiceDescription;
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

        ViatorProductTourGradeLanguageServicesBean that = (ViatorProductTourGradeLanguageServicesBean) o;

        if (rid != that.rid) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (gradeCode != null ? !gradeCode.equals(that.gradeCode) : that.gradeCode != null) return false;
        if (languageCodeAndService != null ? !languageCodeAndService.equals(that.languageCodeAndService) : that.languageCodeAndService != null)
            return false;
        if (languageCode != null ? !languageCode.equals(that.languageCode) : that.languageCode != null) return false;
        if (languageService != null ? !languageService.equals(that.languageService) : that.languageService != null)
            return false;
        if (languageServiceDescription != null ? !languageServiceDescription.equals(that.languageServiceDescription) : that.languageServiceDescription != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (gradeCode != null ? gradeCode.hashCode() : 0);
        result = 31 * result + (languageCodeAndService != null ? languageCodeAndService.hashCode() : 0);
        result = 31 * result + (languageCode != null ? languageCode.hashCode() : 0);
        result = 31 * result + (languageService != null ? languageService.hashCode() : 0);
        result = 31 * result + (languageServiceDescription != null ? languageServiceDescription.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
