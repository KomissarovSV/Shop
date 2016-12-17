package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Position;

import java.util.List;

@Repository
public interface PositionRepository extends CrudRepository<Position,Long> {

    public List<Position> findAll();
}
