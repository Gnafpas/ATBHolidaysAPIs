package Beans.HereAPIBeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by George on 13/05/2018.
 */
public class View {

    @JsonProperty(value="Result")
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }
}
