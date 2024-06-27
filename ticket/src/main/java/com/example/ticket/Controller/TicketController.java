package com.example.ticket.Controller;

import com.example.ticket.Dto.TicketRequest;
import com.example.ticket.Dto.TicketResponse;
import com.example.ticket.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<TicketResponse> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping
    public TicketResponse addOrderTicket(@RequestBody TicketRequest ticketRequest) {
        return ticketService.addOrderTicket(ticketRequest);
    }
}
