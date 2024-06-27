package com.example.ticket.Service.ServiceImplemantation;

import com.example.ticket.Dto.TicketRequest;
import com.example.ticket.Dto.TicketResponse;
import com.example.ticket.Service.TicketService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TicketServiceImpl implements TicketService {
    private final List<TicketResponse> tickets = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public List<TicketResponse> getAllTickets() {
        return new ArrayList<>(tickets);  // Return a copy to prevent modification
    }

    @Override
    public TicketResponse addOrderTicket(TicketRequest ticketRequest) {
        TicketResponse ticketResponse = new TicketResponse(counter.incrementAndGet(), ticketRequest.getName(), ticketRequest.getTicket());
        tickets.add(ticketResponse);
        return ticketResponse;
    }
}
