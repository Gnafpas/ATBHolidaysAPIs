package APIBeans.Product_Details;

/**
 * Created by George on 19/06/17.
 */
public class Product_Detail_bookingQuestions {

    private String product_code;
    private String question_id;
    private String string_question_id;
    private String title_EN;
    private String sub_title_EN;
    private boolean required;
    private String message;
    private int sort_order;

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getString_question_id() {
        return string_question_id;
    }

    public void setString_question_id(String string_question_id) {
        this.string_question_id = string_question_id;
    }

    public String getTitle_EN() {
        return title_EN;
    }

    public void setTitle_EN(String title_EN) {
        this.title_EN = title_EN;
    }

    public String getSub_title_EN() {
        return sub_title_EN;
    }

    public void setSub_title_EN(String sub_title_EN) {
        this.sub_title_EN = sub_title_EN;
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

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }
}
