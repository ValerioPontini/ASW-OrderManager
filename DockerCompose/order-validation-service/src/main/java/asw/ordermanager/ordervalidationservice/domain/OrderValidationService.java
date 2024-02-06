package asw.ordermanager.ordervalidationservice.domain;
import asw.ordermanager.orderservice.domain.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*; 
import java.util.stream.*; 
import java.util.function.Function; 

import java.util.logging.Logger;



@Service @Transactional
public class OrderValidationService {

	private final Logger logger = Logger.getLogger(this.getClass().toString());

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;


	public Product createProduct(String name, int stockLevel){
		Product product = new Product(name, stockLevel); 
		product = productRepository.save(product);
		return product;
	}

	public Order createOrder(Long id,  List<OrderItem> orderItems, String customer){
		Order order = new Order(id, orderItems, customer);
		order = orderRepository.save(order);
		return order;
	}

	public Product updateStockLevel(String name, int stockLevelVariation) {
		Product product = productRepository.findByName(name); 
		product.setStockLevel(product.getStockLevel() + stockLevelVariation);
		product = productRepository.save(product);
		return product;
	}

	/* Verifica la validità di un ordine. */ 
	public OrderValidation validateOrder(Long id){

		Order order = orderRepository.findById(id);
		String motivation = ""; 
		if (order==null) {
			motivation += "L'ordine " + id + " non esiste.";
			return new OrderValidation(id, order, false, motivation);
		}
		List<String> productNames = toProductNames(order.getOrderItems());
		List<Product> products = productRepository.findByNameIn(productNames); 
		Map<String,Product> productMap = toProductMap(products); 

		boolean isValid = true; 
		for (OrderItem orderItem: order.getOrderItems()) {
			String name = orderItem.getProduct(); 
			Product product = productMap.get(name);
			if (product==null) {
				isValid = false; 
				motivation += "Il prodotto " + name + " non esiste. ";
				// break; 
			} else if (product.getStockLevel() < orderItem.getQuantity()) {
				isValid = false; 
				motivation += "Il prodotto " + name + " non è disponibile nella quantità richiesta. ";
				// break; 
			}
		}
		if (motivation.length()==0) {
			motivation = "OK"; 
		}
		return new OrderValidation(id, order, isValid, motivation);
	}
	
		

	private List<String> toProductNames(List<OrderItem> items) {
		List<String> names = 
			items.stream()
				.map(item -> item.getProduct())
				.collect(Collectors.toList());
		return names; 
	}

	private Map<String,Product> toProductMap(List<Product> products) {
		Map<String,Product> map = 
			products.stream() 
				.collect(Collectors.toMap(Product::getName, Function.identity()));
		return map;
	}


}