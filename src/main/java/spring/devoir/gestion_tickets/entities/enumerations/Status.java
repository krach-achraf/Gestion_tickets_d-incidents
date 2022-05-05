package spring.devoir.gestion_tickets.entities.enumerations;

public enum Status {
    EN_COURS("En cours de traitement") ,
    RESOLU("Resolu");

    private String name;

    Status(String name) {
        this.name = name;
    }
}
