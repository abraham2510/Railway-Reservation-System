package com.example.Railway_Reservation.Service;

import com.example.Railway_Reservation.Model.TrainModel;
import com.example.Railway_Reservation.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    @Autowired
    TrainRepository trainRepository;
    public TrainModel addTrains(TrainModel trainModel){
        return trainRepository.save(trainModel);
    }

    public List<TrainModel> getAllTrain(){
        return trainRepository.findAll();
    }

    public TrainModel getTrainById(int id){
        return trainRepository.findById(id).orElse(null);
    }

    public TrainModel update(int id,TrainModel trainModel){
        TrainModel oldData = trainRepository.findById(id).orElse(null);
        oldData.setTrainName(trainModel.getTrainName());
        oldData.setSourceStation(trainModel.getSourceStation());
        oldData.setDestinationStation(trainModel.getDestinationStation());
        return trainRepository.save(oldData);
    }

    public String deleteTrain(int id){
        trainRepository.deleteById(id);
        return "Train ID"+ " "+ id + " "+ "Deleted Successfully";
    }

    public List<TrainModel> search(String sourceStation, String destinationStation){
        return trainRepository.search(sourceStation, destinationStation);
    }
}
