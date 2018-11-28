package Beans.ATBDBBeans.KalitaonHotel;

import javax.persistence.*;

/**
 * Created by George on 06/05/2018.
 */
@Entity
@Table(name = "room_price", schema = "Sunhotels", catalog = "")
public class RoomPriceBean {
    private int id;
    private String date;
    private String marketType;
    private String roomPrice;
    private String children1Price;
    private String children2Price;
    private String children3Price;
    private String infantPrice;
    private String currency;
    private String minStay;
    private String releaseDay;
    private String hotelId;
    private String roomId;
    private String availableId;
    private String providerId;
    private int stock;
    private String extraBedPrice;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "market_type")
    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    @Basic
    @Column(name = "room_price")
    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    @Basic
    @Column(name = "children_1_price")
    public String getChildren1Price() {
        return children1Price;
    }

    public void setChildren1Price(String children1Price) {
        this.children1Price = children1Price;
    }

    @Basic
    @Column(name = "children_2_price")
    public String getChildren2Price() {
        return children2Price;
    }

    public void setChildren2Price(String children2Price) {
        this.children2Price = children2Price;
    }

    @Basic
    @Column(name = "children_3_price")
    public String getChildren3Price() {
        return children3Price;
    }

    public void setChildren3Price(String children3Price) {
        this.children3Price = children3Price;
    }

    @Basic
    @Column(name = "infant_price")
    public String getInfantPrice() {
        return infantPrice;
    }

    public void setInfantPrice(String infantPrice) {
        this.infantPrice = infantPrice;
    }

    @Basic
    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "min_stay")
    public String getMinStay() {
        return minStay;
    }

    public void setMinStay(String minStay) {
        this.minStay = minStay;
    }

    @Basic
    @Column(name = "release_day")
    public String getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(String releaseDay) {
        this.releaseDay = releaseDay;
    }

    @Basic
    @Column(name = "hotel_id")
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "room_id")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "available_id")
    public String getAvailableId() {
        return availableId;
    }

    public void setAvailableId(String availableId) {
        this.availableId = availableId;
    }

    @Basic
    @Column(name = "provider_id")
    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }



    @Basic
    @Column(name = "stock")
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "extra_bed_price")
    public String getExtraBedPrice() {
        return extraBedPrice;
    }

    public void setExtraBedPrice(String extraBedPrice) {
        this.extraBedPrice = extraBedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomPriceBean that = (RoomPriceBean) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (marketType != null ? !marketType.equals(that.marketType) : that.marketType != null) return false;
        if (roomPrice != null ? !roomPrice.equals(that.roomPrice) : that.roomPrice != null) return false;
        if (children1Price != null ? !children1Price.equals(that.children1Price) : that.children1Price != null)
            return false;
        if (children2Price != null ? !children2Price.equals(that.children2Price) : that.children2Price != null)
            return false;
        if (children3Price != null ? !children3Price.equals(that.children3Price) : that.children3Price != null)
            return false;
        if (infantPrice != null ? !infantPrice.equals(that.infantPrice) : that.infantPrice != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (minStay != null ? !minStay.equals(that.minStay) : that.minStay != null) return false;
        if (releaseDay != null ? !releaseDay.equals(that.releaseDay) : that.releaseDay != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (availableId != null ? !availableId.equals(that.availableId) : that.availableId != null) return false;
        if (providerId != null ? !providerId.equals(that.providerId) : that.providerId != null) return false;
        if (stock != that.stock) return false;
        if (extraBedPrice != null ? !extraBedPrice.equals(that.extraBedPrice) : that.extraBedPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (marketType != null ? marketType.hashCode() : 0);
        result = 31 * result + (roomPrice != null ? roomPrice.hashCode() : 0);
        result = 31 * result + (children1Price != null ? children1Price.hashCode() : 0);
        result = 31 * result + (children2Price != null ? children2Price.hashCode() : 0);
        result = 31 * result + (children3Price != null ? children3Price.hashCode() : 0);
        result = 31 * result + (infantPrice != null ? infantPrice.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (minStay != null ? minStay.hashCode() : 0);
        result = 31 * result + (releaseDay != null ? releaseDay.hashCode() : 0);
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (availableId != null ? availableId.hashCode() : 0);
        result = 31 * result + (providerId != null ? providerId.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + (extraBedPrice != null ? extraBedPrice.hashCode() : 0);
        return result;
    }
}
