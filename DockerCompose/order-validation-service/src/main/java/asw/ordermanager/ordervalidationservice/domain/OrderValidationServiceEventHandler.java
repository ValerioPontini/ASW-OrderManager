package asw.ordermanager.ordervalidationservice.domain;

import asw.ordermanager.common.api.event.DomainEvent; 
import asw.ordermanager.orderservice.api.event.*; 
import asw.ordermanager.productservice.api.event.*; 
import asw.ordermanager.orderservice.domain.OrderItem;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@Service
public class OrderValidationServiceEventHandler {

	private final Logger logger = Logger.getLogger(this.getClass().toString());

	@Autowired
	private OrderValidationService orderValidationService;

	public void onEvent(DomainEvent event){
			logger.info(event.getClass().toString());
			if (event instanceof OrderCreatedEvent ev) {
				this.createOrder(ev);
			} else if (event instanceof ProductCreatedEvent ev) {
				this.createProduct(ev);
			} else if (event instanceof ProductStockLevelUpdatedEvent ev){
				this.updateStockLevel(ev);
		}
	}

	public void createProduct(ProductCreatedEvent product) {
		orderValidationService.createProduct(product.getName(), product.getStockLevel());
		}

	public void createOrder(OrderCreatedEvent order) {
		orderValidationService.createOrder(order.getId(), order.getOrderItems(), order.getCustomer());
		}

	public void updateStockLevel(ProductStockLevelUpdatedEvent product) {
		orderValidationService.updateStockLevel(product.getName(), product.getStockLevelVariation());
		}

}
