package com.musala.droneops.controller;

import com.musala.droneops.model.Drone;
import com.musala.droneops.repository.DroneRepository;
import com.musala.droneops.service.DroneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rhume
 */
@RestController
public class DroneController {
    
    @Autowired
    private DroneRepository droneRepository;
    
    @Autowired
    private DroneService droneService;
    
    @GetMapping(value="/drones")
    public List<Drone> findAllDrones() {
        return droneService.getAllDrones();
    }
    
    @GetMapping(value="/drones/{id}")
    public Drone findDrone(@PathVariable long id) {
        return droneService.getDroneById(id);
    }
    
    @PostMapping(value="/save")
    public String saveDrone(@RequestBody Drone drone) {
        droneRepository.save(drone);
        return "Drone saved...";
    }
    
    @PutMapping(value="/updateDrone/{id}")
    public String updateDrone(@PathVariable long id, @RequestBody Drone drone) {
        Drone updatedDrone = droneRepository.findById(id).get();
        updatedDrone.setSerialNumber(drone.getSerialNumber());
        updatedDrone.setModel(drone.getModel());
        updatedDrone.setWeight(drone.getWeight());
        updatedDrone.setBatteryLevel(drone.getBatteryLevel());
        updatedDrone.setDroneState(drone.getDroneState());
        droneRepository.save(updatedDrone);
        return "Updated drone: " + drone.getSerialNumber();
    }
    
    @DeleteMapping(value="/deleteDrone/{id}")
    public String deleteDrone(@PathVariable long id) {
        droneRepository.deleteById(id);
        return "Deleted drone " + id;
    }
}