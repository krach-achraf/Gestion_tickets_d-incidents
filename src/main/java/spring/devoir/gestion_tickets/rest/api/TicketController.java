package spring.devoir.gestion_tickets.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.devoir.gestion_tickets.entities.Ticket;
import spring.devoir.gestion_tickets.services.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/developpeurs")
    public List<Ticket> findByDeveloppeurIsNull() {
        return ticketService.findByDeveloppeurIsNull();
    }

    @GetMapping("/developpeur/{id}")
    public List<Ticket> findByDeveloppeur_Id(@PathVariable int id) {
        return ticketService.findByDeveloppeur_Id(id);
    }

    @GetMapping("/clients/{id}")
    public List<Ticket> findByClient_Id(@PathVariable int id) {
        return ticketService.findByClient_Id(id);
    }

    @PostMapping
    public void save(@RequestBody Ticket ticket) {
        ticketService.save(ticket);
    }
}
