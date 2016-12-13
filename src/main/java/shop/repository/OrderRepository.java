package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Order;
import shop.entity.User;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

    public List<Order> findByUser(User user);
}
