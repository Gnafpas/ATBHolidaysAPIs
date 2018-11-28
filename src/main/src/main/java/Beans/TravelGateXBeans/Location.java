package Beans.TravelGateXBeans;

/**
 * Created by George on 10/07/2018.
 */
public class Location {

    private String address;
    private String city;
    private String country;
    private Coordinates coordinates;
    private DestinationsData closestDestination;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public DestinationsData getClosestDestination() {
        return closestDestination;
    }

    public void setClosestDestination(DestinationsData closestDestination) {
        this.closestDestination = closestDestination;
    }
}
