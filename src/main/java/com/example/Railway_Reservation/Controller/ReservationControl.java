package com.example.Railway_Reservation.Controller;

import com.example.Railway_Reservation.Model.ReservationModel;
import com.example.Railway_Reservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationControl {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservations")
    public ReservationModel createReservation(@RequestBody ReservationModel reservationModel) {
        return reservationService.createReservation(reservationModel);
    }

    @GetMapping("/reservations")
    public List<ReservationModel> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/passengers/{id}/reservations")
    public List<ReservationModel> getReservationsByPassenger(@PathVariable int id) {
        return reservationService.getReservationsByPassenger(id);
    }

    @GetMapping("/trains/{id}/reservations")
    public List<ReservationModel> getReservationsByTrain(@PathVariable int id) {
        return reservationService.getReservationsByTrain(id);
    }

    @PutMapping("/reservations/{id}/cancel")
    public ReservationModel cancelReservation(@PathVariable int id) {
        return reservationService.cancelReservation(id);
    }

    @GetMapping("/trains/{id}/availability")
    public String checkSeatAvailability(@PathVariable int id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date travelDate) {
        return reservationService.checkSeatAvailability(id, travelDate);
    }

    @GetMapping("/reservations/{id}/status")
    public String getReservationStatus(@PathVariable int id) {
        return reservationService.getReservationStatus(id);
    }
}