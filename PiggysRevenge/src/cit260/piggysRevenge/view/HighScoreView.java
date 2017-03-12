/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.model.HighScore;
import java.util.ArrayList;
import java.util.Arrays;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author hales
 */
public class HighScoreView extends View {
         
    
    @Override
    public void display() {
            
        ArrayList<HighScore> highScores = PiggysRevenge.getCurrentGame().getHighScores();
        System.out.println(highScores);
        for (int n = 0; n < highScores.size(); n++) {
            for (int m = 0; m < highScores.size() - 1 - n; m++) {
                if (highScores.get(m).getScore() < highScores.get(m + 1).getScore()) {
                    HighScore swapHighScore = highScores.get(m);
                    highScores.set(m,highScores.get(m + 1));
                    highScores.set(m + 1,swapHighScore);
                }
            }
        }
        
//        System.out.println(highScores);


          System.out.println("\n-------------------------------------------"
                + "\n               HIGH SCORES                 "
                + "\n-------------------------------------------"
                + "\n"
                + "\nName           Score             House Size"
                + "\n----           -----             ----------"
                + "\n");
          
//       int index = 0;
//       for (HighScore : highScores) {
//           line = new StringBuilder("                                         ");
//           Actor value = MapControl.getActorFromPoint(point,PiggysRevenge.getCurrentGame().getMap());
//           if (value == null) {
//               line.insert(0, Integer.toString(index+1) + ":  Wolf");
//           } else {
//               line.insert(0, Integer.toString(index+1) + ":  " + value);
//           }
//           line.insert(20, distances[index]);
//           System.out.println(line.toString());
//           index++;
    }

    @Override
    public boolean doAction(String input1) {
        return false;
    }

}

