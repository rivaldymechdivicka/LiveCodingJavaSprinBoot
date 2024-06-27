package com.example.reservasi.Controllers;

import com.example.reservasi.Dto.ReservationRequest;
import com.example.reservasi.Dto.ReservationResponse;
import com.example.reservasi.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public ReservationResponse addReservation(@RequestBody ReservationRequest reservationRequest) {
        ReservationResponse response = reservationService.addReservation(reservationRequest);
        if (response == null) {
            throw new IllegalArgumentException("Reservation could not be processed.");
        }
        return response;
    }

    @GetMapping("/weekly-summary")
    public List<ReservationResponse> getWeeklySummary() {
        return reservationService.getWeeklySummary();
    }
}
