/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import cit260.piggysRevenge.exceptions.InventoryControlException;
import cit260.piggysRevenge.model.Item;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class InventoryControl {
    
    public static int storeHat(Item item) throws InventoryControlException{
        //make sure we got a hat
        if (!"hat".equals(item.getItemType())) {
            throw new InventoryControlException("Did not receive item of hat type");
        }
        //Get player's backpack contents
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();

        //Look for a free space in the hat part of the backpack
        int i = 0;
        for (Item hat : itemList[0]) {
        //check if item is already in inventory
            if (item.equals(hat)) {
                throw new InventoryControlException("Item already in inventory");
            } else if (hat == null) {
                //Item item = new Item("hat" + Integer.toString(i+1),"This is a generic hat","hat");
                itemList[0][i] = item;
                PiggysRevenge.getCurrentGame().getBackpack().setItemList(itemList);
                //return the slot number
                return i;
            }
            i++;
        }
        //if we couldn't add the item for some reason, return -3
        throw new InventoryControlException("An error occured while storing the hat in inventory");
    }

    public static int storeShoe(Item item) throws InventoryControlException {
        //make sure we got a hat
        if (!"shoe".equals(item.getItemType())) {
            throw new InventoryControlException("Did not receive item of shoe type");
        }
        //Get player's backpack contents
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();

        //Look for a free space in the hat part of the backpack
        int i = 0;
        for (Item shoe : itemList[1]) {
        //check if item is already in inventory
            if (item.equals(shoe)) {
                throw new InventoryControlException("Item already in inventory");
            } else if (shoe == null) {
                //Item item = new Item("hat" + Integer.toString(i+1),"This is a generic hat","hat");
                itemList[1][i] = item;
                PiggysRevenge.getCurrentGame().getBackpack().setItemList(itemList);
                //return the slot number
                return i;
            }
            i++;
        }
        //if we couldn't add the item for some reason, return -3
        throw new InventoryControlException("An error occured while storing the shoe in inventory");
    }
    
    public static void equipHat(int result) throws InventoryControlException {
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        if (itemList[0][result] != null) {
            PiggysRevenge.getPlayer().setCurrentHat(itemList[0][result]);
        } else {
            throw new InventoryControlException("Error Equiping Hat");
        }
    }
    
    public static void equipShoe(int result) throws InventoryControlException {
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        if (itemList[1][result] != null) {
            PiggysRevenge.getPlayer().setCurrentShoes(itemList[1][result]);
        } else {
            throw new InventoryControlException("Error Equiping Shoe");
        }
    }
}