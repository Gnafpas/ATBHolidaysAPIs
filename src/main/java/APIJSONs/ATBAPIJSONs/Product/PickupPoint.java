package APIJSONs.ATBAPIJSONs.Product;

/**
 * Created by George on 02/04/2018.
 */
public class PickupPoint {

    private int id;
    private String productId;
    private String hotelId;
    private String hotelPickupPoint;
    private String dropOfEndPoint;
    private String startingPoint;
    private String latitude;
    private String longitude;
    private String pickupNote;
    private String updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelPickupPoint() {
        return hotelPickupPoint;
    }

    public void setHotelPickupPoint(String hotelPickupPoint) {
        this.hotelPickupPoint = hotelPickupPoint;
    }

    public String getDropOfEndPoint() {
        return dropOfEndPoint;
    }

    public void setDropOfEndPoint(String dropOfEndPoint) {
        this.dropOfEndPoint = dropOfEndPoint;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPickupNote() {
        return pickupNote;
    }

    public void setPickupNote(String pickupNote) {
        this.pickupNote = pickupNote;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
