/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.model.Location;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class MapView extends View {

    public MapView() {
    }

    @Override
    public void display() {
        
        int columns = PiggysRevenge.getCurrentGame().getMap().getColumnCount();
        //get locations and prep an empty line for string building
        Location[][] locations = PiggysRevenge.getCurrentGame().getMap().getLocations();
        String emptyLine = "";
        for (int i = 1; i < columns*5+10; i++ ) {
            emptyLine += " ";
        }

        //draw the title
        StringBuilder line = new StringBuilder(emptyLine);
        //String mapTitle = "The Far Away Land of Nonsense";
        //this.console.println(mapTitle.length()/2);
        //this.console.println(line.toString().length()/2);
        //line.insert(10, mapTitle);
        //this.console.println(line.toString());

        //draw a line.
        String aLine = "";
        for (int i = 0; i <= columns*5+10; i++ ) {
            aLine += "–";
        }
        this.console.println(aLine);

        //draw column headers
        //line = new StringBuilder(emptyLine);
        char ch = 'A';
        for (int insertPoint = 10; insertPoint <= columns*5+9; insertPoint+=5) {
            line.insert(insertPoint,"| " + ch + " |");
            ch++;
        }
        this.console.println(line.toString());

        //draw the rows
        for (int currentRow = 1; currentRow <= PiggysRevenge.getCurrentGame().getMap().getRowCount(); currentRow++) {
            line = new StringBuilder(emptyLine);
            line.insert(7,Integer.toString(currentRow) + " ");
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                line.insert(10+currentColumn*5,"|" + locations[currentRow-1][currentColumn].getScene().mapSymbol() + "|");
            }
            this.console.println(line.toString());
        }
//            this.console.println("\nCurrent Scence: "
//                    + locations[PiggysRevenge.getCurrentGame().getPlayer().getCoordinates().x][PiggysRevenge.getCurrentGame().getPlayer().getCoordinates().y].getScene().getName());
        this.console.println("\nKEY:  	. Unvisited");
        this.console.println("	# Visited");
        this.console.println("	@ You (" + String.valueOf((char)('A' + PiggysRevenge.getCurrentGame().getPlayer().getCoordinates().y)) + (PiggysRevenge.getCurrentGame().getPlayer().getCoordinates().x+1) + ")");
        this.console.println("	P A Little Piggy");
        this.console.println("	B The Builder");
        
    }
    
    @Override
    public boolean doAction(String value) {
        return true;
    }
    
}
