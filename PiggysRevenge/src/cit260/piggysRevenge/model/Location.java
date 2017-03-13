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
 * @author hales
 */
public class Location implements Serializable {
    
    private int column;
    private int row;
    private Boolean visited;
    private Scene scene;
    private Actor actor;
    private Item item;
    private boolean containsWolf;

    public Location(int column, int row) {
        this.column = column;
        this.row = row;
        this.visited = false;
        this.containsWolf = false;
    }

    public Location() {
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isContainsWolf() {
        return containsWolf;
    }

    public void setContainsWolf(boolean containsWolf) {
        this.containsWolf = containsWolf;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.column;
        hash = 97 * hash + this.row;
        hash = 97 * hash + Objects.hashCode(this.visited);
        hash = 97 * hash + Objects.hashCode(this.scene);
        hash = 97 * hash + Objects.hashCode(this.actor);
        hash = 97 * hash + Objects.hashCode(this.item);
        hash = 97 * hash + (this.containsWolf ? 1 : 0);
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
        final Location other = (Location) obj;
        if (this.column != other.column) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        if (this.containsWolf != other.containsWolf) {
            return false;
        }
        if (!Objects.equals(this.visited, other.visited)) {
            return false;
        }
        if (!Objects.equals(this.scene, other.scene)) {
            return false;
        }
        if (this.actor != other.actor) {
            return false;
        }
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "column=" + column + ", row=" + row + ", visited=" + visited + ", scene=" + scene + ", actor=" + actor + ", item=" + item + ", containsWolf=" + containsWolf + '}';
    }
    
}
