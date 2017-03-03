/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.model.Item;
import java.util.Arrays;
import java.util.Scanner;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
class InventoryMenuView extends View {

    public InventoryMenuView() {
        super("\n"
                + "\n======================================="
                + "\n| Inventory Menu                           |"
                + "\n======================================="
                + "\nI - View (I)nventory"
                + "\nH - Change (H)at"
                + "\nS - Change (S)hoes"
                + "\nB - (B)ack to Game Menu"
                + "\n=======================================");
    }
 
    @Override
    public boolean doAction(String menuOption) {
        // System.out.println("\n*** doAction() function called ***");
        
        menuOption = menuOption.toUpperCase();
        Item[][] itemList = PiggysRevenge.getBackpack().getItemList();
        switch (menuOption) {
            case "I":
                this.displayInventory();
                break;
            case "H":
                //System.out.println("\n*** Giving player a free hat ***");
                //give the player one hat to test stuff
                int i = 0;
                for (Item hat : itemList[0]) {
                    //System.out.println("\npass " + Integer.toString(i));
                    if (hat == null) {
                        Item item = new Item("hat" + Integer.toString(i+1),"This is a generic hat","hat");
                        itemList[0][i] = item;
                        break;
                    }
                    i++;
                }
                //if we didn't loop through the whole array without finding a non-null...
                if (i != 3) {
                    //System.out.println("\n*** inserting something! ***");
                    PiggysRevenge.getBackpack().setItemList(itemList);
                }
                this.setHat();
                break;
            case "S":
                //System.out.println("\n*** Giving player a free shoe ***");
                //TEST CODE START
                //give the player one shoes to test stuff
                i = 0;
                for (Item hat : itemList[1]) {
                    //System.out.println("\npass " + Integer.toString(i));
                    if (hat == null) {
                        Item item = new Item("shoes" + Integer.toString(i+1),"These are generic shoes","shoes");
                        itemList[1][i] = item;
                        break;
                    }
                    i++;
                }
                //if we found a null in our loop...
                if (i != 3) {
                    //System.out.println("\n*** inserting something! ***");
                    PiggysRevenge.getBackpack().setItemList(itemList);
                }
                //TEST CODE END
                this.setShoes();
                break;
            case "B":
            case "Q":
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;    
    }

    private void displayInventory() {
        //System.out.println("\n*** displayInventory() function called ***");
        System.out.println(Arrays.deepToString(PiggysRevenge.getBackpack().getItemList()));
    }

    private void setHat() {
        //System.out.println("\n*** setHat() function called ***");
        ChangeHatView changeHatView = new ChangeHatView();
        changeHatView.display();
    }

    private void setShoes() {
        //System.out.println("\n*** setShoes() function called ***");
        ChangeShoesView changeShoesView = new ChangeShoesView();
        changeShoesView.display();
    }

}
