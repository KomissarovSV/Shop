package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position,Long> {
}
