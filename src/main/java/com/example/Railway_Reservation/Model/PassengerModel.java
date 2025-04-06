package com.example.Railway_Reservation.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PassengerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;
}
