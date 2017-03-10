/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.model.Location;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class GameMenuView extends View {

    public GameMenuView() {
        super ("\n"
                + "\n======================================="
                + "\n| Game Menu                           |"
                + "\n======================================="
                + "\nM - (M)ove"
                + "\nS - (S)how Map"
                + "\nD - Calculate (D)istance between two points"
                + "\nI - (I)nventory"
                + "\nG - Play the Mini (G)ame!"
                + "\nC - Show s(C)ore"
                + "\nP - Show (P)robability of winning the game"
                + "\nU - Calc(U)late number of bricks for the house"
                + "\nB - (B)ack to Main Menu"
                + "\n=======================================");
    }
    @Override
    public boolean doAction(String menuOption) {
        // System.out.println("\n*** doAction() function called ***");
        
        menuOption = menuOption.toUpperCase();
        
        switch (menuOption) {
            case "M":
                this.displayMoveMenu();
                break;
            case "S":
                this.displayMap();
                break;
            case "D":
                this.displayDistance();
                break;
            case "I":
                this.displayInventoryMenu();
                break;
            case "G":
                this.displayMiniGameMenu();
                break;
            case "C":
                this.displayScore();
                break;
            case "P":
                this.displayProbability();
                break;
            case "U":
                this.displayHouseMenu();
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

    private void displayMoveMenu() {
        
        MoveMenuView moveMenu = new MoveMenuView();
        moveMenu.display();
    }

    private void displayMap() {
//        System.out.println("\n*** displayMap() function called ***");
//        StringBuilder line = new StringBuilder(
//            )

        Location[][] locations = PiggysRevenge.getCurrentGame().getMap().getLocations();
        System.out.println("The Far Away Land of Nonsense");
    }

    private void displayDistance() {
        //System.out.println("\n*** displayDistance() function called ***");
        DistanceView distanceView = new DistanceView();
        distanceView.display();
    }

    private void displayInventoryMenu() {
        //System.out.println("\n*** displayInventory() function called ***");
        //We'll probably pass a backpack object in here.
        InventoryMenuView inventoryMenu = new InventoryMenuView();
        inventoryMenu.display();
    }

    private void displayMiniGameMenu() {
        //System.out.println("\n*** displayMiniGameMenu() function called ***");
        MiniGameMenuView miniGameMenu = new MiniGameMenuView();
        miniGameMenu.display();
    }

    private void displayScore() {
        //System.out.println("\n*** displayScore() function called ***");
        ScoreView scoreView = new ScoreView();
        scoreView.display();
    }

    private void displayProbability() {
        //System.out.println("\n*** displayProbability() function called ***");
        ProbabilityView probabilityView = new ProbabilityView();
        probabilityView.display();
    }

    private void displayHouseMenu() {
        // System.out.println("\n*** displayHouseMenu() function called ***");
        HouseSizeView houseSize = new HouseSizeView();
        houseSize.display();
    }
    
}
