package com.musala.droneops.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rhume
 */
public enum Model {
    
    LT("LIGHTWEIGHT"), MT("MIDDLEWEIGHT"), CT("CRUISERWEIGHT"), HT("HEAVYWEIGHT");
    
    private static final Map<String, Model> MODELS = new HashMap<>();
    
    static {
        for (Model model : values()) {
            MODELS.put(model.modelName, model);
        }
    }
    
    public String modelName;

    private Model(String modelName) {
        this.modelName = modelName;
    }    
    
    public static Model valueOfModel(String modelName) {
        return MODELS.get(modelName);
    }
}
