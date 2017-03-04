/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

/**
 *
 * @author hales
 */
public class findHatView extends View {
    

    public findHatView() {
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
                + "\nV - (View current backpack inventory"
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
                return true;
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
    }

    private void storeHat() {
        System.out.println("*** storeHat function called ***");
    }

    private void displayInventory() {
        System.out.println("*** displayInventory function called ***");
    }

    
}