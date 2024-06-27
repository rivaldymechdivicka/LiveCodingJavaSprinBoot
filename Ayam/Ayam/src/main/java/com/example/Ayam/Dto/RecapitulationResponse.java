package com.example.Ayam.Dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecapitulationResponse {
    private Long id;
    private String eggs;
    private String dateLayEggs;
}
