package Beans.HereAPIBeans;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by George on 13/05/2018.
 */
public class Response {
    @JsonProperty(value="View")
    private List<View> view;

    public List<View> getView() {
        return view;
    }

    public void setView(List<View> view) {
        this.view = view;
    }
}
