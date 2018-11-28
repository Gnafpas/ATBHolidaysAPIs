package Beans.EventsTravelAPIBeans;

import java.util.Arrays;
import java.util.List;

public class EventsTravelCreateOrderRequest {
	
	private List<OrderProduct> products;


	public List<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(List<OrderProduct> products) {
		this.products = products;
	}
}
