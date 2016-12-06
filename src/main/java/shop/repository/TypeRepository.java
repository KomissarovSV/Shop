package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Type;

@Repository
public interface TypeRepository extends CrudRepository<Type,Long> {
}
