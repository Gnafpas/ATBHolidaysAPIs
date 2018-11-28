package APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes;


import java.util.List;

/**
 * Created by George on 11/12/2017.
 */
public class RoomTypeWithRoomsResponse {

    private String roomType;
    private int roomtypeID;
    private List<RoomResponse> rooms;
    private boolean sharedRoom;


    public boolean isSharedRoom() {
        return sharedRoom;
    }

    public void setSharedRoom(boolean sharedRoom) {
        this.sharedRoom = sharedRoom;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomtypeID() {
        return roomtypeID;
    }

    public void setRoomtypeID(int roomtypeID) {
        this.roomtypeID = roomtypeID;
    }

    public List<RoomResponse> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomResponse> rooms) {
        this.rooms = rooms;
    }
}
