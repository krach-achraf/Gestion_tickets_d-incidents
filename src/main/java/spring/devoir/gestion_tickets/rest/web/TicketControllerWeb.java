package spring.devoir.gestion_tickets.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.devoir.gestion_tickets.entities.Ticket;
import spring.devoir.gestion_tickets.entities.User;
import spring.devoir.gestion_tickets.services.TicketService;
import spring.devoir.gestion_tickets.services.UserServiceImpl;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")
public class TicketControllerWeb {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public String index(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> roles =  auth.getAuthorities();
        if(roles.toString().contains("ADMIN"))
            model.addAttribute("tickets", ticketService.findByDeveloppeurIsNull());
        else if(roles.toString().contains("DEVELOPPEUR"))
            model.addAttribute("tickets", ticketService.findByDeveloppeur_Id(idAuth()));
        else
            model.addAttribute("tickets", ticketService.findByClient_Id(idAuth()));
        return "template/tickets-liste";
    }

    @GetMapping("client/ticket/add")
    public String ticketsAdd(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "template/add-ticket";
    }

    @PostMapping("client/ticket/add")
    public String ticketsSave(@ModelAttribute Ticket ticket, Model model, BindingResult result) {
        ticket.setClient(userService.getById(idAuth()));
        ticket.setStatus("en cours");
        ticketService.save(ticket);
        model.addAttribute("tickets", ticketService.findByClient_Id(idAuth()));
        return "template/tickets-liste";
    }

    @GetMapping("/admin/tickets/affecter/{id}")
    public String affecteTicket(@PathVariable long id, Model model) {
        Ticket ticket = ticketService.getById(id);
        List<User> users = userService.findAll();
        users.removeIf(user -> !user.getRoles().toString().contains("DEVELOPPEUR"));
        model.addAttribute("users", users);
        model.addAttribute("ticket", ticket);
        return "template/affectation-ticket";
    }

    @GetMapping("/admin/tickets/choisir/{id}/{idT}")
    public String saveAffectationTicket(@PathVariable long id,@PathVariable long idT, Model model) {
        User developpeur = userService.getById(id);
        Ticket ticket = ticketService.getById(idT);
        ticket.setDeveloppeur(developpeur);
        ticketService.save(ticket);
        model.addAttribute("tickets", ticketService.findByDeveloppeurIsNull());
        return "template/tickets-liste";
    }

    @GetMapping("developpeur/tickets/status/{id}")
    public String changeStatus(@PathVariable long id, Model model){
        Ticket ticket = ticketService.getById(id);
        ticket.setStatus("resolu");
        ticketService.save(ticket);
        model.addAttribute("tickets", ticketService.findByDeveloppeur_Id(idAuth()));
        return "template/tickets-liste";
    }

    private long idAuth(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        return user.getId();
    }
}
