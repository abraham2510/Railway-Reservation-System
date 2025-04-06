package com.example.Railway_Reservation.Service;

import com.example.Railway_Reservation.Model.PassengerModel;
import com.example.Railway_Reservation.Model.ReservationModel;
import com.example.Railway_Reservation.Repository.PassengerRepository;
import com.example.Railway_Reservation.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    public PassengerModel addPassenger(PassengerModel passengerModel){
        return passengerRepository.save(passengerModel);
    }

    public List<PassengerModel> getAllPassenger(){
        return passengerRepository.findAll();
    }

    public PassengerModel updatePassenger(int id,PassengerModel passengerModel){
        PassengerModel oldData =  passengerRepository.findById(id).orElse(null);
        oldData.setName(passengerModel.getName());
        oldData.setAge(passengerModel.getAge());
        oldData.setGender(passengerModel.getGender());
        oldData.setEmail(passengerModel.getEmail());
        return passengerRepository.save(oldData);
    }

    public String deletePassenger(int id){
        passengerRepository.deleteById(id);
        return "Passenger ID Deleted Successfully";
    }

    public ReservationModel createReservation(ReservationModel reservationModel){
        return reservationRepository.save(reservationModel);
    }
}
