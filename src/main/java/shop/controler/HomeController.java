package shop.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.common.Statistic;
import shop.entity.*;
import shop.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Controller
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    PositionRepository positionRepository;

    @RequestMapping("/")
    public String getHome() {
        return "home";
    }

    @RequestMapping("/product")
    public String getProduct(@RequestParam("id") long id, Model model) {
        Product one = productRepository.findOne(id);
        model.addAttribute("product", one);
        return "product";
    }

    @RequestMapping("/basket")
    public String basket() {
        return "basket";
    }

    @RequestMapping("/history")
    public String history(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userRepository.findByName(name);
        List<Order> orders = orderRepository.findByUser(user);
        model.addAttribute("orders", orders);
        return "history";
    }

    @RequestMapping("/order")
    public String order(@RequestParam("id") long id, Model model) {
        Order order = orderRepository.findOne(id);
        model.addAttribute(order);
        System.out.println(order.getOrderPositions().size());
        return "order";
    }

    @RequestMapping("/manage")
    public String manage(Model model) {
        Iterable<Order> all = orderRepository.findAll();
        Iterable<Status> statuses = statusRepository.findAll();
        model.addAttribute("orders", all);
        model.addAttribute("statuses", statuses);
        return "manage";
    }

    @RequestMapping("/statistics")
    public String statistics(Model model) {
        List<Position> positions = positionRepository.findAll();
        List<Statistic> statistics = new ArrayList<>();
        double cost = 0;
        int cout = 0;
        Map<Product, List<Statistic>> collect = positions.stream()
                .filter(p ->p.getOrder().getStatus().equals("Done"))
                .map(position -> {
                    Statistic statistic = new Statistic();
                    statistic.setProduct(position.getProduct());
                    statistic.setCost(position.getCost());
                    statistic.setCount(position.getCount());
                    return statistic;
                }).collect(groupingBy(Statistic::getProduct));
        for (Product product : collect.keySet()) {
            List<Statistic> statistics2 = collect.get(product);
            for (Statistic statistic : statistics2) {
                cost += statistic.getCost();
                cout += statistic.getCount();
            }
            Statistic statistic = new Statistic();
            statistic.setCount(cout);
            statistic.setProduct(product);
            statistic.setCost(cost);
            statistics.add(statistic);
        }
        model.addAttribute("statistics",statistics);
        return "statistics";
    }

    @RequestMapping("/change")
    public String change(@RequestParam("id") long id,
                         @RequestParam("status") long statusId, Model model) {
        Order order = orderRepository.findOne(id);
        Status status = statusRepository.findOne(statusId);
        order.setStatus(status);
        orderRepository.save(order);
        Iterable<Order> all = orderRepository.findAll();
        Iterable<Status> statuses = statusRepository.findAll();
        model.addAttribute("orders", all);
        model.addAttribute("statuses", statuses);
        return "manage";
    }

}
