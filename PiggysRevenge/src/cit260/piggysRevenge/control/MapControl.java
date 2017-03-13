/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import cit260.piggysRevenge.model.Actor;
import cit260.piggysRevenge.model.Location;
import cit260.piggysRevenge.model.SceneType;
import cit260.piggysRevenge.model.Map;
import cit260.piggysRevenge.model.Scene;
import java.awt.Point;
import java.util.Random;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class MapControl {
    //L06 BOLTON INDIVIDUAL ASSIGNMENT
    public static double calculateEventProbability(double visitedScenes, double totalScenes, double visitedEvents, double totalEvents) {

        if (visitedScenes < 1 || totalScenes < 2 || visitedEvents < 0 || totalEvents < 1) {
            return -1;
        }
        if (visitedScenes > totalScenes) {
            return -2;
        }
        if (visitedEvents > totalEvents) {
            return -3;
        }
        if (totalScenes > 100) {
            return -4;
        }
        if (totalEvents > 5) {
            return -5;
        }
        if ((totalScenes - visitedScenes) < (totalEvents - visitedEvents)) {
            return -6;
        }

        //avoid division by zero
        if (totalScenes - visitedScenes == totalEvents - visitedEvents) {
            return 100.0;
        }

        double probability = 1.0;

        //loop through a range from 0 to the number of unvisited events, calculating probability for discovering/visiting one event per turn until all events are visited
        for ( double i=0; i < totalEvents - visitedEvents; i++) {
            double a = totalEvents - visitedEvents - i;
            double b = totalScenes - visitedScenes - i;
            probability *= a/b;
        }
        
        //round and multiply by 100 to get percent
        probability *= 1000;
        probability = (double)Math.round(probability);
        probability /= 10.0;
        return probability;

    }


    //L06 INDIVIDUAL ASSIGNMENT ZAC POWELL
    public static double calcDistance(double startPositionX, double startPositionY, double endPositionX, double endPositionY){
        
        if (startPositionX < 0 || endPositionX < 0 || startPositionY < 0 || endPositionY < 0){
                return -1;
        }
        int maxColumns = PiggysRevenge.getCurrentGame().getMap().getColumnCount();
        int maxRows = PiggysRevenge.getCurrentGame().getMap().getRowCount();
        if (startPositionX > maxColumns || startPositionY > maxRows || endPositionX > maxColumns || endPositionY > maxRows){
                return -2;
        }

        return Math.sqrt( (startPositionX - endPositionX) * (startPositionX - endPositionX) + (startPositionY-endPositionY) * (startPositionY-endPositionY) );

    }

    public static Map createMap() {
        // System.out.println("*** createMap() called ***");
        
        Map map = new Map(7, 7); //set map size here
        
        Scene[] scenes = createScenes(map);
        
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
    }

    private static Scene[] createScenes(Map map) {
        // System.out.println("*** Scene function called***");
        //we need to create as many scenes as there are map locations
        int totalMapLocations = map.getColumnCount()*map.getRowCount();
        Scene[] scenes = new Scene[totalMapLocations];
        
        int loop = 0;
        int i = 0;
        while (true) {
            if (i==totalMapLocations) {
                break;
            }
            Scene randomScene = new Scene();
            randomScene.setName("The desert");
            randomScene.setDescription("\nYou are in the middle of barren, lifeless desert."
                    + "\nWater lost to evaporation and transpiration here"
                    + "\nexceeds the amount of precipitation...");
            randomScene.setMapSymbol(" . ");
            scenes[SceneType.desert.ordinal()+(10*loop)] = randomScene;
            i++;

            if (i==totalMapLocations) {
                break;
            }
            randomScene = new Scene();
            randomScene.setName("The forest");
            randomScene.setDescription("\nYou are in a busy, dense forest.");
            randomScene.setMapSymbol(" . ");
            scenes[SceneType.forest.ordinal()+(10*loop)] = randomScene;
            i++;

            if (i==totalMapLocations) {
                break;
            }
            randomScene = new Scene();
            randomScene.setName("The Old Mill");
            randomScene.setDescription("\nYou are at the old mill.  Rumor is there may"
                    + "\nbe gold buried in the foundation...");
            randomScene.setMapSymbol(" . ");
            scenes[SceneType.mill.ordinal()+(10*loop)] = randomScene;
            i++;

            if (i==totalMapLocations) {
                break;
            }
            randomScene = new Scene();
            randomScene.setName("The grassy field");
            randomScene.setDescription("\nYou are in huge field of grass.");
            randomScene.setMapSymbol(" . ");
            scenes[SceneType.grassyField.ordinal()+(10*loop)] = randomScene;
            i++;

            if (i==totalMapLocations) {
                break;
            }
            randomScene = new Scene();
            randomScene.setName("The valley");
            randomScene.setDescription("\nYou are in a millenia old valley carved by ancient glaciers.");
            randomScene.setMapSymbol(" . ");
            scenes[SceneType.valley.ordinal()+(10*loop)] = randomScene;
            i++;

            if (i==totalMapLocations) {
                break;
            }
            randomScene = new Scene();
            randomScene.setName("The river");
            randomScene.setDescription("\nYou are at the edge of a swift and violent river.");
            randomScene.setMapSymbol(" . ");
            scenes[SceneType.river.ordinal()+(10*loop)] = randomScene;
            i++;

            if (i==totalMapLocations) {
                break;
            }
            randomScene = new Scene();
            randomScene.setName("The rocky cliffs");
            randomScene.setDescription("\nYou are at the rocky cliffs, hundreds of feet above the cliff floors."
                    + "\nDon't fall off.");
            randomScene.setMapSymbol(" . ");
            scenes[SceneType.rockyCliffs.ordinal()+(10*loop)] = randomScene;
            i++;

            if (i==totalMapLocations) {
                break;
            }
            randomScene = new Scene();
            randomScene.setName("The frozen tundra");
            randomScene.setDescription("\nYou are at the frozen tundra, with reindeer, and ice...");
            randomScene.setMapSymbol(" . ");
            scenes[SceneType.frozenTundra.ordinal()+(10*loop)] = randomScene;
            i++;

            if (i==totalMapLocations) {
                break;
            }
            randomScene = new Scene();
            randomScene.setName("The beach");
            randomScene.setDescription("\nYou are the beach!  Relax.");
            randomScene.setMapSymbol(" . ");
            scenes[SceneType.beach.ordinal()+(10*loop)] = randomScene;
            i++;

            if (i==totalMapLocations) {
                break;
            }
            randomScene = new Scene();
            randomScene.setName("The ancient canyons");
            randomScene.setDescription("\nYou are deep down in the canyons.  The ancients made their homes here.");
            randomScene.setMapSymbol(" . ");
            scenes[SceneType.canyons.ordinal()+(10*loop)] = randomScene;
            i++;
            loop++;
        }
        //Randomize the scenes
        // Scramble the array elements using the standard Fisher-Yates shuffle, 
        Random rand = new Random();
        for(i=0; i<scenes.length; i++) {
            int j = rand.nextInt(scenes.length);
            // Swap letters
            Scene temp = scenes[i];
            scenes[i] = scenes[j];
            scenes[j] = temp;
        }
        //finally, set the first scene as the start scene
        Scene startingScene = new Scene();
        startingScene.setName("Starting Scene");
        startingScene.setDescription("\nYay, you're at the beginning");
        startingScene.setMapSymbol(" @ ");
        scenes[totalMapLocations/2] = startingScene;
        
        //System.out.println(Arrays.toString(scenes));
        return scenes;
    }

    static void moveActorsToStartingLocation(Map map) {
        // System.out.println("*** assignScenesToLocations called ***");
        //pick random, unique locations for actors and assign the actor to those locations.
        Location[][] locations = map.getLocations();
        Point[] tempPoints = new Point[Actor.values().length];

        Point point;
        int columns = map.getColumnCount();
        int rows = map.getRowCount();
        //for each of the actors in Actor...
        for (int i = 0; i < tempPoints.length; i++) {
            point = returnEmptyActorLocation(columns,rows,tempPoints);
            
            //if unique, add to the temp array for checking later points
            tempPoints[i] = point;
            //and assign the next actor in the Actor class to the chosen location.
            locations[point.x][point.y].setActor(Actor.values()[i]);
            //System.out.println("adding " + Actor.values()[i] + " to " + point.x + "," + point.y);
        }
    }

    private static Point returnEmptyActorLocation(int columns,int rows,Point[] tempPoints) {
        boolean pickNewLocation;
        int point1, point2;
        Random rand = new Random();
        Point point = null;
        do {
            pickNewLocation = true;
            //pick a random column
            point1 = rand.nextInt(columns);
            //pick a random row
            point2 = rand.nextInt(rows);
            if (point1 != 3 && point2 != 3) {
            //create a point if not 3,3
                point = new Point(point1,point2);

                //check to make sure the point is unique
                for (Point temp : tempPoints) {
//                    System.out.println("temp and point:");
//                    System.out.println(temp);
//                    System.out.println(point);
                    if (temp==null) {
                        pickNewLocation = false;
                        break;
                    } else if (temp.equals(point)) {
//                        System.out.println("SAME POINT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                        System.out.println(point);
                        pickNewLocation = true;
                        break;
                    } else {
                        pickNewLocation = false;
                    }
                }
            }
        } while (pickNewLocation);
        return point;
    }
    
    public static Point[] getActorPoints(Map map) {
         //System.out.println("*** getActorPoints called ***");
         //create array to save actor points
         Point[] actorPoints = new Point[Actor.values().length];
         //get the map locations
//         System.out.println("All Actors:  ");
         
         Location[][] locations = map.getLocations();
         int nextIndex = 0;
         //go through each location to find the actors
         for (Location[] array1 : locations) {
            for (Location location : array1) {
//                System.out.println(location.getActor());
                //if the location has an actor
                if (location.getActor() != null) {
                    //store the actor's coordinates as a point in the point array
                    Point point = new Point(location.getColumn(),location.getRow());
                    actorPoints[nextIndex] = point;
                    nextIndex++;
                }
            }
         }
         if (nextIndex != Actor.values().length) {
             System.out.println("ERROR:  not enough points in getActorPoints()");
         }
         //System.out.println("ActorPoints:  ");
         //System.out.println(Arrays.toString(actorPoints)); //testing
         return actorPoints;
    }
    
    public static String[] getActorNames(Map map) {
         //System.out.println("*** getActorPoints called ***");
         //create array to save actor points
         String[] actorNames = new String[Actor.values().length];
         //get the map locations
//         System.out.println("All Actors:  ");
         
         Location[][] locations = map.getLocations();
         int nextIndex = 0;
         //go through each location to find the actors
         for (Location[] array1 : locations) {
            for (Location location : array1) {
//                System.out.println(location.getActor());
                //if the location has an actor
                if (location.getActor() != null) {
                    //store the actor's coordinates as a point in the point array
                    String name = location.getActor().name();
                    actorNames[nextIndex] = name;
                    nextIndex++;
                }
            }
         }
         if (nextIndex != Actor.values().length) {
             System.out.println("ERROR:  not enough names in getActorNames()");
         }
         //System.out.println("ActorPoints:  ");
         //System.out.println(Arrays.toString(actorPoints)); //testing
         return actorNames;
    }
    
//    public static Actor getActorFromPoint(Point point, Map map) {
//        Location[][] locations = map.getLocations();
////        System.out.println(point.x);
////        System.out.println(point.y);
////        System.out.println(locations[point.x][point.y]);
//        try {
//            return locations[point.x][point.y].getActor();
//        } catch (NullPointerException e) {
//            return null;
//        }
//    }

    public static void movePlayer(Point playerLoc,String dir) {
        //System.out.println("*** movePlayer() called ***");
        Location[][] locations = PiggysRevenge.getCurrentGame().getMap().getLocations();
        switch (dir) {
            case "left":
                if (playerLoc.y == 0) {
                    System.out.println("*** ERROR: Player Can't Move Left ***");
                } else {
                    if (locations[playerLoc.x][playerLoc.y].getActor() == null) {
                        locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" # ");
                    } else {
                        if ("Builder".equals(locations[playerLoc.x][playerLoc.y].getActor().name())) {
                            locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" B ");
                        } else {
                            locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" P ");
                        }
                    }
                    playerLoc.y -= 1;
                }
                break;
            case "right":
                if (playerLoc.y == 6) {
                    System.out.println("*** ERROR: Player Can't Move Right ***");
                } else {
                    if (locations[playerLoc.x][playerLoc.y].getActor() == null) {
                        locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" # ");
                    } else {
                        if ("Builder".equals(locations[playerLoc.x][playerLoc.y].getActor().name())) {
                            locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" B ");
                        } else {
                            locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" P ");
                        }
                    }
                    playerLoc.y += 1;
                }
                break;
            case "up":
                if (playerLoc.x == 0) {
                    System.out.println("*** ERROR: Player Can't Move Up ***");
                } else {
                    if (locations[playerLoc.x][playerLoc.y].getActor() == null) {
                        locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" # ");
                    } else {
                        if ("Builder".equals(locations[playerLoc.x][playerLoc.y].getActor().name())) {
                            locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" B ");
                        } else {
                            locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" P ");
                        }
                    }
                    playerLoc.x -= 1;
                }
                break;
            case "down":
                if (playerLoc.x == 6) {
                    System.out.println("*** ERROR: Player Can't Move Down ***");
                } else {
                    if (locations[playerLoc.x][playerLoc.y].getActor() == null) {
                        locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" # ");
                    } else {
                        if ("Builder".equals(locations[playerLoc.x][playerLoc.y].getActor().name())) {
                            locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" B ");
                        } else {
                            locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" P ");
                        }
                    }
                    playerLoc.x += 1;
                }
                break;
        }
        PiggysRevenge.getCurrentGame().getPlayer().setCoordinates(playerLoc);
        locations[playerLoc.x][playerLoc.y].setVisited(Boolean.TRUE);
        locations[playerLoc.x][playerLoc.y].getScene().setMapSymbol(" @ ");
        PiggysRevenge.getCurrentGame().incrementTurns();
    }
    
    public static void moveWolf(Point wolfLoc) {
        //wolf move up/down or left right at random
        //also checks for map boundaries, then moves one direction or the other
        //totally random at this point, to make it harder, compare wolfLoc to playerLoc
        //and make wolf move toward player, or limit directions based on playerLoc, etc.
        Random rand = new Random();
        if (rand.nextBoolean()) {
            switch (wolfLoc.y) {
                case 0:
                    wolfLoc.y++;
                    break;
                case 6:
                    wolfLoc.y--;
                    break;
                default:
                    if (rand.nextBoolean()) {
                        wolfLoc.y++;
                    } else {
                        wolfLoc.y--;
                    }   break;
            }
        } else {
            switch (wolfLoc.x) {
                case 0:
                    wolfLoc.x++;
                    break;
                case 6:
                    wolfLoc.x--;
                    break;
                default:
                    if (rand.nextBoolean()) {
                        wolfLoc.x++;
                    } else {
                        wolfLoc.x--;
                    }   break;
            }
        }
        PiggysRevenge.getCurrentGame().getWolf().setCoordinates(wolfLoc);
    }
    
        public static void drawMap() {
            int columns = PiggysRevenge.getCurrentGame().getMap().getColumnCount();
            //get locations and prep an empty line for string building
            Location[][] locations = PiggysRevenge.getCurrentGame().getMap().getLocations();
            String emptyLine = "";
            for (int i = 1; i < columns*5+10; i++ ) {
                emptyLine += " ";
            }

            //draw the title
            StringBuilder line = new StringBuilder(emptyLine);
            String mapTitle = "The Far Away Land of Nonsense";
            //System.out.println(mapTitle.length()/2);
            //System.out.println(line.toString().length()/2);
            line.insert(10, mapTitle);
            System.out.println(line.toString());

            //draw a line.
            String aLine = "";
            for (int i = 0; i <= columns*5+10; i++ ) {
                aLine += "–";
            }
            System.out.println(aLine);

            //draw column headers
            line = new StringBuilder(emptyLine);
            char ch = 'A';
            for (int insertPoint = 10; insertPoint <= columns*5+9; insertPoint+=5) {
                line.insert(insertPoint,"| " + ch + " |");
                ch++;
            }
            System.out.println(line.toString());

            //draw the rows
            for (int currentRow = 1; currentRow <= PiggysRevenge.getCurrentGame().getMap().getRowCount(); currentRow++) {
                line = new StringBuilder(emptyLine);
                line.insert(7,Integer.toString(currentRow) + " ");
                for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                    line.insert(10+currentColumn*5,"|" + locations[currentRow-1][currentColumn].getScene().mapSymbol() + "|");
                }
                System.out.println(line.toString());
            }
            System.out.println("\nKEY:  	. Unvisited");
            System.out.println("	# Visited");
            System.out.println("	@ You (" + String.valueOf((char)('A' + PiggysRevenge.getCurrentGame().getPlayer().getCoordinates().y)) + (PiggysRevenge.getCurrentGame().getPlayer().getCoordinates().x+1) + ")"); //add location later
            System.out.println("	P A Little Piggy");
            System.out.println("	B The Builder");
        }

}