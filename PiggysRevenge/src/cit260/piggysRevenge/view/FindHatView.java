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
 * @author hales
 */
public class FindHatView extends View {
    

    public FindHatView() {
        super ( "\n"
+ "        .e$$$$$$$$$o.  .z+\"\"-eu.      .xu..\n" +
"     d$$$$$$$$$$$$$$$$$o.    $$$$$u#         ^%s\n" +
"   u$$$$$$$$$$$$$$$$$$$$$$.  $$$$\"              ^s\n" +
"  u$$$$$$$$$$$$$$$$$$$$$$$$u $$$                  \".\n" +
"  $$$$$$$$$$$$$$$$$$$$$$$$$$c$$                    'c\n" +
" $$$$$$$$$$$$$$$$$$$$$$$$$$$$$               :       k\n" +
" $$$$$$$$$$$$$$$$$$$$$$$$$$$$$              :z!      '>\n" +
" $$$$$$$$$$$$$$$$$$$$$$$$$$$$EB             R         5\n" +
" $$$$$$$$\"RR$$$$$$$$$$$$$$$$$E'            :E         9\n" +
" $$$$$$P   $$$$$$$$$$$$$$$$$$E k           ' `%       F\n" +
" $$$$$\"    9$$$$$$$$$$$$$$$$$E ?           '   *     z\n" +
" $$$$      9$$$$$$$$$$$$$$$$$`  $           >   k   X\n" +
" d**Nx     $$$$$$$$$$$$$$$$$$   ''          5   ?  f\n" +
"$$  ?Lk   :$$$$$$$$$$$$$$$$$$               `  u#$$N\n" +
"RRF $5\"   8$$$$$$$$$$$$$$$$$$                E?&9$$FE\n" +
" \"**#`    $$$$$$$$$$$$$$$$$$$                ? \"$$$@`\n" +
"         J$*$$$$$$$$$$$$$$$$$                 L\n" +
"        x$$$$c#$$$$**#\"\"\"\"\"\"\"\"$$$$$$$$$$$$eed\"R"
                + "\n"
                + "\n"
                + "\nCONGRATULATIONS!! You found a hat!"
                + "\n\n\nPlease choose from the following:"
                + "======================================="
                + "\nE - (E)quip"
                + "\nS - (S)tore in backpack"
                + "\nL - (L)eave the hat here"
                + "\nV - (V)iew current backpack inventory"
                + "\nB - (B)ack to Game"
                + "\n=======================================");
    }
    

    @Override
    public boolean doAction(String menuOption) {
              // System.out.println("\n*** doAction() function called ***");
        
        menuOption = menuOption.toUpperCase();
        
        switch (menuOption) {
            case "E":
                this.equipHat();
                return true;
            case "S":
                this.storeHat();
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

    private void equipHat() {
        System.out.println("*** equipHat function called ***");
        int result = InventoryControl.giveHat();
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        if (itemList[0][result] != null) {
            PiggysRevenge.getPlayer().setCurrentHat(itemList[0][result]);
            System.out.println("\n-----------------------------------------------------------------"
                    + "\nHat Equipped.");
        } else {
            System.out.println("\n*** Error Equiping Hat ***");
        }
    }

    private void storeHat() {
        System.out.println("*** storeHat function called ***");
        int result = InventoryControl.giveHat();
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