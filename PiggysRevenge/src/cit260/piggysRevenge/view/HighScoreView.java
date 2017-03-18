/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import cit260.piggysRevenge.exceptions.GameControlException;
import cit260.piggysRevenge.model.HighScore;
import java.util.ArrayList;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author hales
 */
public class HighScoreView extends View {
         
    
    @Override
    public void display() {
            
        ArrayList<HighScore> highScores = PiggysRevenge.getCurrentGame().getHighScores();

        for (int n = 0; n < highScores.size(); n++) {
            for (int m = 0; m < highScores.size() - 1 - n; m++) {
                if (highScores.get(m).getScore() < highScores.get(m + 1).getScore()) {
                    HighScore swapHighScore = highScores.get(m);
                    highScores.set(m,highScores.get(m + 1));
                    highScores.set(m + 1,swapHighScore);
                }
            }
        }
        
          System.out.println("\n-------------------------------------------"
                + "\n               HIGH SCORES                 "
                + "\n-------------------------------------------"
                + "\n"
                + "\nName           Score             House Size"
                + "\n----           -----             ----------"
                + "\n");
          
       int index = 0;
       for (HighScore hs : highScores) {

            try {
                System.out.println(hs.getName() + "        " + hs.getScore() + "            "
                        + GameControl.calcNumberOfBricks(hs.getHouse().getLength(),
                                hs.getHouse().getWidth(), hs.getHouse().getHeight(),
                                hs.getHouse().getStories()));
            } catch (GameControlException ex) {
                System.out.println(ex.getMessage());
            }



           index++;
       }
    }

    @Override
    public boolean doAction(String input1) {
        return false;
    }

}

