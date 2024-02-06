package asw.ordermanager.productservice.api.event;

import asw.ordermanager.common.api.event.DomainEvent;

public class ProductCreatedEvent implements DomainEvent{

	private Long id;
	private String name; 
	private String category;
	private int stockLevel;
	private double price; 

	public ProductCreatedEvent(String name, String category, int stockLevel, double price) {
		this.name = name; 
		this.category = category; 
		this.stockLevel = stockLevel; 
		this.price = price; 
	} 

	public ProductCreatedEvent() {
    
	}

	public Long getId(){
		return this.id;
	}

	public String getName(){
		return this.name;
	}

	public String getCategory(){
		return this.category;
	}

	public int getStockLevel(){
		return this.stockLevel;
	}

	public double getPrice(){
		return this.price;
	}
}