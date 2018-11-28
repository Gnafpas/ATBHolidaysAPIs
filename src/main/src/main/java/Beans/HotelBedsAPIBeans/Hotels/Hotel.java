package Beans.HotelBedsAPIBeans.Hotels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by George on 12/01/2018.
 */
public class Hotel {

    private int code;
    private Name name;
    private String accommodationTypeCode;
    private String countryCode;
    private String destinationCode;
    private String zoneCode;
    private Coordinates coordinates;
    private String categoryCode;
    private String categoryGroupCode;
    private String chainCode;
    private Description description;
    private Address address;
    private String postalCode;
    private City city;
    private String email;
    private String web;
    private String giataCode;
    private String license;
    private List<Phone> phones;
    private List<Issue> issues;
    private List<Terminal> terminals;
    private List<Facility> facilities;
    private List<String> boardCodes;
    private List<String> segmentCodes;
    private List<InterestPoint> interestPoints;
    private List<Room> rooms;
    private List<Wildcard> wildcards;
    private List<Image> images;
    @JsonProperty("S2C")
    private String S2C;

    public String getCategoryGroupCode() {
        return categoryGroupCode;
    }

    public void setCategoryGroupCode(String categoryGroupCode) {
        this.categoryGroupCode = categoryGroupCode;
    }

    public String getS2C() {
        return S2C;
    }

    public void setS2C(String S2C) {
        this.S2C = S2C;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getAccommodationTypeCode() {
        return accommodationTypeCode;
    }

    public void setAccommodationTypeCode(String accommodationTypeCode) {
        this.accommodationTypeCode = accommodationTypeCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getChainCode() {
        return chainCode;
    }

    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getGiataCode() {
        return giataCode;
    }

    public void setGiataCode(String giataCode) {
        this.giataCode = giataCode;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public List<String> getBoardCodes() {
        return boardCodes;
    }

    public void setBoardCodes(List<String> boardCodes) {
        this.boardCodes = boardCodes;
    }

    public List<String> getSegmentCodes() {
        return segmentCodes;
    }

    public void setSegmentCodes(List<String> segmentCodes) {
        this.segmentCodes = segmentCodes;
    }

    public List<InterestPoint> getInterestPoints() {
        return interestPoints;
    }

    public void setInterestPoints(List<InterestPoint> interestPoints) {
        this.interestPoints = interestPoints;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Wildcard> getWildcards() {
        return wildcards;
    }

    public void setWildcards(List<Wildcard> wildcards) {
        this.wildcards = wildcards;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
