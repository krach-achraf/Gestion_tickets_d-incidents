package spring.devoir.gestion_tickets.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.devoir.gestion_tickets.services.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketControllerWeb {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public String index(){
        return "/index";
    }
}
