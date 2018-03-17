package Beans.HotelBedsAPIBeans.Types;

/**
 * Created by George on 10/03/2018.
 */
public class Accommodation {
    private String code;
    private TypeMultiDescription typeMultiDescription;
    private String typeDescription;


    public TypeMultiDescription getTypeMultiDescription() {
        return typeMultiDescription;
    }

    public void setTypeMultiDescription(TypeMultiDescription typeMultiDescription) {
        this.typeMultiDescription = typeMultiDescription;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }
}
