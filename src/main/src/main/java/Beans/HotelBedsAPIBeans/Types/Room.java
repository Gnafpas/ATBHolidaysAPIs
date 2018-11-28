package Beans.HotelBedsAPIBeans.Types;

/**
 * Created by George on 11/03/2018.
 */
public class Room {

    private String code;
    private String type;
    private String characteristic;
    private String minPax;
    private String maxPax;
    private String maxAdults;
    private String maxChildren;
    private String minAdults;
    private String description;
    private TypeMultiDescription typeDescription;
    private TypeMultiDescription characteristicDescription;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getMinPax() {
        return minPax;
    }

    public void setMinPax(String minPax) {
        this.minPax = minPax;
    }

    public String getMaxPax() {
        return maxPax;
    }

    public void setMaxPax(String maxPax) {
        this.maxPax = maxPax;
    }

    public String getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(String maxAdults) {
        this.maxAdults = maxAdults;
    }

    public String getMaxChildren() {
        return maxChildren;
    }

    public void setMaxChildren(String maxChildren) {
        this.maxChildren = maxChildren;
    }

    public String getMinAdults() {
        return minAdults;
    }

    public void setMinAdults(String minAdults) {
        this.minAdults = minAdults;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeMultiDescription getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(TypeMultiDescription typeDescription) {
        this.typeDescription = typeDescription;
    }

    public TypeMultiDescription getCharacteristicDescription() {
        return characteristicDescription;
    }

    public void setCharacteristicDescription(TypeMultiDescription characteristicDescription) {
        this.characteristicDescription = characteristicDescription;
    }
}
