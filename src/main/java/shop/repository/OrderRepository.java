package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import shop.entity.Order;

@Service
public interface OrderRepository extends CrudRepository<Order,Long> {
}
