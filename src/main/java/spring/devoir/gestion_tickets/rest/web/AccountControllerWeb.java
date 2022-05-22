package spring.devoir.gestion_tickets.rest.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AccountControllerWeb {

    @GetMapping("login")
    public String login(){
        return "auth/login";
    }
}