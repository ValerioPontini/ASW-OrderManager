package asw.ordermanager.orderservice.api.event;

import asw.ordermanager.common.api.event.DomainEvent;
import asw.ordermanager.orderservice.domain.OrderItem;
import java.util.List;

public class OrderCreatedEvent implements DomainEvent{

	private Long id;
	private String customer; 
	private String address;
	private List<OrderItem> orderItems;
	private double total; 

	public OrderCreatedEvent(Long id, String customer, String address, List<OrderItem> orderItems, double total) {
		this.id = id;
		this.customer = customer; 
		this.address = address; 
		this.orderItems = orderItems; 
		this.total = total; 
	} 

	public OrderCreatedEvent() {
   
	}

	public Long getId(){
		return this.id;
	}

	public String getCustomer(){
		return this.customer;
	}

	public String getAddres(){
		return this.address;
	}

	public List<OrderItem> getOrderItems(){
		return this.orderItems;
	}

	public double getTotal(){
		return this.total;
	}
}