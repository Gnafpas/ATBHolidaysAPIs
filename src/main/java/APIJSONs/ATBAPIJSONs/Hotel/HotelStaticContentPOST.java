package APIJSONs.ATBAPIJSONs.Hotel;

import java.util.List;

/**
 * Created by George on 09/01/2018.
 */
public class HotelStaticContentPOST {

    private List<Integer>  hotelIDs;
    private int  destinationId=0;
    private Integer  listStartPosition =0;
    private Integer  listLastPosition =100;

    public List<Integer> getHotelIDs() {
        return hotelIDs;
    }

    public void setHotelIDs(List<Integer> hotelIDs) {
        this.hotelIDs = hotelIDs;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public Integer getListStartPosition() {
        return listStartPosition;
    }

    public void setListStartPosition(Integer listStartPosition) {
        this.listStartPosition = listStartPosition;
    }

    public Integer getListLastPosition() {
        return listLastPosition;
    }

    public void setListLastPosition(Integer listLastPosition) {
        this.listLastPosition = listLastPosition;
    }
}
