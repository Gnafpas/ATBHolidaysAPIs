
package APIJSONs.ATBAPIJSONs.Hotel.RoomsAndRoomTypes;


import DAOs.SunHotelsAPIDAOs.ArrayOfPriceWithPaymentMethods;
import DAOs.SunHotelsAPIDAOs.Discount;
import DAOs.SunHotelsAPIDAOs.MonetaryValueWithPaymentMethods;

import java.util.List;

public class RoomMealResponse {

    private int mealId;
    private ArrayOfPriceWithPaymentMethods prices;
    private Discount discount;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public ArrayOfPriceWithPaymentMethods getPrices() {
        return prices;
    }

    public void setPrices(ArrayOfPriceWithPaymentMethods prices) {
        this.prices = prices;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
