package Beans.HotelBedsAPIBeans.Hotels;

/**
 * Created by George on 12/01/2018.
 */
public class Image {

    private String imageTypeCode;
    private String path;
    private int order;
    private String roomCode;
    private String roomType;
    private String characteristicCode;

    public String getImageTypeCode() {
        return imageTypeCode;
    }

    public void setImageTypeCode(String imageTypeCode) {
        this.imageTypeCode = imageTypeCode;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCharacteristicCode() {
        return characteristicCode;
    }

    public void setCharacteristicCode(String characteristicCode) {
        this.characteristicCode = characteristicCode;
    }
}
