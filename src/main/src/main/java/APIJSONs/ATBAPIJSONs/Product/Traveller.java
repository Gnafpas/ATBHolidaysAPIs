package APIJSONs.ATBAPIJSONs.Product;

/**
 * Created by George on 02/08/2017.
 */
public class Traveller {

    private int age;
    private String firstname;
    private String surname;
    private String title;
    private boolean leadTraveller=false;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
