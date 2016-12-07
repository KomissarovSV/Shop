package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import shop.entity.Role;

@Service
public interface RoleRepository extends CrudRepository<Role,Long>{
}
