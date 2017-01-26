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
 * @author hales AND bolton
 */
public class Player implements Serializable{
    private String name;
    private double distanceToWolf;
    private double distanceToPantry;
    private double distanceToNearestKey;
    private boolean hasEaten;

    public Player() {
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistanceToWolf() {
        return distanceToWolf;
    }

    public void setDistanceToWolf(double distanceToWolf) {
        this.distanceToWolf = distanceToWolf;
    }

    public double getDistanceToPantry() {
        return distanceToPantry;
    }

    public void setDistanceToPantry(double distanceToPantry) {
        this.distanceToPantry = distanceToPantry;
    }

    public double getDistanceToNearestKey() {
        return distanceToNearestKey;
    }

    public void setDistanceToNearestKey(double distanceToNearestKey) {
        this.distanceToNearestKey = distanceToNearestKey;
    }

    public boolean isHasEaten() {
        return hasEaten;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.distanceToWolf) ^ (Double.doubleToLongBits(this.distanceToWolf) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.distanceToPantry) ^ (Double.doubleToLongBits(this.distanceToPantry) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.distanceToNearestKey) ^ (Double.doubleToLongBits(this.distanceToNearestKey) >>> 32));
        hash = 71 * hash + (this.hasEaten ? 1 : 0);
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
        final Player other = (Player) obj;
        if (Double.doubleToLongBits(this.distanceToWolf) != Double.doubleToLongBits(other.distanceToWolf)) {
            return false;
        }
        if (Double.doubleToLongBits(this.distanceToPantry) != Double.doubleToLongBits(other.distanceToPantry)) {
            return false;
        }
        if (Double.doubleToLongBits(this.distanceToNearestKey) != Double.doubleToLongBits(other.distanceToNearestKey)) {
            return false;
        }
        if (this.hasEaten != other.hasEaten) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", distanceToWolf=" + distanceToWolf + ", distanceToPantry=" + distanceToPantry + ", distanceToNearestKey=" + distanceToNearestKey + ", hasEaten=" + hasEaten + '}';
    }
    
    


    
    
}
