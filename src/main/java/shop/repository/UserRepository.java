package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import shop.entity.User;

@Service
public interface UserRepository extends CrudRepository<User,Long>{

    public User findByName(String name);
}
