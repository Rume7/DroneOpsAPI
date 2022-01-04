package com.musala.droneops.repository;

import com.musala.droneops.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Rhume
 */
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    
}
