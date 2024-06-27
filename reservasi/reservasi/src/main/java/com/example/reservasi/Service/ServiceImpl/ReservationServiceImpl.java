package com.example.reservasi.Service.ServiceImpl;

import com.example.reservasi.Dto.ReservationRequest;
import com.example.reservasi.Dto.ReservationResponse;
import com.example.reservasi.Service.ReservationService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final Map<String, List<ReservationResponse>> reservations = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();
    private final List<String> closedDays = Arrays.asList("Wednesday", "Friday");
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE");

    @Override
    public ReservationResponse addReservation(ReservationRequest reservationRequest) {
        try {
            String date = reservationRequest.getDate();
            Date parsedDate = dateFormat.parse(date);
            String dayOfWeek = dayOfWeekFormat.format(parsedDate);

            if (closedDays.contains(dayOfWeek)) {
                return null;
            }

            List<ReservationResponse> dayReservations = reservations.getOrDefault(date, new ArrayList<>());
            if (dayReservations.size() >= 2) {
                return null;
            }

            ReservationResponse reservationResponse = new ReservationResponse(
                    counter.incrementAndGet(),
                    reservationRequest.getCustomerName(),
                    date
            );
            dayReservations.add(reservationResponse);
            reservations.put(date, dayReservations);
            return reservationResponse;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ReservationResponse> getWeeklySummary() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());

        List<ReservationResponse> weeklySummary = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String date = dateFormat.format(calendar.getTime());
            weeklySummary.addAll(reservations.getOrDefault(date, new ArrayList<>()));
            calendar.add(Calendar.DAY_OF_WEEK, 1);
        }
        return weeklySummary.stream()
                .filter(res -> {
                    try {
                        return !closedDays.contains(dayOfWeekFormat.format(dateFormat.parse(res.getDate())));
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }
}
