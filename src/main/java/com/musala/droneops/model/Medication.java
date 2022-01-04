package com.musala.droneops.model;

import com.musala.dronedelivery.exceptions.MedicationException;
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
public class Medication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private int weight;

    @Column(name = "image_url")
    private String imageUrl;

    //@ManyToOne
    //@JoinColumn(name = "drone_SN", nullable = true)
    //private Drone drone_SN;
    public Medication() {}

    public Medication(String code, String name, int weight, String imageUrl) throws MedicationException {
        if (validateMedicationName(name) && validateMedicationCode(code)) {
            this.name = name;
            this.code = code;
        } else {
            throw new MedicationException(name + " should contain only letter, numbers, _ and _\n"
                    + code + " should contain only uppercase letters, _ and numbers.");
        }
        this.weight = weight;
        this.imageUrl = imageUrl;
    }

    private boolean validateMedicationName(String name) {
        return name.matches("[a-zA-Z_0-9-].*$");
    }

    private boolean validateMedicationCode(String code) {
        return code.matches("[A-Z_0-9].*$");
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medication other = (Medication) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Medication{" + "code=" + code + ", name=" + name + '}';
    }
}
