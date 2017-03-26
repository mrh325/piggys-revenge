/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.model.Location;
import java.awt.Point;
import java.io.IOException;
import java.io.PrintWriter;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
class MapReportView extends View {

    public MapReportView() {
        super("Please enter the filename where this map report will be printed:");
    }

    @Override
    public boolean doAction(String value) {

        try {
            this.saveMapReportToFile(value);
            this.console.println("\nYour map report was successfully saved to " + value);
        } catch (Exception e) {
            ErrorView.display("MapReportView - Save Map Report - ", e.getMessage());
        }
        return true;
    }

    private void saveMapReportToFile(String filePath) {

        try (PrintWriter out = new PrintWriter(filePath)) {
            out.printf("%n%-102s","MAP REPORT");
            out.printf("%n%-102s","Note: Use of this report to obtain outrageously high scores is strictly prohibited!");
            out.printf("%n%n%-10s%20s%15s%35s%5s%7s%10s","Coordinate","Scene","Actor","Item","Wolf","Player","Visited");
            out.printf("%n%-10s%20s%15s%35s%5s%7s%10s","----------","-----","-----","----","----","------","-------");
            Location[][] locations = PiggysRevenge.getCurrentGame().getMap().getLocations();
            for (Location[] locationX : locations) {
                for (Location locationY : locationX) {
                    String wolfThere = "No";
                    Point wolfLoc = PiggysRevenge.getCurrentGame().getWolf().getCoordinates();
                    if (wolfLoc.x == locationY.getColumn() && wolfLoc.y == locationY.getRow()) {
                        wolfThere = "Yes";
                    }
                    String playerThere = "No";
                    Point playerLoc = PiggysRevenge.getCurrentGame().getPlayer().getCoordinates();
                    if (playerLoc.x == locationY.getColumn() && playerLoc.y == locationY.getRow()) {
                        playerThere = "Yes";
                    }
                    String actorThere = "None";
                    if (locationY.getActor() != null) {
                        actorThere = locationY.getActor().name();
                    }
                    String itemThere = "None";
                    if (locationY.getItem() != null) {
                        itemThere = locationY.getItem().getName();
                    }
                    char ch = 'A';
                    ch = (char) (ch + locationY.getRow());
                    String visitedThere = "No";
                    if (locationY.getVisited()) {
                        visitedThere = "Yes";
                    }
                    out.printf("%n%-10s%20s%15s%35s%5s%7s%10s", ch + Integer.toString(locationY.getColumn()+1)
                            ,locationY.getScene().getName()
                            ,actorThere
                            ,itemThere
                            ,wolfThere
                            ,playerThere
                            ,visitedThere
                    );
                    out.printf("%n%102s", "------------------------------------------------------------------------------------------------------");
                }
            }
        } catch (IOException e) {
            ErrorView.display("in saveMapReportToFile - ", e.getMessage());
        }
    }

}
