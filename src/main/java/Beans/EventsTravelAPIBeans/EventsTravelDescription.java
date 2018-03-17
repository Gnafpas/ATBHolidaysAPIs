package Beans.EventsTravelAPIBeans;


public class EventsTravelDescription {

    private String seating_description;

    private String location;

    private String match_id;

    private String event_guest;

    private String hospitality_description;

    private String city;

    private String country;

    private String delivery_description;

    private String category;

    private String event;

    private String name;

    private String[] sub_category_full;

    private String seating;

    private String seating_id;

    private String sub_category;

    public String getSeating_description ()
    {
        return seating_description;
    }

    public void setSeating_description (String seating_description)
    {
        this.seating_description = seating_description;
    }

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

    public String getMatch_id ()
    {
        return match_id;
    }

    public void setMatch_id (String match_id)
    {
        this.match_id = match_id;
    }

    public String getEvent_guest ()
    {
        return event_guest;
    }

    public void setEvent_guest (String event_guest)
    {
        this.event_guest = event_guest;
    }

    public String getHospitality_description ()
    {
        return hospitality_description;
    }

    public void setHospitality_description (String hospitality_description)
    {
        this.hospitality_description = hospitality_description;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public String getDelivery_description ()
    {
        return delivery_description;
    }

    public void setDelivery_description (String delivery_description)
    {
        this.delivery_description = delivery_description;
    }

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public String getEvent ()
    {
        return event;
    }

    public void setEvent (String event)
    {
        this.event = event;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String[] getSub_category_full ()
    {
        return sub_category_full;
    }

    public void setSub_category_full (String[] sub_category_full)
    {
        this.sub_category_full = sub_category_full;
    }

    public String getSeating ()
    {
        return seating;
    }

    public void setSeating (String seating)
    {
        this.seating = seating;
    }

    public String getSeating_id ()
    {
        return seating_id;
    }

    public void setSeating_id (String seating_id)
    {
        this.seating_id = seating_id;
    }

    public String getSub_category ()
    {
        return sub_category;
    }

    public void setSub_category (String sub_category)
    {
        this.sub_category = sub_category;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [seating_description = "+seating_description+", location = "+location+", match_id = "+match_id+", event_guest = "+event_guest+", hospitality_description = "+hospitality_description+", city = "+city+", country = "+country+", delivery_description = "+delivery_description+", category = "+category+", event = "+event+", name = "+name+", sub_category_full = "+sub_category_full+", seating = "+seating+", seating_id = "+seating_id+", sub_category = "+sub_category+"]";
    }
}
