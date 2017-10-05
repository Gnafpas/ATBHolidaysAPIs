package Beans.ViatorAPIBeans.Bookings.Book;

/**
 * Created by George on 02/08/2017.
 */
public class Traveller {

    private int bandId;
    private String firstname;
    private String surname;
    private String title;
    private boolean leadTraveller=false;

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLeadTraveller() {
        return leadTraveller;
    }

    public void setLeadTraveller(boolean leadTraveller) {
        this.leadTraveller = leadTraveller;
    }
}
