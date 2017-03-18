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
 * @author hales
 */
public class FindHatView extends View {
    Item item;
    Point playerLoc;

    public FindHatView(Point playerLoc, Item item) {
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
                + "\nCONGRATULATIONS!! You found the "
                + item.getName()
                + "\nwhich "
                + item.getDescription()
                + "\n\n\nPlease choose from the following:"
                + "======================================="
                + "\nE - (E)quip"
                + "\nS - (S)tore in backpack"
                + "\nL - (L)eave the hat here"
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
                this.equipHat();
            } catch (InventoryControlException ex) {
                System.out.println(ex.getMessage());
            }
        }
                return true;
            case "S":
        {
            try {
                this.storeHat();
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

    private void equipHat() throws InventoryControlException {
        System.out.println("*** equipHat function called ***");
        int result = InventoryControl.storeHat(this.item);
        switch (result) {
            case 0:
            case 1:
            case 2:
                InventoryControl.equipHat(result);
                PiggysRevenge.getCurrentGame().getMap().getLocations()[playerLoc.x][playerLoc.y].setItem(null);
        }
        
    }

    private void storeHat() throws InventoryControlException {
        System.out.println("*** storeHat function called ***");
        int result = InventoryControl.storeHat(this.item);
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