/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import cit260.piggysRevenge.model.Game;
import cit260.piggysRevenge.model.Player;
import static java.lang.Math.round;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class GameControl {
    //L06 TEAM ASSIGNMENT
    public static int calcScore(int numberOfBricks, int numberOfTurns, boolean hasEaten, boolean wolfKilled) {
        //bricks can not be less than 0
        if (numberOfBricks < 0) {
            return -1;
        }        
        //turns can not be less than 1
        if (numberOfTurns < 1) {
            return -2;
        }
        //wolf can't be killed if player has not eaten.
        if (hasEaten == false && wolfKilled == true) {
            return -3;
        }

        int currentScore;

        //all score weights subject to change
        currentScore = (numberOfBricks * 10);
        if (hasEaten == true) {
            currentScore = currentScore + 1000;
            if (wolfKilled == true) {
                currentScore = currentScore + 2000;
            }
        }
        if (currentScore == 0) {
            return 0;
        } else {
            return currentScore - (numberOfTurns * 10);
        }
    }
    //L06 MICHAEL HALES INDIVIDUAL ASSIGNMENT
    public static int calcNumberofBricks (int length, int width, int height, int numberOfStories) {
        
        double surfaceAreaPerFloor, surfaceAreaOfRoof;
        
        // Length must be between 5 and 20
        if (length < 5) {
            return -11;
        }
        if (length > 20){
            return -12;
        }
        // Width must be between 6 and 10
        if (width < 5) {
            return -21;
        }
        if (width > 20){
            return -22;
        }
        // Height must be between 1 and 3
        if (height < 6) {
            return -31;
        }
        if (height > 10){
            return -32;
        }
        
        if (numberOfStories <= 0){
            return -41;
        }
        if (numberOfStories > 3){
            return -42;
        }
        
        double l = (double) length;
        double w = (double) width;
        double h = (double) height;
        double n = (double) numberOfStories;
        
        surfaceAreaPerFloor = (l * w) + (2 * l * h) + (2 * w * h);
        surfaceAreaOfRoof = round(((l * (Math.sqrt(Math.pow((w / 2), 2) + Math.pow(h, 2)))
                + (w * (Math.sqrt(Math.pow((l / 2), 2) + Math.pow(h, 2)))))));
        return (int) (((surfaceAreaPerFloor * numberOfStories) + surfaceAreaOfRoof)/4); 
    }

    public static Player createPlayer(String playersName) {
        
        if (playersName == null) {
            return null;
        }
        
        Player player = new Player();
        player.setName(playersName);
        player.setHasEaten(false);
        
        PiggysRevenge.setPlayer(player);
        return player;
    }

    public static void createNewGame(Player player) {
        System.out.println("\n*** createNewGame() function called ***");
        Game game = new Game();
        PiggysRevenge.setCurrentGame(game);
    }
    
}

