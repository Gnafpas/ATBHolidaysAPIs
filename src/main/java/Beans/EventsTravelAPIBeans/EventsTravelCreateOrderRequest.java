package Beans.EventsTravelAPIBeans;

import java.util.Arrays;

public class EventsTravelCreateOrderRequest {
	
	private OrderProduct[] products;
	
	public OrderProduct[] getProducts() {
		return products;
	}
	public void setProducts(OrderProduct[] products) {
		this.products = products;
	}
	public EventsTravelCreateOrderRequest() {
		super();
	}
	public EventsTravelCreateOrderRequest(OrderProduct[] products) {
		super();
		this.products = products;
	}
	@Override
	public String toString() {
		return "EventsTravelCreateOrderRequest [products=" + Arrays.toString(products) + "]";
	}
}
