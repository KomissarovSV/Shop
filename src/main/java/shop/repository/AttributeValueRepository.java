package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.AttributeValue;

@Repository
public interface AttributeValueRepository extends CrudRepository<AttributeValue,Long>{
}
