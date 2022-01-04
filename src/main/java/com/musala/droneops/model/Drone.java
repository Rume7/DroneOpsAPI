package com.musala.droneops.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rhume
 */
@Entity
public class Drone implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="serialNumber")
    private String serialNumber;
    
    @Column(name="model")
    private String model;
    
    @Column(name="weight")
    private double weight;
    
    @Column(name="battery_level")
    private int batteryLevel;
    
    @Column(name="drone_state")
    private String droneState;

    //@OneToMany
    //private Set<Medication> medications;
    
    public Drone() {}

    public Drone(String serialNumber, String model, double weight, int battery_level, String droneState) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weight = weight;
        this.batteryLevel = battery_level;
        this.droneState = droneState;
    }

    public long getId() {
        return id;
    }
    
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public String getDroneState() {
        return droneState;
    }

    public void setDroneState(String droneState) {
        this.droneState = droneState;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.serialNumber);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null && getClass() != obj.getClass()) {
            return false;
        }
        final Drone other = (Drone) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.serialNumber, other.serialNumber);
    }

    @Override
    public String toString() {
        return "Drone{" + "serialNumber=" + serialNumber + ", model=" + model + '}';
    }
}
