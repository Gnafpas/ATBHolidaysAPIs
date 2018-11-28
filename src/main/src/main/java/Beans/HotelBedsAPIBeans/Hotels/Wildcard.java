package Beans.HotelBedsAPIBeans.Hotels;

/**
 * Created by George on 12/01/2018.
 */
public class Wildcard {

    private String roomCode;
    private String roomType;
    private String characteristicCode;
    private HotelRoomDescription hotelRoomDescription;

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

    public HotelRoomDescription getHotelRoomDescription() {
        return hotelRoomDescription;
    }

    public void setHotelRoomDescription(HotelRoomDescription hotelRoomDescription) {
        this.hotelRoomDescription = hotelRoomDescription;
    }
}
