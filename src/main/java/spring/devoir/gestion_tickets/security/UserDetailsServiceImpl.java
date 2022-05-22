package spring.devoir.gestion_tickets.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import spring.devoir.gestion_tickets.entities.User;
import spring.devoir.gestion_tickets.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("Username ou mot de passe est encorrecte");
        }
        return new MyUserDetails(user);
    }

}