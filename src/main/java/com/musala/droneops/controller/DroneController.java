package com.musala.droneops.controller;

import com.musala.droneops.model.Drone;
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
        Drone returnedDrone = droneService.saveDrone(drone);
        if (returnedDrone == null) {
            return "Can't save anymore drones";
        }
        return "Drone saved...";
    }
    
    @PutMapping(value="/updateDrone/{id}")
    public String updateDrone(@PathVariable long id, @RequestBody Drone drone) {        
        Drone updatedDrone = droneService.getDroneById(id);
        updatedDrone.setSerialNumber(drone.getSerialNumber());
        updatedDrone.setModel(drone.getModel());
        updatedDrone.setWeight(drone.getWeight());
        updatedDrone.setBatteryLevel(drone.getBatteryLevel());
        updatedDrone.setDroneState(drone.getDroneState());
        droneService.updateDrone(id, updatedDrone);
        return "Updated drone: " + id;
    }
    
    @DeleteMapping(value="/deleteDrone/{id}")
    public String deleteDrone(@PathVariable long id) {
        droneService.deleteDrone(id);
        return "Deleted drone " + id;
    }
}
