package spring.devoir.gestion_tickets.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import spring.devoir.gestion_tickets.entities.User;

import java.util.List;

public interface UserService  extends UserDetailsService {
    User findByUsername(String username);
    User findByEmail(String email);
    void save(User user) throws Exception;
    void deleteById(Long id);
    List<User> findAll();
}
