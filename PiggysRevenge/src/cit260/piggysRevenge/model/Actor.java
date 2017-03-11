/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Random;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author hales
 */

public enum Actor implements Serializable {
    
    Piggy1("This little piggy went to market."),
    Piggy2("This little piggy stayed home."),
    Piggy3("This little piggy had roast beef."),
    Piggy4("This little piggy had none.");
    
    private final String description;

    Actor(String description) {
        this.description = description;

    }

    public String getDescription() {
        return description;
    }
}