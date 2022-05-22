package spring.devoir.gestion_tickets.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.devoir.gestion_tickets.entities.Ticket;
import spring.devoir.gestion_tickets.services.TicketService;
import spring.devoir.gestion_tickets.services.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketControllerWeb {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public String index(){
        return "layout/index";
    }

    @GetMapping("/admin")
    public String ticketsNonAttribues(Model model) {
        List<Ticket> tickets = ticketService.findByDeveloppeurIsNull();
        model.addAttribute("tickets", tickets);
        return "template/ticket-non-attribue";
    }

    @GetMapping("/admin/affecter/{id}")
    public String affecteTicket(@PathVariable long id, Model model) {
        Ticket ticket = ticketService.getById(id);

        return "template/ticket-non-attribue";
    }

    public List<Ticket> findByDeveloppeur_Id(int id) {
        return ticketService.findByDeveloppeur_Id(id);
    }

    public List<Ticket> findByClient_Id(int id) {
        return ticketService.findByClient_Id(id);
    }

    public void save(Ticket ticket) {
        ticketService.save(ticket);
    }
}
