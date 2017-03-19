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
public class FindBuilderView extends View {

    String builderAsciiArt = "\n\nYOU HAVE FOUND THE BUILDER!";
    
    public FindBuilderView() {
        System.out.println(this.builderAsciiArt);
    }

    @Override
    public void display() {
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
        if (unvisitedPiggys > 0) {
            System.out.println("You must find all four piggys before I can work with you."
                    + "\nReturn to me after you have found all four piggys.");
        } else {
            System.out.println("Thank you for finding the piggys.  I can't help you yet"
                    + "\nbecause the programmers haven't finished my progamming.");
        }
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
        System.out.println("\n*** doAction() in FindBuilderView called ***");
        return true;
    }
}