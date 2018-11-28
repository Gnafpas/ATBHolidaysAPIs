package Beans.HotelBedsAPIBeans.Availability;

/**
 * Created by George on 16/03/2018.
 */
public class Stay {

    private String checkIn;
    private String checkOut;
    private String shiftDays;

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getShiftDays() {
        return shiftDays;
    }

    public void setShiftDays(String shiftDays) {
        this.shiftDays = shiftDays;
    }
}
