/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import cit260.piggysRevenge.control.MapControl;
import cit260.piggysRevenge.control.MiniGameControl;
import cit260.piggysRevenge.exceptions.GameControlException;
import cit260.piggysRevenge.model.House;
import cit260.piggysRevenge.model.Map;
import cit260.piggysRevenge.model.MiniGame;
import java.awt.Point;
import java.util.Scanner;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class FindBuilderView extends View {

    String builderAsciiArt = "\n\nYOU HAVE FOUND THE BUILDER!";
    
    public FindBuilderView() {
        System.out.println(this.builderAsciiArt);
    }

    @Override
    public void display() {
        if (PiggysRevenge.getCurrentGame().getHouse().isCompleted()) {
            System.out.println("you have completed your house already, go get that wolf!");
            this.pressAnyKeyToContinue();
            return;
        }
        Map map = PiggysRevenge.getCurrentGame().getMap();
        Point[] actorPoints = MapControl.getActorPoints(map);
        //make sure all 4 piggys are found
        int unvisitedPiggys = 0;
        for (Point point : actorPoints) {
            if (map.getLocations()[point.x][point.y].getVisited() == false) {
                if (!"Builder".equals(map.getLocations()[point.x][point.y].getActor().name())) {
                    unvisitedPiggys++;
                }
            }
        }
        if (unvisitedPiggys > 0) {
            System.out.println("You must find all four piggys before I can work with you."
                    + "\nReturn to me after you have found all four piggys.");
        //if all 4 piggys are found, make sure house dimensions were chosen
        } else {
            System.out.println("Thank you for finding the piggys.  Having found the piggys, "
                    + "\nwe are now ready to build the house.");
            House playerHouse = PiggysRevenge.getCurrentGame().getHouse();
            while (playerHouse.getHeight() == 0
                || playerHouse.getLength() == 0
                || playerHouse.getWidth() == 0
                || playerHouse.getStories() == 0) {
                System.out.println("You need to choose how big your house will be first.");
                HouseSizeView houseSize = new HouseSizeView();
                houseSize.display();
            }
            //check if player has enough bricks fo the chosen house size
            int neededBricks = 0;
            try {
                neededBricks = GameControl.calcNumberOfBricks(playerHouse.getLength(), playerHouse.getWidth(), playerHouse.getHeight(), playerHouse.getStories());
            } catch (GameControlException ex) {
                System.out.println(ex.getMessage());
                return;
            }
            int playerBricks = PiggysRevenge.getCurrentGame().getBackpack().getBricks();
            System.out.println("\nYour previously chosen house dimensions are:"
                    + "\nLength: " + playerHouse.getLength()
                    + "\nWidth: " + playerHouse.getWidth()
                    + "\nHeight: " + playerHouse.getHeight()
                    + "\nStories: " + playerHouse.getStories()
                    + "\nWhich will require "
                    + neededBricks
                    + " bricks.");

            System.out.println("You current have "
                    + playerBricks
                    + " bricks.");
            //if not enough bricks, return.
            if (neededBricks > playerBricks) {
                System.out.println("\nYou do not have enough bricks to continue.\nPlease collect "
                        + neededBricks
                        + " bricks before returning.");
                this.pressAnyKeyToContinue();
                return;
            } else {
                //if enough bricks have been collected, set house.completed = true,
                //delete all the bricks, and play mini game
                PiggysRevenge.getCurrentGame().getHouse().setCompleted(true);
                MapControl.deleteBricks(PiggysRevenge.getCurrentGame().getMap());
                System.out.println("You have collected the required number of bricks, I will now build your house...");
                System.out.println("...and done!");
                System.out.println("Now you need to unlock the treasure chest to eat the roast beef.");
                while (PiggysRevenge.getCurrentGame().getPlayer().isHasEaten() == false) {
                    MiniGame miniGame = new MiniGame();
                    miniGame.setComboOrder("1234");
                    MiniGameControl.generateComboOrder(miniGame);
                    MiniGameView miniGameView = new MiniGameView(miniGame);
                    miniGameView.display();
                }
                System.out.println("Great Job!  You unlocked the treasure chest! You now have"
                        + "\n15 turns to capture the wolf.");
                //ADD 15 TURNS FEATURE HERE!!!!!!!!!!!!!!!!!!
            }
        }
        this.pressAnyKeyToContinue();
    }
    

    @Override
    public boolean doAction(String value) {
        System.out.println("\n*** doAction() in FindBuilderView called ***");
        return true;
    }
    
    private void pressAnyKeyToContinue() {
        try
        {
            Scanner keyIn = new Scanner(System.in);

            System.out.print("Press the enter key to continue");
            keyIn.nextLine();
        }  
        catch(Exception e)
        {}          
    }
}