package asw.ordermanager.ordervalidationservice.domain;

import jakarta.persistence.*;

import lombok.*; 

/* Prodotto con inventario. */ 
@Entity 
@Data 
@NoArgsConstructor 
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product implements Comparable<Product> {

	@Id
	@EqualsAndHashCode.Include
	private String name; 
	/* quantità disponibile */ 
	private int stockLevel; 

	public Product(String name, int stockLevel) {
		this(); 
		this.name = name; 
		this.stockLevel = stockLevel; 
	}

	public void setStockLevel(int stockLevel){
		this.stockLevel = stockLevel;
	}


	@Override
	public int compareTo(Product other) {
		return this.name.compareTo(other.name); 
	}
	
}
