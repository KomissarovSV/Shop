package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Attribute;

@Repository
public interface AttributeRepository extends CrudRepository<Attribute,Long> {
}
