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
class L11View extends View {

    public L11View() {
        super("Hi, I need you to enter any integer.  Letters/Doubles will throw an exception.");
    }

    @Override
    public boolean doAction(String value) {
        try {
            int userInput = Integer.parseInt(value);
            System.out.println("Great!  You entered " + userInput + " which is a single int.");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("\n-----------------------------------------------------------------"
                        + "\nERROR:  I need you to input a single int only.  Thanks."
                        + "\n-----------------------------------------------------------------");
            return false;
        }
    }
    
}
