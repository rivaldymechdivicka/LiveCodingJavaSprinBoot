package com.example.Ayam.Service;

import com.example.Ayam.Dto.AyamRequest;
import com.example.Ayam.Dto.AyamResponse;

import java.util.List;

public interface AyamService {
    AyamResponse addAyamEggs(AyamRequest ayamRequest);
    List<AyamResponse> getRecapitulation();
}
