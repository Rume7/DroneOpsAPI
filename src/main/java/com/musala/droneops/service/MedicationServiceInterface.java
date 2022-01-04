package com.musala.droneops.service;

import com.musala.droneops.model.Medication;
import java.util.List;

/**
 *
 * @author Rhume
 */
public interface MedicationServiceInterface {
    
    Medication createMedication(Medication medication);
    
    List<Medication> getAllMedication();
    
    List<Medication> getMedicationByName(String name);
    
    Medication getMedicationByCode(String code);
    
    //List<Medication> getMedicationCarriedByADrone(Drone drone);
    
    List<Medication> getMedicationsOfWeightLessThanX(double weightX);
    
    Medication updateMedication(long id, Medication med);
    
    // A delivered medication gets deleted from the database.
    void deliverMedication(long code);
    
}
