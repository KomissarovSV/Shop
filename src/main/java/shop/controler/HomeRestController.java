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
@SessionAttributes("positions")
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

    @Autowired
    AttributeRepository attributeRepository;

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

    @RequestMapping("/basket/positions")
    public List<Position> basket(@ModelAttribute("positions") List<Position> positions){
        return positions;
    }

    @RequestMapping("/addBasket")
    public void addInBasket(@RequestParam("id") long id,
                            @ModelAttribute("positions") List<Position> positions){
        for (Position position : positions) {
            if (position.getProduct().getId() == id){
                position.setCount(position.getCount() + 1);
                position.setCost(position.getCost() + position.getProduct().getCost());
                return;
            }
        }
        Product one = productRepository.findOne(id);
        Position position = new Position();
        position.setBuy(true);
        position.setCount(1);
        position.setCost(one.getCost());
        position.setProduct(one);
        positions.add(position);
    }

    @ModelAttribute("positions")
    public List<Position> populatePerson() {
        return new ArrayList<>();
    }

    @RequestMapping("/book")
    public void book(@RequestBody BookBody bookBody, @ModelAttribute("positions") List<Position> positions){
        if (bookBody.getPhone() == null){
            return;
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Order order = new Order();
        LocalDateTime date = LocalDateTime.now();
        double cost = 0;
        for (Position position : bookBody.getPositions()) {
            positions.remove(position);
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
                       @ModelAttribute("positions") List<Position> positions){
        positions.remove(index);
    }

    @RequestMapping("/atts")
    public Iterable<Attribute> atts(){
        Iterable<Attribute> all = attributeRepository.findAll();
        return all;
    }

    @RequestMapping("/save")
    public void save(@RequestBody Product product){
        productRepository.save(product);
    }
}
