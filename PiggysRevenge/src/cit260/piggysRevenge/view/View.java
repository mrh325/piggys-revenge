/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author hales
 */
public abstract class View implements ViewInterface {

    protected String displayMessage;

    protected final BufferedReader keyboard = PiggysRevenge.getInFile();
    protected final PrintWriter console = PiggysRevenge.getOutFile();

    public View() {
    }

    public View(String message) {
        this.displayMessage = message;
    }

    @Override
    public void display() {
        // this.console.println("\n*** display() function called ***");
        boolean done = false;
        do {
            // this.console.println(this.menu);
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) {
                return;
            }

            done = this.doAction(value);

        } while (!done);

    }

    @Override
    public String getInput() {

        String value = "";
        boolean valid = false;

        try {
            while (!valid) {
                this.console.println("\n" + this.displayMessage);

                value = this.keyboard.readLine();
                value = value.trim();

                if (value.length() < 1) {
                    this.console.println("\n-----------------------------------------------------------------"
                            + "\nInvalid input. Please re-enter your input."
                            + "\n-----------------------------------------------------------------");
                    continue;

                }
                break;
            }
        } catch (IOException ex) {
             this.console.println("ERROR in View - " + ex.getMessage());
        }
        return value;
    }

}
