/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

/**
 *
 * @author natebolton
 */
class EndGameView {

    void display() {
        System.out.println("\nGAME OVER");
        ScoreView scoreView = new ScoreView();
        scoreView.display();
        System.out.println("\nThank you for playing.  The game will now exit.");
        System.exit(0);
    }
    
}
