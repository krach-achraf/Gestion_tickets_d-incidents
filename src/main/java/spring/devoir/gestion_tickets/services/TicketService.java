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

    public Ticket getById(Long aLong) {
        return ticketRepository.getById(aLong);
    }

    public List<Ticket> findByDeveloppeurIsNull() {
        return ticketRepository.findByDeveloppeurIsNull();
    }

    public List<Ticket> findByDeveloppeur_Id(Long id) {
        return ticketRepository.findByDeveloppeur_Id(id);
    }

    public List<Ticket> findByClient_Id(Long id) {
        return ticketRepository.findByClient_Id(id);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }
}
