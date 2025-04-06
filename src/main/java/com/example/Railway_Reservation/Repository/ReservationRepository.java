package com.example.Railway_Reservation.Repository;

import com.example.Railway_Reservation.Model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, Integer> {
    List<ReservationModel> findByPassengerId(int passengerId);
    List<ReservationModel> findByTrainId(int trainId);
    List<ReservationModel> findByTrainIdAndReservationDate(int trainId, Date reservationDate);
}