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
public class FindBuilderView extends View {

    String builderAsciiArt = "\n\nYOU HAVE FOUND THE BUILDER!";
    
    public FindBuilderView() {
        System.out.println(this.builderAsciiArt);
    }

    @Override
    public void display() {
        System.out.println("ADD BUILDER DIALOGUE HERE");
    }    
    

    @Override
    public boolean doAction(String value) {
        System.out.println("\n*** doAction() in FindBuilderView called ***");
        return true;
    }
}