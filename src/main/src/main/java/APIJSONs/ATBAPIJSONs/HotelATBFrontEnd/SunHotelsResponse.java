package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd;


import APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes.SunHotelsRoomTypeWithRoomsResponse;
import java.util.Comparator;
import java.util.List;

/**
 * Created by George on 07/12/2017.
 */
public class SunHotelsResponse implements Comparable<SunHotelsResponse> {


    private String city;
    private String star_rating;
    private String description;
    private String headline;
    private String country;
    private String longitude;
    private String state;
    private String district;
    private List<SunHotelsRoomTypeWithRoomsResponse> room_types;
    private String country_code;
    private String address;
    private String latitude;
    private String timezone;
    private String zip_code;
    private String type;
    private int id;
    private String name;
    private int providerId;

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(String star_rating) {
        this.star_rating = star_rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<SunHotelsRoomTypeWithRoomsResponse> getRoom_types() {
        return room_types;
    }

    public void setRoom_types(List<SunHotelsRoomTypeWithRoomsResponse> room_types) {
        this.room_types = room_types;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int compareTo(SunHotelsResponse o) {
        return Comparators.ratting.compare(this, o);
    }


    public static class Comparators {

        public static Comparator<SunHotelsResponse> ratting = new Comparator<SunHotelsResponse>() {
            @Override
            public int compare(SunHotelsResponse o1, SunHotelsResponse o2) {
                return o1.getStar_rating().compareTo(o2.getStar_rating());
            }
        };

    }
}
