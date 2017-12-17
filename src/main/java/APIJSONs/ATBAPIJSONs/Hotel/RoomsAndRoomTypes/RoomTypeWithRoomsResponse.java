package APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes;


import java.util.List;

/**
 * Created by George on 11/12/2017.
 */
public class RoomTypeWithRoomsResponse {

    private String name;
    private int roomtypeID;
    private List<RoomResponse> rooms;
    private boolean sharedRoom;


    public boolean isSharedRoom() {
        return sharedRoom;
    }

    public void setSharedRoom(boolean sharedRoom) {
        this.sharedRoom = sharedRoom;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
