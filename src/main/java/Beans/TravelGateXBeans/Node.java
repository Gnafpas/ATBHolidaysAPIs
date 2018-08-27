package Beans.TravelGateXBeans;

import java.util.List;

/**
 * Created by George on 09/07/2018.
 */
public class Node {

    private String code;
    private DestinationsData destinationData;
    private RoomData roomData;
    private HotelData hotelData;
    private BoardData boardData;
    private List<Error> error;
    private String createdAt;
    private String updatedAt;

    public HotelData getHotelData() {
        return hotelData;
    }

    public void setHotelData(HotelData hotelData) {
        this.hotelData = hotelData;
    }

    public BoardData getBoardData() {
        return boardData;
    }

    public void setBoardData(BoardData boardData) {
        this.boardData = boardData;
    }

    public RoomData getRoomData() {
        return roomData;
    }

    public void setRoomData(RoomData roomData) {
        this.roomData = roomData;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DestinationsData getDestinationData() {
        return destinationData;
    }

    public void setDestinationData(DestinationsData destinationData) {
        this.destinationData = destinationData;
    }

    public List<Error> getError() {
        return error;
    }

    public void setError(List<Error> error) {
        this.error = error;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
