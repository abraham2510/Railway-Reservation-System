package com.example.Railway_Reservation.Controller;

import com.example.Railway_Reservation.Model.PassengerModel;
import com.example.Railway_Reservation.Model.ReservationModel;
import com.example.Railway_Reservation.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("passenger")
public class PassengerControl {
    @Autowired
    PassengerService passengerService;

    //Add a Passenger
    @PostMapping("/addPassenger")
    public PassengerModel addPassenger(@RequestBody PassengerModel passengerModel){
        return passengerService.addPassenger(passengerModel);
    }

    //Get All Passengers
    @GetMapping("/getAllPassenger")
    public List<PassengerModel> getAllPassenger(){
        return passengerService.getAllPassenger();
    }

    //Update Passenger Details
    @PutMapping("/updatePassenger/{id}")
    public PassengerModel updatePassenger(@PathVariable int id, @RequestBody PassengerModel passengerModel){
        return passengerService.updatePassenger(id, passengerModel);
    }

    //Delete Passenger
    @DeleteMapping("/deletePassenger/{id}")
    public String deletePassenger(@PathVariable int id){
        return passengerService.deletePassenger(id);
    }

//    //Create a Reservation
//    @PostMapping("/createReservation")
//    public ReservationModel createReservation(@RequestBody ReservationModel reservationModel){
//        return passengerService.createReservation(reservationModel);
    

}
