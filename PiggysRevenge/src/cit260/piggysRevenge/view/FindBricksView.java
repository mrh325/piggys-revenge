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
        System.out.println(builderAsciiArt);
    }

    @Override
    public void display() {
        System.out.println("\nYou found " + this.bricksFound + " bricks.");
        System.out.println("Press enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }
    
    @Override
    public boolean doAction(String value) {
        System.out.println("\n*** doAction() in FindBricksView called ***");
        return true;
    }
    
}
