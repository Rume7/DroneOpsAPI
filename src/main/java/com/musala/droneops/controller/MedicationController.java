package com.musala.droneops.controller;

import com.musala.droneops.model.Medication;
import com.musala.droneops.service.MedicationServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MedicationController {
    
    //@Autowired
    //private MedicationRepository medicRepo;
    
    @Autowired
    private MedicationServiceInterface medicationService;
    
    @GetMapping(value="/medications")
    public List<Medication> getAllMedications() {
        //return medicRepo.findAll();
        return medicationService.getAllMedication();
    }
    
    @GetMapping(value="/medications/code/{code}")
    public Medication getMedicationsByCode(@PathVariable String code) {
        //List<Medication> all_medications = medicationService.getAllMedication();
        //List<Medication> medications = new ArrayList<>();
        //all_medications.stream().filter(med -> med.getCode().equals(code))
        //        .forEach(medic -> medications.add(medic));
        //return medications;
        return medicationService.getMedicationByCode(code);
    }
    
    @PostMapping(value="/medication/save")
    public Medication saveMedication(@RequestBody Medication medication) {
        return medicationService.createMedication(medication);
        //medicRepo.save(medication);
        //return "Saved medication...";
    }
    
    @PutMapping(value="/medications/update/{code}")
    public Medication updateMedication(@PathVariable String code, @RequestBody Medication medication) {
        Medication updatedMedication = medicationService.getMedicationByCode(code);
        updatedMedication.setCode(medication.getCode());
        updatedMedication.setName(medication.getName());
        updatedMedication.setWeight(medication.getWeight());
        updatedMedication.setImageUrl(medication.getImageUrl());
        return medicationService.createMedication(updatedMedication);
        //return "Updated ... ";
    }
    
    /**    
    @GetMapping("/medications/name/{name}")
    public List<Medication> getMedicationsByName(@PathVariable String name) {
        return medicationService.getMedicationByName(name);
    }
    
    @GetMapping("/medications/weight/{serial}")
    public List<Medication> getMedicationsLessThanDroneWeight(@RequestBody Drone drone) {
        return medicationService.getMedicationsOfWeightLessThanX(drone.getWeight());
    }
    
    @DeleteMapping("/medications/delete/{code}")
    public void deliverMedication(@RequestBody Medication medication, @PathVariable String code) {
        medicationService.deliverMedication(code);
    }
    
    @PostMapping("/medication/create_med/")
    public Medication createMedication(@RequestBody Medication medication) {
        medicationService.createMedication(newMedication);        
        return newMedication;
    }*/
}
