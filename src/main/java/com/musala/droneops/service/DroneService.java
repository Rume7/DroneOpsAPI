package com.musala.droneops.service;

import com.musala.droneops.model.Drone;
import com.musala.droneops.repository.DroneRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rhume
 */
@Service
public class DroneService implements DroneServiceInterface {

    @Autowired
    DroneRepository droneRepository;

    public Drone saveDrone(Drone drone) {
        long numberOfDrones = droneRepository.count();
        if (numberOfDrones < 10) {
            return droneRepository.save(drone);
        }
        return null;
    }

    @Override
    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    @Override
    public Drone getDroneById(long id) {
        Optional<Drone> aDrone = droneRepository.findById(id);
        return aDrone.orElse(new Drone());
    }

    @Override
    public List<Drone> getDronesByModel(String model) {
        List<Drone> new_drones = new ArrayList<>();
        List<Drone> all_drones = droneRepository.findAll();
        all_drones.stream().filter(drone
                -> (drone.getModel().equals(model)))
                .forEachOrdered(drone -> new_drones.add(drone));
        return new_drones;
    }

    @Override
    public List<Drone> getDronesByState(String state) {
        List<Drone> new_drones = new ArrayList<>();
        List<Drone> all_drones = droneRepository.findAll();
        all_drones.stream().filter(drone
                -> (drone.getDroneState().equals(state)))
                .forEachOrdered(drone -> new_drones.add(drone));
        return new_drones;
    }

    @Override
    public Drone updateDrone(long id, Drone drone) {
        if (drone != null) {
            Drone updatedDrone = droneRepository.findById(id).get();
            updatedDrone.setDroneState(drone.getDroneState());
            updatedDrone.setSerialNumber(drone.getSerialNumber());
            updatedDrone.setBatteryLevel(drone.getBatteryLevel());
            updatedDrone.setModel(drone.getModel());
            updatedDrone.setWeight(drone.getWeight());
            return droneRepository.save(updatedDrone);
        }
        return null;
    }
    
    public ResponseEntity.BodyBuilder deleteDrone(long id) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN);
    }
}
