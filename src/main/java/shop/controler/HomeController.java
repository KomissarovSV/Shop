package shop.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.entity.Order;
import shop.entity.Product;
import shop.entity.User;
import shop.repository.OrderRepository;
import shop.repository.ProductRepository;
import shop.repository.UserRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String getHome(){
        return "home";
    }

    @RequestMapping("/product")
    public String getProduct(@RequestParam("id") long id, Model model){
        Product one = productRepository.findOne(id);
        model.addAttribute("product",one);
        return "product";
    }

    @RequestMapping("/basket")
    public String basket(){
        return "basket";
    }

    @RequestMapping("/history")
    public String history(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByName(name);
        System.out.println(user);
        Order order = orderRepository.findByUser(user);
        System.out.println(order);
        model.addAttribute(order);
        return "history";
    }
}
