package asw.ordermanager.ordervalidationservice.domain;

import asw.ordermanager.orderservice.domain.OrderItem;
import jakarta.persistence.*; 

import java.util.*; 

import lombok.*; 

/* Ordine. */ 
@Entity 
@Table(name="ORDERS")
@Data 
@NoArgsConstructor 
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Comparable<Order> {

	@Id
	@EqualsAndHashCode.Include
	private Long id; 
	@ElementCollection(fetch = FetchType.EAGER)	
	private List<OrderItem> orderItems;
	private String customer;

	public Order(Long id, List<OrderItem> orderItems, String customer) {
		this();  
		this.id = id;
		this.orderItems = orderItems; 
		this.customer = customer;
	}


	@Override
	public int compareTo(Order other) {
		return this.id.compareTo(other.id); 
	}
	
}
