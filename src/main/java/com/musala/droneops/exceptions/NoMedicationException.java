package com.musala.dronedelivery.exceptions;

/**
 *
 * @author Rhume
 */
public class NoMedicationException extends Exception {
    
    private String exceptionMessage;
    
    public NoMedicationException(String message) {
        this.exceptionMessage = message;
    }
    
    @Override
    public String getMessage() {
        return exceptionMessage;
    }
    
    @Override
    public String toString(){
        return "NoMedicationException{ message= " + exceptionMessage +"}";
    }
}
