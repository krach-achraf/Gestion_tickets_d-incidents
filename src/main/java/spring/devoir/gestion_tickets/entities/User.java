package spring.devoir.gestion_tickets.entities;

import spring.devoir.gestion_tickets.entities.enumerations.Role;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nom;

    @Column(nullable = false, length = 30)
    private String prenom;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

    private Role role;

    public User() {
    }

    public User(Long id, String nom, String prenom, String username, String email, String password, Role role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String nom, String prenom, String username, String email, String password, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
