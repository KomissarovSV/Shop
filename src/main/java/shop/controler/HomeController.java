package shop.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.entity.Product;
import shop.repository.ProductRepository;

@Controller
@SessionAttributes("products")
public class HomeController {

    @Autowired
    ProductRepository productRepository;

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
    public String basket(@ModelAttribute("products") Iterable<Product> products){
        return "basket";
    }

}
