/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import java.util.Scanner;

/**
 *
 * @author natebolton
 */
public class FindBricksView extends View {
    
    String builderAsciiArt = "\n" +
"                            {-)   |\\\n" +
"                       [m,].-\"-.   /\n" +
"      [][__][__]         \\(/\\__/\\)/\n" +
"      [__][__][__][__]~~~~  |  |\n" +
"      [][__][__][__][__][] /   |\n" +
"      [__][__][__][__][__]| /| |\n" +
"      [][__][__][__][__][]| || |  ~~~~\n" +
"      [__][__][__][__][__]__,__,  \\__/"
            + "\n\nYOU HAVE FOUND BRICKS!";
    int bricksFound;

    public FindBricksView(int bricksFound) {
        this.bricksFound = bricksFound;
        this.console.println(builderAsciiArt);
    }

    @Override
    public void display() {
        this.console.println("\nYou found " + this.bricksFound + " bricks.");
        this.pressAnyKeyToContinue();
    }
    
    @Override
    public boolean doAction(String value) {
        this.console.println("\n*** doAction() in FindBricksView called ***");
        return true;
    }

    private void pressAnyKeyToContinue() {
        try
        {
//            Scanner keyIn = new Scanner(System.in);

            System.out.print("Press the enter key to continue");
            this.keyboard.readLine();
            this.console.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }  
        catch(Exception e)
        {}          
    }
}
