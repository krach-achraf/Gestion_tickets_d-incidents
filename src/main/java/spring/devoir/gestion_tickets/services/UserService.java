package spring.devoir.gestion_tickets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.devoir.gestion_tickets.entities.User;
import spring.devoir.gestion_tickets.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user) throws Exception {
        if(findByEmail(user.getEmail()) != null)
            throw new Exception("Email deja existe");
        else if(findByUsername(user.getUsername()) != null)
            throw new Exception("Username deja existe");
        else
            userRepository.save(user);
    }
}
