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
        super ( "\n" +
"                                        ,,~~~~~~,,..\n" +
"                             ...., ,'~             |\n" +
"                             \\    V                /\n" +
"                              \\  /                 /\n" +
"                              ;####>     @@@@@     )\n" +
"                              ##;,      @@@@@@@    )\n" +
"                           .##/  ~>      @@@@@   .   .\n" +
"                          ###''#>              '      '\n" +
"      .:::::::.      ..###/ #>               '         '\n" +
"     //////))))----~~ ## #}                '            '\n" +
"   ///////))))))                          '             '\n" +
"  ///////)))))))\\                        '              '\n" +
" //////)))))))))))                                      '\n" +
" |////)))))))))))))____________________________________).\n" +
"|||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n" +
" ````````````````````````````''''''''''''''''''''''''''''"
                + "\n"
                + "\nCONGRATULATIONS!! You found "
                + item.getName()
                + "\nFunction:  "
                + item.getDescription()
                + "\n\n\nPlease choose from the following:"
                + "\n======================================="
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
              // this.console.println("\n*** doAction() function called ***");
        
        menuOption = menuOption.toUpperCase();
        
        switch (menuOption) {
            case "E":
        {
            try {
                this.equipShoe();
            } catch (InventoryControlException ex) {
                this.console.println(ex.getMessage());
            }
        }
                return true;
            case "S":
        {
            try {
                this.storeShoe();
            } catch (InventoryControlException ex) {
                this.console.println(ex.getMessage());
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
                this.console.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;
    }

    private void equipShoe() throws InventoryControlException {
        //this.console.println("*** equipShoe function called ***");
        int result = InventoryControl.storeShoe(this.item);
        switch (result) {
            case 0:
            case 1:
            case 2:
                InventoryControl.equipShoe(result);
                PiggysRevenge.getCurrentGame().getMap().getLocations()[playerLoc.x][playerLoc.y].setItem(null);
                this.console.println(PiggysRevenge.getPlayer().getCurrentShoes().getName() + " Equipped.");
        }
    }

    private void storeShoe() throws InventoryControlException {
        //this.console.println("*** storeShoe function called ***");
        int result = InventoryControl.storeShoe(this.item);
        this.console.println("Shoe stored in slot " + result);
        PiggysRevenge.getCurrentGame().getMap().getLocations()[playerLoc.x][playerLoc.y].setItem(null);
    }
    
    private void displayInventory() {
        this.console.println("*** displayInventory function called ***");
        //this.console.println("\n*** displayInventory() function called ***");
//        this.console.println(Arrays.deepToString(PiggysRevenge.getBackpack().getItemList())); //inventory throw-up
        Item[][] itemList = PiggysRevenge.getCurrentGame().getBackpack().getItemList();
        this.console.println("\n-----------------------------------------------------------------"
                + "\nHats:");
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
                + "\nShoes:");
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

}