/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.model;

import java.io.Serializable;

/**
 *
 * @author natebolton
 */
public enum ItemType implements Serializable {
    
    CowboyHat("Cowboy Hat","Allows you to see distance to wolf.","hat"),
    Fedora("Fedora","Allows you to see distances to Piggys","hat"),
    HardHat("Hard Hat","Allows you to see distance to Builder","hat"),
    Sneakers("Sneakers","Allow you to move at double speed","shoe"),
    AlienBoots("Alien Boots","Sort the distances view.","shoe");
    private final String name;
    private final String description;
    private final String type;

    ItemType(String name,String description,String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

}
