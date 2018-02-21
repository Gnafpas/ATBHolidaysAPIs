
package APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes;


import DAOs.SunHotelsAPIDAOs.ArrayOfPriceWithPaymentMethods;
import DAOs.SunHotelsAPIDAOs.Discount;
import DAOs.SunHotelsAPIDAOs.MonetaryValueWithPaymentMethods;

import java.math.BigDecimal;
import java.util.List;

public class RoomMealResponse {

    private Discount discount;
    private int mealId;
    private BigDecimal price;
    private String mealName;


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

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
