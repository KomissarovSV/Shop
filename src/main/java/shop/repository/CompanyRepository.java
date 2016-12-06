package shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shop.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company,Long>{
}
