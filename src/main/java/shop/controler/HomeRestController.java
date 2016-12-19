package shop.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import shop.common.BookBody;
import shop.entity.*;
import shop.repository.*;

import java.time.LocalDateTime;
import java.util.*;

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

    @Autowired
    RoleRepository roleRepository;

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
    public void book(@RequestBody BookBody bookBody, @ModelAttribute("products") List<Product> products){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Order order = new Order();
        LocalDateTime date = LocalDateTime.now();
        double cost = 0;
        for (Position position : bookBody.getPositions()) {
            products.remove(position.getProduct());
            position.setOrder(order);
            cost += position.getCost();
        }
        order.setDate(date);
        order.setCost(cost);
        Status status = statusRepository.findByName("Waiting for approval");
        order.setStatus(status);
        order.setOrderPositions(bookBody.getPositions());
        if (!auth.getName().equals("anonymousUser")) {
            String name = auth.getName();
            User user = userRepository.findByName(name);
            order.setUser(user);
        }else{

            User anonim = new User();
            anonim.setName("Anonymous");
            anonim.setPhone(bookBody.getPhone());
            anonim.setEmail("an@an.an");
            anonim.setPassword("3466547");
            anonim.setMatchingPassword("3466547");
            Role role = roleRepository.findByName("ROLE_USER");
            anonim.setRoles(new HashSet<>(Arrays.asList(role)));
            userRepository.save(anonim);
            order.setUser(anonim);
        }
        orderRepository.save(order);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam("index") int index,
                       @ModelAttribute("products") List<Product> products){
        products.remove(index);
    }
}
