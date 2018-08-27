package Beans.TravelGateXBeans;

import Beans.TravelGateXBeans.Text;

import java.util.List;

/**
 * Created by George on 10/07/2018.
 */
public class RoomData {
    private String roomCode;
    private List<Text> texts;

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }
}
