package Beans.TravelGateXBeans;

import java.util.List;

/**
 * Created by George on 10/07/2018.
 */
public class Amenity {

    private String code;
    enum type
    {
        HOTEL,
        ROOM,
        SERVICE,
        GENERAL;
    }
    private List<Text> texts;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }
}
