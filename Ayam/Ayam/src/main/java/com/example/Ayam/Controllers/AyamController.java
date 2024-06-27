package com.example.Ayam.Controllers;

import com.example.Ayam.Dto.AyamRequest;
import com.example.Ayam.Dto.AyamResponse;
import com.example.Ayam.Service.AyamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ayam")
public class AyamController {
    private final AyamService ayamService;

    @Autowired
    public AyamController(AyamService ayamService) {
        this.ayamService = ayamService;
    }

    @PostMapping("/add")
    public AyamResponse addAyamEggs(@RequestBody AyamRequest ayamRequest) {
        return ayamService.addAyamEggs(ayamRequest);
    }

    @GetMapping("/recapitulation")
    public List<AyamResponse> getRecapitulation() {
        return ayamService.getRecapitulation();
    }
}
