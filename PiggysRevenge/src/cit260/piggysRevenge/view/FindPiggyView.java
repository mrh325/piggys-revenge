/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.MapControl;
import cit260.piggysRevenge.model.Map;
import java.awt.Point;
import piggysrevenge.PiggysRevenge;

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
        Point playerCoords = PiggysRevenge.getCurrentGame().getPlayer().getCoordinates();
        Map map = PiggysRevenge.getCurrentGame().getMap();
        Point[] actorPoints = MapControl.getActorPoints(map);
        int unvisitedPiggys = -1; //-1 for builder
        for (Point point : actorPoints) {
            if (map.getLocations()[point.x][point.y].getVisited() == false) {
                unvisitedPiggys++;
            }
        }
        System.out.println("\n\n"
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
                + map.getLocations()[playerCoords.x][playerCoords.y].getActor().getDescription()
                + ".\nThere are still "
                + unvisitedPiggys
                + " Piggys left to find.");
    }
    
    

    @Override
    public boolean doAction(String value) {
        System.out.println("\n*** doAction() in FindPiggyView called ***");
        return true;
    }
}
