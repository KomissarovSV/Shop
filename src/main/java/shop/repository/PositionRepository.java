package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import shop.entity.Position;

@Service
public interface PositionRepository extends CrudRepository<Position,Long> {
}
