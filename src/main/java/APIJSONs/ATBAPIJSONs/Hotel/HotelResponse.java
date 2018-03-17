package APIJSONs.ATBAPIJSONs.Hotel;


import APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes.RoomTypeWithRoomsResponse;

import java.util.Comparator;
import java.util.List;

/**
 * Created by George on 07/12/2017.
 */
public class HotelResponse implements Comparable<HotelResponse>{

    private int hotelId;
    private String starRating;
    private String countryCode;
    private String zipCode;
    private Integer currencyId;
    private Integer destinationId;
    private List<Photo> photos;
    private List<HotelFacility> facilities;
    private List<RoomTypeWithRoomsResponse> roomtypes;
    private String city;
    private String description;
    private String country;
    private String longitude;
    private String state;
    private String district;
    private String address;
    private String latitude;
    private String name;
    private String accommodationId;
    private String accommodationName;
    private int resortId;

    public String getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(String accommodationId) {
        this.accommodationId = accommodationId;
    }

    public String getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(String accommodationName) {
        this.accommodationName = accommodationName;
    }

        public int getResortId() {
        return resortId;
    }

    public void setResortId(int resortId) {
        this.resortId = resortId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<HotelFacility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<HotelFacility> facilities) {
        this.facilities = facilities;
    }

    public List<RoomTypeWithRoomsResponse> getRoomtypes() {
        return roomtypes;
    }

    public void setRoomtypes(List<RoomTypeWithRoomsResponse> roomtypes) {
        this.roomtypes = roomtypes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(HotelResponse o) {
        return Comparators.ratting.compare(this, o);
    }


    public static class Comparators {

        public static Comparator<HotelResponse> ratting = new Comparator<HotelResponse>() {
            @Override
            public int compare(HotelResponse o1, HotelResponse o2) {
                return o1.getStarRating().compareTo(o2.getStarRating());
            }
        };

    }
}
