package spring.devoir.gestion_tickets.entities.enumerations;

public enum Urgence {
    CRITIQUE("Critique"),
    URGENT("Urgent"),
    NORMAL("Normal"),
    NON_URGENT("Non urgent");

    private String name;

    Urgence(String name) {
        this.name = name;
    }
}
