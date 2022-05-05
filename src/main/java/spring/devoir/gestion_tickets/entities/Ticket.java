package spring.devoir.gestion_tickets.entities;

import spring.devoir.gestion_tickets.entities.enumerations.Status;
import spring.devoir.gestion_tickets.entities.enumerations.Urgence;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Lob
    private String description;

    @Column(nullable = false)
    private Urgence urgence;

    @Column(nullable = false, length = 50)
    private String envirenemment;

    @Column(nullable = false, length = 50)
    private String logiciel;

    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "developpeur_id")
    private User developpeur;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Ticket() {
    }

    public Ticket(Long id,
                  String description,
                  Urgence urgence,
                  String envirenemment,
                  String logiciel,
                  Status status,
                  User developpeur,
                  User client) {
        this.id = id;
        this.description = description;
        this.urgence = urgence;
        this.envirenemment = envirenemment;
        this.logiciel = logiciel;
        this.status = status;
        this.developpeur = developpeur;
        this.client = client;
    }

    public Ticket(String description,
                  Urgence urgence,
                  String envirenemment,
                  String logiciel,
                  Status status,
                  User developpeur,
                  User client) {
        this.description = description;
        this.urgence = urgence;
        this.envirenemment = envirenemment;
        this.logiciel = logiciel;
        this.status = status;
        this.developpeur = developpeur;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Urgence getUrgence() {
        return urgence;
    }

    public void setUrgence(Urgence urgence) {
        this.urgence = urgence;
    }

    public String getEnvirenemment() {
        return envirenemment;
    }

    public void setEnvirenemment(String envirenemment) {
        this.envirenemment = envirenemment;
    }

    public String getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(String logiciel) {
        this.logiciel = logiciel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getDeveloppeur() {
        return developpeur;
    }

    public void setDeveloppeur(User developpeur) {
        this.developpeur = developpeur;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
