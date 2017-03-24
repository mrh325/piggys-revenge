/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.control;

import cit260.piggysRevenge.exceptions.GameControlException;
import cit260.piggysRevenge.model.Backpack;
import cit260.piggysRevenge.model.Game;
import cit260.piggysRevenge.model.House;
import cit260.piggysRevenge.model.Item;
import cit260.piggysRevenge.model.ItemType;
import cit260.piggysRevenge.model.Location;
import cit260.piggysRevenge.model.Map;
import cit260.piggysRevenge.model.Player;
import cit260.piggysRevenge.model.Scene;
import cit260.piggysRevenge.model.Wolf;
import cit260.piggysRevenge.view.ErrorView;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Math.round;
import java.util.Random;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class GameControl {
    //L06 TEAM ASSIGNMENT
    public static int calcScore(int numberOfBricks, int numberOfTurns, boolean hasEaten, boolean wolfKilled) throws GameControlException {
        //bricks can not be less than 0
        if (numberOfBricks < 0) {
            throw new GameControlException("The number of bricks cannot be negative.");
        }        
        //turns can not be less than 1
        if (numberOfTurns < 0) {
            throw new GameControlException("The number of turns must be greater than -1.");
        }
        //wolf can't be killed if player has not eaten.
        if (hasEaten == false && wolfKilled == true) {
            throw new GameControlException("You cannot face the mighty wolf without the magic roast beef.");
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
    public static int calcNumberOfBricks (int length, int width, int height, int numberOfStories) throws GameControlException {
        
        double surfaceAreaPerFloor, surfaceAreaOfRoof;
        
        // Length must be between 5 and 20
        if (length < 5) {
            throw new GameControlException("The length must be greater than 4.");
        }
        if (length > 20){
            throw new GameControlException("The length must be less than 21.");
        }
        // Width must be between 5 and 20
        if (width < 5) {
            throw new GameControlException("The width must be greater than 4.");
        }
        if (width > 20){
            throw new GameControlException("The length must be less than 21.");
        }
        // Height must be between 6 and 10
        if (height < 6) {
            throw new GameControlException("The height must be greater than 5.");
        }
        if (height > 10){
            throw new GameControlException("The height must be less than 11.");
        }
        // Number of Stories must be between 1 and 3
        if (numberOfStories <= 0){
            throw new GameControlException("The number of stories must be greater than 0.");
        }
        if (numberOfStories > 3){
            throw new GameControlException("The number of stories must be less than 4.");
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
        //this.console.println("\n*** createNewGame() function called ***");
        if (player == null) {
            ErrorView.display(GameControl.class.getName(), "Player is null.");
                    
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
            //this.console.println(player.toString());
            
            game.setWolf(GameControl.createNewWolf(map));

            MapControl.moveActorsToStartingLocation(map);
            Item[] items = createItems(map);
            MapControl.moveItemsToStartingLocation(map,items);
            MapControl.seedBricks(map);
        }
    }

    public static House createNewHouse() {
        //this.console.println("\n*** createNewHouse() function called ***");
        House house = new House(0,0,0,0);
        return house;
    }

    public static Backpack createNewBackpack() {
        //this.console.println("\n*** createNewBackpack() function called ***");
        Backpack backpack = new Backpack(new Item[2][3]);
        return backpack;
    }
    
    public static Wolf createNewWolf(Map map) {
        //this.console.println("\n*** createNewWolf() function called ***");
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
        //this.console.println("Wolf coords is:  ");
        //this.console.println(wolf.toString());
        return wolf;
    }

    private static Item[] createItems(Map map) {
        // this.console.println("*** Scene function called***");
        //we need to create as many scenes as there are map locations
        //int totalMapLocations = map.getColumnCount() * map.getRowCount();
        Item[] items = new Item[ItemType.values().length];
        int i = 0;
        for (Item item : items) {
            item = new Item();
            item.setName(ItemType.values()[i].getName());
            item.setDescription(ItemType.values()[i].getDescription());
            item.setItemType(ItemType.values()[i].getType());
            items[i] = item;
            i++;
        }
        return items;
    }
    
    public static void assignScenesToLocations(Map map, Scene[] scenes) {

        Location[][] locations = map.getLocations();
        
        for (int i = 0; i < map.getColumnCount(); i++) {
            for (int j = 0; j < map.getRowCount(); j++) {
//                if (i == 3 && j == 3) {
//                    locations[i][j].setScene(scenes[0]);
//                    locations[i][j].setVisited(Boolean.TRUE);
//                } else {
                if (scenes[i*map.getRowCount()+j] == null) {
                    ErrorView.display(GameControl.class.getName(), Integer.toString(i*map.getRowCount()+j));
                    ErrorView.display(GameControl.class.getName(), scenes[i*map.getRowCount()+j].toString());   
                }
                locations[i][j].setScene(scenes[(i*map.getRowCount()+j)]);
//                }
            }
        }
        
    }

    public static void saveGame(Game currentGame, String filePath) throws GameControlException, FileNotFoundException, IOException {
        
        try ( FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(currentGame);
        }
        catch(Exception e){
                throw new GameControlException("Save Game Error " + e.getMessage());
        }
    }

    public static void getSavedGame(String filePath) throws GameControlException {
        Game game = null;
        
        try( FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject();
        }
        catch(Exception e) {
            throw new GameControlException("Load Game Error " + e.getMessage());
        }
        PiggysRevenge.setCurrentGame(game);
        
    }

}

