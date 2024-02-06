package asw.ordermanager.productservice.api.event;

import asw.ordermanager.common.api.event.DomainEvent;

public class ProductStockLevelUpdatedEvent implements DomainEvent{

	private String name; 
	private int stockLevelVariation;

	public ProductStockLevelUpdatedEvent(String name, int stockLevelVariation) {
		this.name = name; 
		this.stockLevelVariation = stockLevelVariation; 
	} 

	public ProductStockLevelUpdatedEvent() {
   
	}

	public String getName(){
		return this.name;
	}

	public int getStockLevelVariation(){
		return this.stockLevelVariation;
	}
}