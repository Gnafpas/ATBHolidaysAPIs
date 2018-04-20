package APIJSONs.ATBAPIJSONs.Hotel;

import java.math.BigDecimal;

/**
 * Created by George on 07/12/2017.
 */
public class HotelFacility {

    private int id;
    private BigDecimal price;
    private String explanation;
    private int hotelId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
