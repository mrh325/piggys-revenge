/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author natebolton
 */
public class Backpack implements Serializable {
    //Variables
    private Item[][] itemList;
    private int bricks;

    //constructor
    public Backpack() {
        //create two arrays of 3 lenth arrays to hold Hats and Shoes
        this.itemList = new Item[2][3];
        this.bricks = 0;
    }
    
    //methods
    public Item[][] getItemList() {
        return itemList;
    }

    public void setItemList(Item[][] itemList) {
        this.itemList = itemList;
    }

    public int getBricks() {
        return bricks;
    }

    public void setBricks(int bricks) {
        this.bricks = bricks;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Arrays.deepHashCode(this.itemList);
        hash = 29 * hash + this.bricks;
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
        final Backpack other = (Backpack) obj;
        if (this.bricks != other.bricks) {
            return false;
        }
        if (!Arrays.deepEquals(this.itemList, other.itemList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Backpack{" + "itemList=" + Arrays.toString(itemList) + ", bricks=" + bricks + '}';
    }
    
}
