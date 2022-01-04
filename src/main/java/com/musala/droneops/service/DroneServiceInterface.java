package com.musala.droneops.service;

import com.musala.droneops.model.Drone;
import java.util.List;

/**
 *
 * @author Rhume
 */
public interface DroneServiceInterface {
    
    List<Drone> getAllDrones();
    
    Drone getDroneById(long id);
    
    List<Drone> getDronesByModel(String model);
    
    List<Drone> getDronesByState(String state);
    
    Drone updateDrone(long id, Drone drone);
    
}
