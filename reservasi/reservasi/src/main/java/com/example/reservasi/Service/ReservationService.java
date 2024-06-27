package com.example.reservasi.Service;

import com.example.reservasi.Dto.*;


import java.util.List;

public interface ReservationService {
    ReservationResponse addReservation(ReservationRequest reservationRequest);
    List<ReservationResponse> getWeeklySummary();
}
