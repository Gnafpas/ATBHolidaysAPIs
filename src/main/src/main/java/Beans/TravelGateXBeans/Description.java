package Beans.TravelGateXBeans;

import java.util.List;

/**
 * Created by George on 10/07/2018.
 */
public class Description {
     private String type;
     private List<Text> texts;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }
}
