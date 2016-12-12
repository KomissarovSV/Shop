package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import shop.entity.Order;
import shop.entity.User;

import java.util.List;

@Service
public interface OrderRepository extends CrudRepository<Order,Long> {

    public Order findByUser(User user);
}
