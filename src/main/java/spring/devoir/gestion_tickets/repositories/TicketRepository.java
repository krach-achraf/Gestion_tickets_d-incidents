package spring.devoir.gestion_tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.devoir.gestion_tickets.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Long, Ticket> {
}
