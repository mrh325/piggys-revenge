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
    private int piggysFound;
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

    public int getPiggysFound() {
        return piggysFound;
    }

    public void setPiggysFound(int piggysFound) {
        this.piggysFound = piggysFound;
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
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.coordinates);
        hash = 17 * hash + this.piggysFound;
        hash = 17 * hash + (this.hasEaten ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.currentHat);
        hash = 17 * hash + Objects.hashCode(this.currentShoes);
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
        if (this.piggysFound != other.piggysFound) {
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
        return "Player{" + "name=" + name + ", coordinates=" + coordinates + ", piggysFound=" + piggysFound + ", hasEaten=" + hasEaten + ", currentHat=" + currentHat + ", currentShoes=" + currentShoes + '}';
    }
        
}
