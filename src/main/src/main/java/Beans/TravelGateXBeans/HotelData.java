package Beans.TravelGateXBeans;

import java.util.List;

/**
 * Created by George on 10/07/2018.
 */
public class HotelData {
    private String hotelCode;
    private String hotelCodeSupplier;
    private String hotelName;
    private String categoryCode;
    private String chainCode;
    private Property property;
    private boolean exclusiveDeal;
    private Location location;
    private Contact contact;
    private List<Integer> rank;
    private List<String> cardTypes;
    private List<Amenity> amenities;
    private List<Media> medias;
    private List<Description> descriptions;

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getHotelCodeSupplier() {
        return hotelCodeSupplier;
    }

    public void setHotelCodeSupplier(String hotelCodeSupplier) {
        this.hotelCodeSupplier = hotelCodeSupplier;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public boolean isExclusiveDeal() {
        return exclusiveDeal;
    }

    public void setExclusiveDeal(boolean exclusiveDeal) {
        this.exclusiveDeal = exclusiveDeal;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Integer> getRank() {
        return rank;
    }

    public void setRank(List<Integer> rank) {
        this.rank = rank;
    }

    public List<String> getCardTypes() {
        return cardTypes;
    }

    public void setCardTypes(List<String> cardTypes) {
        this.cardTypes = cardTypes;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }
}
