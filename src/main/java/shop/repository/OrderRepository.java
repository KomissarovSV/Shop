package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import shop.entity.OrderObj;

@Service
public interface OrderRepository extends CrudRepository<OrderObj,Long> {
}
