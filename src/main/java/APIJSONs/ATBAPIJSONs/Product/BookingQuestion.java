package APIJSONs.ATBAPIJSONs.Product;

import java.sql.Timestamp;

/**
 * Created by George on 28/03/2018.
 */
public class BookingQuestion {

    private String productId;
    private String questionId;
    private String stringQuestionId;
    private String titleEn;
    private String subTitleEn;
    private boolean required;
    private String message;
    private Integer sortOrder;
    private Timestamp updatedAt;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getStringQuestionId() {
        return stringQuestionId;
    }

    public void setStringQuestionId(String stringQuestionId) {
        this.stringQuestionId = stringQuestionId;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getSubTitleEn() {
        return subTitleEn;
    }

    public void setSubTitleEn(String subTitleEn) {
        this.subTitleEn = subTitleEn;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
