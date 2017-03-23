/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import cit260.piggysRevenge.model.Map;
import java.awt.Point;
import java.util.Scanner;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class FindPiggyView extends View {

    String piggyAsciiArt = "\n\nYOU HAVE FOUND A PIGGY!";
    
    public FindPiggyView() {
        this.console.println(this.piggyAsciiArt);
    }

    @Override
    public void display() {
        Point playerCoords = PiggysRevenge.getCurrentGame().getPlayer().getCoordinates();
        Map map = PiggysRevenge.getCurrentGame().getMap();
        Point[] actorPoints = MapControl.getActorPoints(map);
        int unvisitedPiggys = 0;
        for (Point point : actorPoints) {
            if (map.getLocations()[point.x][point.y].getVisited() == false) {
                if (!"Builder".equals(map.getLocations()[point.x][point.y].getActor().name())) {
                    unvisitedPiggys++;
                }
            }
        }
        this.console.println("\n\n"
                + "         ___\n" +
"         ',_`\"\"\\        .---,\n" +
"            \\   :-\"\"``/`    |\n" +
"             `;'     //`\\   /\n" +
"             /   __     |   ('.\n" +
"            |_ ./O)\\     \\  `) \\\n" +
"           _/-.    `      `\"`  |`-.\n" +
"       .-=; `                  /   `-.\n" +
"      /o o \\   ,_,           .        '.\n" +
"      L._._;_.-'           .            `'-.\n" +
"        `'-.`             '                 `'-.\n" +
"            `.         '                        `-._\n" +
"              '-._. -'                              '.\n" +
"                 \\                                    `\\\n" +
"                  |                                     \\\n" +
"                  |    |                                 ;   _.\n" +
"                  \\    |           |                     |-.((\n" +
"                   ;.  \\           /    /                |-.`\\)\n" +
"                   | '. ;         /    |                 |(_) )\n" +
"                   |   \\ \\       /`    |                 ;'--'\n" +
"                    \\   '.\\    /`      |                /\n" +
"                     |   /`|  ;        \\               /\n" +
"                     |  |  |  |-._      '.           .'\n" +
"                     /  |  |  |__.`'---\"_;'-.     .-'\n" +
"                    //__/  /  |    .-'``     _.-'`\n" +
"                          //__/   //___.--''`"
                + "\n\nHello "
                + PiggysRevenge.getCurrentGame().getPlayer().getName()
                + ".  You found me!  I am "
                + map.getLocations()[playerCoords.x][playerCoords.y].getActor().getDescription());
        if (unvisitedPiggys == 0) {
            this.console.println(".\nI was the last piggy to find! The builder will"
                    + "\nnow build the house for you.");
        } else {
            this.console.println(".\nThere are still "
                    + unvisitedPiggys
                    + " Piggys left to find before the builder will build your house.");
        }
        this.pressAnyKeyToContinue();
    }
    
    

    @Override
    public boolean doAction(String value) {
        this.console.println("\n*** doAction() in FindPiggyView called ***");
        return true;
    }
    
    private void pressAnyKeyToContinue() {
        try
        {
            System.out.print("Press the enter key to continue");
            this.keyboard.readLine();
            this.console.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }  
        catch(Exception e)
        {}          
    }
}
