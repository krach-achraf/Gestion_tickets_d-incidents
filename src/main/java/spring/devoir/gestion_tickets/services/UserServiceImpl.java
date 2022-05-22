package spring.devoir.gestion_tickets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.devoir.gestion_tickets.entities.Role;
import spring.devoir.gestion_tickets.entities.User;
import spring.devoir.gestion_tickets.repositories.RoleRepository;
import spring.devoir.gestion_tickets.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user) throws Exception {
        if (findByEmail(user.getEmail()) != null)
            throw new Exception("Email deja existe");
        else if (findByUsername(user.getUsername()) != null)
            throw new Exception("Username deja existe");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

/*    public int login(User user) {
        User u = findByUsername(user.getUsername());
        if(u == null)
            return -1;
        if (!u.getPassword().equals(user.getPassword()))
            return -2;
        return 1;
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Nom d'utilisateur ou mot de passe erroné");
        for (Role r : user.getRoles())
            System.out.println("Role:" + r.getNom());
        return new
                org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(r -> new
                        SimpleGrantedAuthority("ROLE_" +
                        r.getNom())).collect(Collectors.toList()));
    }
}
