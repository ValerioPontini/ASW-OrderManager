package asw.ordermanager.ordervalidationservice.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface ProductRepository extends CrudRepository<Product, String> {

	public Product findByName(String name);

	public List<Product> findByNameIn(List<String> names);

}

