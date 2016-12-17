package shop.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import shop.entity.*;
import shop.repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Autowired
    StatusRepository statusRepository;

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
    public void book(@RequestBody Set<Position> positions, @ModelAttribute("products") List<Product> products){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Order order = new Order();
        LocalDateTime date = LocalDateTime.now();
        double cost = 0;
        for (Position position : positions) {
            products.remove(position.getProduct());
            position.setOrder(order);
            cost += position.getCost();
        }
        order.setDate(date);
        order.setCost(cost);
        Status status = statusRepository.findByName("Waiting for approval");
        order.setStatus(status);
        order.setOrderPositions(positions);
        if (auth.isAuthenticated()) {
            String name = auth.getName();
            User user = userRepository.findByName(name);
            order.setUser(user);
        }
        System.out.println(order.getOrderPositions().size());
        orderRepository.save(order);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("index") int index,
                       @ModelAttribute("products") List<Product> products){
        products.remove(index);
    }
}
