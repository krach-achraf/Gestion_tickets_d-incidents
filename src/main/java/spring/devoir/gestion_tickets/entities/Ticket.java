package spring.devoir.gestion_tickets.entities;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Lob
    private String description;

    @Column(length = 50)
    private String envirenemment;

    @Column(nullable = false, length = 50)
    private String logiciel;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(nullable = false, length = 20)
    private String urgence;

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
                  String urgence,
                  String envirenemment,
                  String logiciel,
                  String status,
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
                  String urgence,
                  String envirenemment,
                  String logiciel,
                  String status,
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

    public String getUrgence() {
        return urgence;
    }

    public void setUrgence(String urgence) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
