package com.example.Ayam.Dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AyamResponse {
    private Long id;
    private Integer eggs;
    private Double price;
    private String dateLayEggs;
}
