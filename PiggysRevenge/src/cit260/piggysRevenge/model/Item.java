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
public class Item implements Serializable {
    //variables
    private String name;
    private String description;
    private int movementBonus;
    private Scene targetScene;
    private String itemType;

    //constructor
    public Item() {
        
    }
    
    public Item(String name, String description, String itemType) {
        this.name = name;
        this.description = description;
        this.itemType = itemType;
    }

    //methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMovementBonus() {
        return movementBonus;
    }

    public void setMovementBonus(int movementBonus) {
        this.movementBonus = movementBonus;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Scene getTargetScene() {
        return targetScene;
    }

    public void setTargetScene(Scene targetScene) {
        this.targetScene = targetScene;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + this.movementBonus;
        hash = 79 * hash + Objects.hashCode(this.targetScene);
        hash = 79 * hash + Objects.hashCode(this.itemType);
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
        final Item other = (Item) obj;
        if (this.movementBonus != other.movementBonus) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.itemType, other.itemType)) {
            return false;
        }
        if (!Objects.equals(this.targetScene, other.targetScene)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", description=" + description + ", movementBonus=" + movementBonus + ", targetScene=" + targetScene + ", itemType=" + itemType + '}';
    }
    
}
