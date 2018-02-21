package Beans.HotelBedsAPIBeans.Hotels;

import java.util.List;

/**
 * Created by George on 12/01/2018.
 */
public class Room {

    private String roomCode;
    private String roomType;
    private String characteristicCode;
    private List<RoomFacility> roomFacilities;
    private List<RoomStay> roomStays;

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

    public List<RoomFacility> getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(List<RoomFacility> roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public List<RoomStay> getRoomStays() {
        return roomStays;
    }

    public void setRoomStays(List<RoomStay> roomStays) {
        this.roomStays = roomStays;
    }
}
