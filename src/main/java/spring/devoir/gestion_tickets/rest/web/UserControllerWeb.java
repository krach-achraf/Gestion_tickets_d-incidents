package spring.devoir.gestion_tickets.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.devoir.gestion_tickets.entities.User;
import spring.devoir.gestion_tickets.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserControllerWeb {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void register(User user) throws Exception {
        userService.save(user);
    }

    @GetMapping("/login")
    public String login(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "users/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") @Valid User user, BindingResult result){
        int res = userService.login(user);
        if(res == -1){
            System.out.println(result.getObjectName());
            result.addError(new ObjectError("email", "Email incorrect"));
            return "users/login";
        }
        if(res == -2){
            System.out.println(result.getObjectName());
            result.addError(new ObjectError("password", "Password incorrect"));
            return "users/login";
        }
        return "redirect:/tickets";
    }


}
