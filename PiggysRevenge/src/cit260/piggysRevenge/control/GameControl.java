/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

/**
 *
 * @author natebolton
 */
public class GameControl {

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
}
