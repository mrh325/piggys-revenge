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
                return 1;
            }
            i++;
        }
        //if we couldn't add the item for some reason, return 0
        System.out.println("returning zero here!");
        return 0;
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
                return 1;
            }
            i++;
        }
        //if we couldn't add the item for some reason, return 0
        return 0;
    }    
}
