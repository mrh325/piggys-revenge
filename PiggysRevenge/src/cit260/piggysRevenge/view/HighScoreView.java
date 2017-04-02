/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import cit260.piggysRevenge.exceptions.GameControlException;
import cit260.piggysRevenge.model.HighScore;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author hales
 */
public class HighScoreView extends View {

    @Override
    public void display() {

        HighScore[] highScores = PiggysRevenge.getCurrentGame().getHighScores();

            this.console.println("\n-----------------------------------------------------"
                    + "\n                    HIGH SCORES                      "
                    + "\n-----------------------------------------------------"
                    + "\n");
            this.console.printf("%n%-7s%15s%10s%20s", "Rank", "Name", "Score", "House Size");
            this.console.printf("%n%-7s%15s%10s%20s", "----", "----", "-----", "----------");
            this.console.println("\n");

            int index = 0;
            for (HighScore hs : highScores) {
                if (hs != null && index < 10) {

                    try {
                        if (hs.getHouse().isCompleted()) {
                            this.console.printf("%n%-7s%15s%10s%20d", Integer.toString(index + 1), hs.getName(), hs.getScore(),
                                    GameControl.calcNumberOfBricks(hs.getHouse().getLength(),
                                            hs.getHouse().getWidth(), hs.getHouse().getHeight(),
                                            hs.getHouse().getStories()));
                        } else {
                            this.console.printf("%n%-7s%15s%10s%20s", Integer.toString(index + 1), hs.getName(), hs.getScore(), "Not built");
                        }
                    } catch (GameControlException ex) {
                        this.console.println(ex.getMessage());
                    }
                }
                index++;
            }
        

    }

    @Override
    public boolean doAction(String input1) {
        return false;
    }

}
