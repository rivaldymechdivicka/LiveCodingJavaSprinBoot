package com.example.reservasi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    private String customerName;
    private String date; // date should be in yyyy-MM-dd format
}
