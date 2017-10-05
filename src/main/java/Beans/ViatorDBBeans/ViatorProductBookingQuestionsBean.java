package Beans.ViatorDBBeans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by George on 21/08/2017.
 */
@Entity
@Table(name = "viator_product_booking_questions", schema = "develope_viator", catalog = "")
public class ViatorProductBookingQuestionsBean {
    private int rid;
    private String productCode;
    private String questionId;
    private String stringQuestionId;
    private String titleEn;
    private String subTitleEn;
    private boolean required;
    private String message;
    private Integer sortOrder;
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
    @Column(name = "question_id")
    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    @Basic
    @Column(name = "string_question_id")
    public String getStringQuestionId() {
        return stringQuestionId;
    }

    public void setStringQuestionId(String stringQuestionId) {
        this.stringQuestionId = stringQuestionId;
    }

    @Basic
    @Column(name = "title_EN")
    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    @Basic
    @Column(name = "sub_title_EN")
    public String getSubTitleEn() {
        return subTitleEn;
    }

    public void setSubTitleEn(String subTitleEn) {
        this.subTitleEn = subTitleEn;
    }

    @Basic
    @Column(name = "required")
    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

        ViatorProductBookingQuestionsBean that = (ViatorProductBookingQuestionsBean) o;

        if (rid != that.rid) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;
        if (stringQuestionId != null ? !stringQuestionId.equals(that.stringQuestionId) : that.stringQuestionId != null)
            return false;
        if (titleEn != null ? !titleEn.equals(that.titleEn) : that.titleEn != null) return false;
        if (subTitleEn != null ? !subTitleEn.equals(that.subTitleEn) : that.subTitleEn != null) return false;
        if (required != that.required) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (sortOrder != null ? !sortOrder.equals(that.sortOrder) : that.sortOrder != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
        result = 31 * result + (stringQuestionId != null ? stringQuestionId.hashCode() : 0);
        result = 31 * result + (titleEn != null ? titleEn.hashCode() : 0);
        result = 31 * result + (subTitleEn != null ? subTitleEn.hashCode() : 0);
        result = 31 * result + (required ? 1 : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (sortOrder != null ? sortOrder.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
