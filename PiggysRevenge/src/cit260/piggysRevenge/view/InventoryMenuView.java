/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.InventoryControl;
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
                + "\nT - Gimme a ha(T) (FOR TESTING)"
                + "\nO - Gimme a sh(O)es (FOR TESTING)"
                + "\nG - (G)imme a brick (FOR TESTING)"
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
                this.setHat();
                break;
            case "S":
                this.setShoes();
                break;
            case "T":
                //for testing only
                this.giveHat();
                break;
            case "O":
                //for testing only
                this.giveShoe();
                break;
            case "G":
                //for testing only
                PiggysRevenge.getBackpack().setBricks(PiggysRevenge.getBackpack().getBricks()+1);
                System.out.println("Brick Granted...");
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
//        System.out.println(Arrays.deepToString(PiggysRevenge.getBackpack().getItemList())); //inventory throw-up
        Item[][] itemList = PiggysRevenge.getBackpack().getItemList();
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
        System.out.println(PiggysRevenge.getBackpack().getBricks());
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

    private void giveHat() {
        for (int i = 1; i < 4; i++) {
            Item item = new Item("hat" + Integer.toString(i),"This is a generic hat","hat");
            int result = InventoryControl.storeHat(item);
            switch (result) {
                case -1:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: item is not a hat type");
                    break;
                case -2:
                case 0:
                    if (i == 3 || result == 0) {
                        System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: No space left in inventory");
                    }
                    break;
                case 1:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nA hat has been placed in your backpack.");
                    return;
            }
        }
    }

    private void giveShoe() {
        for (int i = 1; i < 4; i++) {
            Item item = new Item("shoes" + Integer.toString(i),"These are generic shoes","shoe");
            int result = InventoryControl.storeShoe(item);
            switch (result) {
                case -1:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: item is not a shoe type");
                    break;
                case -2:
                case 0:
                    if (i == 3 || result == 0) {
                        System.out.println("\n-----------------------------------------------------------------"
                            + "\nERROR: No space left in inventory");
                    }
                    break;
                case 1:
                    System.out.println("\n-----------------------------------------------------------------"
                            + "\nShoes have been placed in your backpack.");
                    return;
            }
        }
    }

}
