/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author hales AND bolton AND powell
 */
public class Player implements Serializable{
    private String name;
    private Point coordinates;
    private double distanceToWolf;
    private double distanceToPantry;
    private double distanceToNearestActor;
    private boolean hasEaten;
    private Item currentHat;
    private Item currentShoes;

    public Player() {
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
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

    public double getDistanceToNearestActor() {
        return distanceToNearestActor;
    }

    public void setDistanceToNearestActor(double distanceToNearestActor) {
        this.distanceToNearestActor = distanceToNearestActor;
    }

    public boolean isHasEaten() {
        return hasEaten;
    }

    public void setHasEaten(boolean hasEaten) {
        this.hasEaten = hasEaten;
    }

    public Item getCurrentHat() {
        return currentHat;
    }

    public void setCurrentHat(Item currentHat) {
        this.currentHat = currentHat;
    }

    public Item getCurrentShoes() {
        return currentShoes;
    }

    public void setCurrentShoes(Item currentShoes) {
        this.currentShoes = currentShoes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.coordinates);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.distanceToWolf) ^ (Double.doubleToLongBits(this.distanceToWolf) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.distanceToPantry) ^ (Double.doubleToLongBits(this.distanceToPantry) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.distanceToNearestActor) ^ (Double.doubleToLongBits(this.distanceToNearestActor) >>> 32));
        hash = 59 * hash + (this.hasEaten ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.currentHat);
        hash = 59 * hash + Objects.hashCode(this.currentShoes);
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
        if (Double.doubleToLongBits(this.distanceToNearestActor) != Double.doubleToLongBits(other.distanceToNearestActor)) {
            return false;
        }
        if (this.hasEaten != other.hasEaten) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.coordinates, other.coordinates)) {
            return false;
        }
        if (!Objects.equals(this.currentHat, other.currentHat)) {
            return false;
        }
        if (!Objects.equals(this.currentShoes, other.currentShoes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", coordinates=" + coordinates + ", distanceToWolf=" + distanceToWolf + ", distanceToPantry=" + distanceToPantry + ", distanceToNearestActor=" + distanceToNearestActor + ", hasEaten=" + hasEaten + ", currentHat=" + currentHat + ", currentShoes=" + currentShoes + '}';
    }


    
}
