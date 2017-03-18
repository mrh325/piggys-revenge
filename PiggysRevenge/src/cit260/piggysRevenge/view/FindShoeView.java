/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.InventoryControl;
import cit260.piggysRevenge.exceptions.InventoryControlException;
import cit260.piggysRevenge.model.Item;
import java.awt.Point;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class FindShoeView extends View {
    Item item;
    Point playerLoc;

    public FindShoeView(Point playerLoc, Item item) {
        super ( "\n"
                + "\n"
                + "\n"
                + "\nCONGRATULATIONS!! You found "
                + item.getName()
                + "\n"
                + item.getDescription()
                + "\n\n\nPlease choose from the following:"
                + "======================================="
                + "\nE - (E)quip"
                + "\nS - (S)tore in backpack"
                + "\nL - (L)eave the shoe here"
                + "\nV - (V)iew current backpack inventory"
                + "\nB - (B)ack to Game"
                + "\n=======================================");
        this.item = item;
        this.playerLoc = playerLoc;
    }
    

    @Override
    public boolean doAction(String menuOption) {
              // System.out.println("\n*** doAction() function called ***");
        
        menuOption = menuOption.toUpperCase();
        
        switch (menuOption) {
            case "E":
        {
            try {
                this.equipShoe();
            } catch (InventoryControlException ex) {
                System.out.println(ex.getMessage());
            }
        }
                return true;
            case "S":
        {
            try {
                this.storeShoe();
            } catch (InventoryControlException ex) {
                System.out.println(ex.getMessage());
            }
        }
                return true;
            case "V":
                this.displayInventory();
                return false;
            case "L":
            case "B":
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;
    }

    private void equipShoe() throws InventoryControlException {
        //System.out.println("*** equipShoe function called ***");
        int result = InventoryControl.storeShoe(this.item);
        switch (result) {
            case 0:
            case 1:
            case 2:
                InventoryControl.equipShoe(result);
                PiggysRevenge.getCurrentGame().getMap().getLocations()[playerLoc.x][playerLoc.y].setItem(null);
        }
    }

    private void storeShoe() throws InventoryControlException {
        //System.out.println("*** storeShoe function called ***");
        int result = InventoryControl.storeShoe(this.item);
    }
    
    private void displayInventory() {
        System.out.println("*** displayInventory function called ***");
        //System.out.println("\n*** displayInventory() function called ***");
//        System.out.println(Arrays.deepToString(PiggysRevenge.getBackpack().getItemList())); //inventory throw-up
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        System.out.println("\n-----------------------------------------------------------------"
                + "\nHats:");
        int i = 1;
        for (Item hat : itemList[0]) {
            if (hat != null) {
                System.out.print("\n");
                if (hat == PiggysRevenge.getPlayer().getCurrentHat()) {
                    System.out.println(hat.getName() + " - CURRENTLY WEARING");
                } else {
                    System.out.println(hat.getName());
                }
                System.out.println(hat.getDescription());
                i++;
            }
        }
        if (i == 1) {
            System.out.println("\nYou have no hats.");
        }
        System.out.println("\n-----------------------------------------------------------------"
                + "\nShoes:");
        i = 1;
        for (Item shoe : itemList[1]) {
            if (shoe != null) {
                System.out.print("\n");
                if (shoe == PiggysRevenge.getPlayer().getCurrentShoes()) {
                    System.out.println(shoe.getName() + " - CURRENTLY WEARING");
                } else {
                    System.out.println(shoe.getName());
                }
                System.out.println(shoe.getDescription());
                i++;
            }
        }
        if (i == 1) {
            System.out.println("\nYou have no shoes.");
        }
        System.out.println("\n-----------------------------------------------------------------"
                + "\nBricks:");
        System.out.println(PiggysRevenge.getCurrentGame().getBackpack().getBricks());
    }

}