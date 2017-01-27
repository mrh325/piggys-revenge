/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author natebolton
 */
public class Hat extends Item implements Serializable {
    //variables
    private String targetScene;
    
    //constructor
    public Hat() {
    }
    
    //methods
    public String getTargetScene() {
        return targetScene;
    }

    public void setTargetScene(String targetScene) {
        this.targetScene = targetScene;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.targetScene);
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
        final Hat other = (Hat) obj;
        if (!Objects.equals(this.targetScene, other.targetScene)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hat{" + "targetScene=" + targetScene + '}';
    }


}
