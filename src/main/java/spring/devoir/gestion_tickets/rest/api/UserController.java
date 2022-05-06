package spring.devoir.gestion_tickets.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.devoir.gestion_tickets.entities.User;
import spring.devoir.gestion_tickets.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void save(@RequestBody User user) throws Exception {
        userService.save(user);
    }
}
