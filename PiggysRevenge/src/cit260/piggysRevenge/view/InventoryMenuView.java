/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.model.Item;
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
        // this.console.println("\n*** doAction() function called ***");
        
        menuOption = menuOption.toUpperCase();
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        switch (menuOption) {
            case "I":
                this.displayInventory();
                break;
            case "H":
                this.setHat();
                break;
            case "S":
                this.setShoes();
                break;
            case "B":
            case "Q":
                return true;
            default:
                this.console.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;    
    }

    private void displayInventory() {
        //this.console.println("\n*** displayInventory() function called ***");
//        this.console.println(Arrays.deepToString(PiggysRevenge.getBackpack().getItemList())); //inventory throw-up
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        this.console.println("\n-----------------------------------------------------------------"
                + "\nHATS:");
        int i = 1;
        for (Item hat : itemList[0]) {
            if (hat != null) {
                System.out.print("\n");
                if (hat == PiggysRevenge.getPlayer().getCurrentHat()) {
                    this.console.println(hat.getName() + " - CURRENTLY WEARING");
                } else {
                    this.console.println(hat.getName());
                }
                this.console.println(hat.getDescription());
                i++;
            }
        }
        if (i == 1) {
            this.console.println("\nYou have no hats.");
        }
        this.console.println("\n-----------------------------------------------------------------"
                + "\nSHOES:");
        i = 1;
        for (Item shoe : itemList[1]) {
            if (shoe != null) {
                System.out.print("\n");
                if (shoe == PiggysRevenge.getPlayer().getCurrentShoes()) {
                    this.console.println(shoe.getName() + " - CURRENTLY WEARING");
                } else {
                    this.console.println(shoe.getName());
                }
                this.console.println(shoe.getDescription());
                i++;
            }
        }
        if (i == 1) {
            this.console.println("\nYou have no shoes.");
        }
        this.console.println("\n-----------------------------------------------------------------"
                + "\nBricks:");
        this.console.println(PiggysRevenge.getCurrentGame().getBackpack().getBricks());
    }

    private void setHat() {
        //this.console.println("\n*** setHat() function called ***");
        ChangeHatView changeHatView = new ChangeHatView();
        changeHatView.display();
    }

    private void setShoes() {
        //this.console.println("\n*** setShoes() function called ***");
        ChangeShoesView changeShoesView = new ChangeShoesView();
        changeShoesView.display();
    }

}
