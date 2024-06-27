package com.example.ticket.Repository;

import com.example.ticket.Dto.TicketRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketRequest, Long> {
}
