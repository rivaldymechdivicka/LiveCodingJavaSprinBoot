package com.example.ticket.Service;

import com.example.ticket.Dto.TicketRequest;
import com.example.ticket.Dto.TicketResponse;

import java.util.List;

public interface TicketService {
    List<TicketResponse> getAllTickets();
    TicketResponse addOrderTicket(TicketRequest ticketRequest);
}
