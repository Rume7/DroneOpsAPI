package com.musala.dronedelivery.exceptions;

/**
 *
 * @author Rhume
 */
public class MedicationException extends Exception {

    private String medExceptionMessage;
    
    public MedicationException(String message) {
        super(message);
        medExceptionMessage = message;
    }
    
    @Override
    public String getMessage() {
        return medExceptionMessage;
    }

    @Override
    public String toString() {
        return "";
    }
}
