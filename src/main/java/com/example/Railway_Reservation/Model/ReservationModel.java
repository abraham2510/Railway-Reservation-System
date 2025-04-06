package com.example.Railway_Reservation.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ReservationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private PassengerModel passenger;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private TrainModel train;

    private Date reservationDate;
    private String status; // e.g., "Confirmed", "Cancelled"
    private int seatNumber;
}