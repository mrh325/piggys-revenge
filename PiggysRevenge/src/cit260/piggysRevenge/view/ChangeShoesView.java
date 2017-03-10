/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.model.Item;
import java.util.Arrays;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
class ChangeShoesView extends View {

    public ChangeShoesView() {
        super("\nPlease Choose shoes to wear, or type \"N\" for none.");
    }
    
    @Override
    public void display() {
        if (PiggysRevenge.getPlayer().getCurrentShoes() == null) {
            System.out.print("\n\n--You're not currently wearing any shoes.");
        } else {
            System.out.print("\n\n--You current shoes are:" + PiggysRevenge.getPlayer().getCurrentShoes().getName());
        }
        System.out.print("\nYou currently have the following shoes:\n");
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        //System.out.println(Arrays.toString(hats[0]));
        int i = 1;
        for (Item shoe : itemList[1]) {
            if (shoe != null) {
                System.out.print("\n" + Integer.toString(i) + ":  ");
                System.out.println(shoe.getName());
                System.out.println(shoe.getDescription());
                i++;
            }
        }
        //if shoe list is all null...
        if (i == 1) {
            System.out.println("--I'm sorry, you don't have any shoes yet.");
            //System.out.println(Arrays.toString(itemList[1]));
            return;
        }
        super.display();
    }

    @Override
    public boolean doAction(String value) {
        // System.out.println("\n*** doAction() function called in ChangeHatView***");
        
        value = value.toUpperCase();
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        switch (value) {
            case "1":
                if (itemList[1][0] != null) {
                    PiggysRevenge.getPlayer().setCurrentShoes(itemList[1][0]);
                    return true;
                } else {
                    System.out.println("\n*** Invalid selection *** Try again ***");
                }
                break;
            case "2":
                if (itemList[1][1] != null) {
                    PiggysRevenge.getPlayer().setCurrentShoes(itemList[1][1]);
                    return true;
                } else {
                    System.out.println("\n*** Invalid selection *** Try again ***");
                }
                break;
            case "3":
                if (itemList[1][2] != null) {
                    PiggysRevenge.getPlayer().setCurrentShoes(itemList[1][2]);
                    return true;
                } else {
                    System.out.println("\n*** Invalid selection *** Try again ***");
                }
                break;
            case "N":
                PiggysRevenge.getPlayer().setCurrentShoes(null);
                return true;
            case "B":
            case "Q":
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false; 
    }
    
}
