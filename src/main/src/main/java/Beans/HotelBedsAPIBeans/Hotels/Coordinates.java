package Beans.HotelBedsAPIBeans.Hotels;

import java.math.BigDecimal;

/**
 * Created by George on 12/01/2018.
 */
public class Coordinates {

    private BigDecimal longitude;
    private BigDecimal latitude;

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
