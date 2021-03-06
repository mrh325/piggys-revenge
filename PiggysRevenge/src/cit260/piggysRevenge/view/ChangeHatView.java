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
class ChangeHatView extends View {

    public ChangeHatView() {
        super("\nPlease Choose a hat to wear, or type \"N\" for none.");
    }

    @Override
    public void display() {
        if (PiggysRevenge.getPlayer().getCurrentHat() == null) {
            System.out.print("\n\n--You're not currently wearing any hat.");
        } else {
            System.out.print("\n\n--You current hat is:" + PiggysRevenge.getPlayer().getCurrentHat().getName());
        }
        System.out.print("\nYou currently have the following hats:\n");
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        //this.console.println(Arrays.toString(hats[0]));
        int i = 1;
        for (Item hat : itemList[0]) {
            if (hat != null) {
                System.out.print("\n" + Integer.toString(i) + ":  ");
                this.console.println(hat.getName());
                this.console.println(hat.getDescription());
                i++;
            }
        }
        //if i was not incremented, all values are null
        if (i == 1) {
            this.console.println("--I'm sorry, you don't have any hats yet.");
            //this.console.println(Arrays.toString(itemList[0]));
            return;
        }
        super.display();
    }

    @Override
    public boolean doAction(String value) {
        // this.console.println("\n*** doAction() function called in ChangeHatView***");
        
        value = value.toUpperCase();
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        switch (value) {
            case "1":
                if (itemList[0][0] != null) {
                    PiggysRevenge.getPlayer().setCurrentHat(itemList[0][0]);
                    return true;
                } else {
                    this.console.println("\n*** Invalid selection *** Try again ***");
                }
                break;
            case "2":
                if (itemList[0][1] != null) {
                    PiggysRevenge.getPlayer().setCurrentHat(itemList[0][1]);
                    return true;
                } else {
                    this.console.println("\n*** Invalid selection *** Try again ***");
                }
                break;
            case "3":
                if (itemList[0][2] != null) {
                    PiggysRevenge.getPlayer().setCurrentHat(itemList[0][2]);
                    return true;
                } else {
                    this.console.println("\n*** Invalid selection *** Try again ***");
                }
                break;
            case "N":
                PiggysRevenge.getPlayer().setCurrentHat(null);
                return true;
            case "B":
            case "Q":
                return true;
            default:
                this.console.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false; 
    }


    
}
