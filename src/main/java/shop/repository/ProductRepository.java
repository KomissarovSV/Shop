package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
}
