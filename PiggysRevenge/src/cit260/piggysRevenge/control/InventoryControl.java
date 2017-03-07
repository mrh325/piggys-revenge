/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import cit260.piggysRevenge.model.Item;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class InventoryControl {
    
    public static int storeHat(Item item) {
        //make sure we got a hat
        if (!"hat".equals(item.getItemType())) {
            return -1;
        }
        //Get player's backpack contents
        Item[][] itemList = PiggysRevenge.getBackpack().getItemList();

        //Look for a free space in the hat part of the backpack
        int i = 0;
        for (Item hat : itemList[0]) {
        //check if item is already in inventory
            if (item.equals(hat)) {
                return -2;
            } else if (hat == null) {
                //Item item = new Item("hat" + Integer.toString(i+1),"This is a generic hat","hat");
                itemList[0][i] = item;
                PiggysRevenge.getBackpack().setItemList(itemList);
                //return the slot number
                return i;
            }
            i++;
        }
        //if we couldn't add the item for some reason, return -3
        //System.out.println("returning zero here!");
        return -3;
    }

    public static int storeShoe(Item item) {
        //make sure we got a hat
        if (!"shoe".equals(item.getItemType())) {
            return -1;
        }
        //Get player's backpack contents
        Item[][] itemList = PiggysRevenge.getBackpack().getItemList();

        //Look for a free space in the hat part of the backpack
        int i = 0;
        for (Item shoe : itemList[1]) {
        //check if item is already in inventory
            if (item.equals(shoe)) {
                return -2;
            } else if (shoe == null) {
                //Item item = new Item("hat" + Integer.toString(i+1),"This is a generic hat","hat");
                itemList[1][i] = item;
                PiggysRevenge.getBackpack().setItemList(itemList);
                //return the slot number
                return i;
            }
            i++;
        }
        //if we couldn't add the item for some reason, return -3
        return -3;
    }
    
    public static int giveHat() {
        //this method tries to create a unique hat to put in inventory for testing.
        for (int i = 1; i < 4; i++) {
            Item item = new Item("hat" + Integer.toString(i),"This is a generic hat","hat");
            int result = InventoryControl.storeHat(item);
            switch (result) {
                case -1:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: item is not a hat type");
                    return -1;
                case -2:
                case -3:
                    if (i == 3 || result == -3) {
                        System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: No space left in inventory");
                        return -3;
                    }
                    break;
                case 0:
                case 1:
                case 2:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nA hat has been placed in your backpack.");
                    return result;
            }
        }
        return -4;
    }

    public static int giveShoe() {
        //this method tries to create a unique shoes to put in inventory for testing.
        for (int i = 1; i < 4; i++) {
            Item item = new Item("shoes" + Integer.toString(i),"These are generic shoes","shoe");
            int result = InventoryControl.storeShoe(item);
            switch (result) {
                case -1:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: item is not a shoe type");
                    return -1;
                case -2:
                case -3:
                    if (i == 3 || result == -3) {
                        System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: No space left in inventory");
                        return -3;
                    }
                    break;
                case 0:
                case 1:
                case 2:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nShoes have been placed in your backpack.");
                    return result;
            }
        }
        return -4;
    }
}
