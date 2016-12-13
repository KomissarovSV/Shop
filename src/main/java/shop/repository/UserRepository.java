package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

    public User findByName(String name);
}
