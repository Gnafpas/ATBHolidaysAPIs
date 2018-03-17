package Beans.HotelBedsAPIBeans.Types;

/**
 * Created by George on 11/03/2018.
 */
public class Board {

    private String code;
    private TypeMultiDescription description;
    private String multiLingualCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TypeMultiDescription getDescription() {
        return description;
    }

    public void setDescription(TypeMultiDescription description) {
        this.description = description;
    }

    public String getMultiLingualCode() {
        return multiLingualCode;
    }

    public void setMultiLingualCode(String multiLingualCode) {
        this.multiLingualCode = multiLingualCode;
    }
}
