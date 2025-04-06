package com.example.Railway_Reservation.Service;

import com.example.Railway_Reservation.Model.PassengerModel;
import com.example.Railway_Reservation.Model.ReservationModel;
import com.example.Railway_Reservation.Model.TrainModel;
import com.example.Railway_Reservation.Repository.ReservationRepository;
import com.example.Railway_Reservation.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TrainRepository trainRepository; // Inject TrainRepository to fetch train details

    public ReservationModel createReservation(ReservationModel reservationModel) {
        int trainId = reservationModel.getTrain().getId();
        Date travelDate = reservationModel.getReservationDate();

        // Get total seats for the train
        TrainModel train = trainRepository.findById(trainId).orElse(null);
        if (train == null) {
            throw new RuntimeException("Train not found");
        }

        int totalSeats = train.getTotalSeats();
        int reservedSeats = reservationRepository.findByTrainIdAndReservationDate(trainId, travelDate).size();

        if (reservedSeats >= totalSeats) {
            throw new RuntimeException("No available seats!");
        }

        reservationModel.setSeatNumber(reservedSeats + 1);
        return reservationRepository.save(reservationModel);
    }


    public List<ReservationModel> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<ReservationModel> getReservationsByPassenger(int passengerId) {
        return reservationRepository.findByPassengerId(passengerId);
    }

    public List<ReservationModel> getReservationsByTrain(int trainId) {
        return reservationRepository.findByTrainId(trainId);
    }

    public ReservationModel cancelReservation(int id) {
        ReservationModel reservation = reservationRepository.findById(id).orElse(null);
        if (reservation != null) {
            reservation.setStatus("Cancelled");
            return reservationRepository.save(reservation);
        }
        return null;
    }

    public String checkSeatAvailability(int trainId, Date travelDate) {
        TrainModel train = trainRepository.findById(trainId).orElse(null);
        if (train == null) {
            return "Train not found";
        }

        int totalSeats = train.getTotalSeats();

        // Retrieve all reservations for the given train
        List<ReservationModel> reservations = reservationRepository.findByTrainId(trainId);

        // Filter reservations by date and exclude canceled ones
        int reservedSeats = (int) reservations.stream()
                .filter(res -> res.getReservationDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()
                        .equals(travelDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()))
                .filter(res -> !"Cancelled".equalsIgnoreCase(res.getStatus())) // Exclude canceled reservations
                .count();

        int availableSeats = totalSeats - reservedSeats;

        return "Available seats: " + availableSeats + " out of " + totalSeats;
    }




    public String getReservationStatus(int id) {
        ReservationModel reservation = reservationRepository.findById(id).orElse(null);
        return reservation != null ? reservation.getStatus() : "Reservation not found";
    }
}