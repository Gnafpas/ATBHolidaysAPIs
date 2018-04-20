
package APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes;


import DAOs.SunHotelsAPIDAOs.ArrayOfPriceWithPaymentMethods;
import DAOs.SunHotelsAPIDAOs.Discount;
import DAOs.SunHotelsAPIDAOs.MonetaryValueWithPaymentMethods;

import java.math.BigDecimal;
import java.util.List;

public class RoomMealResponse {

    private int mealId;
    private BigDecimal price;
    private String currencyCode;
    private String mealName;


    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }


}
