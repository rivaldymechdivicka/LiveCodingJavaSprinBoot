package com.example.Ayam.Service.ServiceImpl;
import com.example.Ayam.Dto.AyamRequest;
import com.example.Ayam.Dto.AyamResponse;
import com.example.Ayam.Service.AyamService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AyamServiceImpl implements AyamService {
    private final List<AyamResponse> recapitulations = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public AyamResponse addAyamEggs(AyamRequest ayamRequest) {
        String dateLayEggs = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        AyamResponse ayamResponse = new AyamResponse(
                counter.incrementAndGet(),
                ayamRequest.getEggs(),
                ayamRequest.getPrice(),
                dateLayEggs
        );
        recapitulations.add(ayamResponse);
        return ayamResponse;
    }

    @Override
    public List<AyamResponse> getRecapitulation() {
        return new ArrayList<>(recapitulations);  // Return a copy to prevent modification
    }
}
