package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes;


import java.util.List;

/**
 * Created by George on 11/12/2017.
 */
public class SunHotelsRoomTypeWithRoomsResponse {

    private String roomType;
    private int roomTypeId;
    private List<SunHotelsRoomResponse> rooms;


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public List<SunHotelsRoomResponse> getRooms() {
        return rooms;
    }

    public void setRooms(List<SunHotelsRoomResponse> rooms) {
        this.rooms = rooms;
    }
}
