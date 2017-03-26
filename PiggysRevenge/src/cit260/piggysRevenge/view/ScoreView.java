/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import cit260.piggysRevenge.exceptions.GameControlException;
import cit260.piggysRevenge.model.Game;
import cit260.piggysRevenge.model.House;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
class ScoreView extends View {


    public ScoreView() {
        super("\n-----------------------------------------------------------------"
                + "\nGenerating your possible score... Please enter the following"
                + "\non one line. Separate each value with a space"
                + "\n-----------------------------------------------------------------"
                + "\nHow many bricks will be in your house?"
                + "\nHow many turns will have passed when the game ends?"
                + "\nWill you have eaten the roast beef? (Y or N)"
                + "\nWill you have captured the Wolf? (Y or N)");
    }

    @Override
    public void display() {
        // this.console.println("\n*** display() function called ***");
        Game game = PiggysRevenge.getCurrentGame();
        int bricks = 0;
        if (game.getHouse().isCompleted()) {
            House house = game.getHouse();
            try {
                bricks = GameControl.calcNumberOfBricks(house.getLength(), house.getWidth(), house.getHeight(), house.getStories());
            } catch (GameControlException ex) {
                this.console.println(ex.getMessage());
            }
        } else {
            bricks = 0;
        }
        int turns = game.getTurns();
        boolean hasEaten = game.getPlayer().isHasEaten();
        boolean wolfKilled = game.isWolfKilled();
        int result = 0;
        try {
            result = GameControl.calcScore(bricks, turns, hasEaten, wolfKilled);
        } catch (GameControlException ex) {
            this.console.println(ex.getMessage());
        }
        if (result>0) {
            this.console.println("+" + (bricks*10) + " Points for building the house.");
            this.console.println("-" + (turns*10) + " Points for the number of turns taken (" + turns + " turns).");
        } else {
            this.console.println("You get no points if you do not build a house,"
                    + "\neat the roast beef, or kill the wolf.");
        }
        if (hasEaten) {
            this.console.println("+1000 Points for eating roast beef.");    
        }
        if (wolfKilled) {
            this.console.println("+2000 Points for killing the wolf.");    
        }
        this.console.println("\nYOUR SCORE IS:  " + result);
     
    }
    
    @Override
    public boolean doAction(String value) {
        return false;  
    }
    
}
