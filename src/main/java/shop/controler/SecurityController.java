package shop.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import shop.entity.Role;
import shop.entity.User;
import shop.repository.RoleRepository;
import shop.repository.UserRepository;

import javax.validation.Valid;

import java.util.Arrays;
import java.util.HashSet;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class SecurityController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value = "/user/logout", method = GET)
    public String showLogoutForm() {
        return "logout";
    }

    @RequestMapping(value = "/user/registration", method = GET)
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = "/user/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/user/registration", method = POST)
    public String registerUserAccount(@ModelAttribute("user") @Valid User account,
                                            BindingResult result, Model model) {
        if (!result.hasErrors()) {
            createUserAccount(account, result);
            return "successRegister";
        }else {
            model.addAttribute("user",account);
            return "registration";
        }
    }

    private void createUserAccount(User user, BindingResult result) {
        if (userRepository.findByName(user.getName()) == null) {
            user.setPassword(user.getPassword());
            user.setMatchingPassword(user.getPassword());
            Role role = roleRepository.findByName("ROLE_USER");
            user.setRoles(new HashSet<>(Arrays.asList(role)));
            userRepository.save(user);
        }
    }
}
