package com.example.Railway_Reservation.Repository;

import com.example.Railway_Reservation.Model.TrainModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<TrainModel, Integer> {

    @Query("SELECT t from TrainModel t WHERE t.sourceStation = :sourceStation AND t.destinationStation = :destinationStation")
    List<TrainModel> search(String sourceStation, String destinationStation);
}
