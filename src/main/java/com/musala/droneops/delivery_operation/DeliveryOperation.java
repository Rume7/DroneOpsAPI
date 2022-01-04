package com.musala.droneops.delivery_operation;

import com.musala.droneops.model.Drone;
import com.musala.droneops.model.Medication;
import java.util.List;

/**
 *
 * @author Rhume
 */
public interface DeliveryOperation {
    
    boolean checkBatteryLevel(Drone drone);
    
    boolean verifyIfMedicationIsDeliverable(Drone drone, List<Medication> medications);
    
    void changeDroneState(Drone drone);
    
    List<Drone> getAllAvailableDrones();
}
