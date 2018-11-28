package Beans.EventsTravelAPIBeans;

public class EventsTravelProduct {

    private EventsTravelLanguages languages;
    private String time;
    private String shipping_costs;
    private String shipping_method;
    private String stock;
    private String price;
    private String image;
    private String event_id;
    private String date;
    private String sku;
    private String lat;
    private String lng;
    private String formatted_address;
    
    public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public EventsTravelProduct() {
		super();
	}
    
    public EventsTravelLanguages getLanguages ()
    {
        return languages;
    }

	public void setLanguages (EventsTravelLanguages languages)
    {
        this.languages = languages;
    }

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public String getShipping_costs ()
    {
        return shipping_costs;
    }

    public void setShipping_costs (String shipping_costs)
    {
        this.shipping_costs = shipping_costs;
    }

    public String getShipping_method ()
    {
        return shipping_method;
    }

    public void setShipping_method (String shipping_method)
    {
        this.shipping_method = shipping_method;
    }

    public String getStock ()
    {
        return stock;
    }

    public void setStock (String stock)
    {
        this.stock = stock;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getEvent_id ()
    {
        return event_id;
    }

    public void setEvent_id (String event_id)
    {
        this.event_id = event_id;
    }

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getSku ()
    {
        return sku;
    }

    public void setSku (String sku)
    {
        this.sku = sku;
    }

    @Override
    public String toString()
    {
        return "ClassPojo  time = "+time+", shipping_costs = "+shipping_costs+", shipping_method = "+shipping_method+", stock = "+stock+", price = "+price+", image = "+image+", event_id = "+event_id+", date = "+date+", sku = "+sku+"]";
    }
}
