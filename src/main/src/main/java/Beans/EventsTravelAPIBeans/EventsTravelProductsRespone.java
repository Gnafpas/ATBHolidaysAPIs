package Beans.EventsTravelAPIBeans;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;


public class EventsTravelProductsRespone {

    private Map<String, EventsTravelProduct> products = new HashMap<String, EventsTravelProduct>();

    public EventsTravelProductsRespone() {
        super();
    }

    @JsonAnyGetter
    public Map<String, EventsTravelProduct> getProducts() {
        return this.products;
    }

    @JsonAnySetter
    public void setProducts(String name, EventsTravelProduct value) {
        this.products.put(name, value);
    }
}
