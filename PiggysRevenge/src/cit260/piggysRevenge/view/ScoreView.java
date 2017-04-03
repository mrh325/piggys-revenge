/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import cit260.piggysRevenge.exceptions.GameControlException;
import cit260.piggysRevenge.model.Game;
import cit260.piggysRevenge.model.HighScore;
import cit260.piggysRevenge.model.House;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
class ScoreView extends View {
    
    private boolean gameOver;

    public ScoreView(boolean gameOver) {
        super("\n-----------------------------------------------------------------"
                + "\nGenerating your possible score... Please enter the following"
                + "\non one line. Separate each value with a space"
                + "\n-----------------------------------------------------------------"
                + "\nHow many bricks will be in your house?"
                + "\nHow many turns will have passed when the game ends?"
                + "\nWill you have eaten the roast beef? (Y or N)"
                + "\nWill you have captured the Wolf? (Y or N)");
    
        this.gameOver = gameOver;
    }
    
    @Override
    public void display() {
        // this.console.println("\n*** display() function called ***");
        Game game = PiggysRevenge.getCurrentGame();
        int bricks = 0;
        House house = game.getHouse();
        if (game.getHouse().isCompleted()) {
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

        if (gameOver) {
            HighScore[] highScores;

            File varTmpDir = new File("highscores.txt");

            if (varTmpDir.exists()) {
                try (FileInputStream fips = new FileInputStream("highscores.txt");
                        ObjectInputStream input = new ObjectInputStream(fips);) {
                    

                    highScores = (HighScore[]) input.readObject();
                    highScores[10] = new HighScore(game.getPlayer().getName(), result, house);

                    for (int n = 0; n < highScores.length; n++) {
                        for (int m = 0; m < highScores.length - 1 - n; m++) {
                            if (highScores[m].getScore() < highScores[m + 1].getScore()
                                    || "---".equals(highScores[m].getName())) {
                                HighScore swapHighScore = highScores[m];
                                highScores[m] = highScores[m + 1];
                                highScores[m + 1] = swapHighScore;
                            }
                        }
                    }

                    try (FileOutputStream fops = new FileOutputStream("highscores.txt");
                            ObjectOutputStream output = new ObjectOutputStream(fops);) {
                        
                        output.writeObject(highScores);
                        this.console.println("Score saved successfully");
                        
                    } catch (Exception e) {
                        ErrorView.display("ScoreView", e.getMessage());
                    }
                } catch (Exception e) {
                    ErrorView.display("ScoreView", e.getMessage());
                }

            } else {
                try (FileOutputStream fops = new FileOutputStream("highscores.txt");
                        ObjectOutputStream output = new ObjectOutputStream(fops);) {
                    

                    highScores = new HighScore[11];
                        for (int i = 0; i < highScores.length; i++){
                        highScores[i] = new HighScore("---", 0, new House(5, 5, 6, 1));
                        
                    }

                    highScores[0] = new HighScore(game.getPlayer().getName(), result, house);
                    output.writeObject(highScores);
                    this.console.println("New highscore file created.  Score saved successfully");
                } catch (Exception e) {
                    ErrorView.display("ScoreView", e.getMessage());
                }

            }
        }
    }

    @Override
    public boolean doAction(String value) {
        return false;
    }

}
