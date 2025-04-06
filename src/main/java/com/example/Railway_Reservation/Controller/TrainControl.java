package com.example.Railway_Reservation.Controller;

import com.example.Railway_Reservation.Model.TrainModel;
import com.example.Railway_Reservation.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("train")
public class TrainControl {
    @Autowired
    TrainService trainService;

    //Add a Train
    @PostMapping("/addTrain")
    public TrainModel addTrains(@RequestBody TrainModel trainModel){
        return trainService.addTrains(trainModel);
    }

    //Get All Trains
    @GetMapping("/getAllTrain")
    public List<TrainModel> getAllTrain(){
        return trainService.getAllTrain();
    }

    //Get Train by ID
    @GetMapping("/getTrainById/{id}")
    public TrainModel getTrainById(@PathVariable int id){
        return trainService.getTrainById(id);
    }

    //Update Train Details
    @PutMapping("/updateTrain/{id}")
    public TrainModel updateTrain(@PathVariable int id, @RequestBody TrainModel trainModel){
        return trainService.update(id,trainModel);
    }

    //Delete Train
    @DeleteMapping("/deleteTrain/{id}")
    public String deleteTrain(@PathVariable int id){
        return trainService.deleteTrain(id);
    }

    //Search Trains by Route
    @GetMapping("/search")
    public List<TrainModel> search(@RequestParam("source") String sourceStation, @RequestParam("destinationStation") String destinationStation){
        return trainService.search(sourceStation, destinationStation);
    }
}
