package com.musala.droneops.service;

import com.musala.droneops.model.Medication;
import com.musala.droneops.repository.MedicationRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rhume
 */
@Service
public class MedicationService implements MedicationServiceInterface {
    
    @Autowired
    private MedicationRepository medicationRepository;
    
    @Override
    public Medication createMedication(Medication medication) {
        Medication med = medicationRepository.save(medication);
        return med;
    }

    @Override
    public List<Medication> getAllMedication() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication getMedicationByCode(String code) {
        List<Medication> all_meds = medicationRepository.findAll();
        return all_meds.stream().filter(med -> (med.getCode().equals(code)))
                .findFirst().get();
    }
    
    @Override
    public List<Medication> getMedicationByName(String name) {
        List<Medication> medications = new ArrayList<>();
        List<Medication> all_meds = medicationRepository.findAll();
        all_meds.stream().filter(med -> (med.getName().equals(name)))
                .forEachOrdered(med -> medications.add(med));
        return medications;
    }

    /**
     * @param weightX
     * @return 
    @Override
    public List<Medication> getMedicationCarriedByADrone(Drone drone) {
        List<Medication> medications = new ArrayList<>();
        List<Medication> all_meds = medicationRepository.findAll();
        all_meds.stream().filter(med -> 
                (med.getDrone_SN().getSerialNumber().equals(drone.getSerialNumber())))
                .forEachOrdered(med -> medications.add(med));
        return medications;
    }
    */
    
    @Override
    public List<Medication> getMedicationsOfWeightLessThanX(double weightX) {
        List<Medication> medications = new ArrayList<>();
        List<Medication> all_meds = medicationRepository.findAll();
        all_meds.stream().filter(med -> (med.getWeight() < weightX))
                .forEachOrdered(med -> medications.add(med));
        return medications;
    }    
    
    @Override
    public Medication updateMedication(long id, Medication medication) {
        Medication updatedMedication = medicationRepository.findById(id).get();
        updatedMedication.setCode(medication.getCode());
        updatedMedication.setName(medication.getName());
        updatedMedication.setWeight(medication.getWeight());
        updatedMedication.setImageUrl(medication.getImageUrl());
        return medicationRepository.save(updatedMedication);
    }
    
    @Override
    public void deliverMedication(long code){
        medicationRepository.deleteById(code);
    }
}
