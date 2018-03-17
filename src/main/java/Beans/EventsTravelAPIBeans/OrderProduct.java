package Beans.EventsTravelAPIBeans;

public class OrderProduct {
	private String sku;
	private double amount;
	private String company;
	private String firstname;
	private String lastname;
	private String phonenumber;
	private String booking_reference;
	private String email;
	private String checkin_date;
	private String street;
	private String housenumber;
	private String zipcode;
	private String city;
	private String country;
	private String passport_name;
	private String date_of_birth;
	private String nationality;
	
	
	public OrderProduct(){
		super();
	}
	public OrderProduct(String sku, double amount, String company, String firstname, String lastname,
			String phonenumber, String booking_reference, String email, String checkin_date, String street,
			String housenumber, String zipcode, String city, String country, String passport_name,
			String date_of_birth, String nationality) {
		super();
		this.sku = sku;
		this.amount = amount;
		this.company = company;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenumber = phonenumber;
		this.booking_reference = booking_reference;
		this.email = email;
		this.checkin_date = checkin_date;
		this.street = street;
		this.housenumber = housenumber;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
		this.passport_name = passport_name;
		this.date_of_birth = date_of_birth;
		this.nationality = nationality;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getBooking_reference() {
		return booking_reference;
	}
	public void setBooking_reference(String booking_reference) {
		this.booking_reference = booking_reference;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCheckin_date() {
		return checkin_date;
	}
	public void setCheckin_date(String checkin_date) {
		this.checkin_date = checkin_date;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassport_name() {
		return passport_name;
	}
	public void setPassport_name(String passport_name) {
		this.passport_name = passport_name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "EventsTravelCreateOrderRequest [sku=" + sku + ", amount=" + amount + ", company=" + company
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", phonenumber=" + phonenumber
				+ ", booking_reference=" + booking_reference + ", email=" + email + ", checkin_date=" + checkin_date
				+ ", street=" + street + ", housenumber=" + housenumber + ", zipcode=" + zipcode + ", city=" + city
				+ ", country=" + country + ", passport_name=" + passport_name + ", date_of_birth=" + date_of_birth
				+ ", nationality=" + nationality + "]";
	}
}
