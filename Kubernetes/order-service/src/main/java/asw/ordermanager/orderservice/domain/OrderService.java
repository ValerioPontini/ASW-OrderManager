package asw.ordermanager.orderservice.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import asw.ordermanager.common.api.event.DomainEvent; 
import asw.ordermanager.orderservice.api.event.*; 


import asw.ordermanager.orderservice.eventpublisher.OrderEventKafkaPublisher;

import java.util.*; 

@Service @Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderEventKafkaPublisher orderEventKafkaPublisher;


 	public Order createOrder(String customer, String address, List<OrderItem> orderItems, double total) {
		Order order = new Order(customer, address, orderItems, total); 
		order = orderRepository.save(order);
		DomainEvent event = new OrderCreatedEvent(order.getId(), order.getCustomer(), order.getAddress(), order.getOrderItems(), order.getTotal());
		orderEventKafkaPublisher.publish(event);
		return order;
	}

 	public Order getOrder(Long id) {
		Order order = orderRepository.findById(id).orElse(null);
		return order;
	}

	public Collection<Order> getOrders() {
		Collection<Order> orders = orderRepository.findAll();
		return orders;
	}

	public Collection<Order> getOrdersByCustomer(String customer) {
		Collection<Order> orders = orderRepository.findByCustomer(customer);
		return orders;
	}

	public Collection<Order> getOrdersByProduct(String product) {
		Collection<Order> orders = orderRepository.findByOrderItems_Product(product);
		return orders;
	}
	
}
