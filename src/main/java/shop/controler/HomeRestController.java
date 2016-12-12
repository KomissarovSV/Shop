package shop.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import shop.entity.*;
import shop.repository.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@SessionAttributes("products")
public class HomeRestController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    UserRepository userRepository;

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

    @RequestMapping("/basket/products")
    public List<Product> basket(@ModelAttribute("products") List<Product> products){
        return products;
    }

    @RequestMapping("/addBasket")
    public void addInBasket(@RequestParam("id") long id,
                            @ModelAttribute("products") List<Product> products){
        Product one = productRepository.findOne(id);
        products.add(one);
    }

    @ModelAttribute("products")
    public List<Product> populatePerson() {
        return new ArrayList<>();
    }

    @RequestMapping("/book")
    public void book(@RequestBody List<Position> positions){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Order order = new Order();
        positions.forEach(position -> position.setOrder(order));
        order.setOrderPositions(positions);
        if (auth.isAuthenticated()) {
            String name = auth.getName();
            User user = userRepository.findByName(name);
            order.setUser(user);
        }
        orderRepository.save(order);
    }
}
