/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import cit260.piggysRevenge.model.Backpack;
import cit260.piggysRevenge.model.Game;
import cit260.piggysRevenge.model.House;
import cit260.piggysRevenge.model.Item;
import cit260.piggysRevenge.model.Location;
import cit260.piggysRevenge.model.Map;
import cit260.piggysRevenge.model.Player;
import cit260.piggysRevenge.model.Scene;
import cit260.piggysRevenge.model.Wolf;
import java.awt.Point;
import static java.lang.Math.round;
import java.util.Random;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class GameControl {
    //L06 TEAM ASSIGNMENT
    public static int calcScore(int numberOfBricks, int numberOfTurns, boolean hasEaten, boolean wolfKilled) {
        //bricks can not be less than 0
        if (numberOfBricks < 0) {
            return -1;
        }        
        //turns can not be less than 1
        if (numberOfTurns < 1) {
            return -2;
        }
        //wolf can't be killed if player has not eaten.
        if (hasEaten == false && wolfKilled == true) {
            return -3;
        }

        int currentScore;

        //all score weights subject to change
        currentScore = (numberOfBricks * 10);
        if (hasEaten == true) {
            currentScore = currentScore + 1000;
            if (wolfKilled == true) {
                currentScore = currentScore + 2000;
            }
        }
        if (currentScore == 0) {
            return 0;
        } else {
            return currentScore - (numberOfTurns * 10);
        }
    }
    //L06 MICHAEL HALES INDIVIDUAL ASSIGNMENT
    public static int calcNumberOfBricks (int length, int width, int height, int numberOfStories) {
        
        double surfaceAreaPerFloor, surfaceAreaOfRoof;
        
        // Length must be between 5 and 20
        if (length < 5) {
            return -11;
        }
        if (length > 20){
            return -12;
        }
        // Width must be between 5 and 20
        if (width < 5) {
            return -21;
        }
        if (width > 20){
            return -22;
        }
        // Height must be between 6 and 10
        if (height < 6) {
            return -31;
        }
        if (height > 10){
            return -32;
        }
        // Number of Stories must be between 1 and 3
        if (numberOfStories <= 0){
            return -41;
        }
        if (numberOfStories > 3){
            return -42;
        }
        
        double l = (double) length;
        double w = (double) width;
        double h = (double) height;
        double n = (double) numberOfStories;
        
        surfaceAreaPerFloor = (l * w) + (2 * l * h) + (2 * w * h);
        surfaceAreaOfRoof = round(((l * (Math.sqrt(Math.pow((w / 2), 2) + Math.pow(h, 2)))
                + (w * (Math.sqrt(Math.pow((l / 2), 2) + Math.pow(h, 2)))))));
        return (int) (((surfaceAreaPerFloor * numberOfStories) + surfaceAreaOfRoof)/4); 
    }

    public static Player createPlayer(String playersName) {
        
        if (playersName == null) {
            return null;
        }
        
        Player player = new Player();
        player.setName(playersName);
        player.setHasEaten(false);
        
        PiggysRevenge.setPlayer(player);
        return player;
    }

    public static void createNewGame(Player player) {
        //System.out.println("\n*** createNewGame() function called ***");
        if (player == null) {
            System.out.println("\n*** Error:  player is null ***");
        } else {
            Game game = new Game();
            PiggysRevenge.setCurrentGame(game);

            game.setPlayer(player);

            //set map
            game.setHouse(GameControl.createNewHouse());
            game.setBackpack(GameControl.createNewBackpack());

            Map map = MapControl.createMap();
            game.setMap(map);

            //set player's starting coordinates
            Point point = new Point(map.getColumnCount()/2,map.getRowCount()/2);
            player.setCoordinates(point);
            //System.out.println(player.toString());
            
            game.setWolf(GameControl.createNewWolf(map));

            MapControl.moveActorsToStartingLocation(map);
        }
    }

    public static House createNewHouse() {
        //System.out.println("\n*** createNewHouse() function called ***");
        House house = new House(0,0,0,0);
        return house;
    }

    public static Backpack createNewBackpack() {
        //System.out.println("\n*** createNewBackpack() function called ***");
        Backpack backpack = new Backpack(new Item[2][3]);
        return backpack;
    }
    
    public static Wolf createNewWolf(Map map) {
        //System.out.println("\n*** createNewWolf() function called ***");
        //set wolf's starting coordinates
        Wolf wolf = new Wolf();
        //give wolf a random name
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                wolf.setName("Stanley");
                break;
            case 1:
                wolf.setName("Fred");
                break;
            case 2:
                wolf.setName("Thomas");
                break;
            default:
                wolf.setName("Jake");
        }
        Point point = new Point(rand.nextInt(2)*(map.getColumnCount()-1),rand.nextInt(2)*(map.getRowCount()-1));
        wolf.setCoordinates(point);
        Location[][] locations = map.getLocations();
        locations[point.x][point.y].setContainsWolf(true);
        //System.out.println("Wolf coords is:  ");
        //System.out.println(wolf.toString());
        return wolf;
    }

    public static void assignScenesToLocations(Map map, Scene[] scenes) {
        // System.out.println("*** assignScenesToLocations called ***");
        
        Location[][] locations = map.getLocations();
        

        for (int i = 0; i < map.getColumnCount(); i++) {
            for (int j = 0; j < map.getRowCount(); j++) {
                if (i == 3 && j == 3) {
                    locations[i][j].setScene(scenes[0]);
                } else {
                    Random rand = new Random();
                    locations[i][j].setScene(scenes[rand.nextInt(10) + 1]);
                }
            }
        }
        
    }



   
}

