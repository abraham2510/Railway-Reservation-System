package com.example.Railway_Reservation.Repository;

import com.example.Railway_Reservation.Model.PassengerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerModel, Integer> {
}
