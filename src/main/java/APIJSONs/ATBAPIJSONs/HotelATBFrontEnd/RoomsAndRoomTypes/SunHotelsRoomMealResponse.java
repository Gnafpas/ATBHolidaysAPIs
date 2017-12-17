
package APIJSONs.ATBAPIJSONs.HotelATBFrontEnd.RoomsAndRoomTypes;


import java.math.BigDecimal;

public class SunHotelsRoomMealResponse {

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
}
