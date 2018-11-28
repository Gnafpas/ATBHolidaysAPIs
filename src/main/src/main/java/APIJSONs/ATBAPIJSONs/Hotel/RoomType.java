package APIJSONs.ATBAPIJSONs.Hotel;

/**
 * Created by George on 04/01/2018.
 */
public class RoomType {

    private String roomType;
    private boolean sharedRoom;
    private int roomtypeId;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isSharedRoom() {
        return sharedRoom;
    }

    public void setSharedRoom(boolean sharedRoom) {
        this.sharedRoom = sharedRoom;
    }

    public int getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(int roomtypeId) {
        this.roomtypeId = roomtypeId;
    }
}
