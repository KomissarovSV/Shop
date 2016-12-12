package shop.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.entity.Company;
import shop.entity.Product;
import shop.entity.Type;
import shop.repository.CompanyRepository;
import shop.repository.ProductRepository;
import shop.repository.TypeRepository;

@RestController
public class HomeRestController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    TypeRepository typeRepository;

    @RequestMapping("/products")
    public Iterable<Product> getProducts(){
        Iterable<Product> products = productRepository.findAll();
        return products;
    }

    @RequestMapping("/companies")
    public Iterable<Company> getCompany(){
        Iterable<Company> all = companyRepository.findAll();
        return all;
    }

    @RequestMapping("/types")
    public Iterable<Type> getTypes(){
        Iterable<Type> all = typeRepository.findAll();
        return all;
    }

    @RequestMapping("/product/{id}")
    public Product product(@PathVariable long id){
        Product one = productRepository.findOne(id);
        return one;
    }
}
