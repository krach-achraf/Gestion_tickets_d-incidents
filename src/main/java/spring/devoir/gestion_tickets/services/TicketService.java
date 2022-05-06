package spring.devoir.gestion_tickets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.devoir.gestion_tickets.entities.Ticket;
import spring.devoir.gestion_tickets.repositories.TicketRepository;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> findByDeveloppeurIsNotNull() {
        return ticketRepository.findByDeveloppeurIsNotNull();
    }

    public List<Ticket> findByDeveloppeur_Id(int id) {
        return ticketRepository.findByDeveloppeur_Id(id);
    }

    public List<Ticket> findByClient_Id(int id) {
        return ticketRepository.findByClient_Id(id);
    }

    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }
}
