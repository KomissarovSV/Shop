package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status,Long>{

    public Status findByName(String name);
}
