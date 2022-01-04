package com.musala.droneops.repository;

import com.musala.droneops.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rhume
 */
public interface DroneRepository extends JpaRepository<Drone, Long> {
    
}
