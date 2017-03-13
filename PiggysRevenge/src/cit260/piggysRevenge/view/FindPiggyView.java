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
public class FindPiggyView extends View {

    String piggyAsciiArt = "\n\nYOU HAVE FOUND A PIGGY!";
    
    public FindPiggyView() {
        System.out.println(this.piggyAsciiArt);
    }

    @Override
    public void display() {
        System.out.println("ADD BUILDER DIALOGUE HERE");
    }
    
    

    @Override
    public boolean doAction(String value) {
        System.out.println("\n*** doAction() in FindPiggyView called ***");
        return true;
    }
}
