package asw.ordermanager.ordervalidationservice.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface OrderRepository extends CrudRepository<Order, String> {

	public Order findById(Long id);
}

