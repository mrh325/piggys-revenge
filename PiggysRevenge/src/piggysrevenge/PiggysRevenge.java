/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piggysrevenge;

import cit260.piggysRevenge.model.Backpack;
import cit260.piggysRevenge.model.Game;
import cit260.piggysRevenge.model.Player;
import cit260.piggysRevenge.model.Item;
import cit260.piggysRevenge.model.Hat;
import cit260.piggysRevenge.model.MiniGame;
import cit260.piggysRevenge.model.Wolf;
import cit260.piggysRevenge.model.Location;
import cit260.piggysRevenge.model.Map;
import cit260.piggysRevenge.model.Scene;

/**
 *
 * @author hales
 */
public class PiggysRevenge {

    public static void teamAssignment() {
        Player playerOne = new Player();
        
        playerOne.setName("Bob");
        playerOne.setDistanceToWolf(2);
        playerOne.setDistanceToPantry(3);
        playerOne.setDistanceToNearestKey(5);
        playerOne.setHasEaten(true);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
    public static void nateBoltonAssignment() {
        Backpack myBackpack = new Backpack();
        
        myBackpack.setName("Green Backpack");
        myBackpack.setItemList("Hat1, Hat2, Shoes1");
        
        System.out.println(myBackpack.toString());
        
        Item myItem = new Item();
        
        myItem.setName("key1");
        myItem.setDescription("This is the first of four keys required to unlock the pantry.");
        myItem.setItemType("key");
        myItem.setMovementBonus(0);
        
        System.out.println(myItem.toString());
        
        Hat myHat = new Hat();
        
        myHat.setTargetScene("Empty Scene");
        
        System.out.println(myHat.toString());
    }
    
    public static void zacPowellAssignment(){
        MiniGame playMiniGame = new MiniGame();
        
        playMiniGame.setKey1order(1);
        playMiniGame.setKey2order(2);
        playMiniGame.setKey3order(3);
        playMiniGame.setKey4order(4);
        
        System.out.println(playMiniGame.toString());
        
        Game playGame = new Game();
        
        playGame.setTurns(0);
        playGame.setScore(0);
        playGame.setMap("myMap");
        playGame.setPlayer("Player");
        
        System.out.println(playGame.toString());
        
        Wolf myWolf = new Wolf();
        
        
        myWolf.setName("Zeke");
        
        System.out.println(myWolf.toString());
    }
    
    public static void michaelHalesAssignment() {
        
        // Scene class
        
        Scene currentScene = new Scene();
        
        currentScene.setName("Man Cave");
        currentScene.setDescription("Best room in the house");
        currentScene.setContainsWolf(false);
        
        System.out.println(currentScene.toString());
        
        // Map Class
        
        Map gameMap = new Map();
        
        gameMap.setRowCount(5);
        gameMap.setColumnCount(5);
        gameMap.setCurrentPlayerLocation("B2");
        gameMap.setCurrentWolfLocation("C4");
        gameMap.setCurrentRow(3);
        gameMap.setCurrentColumn(2);
        gameMap.setCurrentScene(currentScene);
        
        System.out.println(gameMap.toString());
        
        // Location class
        
        Location currentLocation = new Location();
        
        currentLocation.setColumn("D");
        currentLocation.setRow("3");
        currentLocation.setVisited(true);
        
        System.out.println(currentLocation.toString());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        teamAssignment();
        nateBoltonAssignment();
        zacPowellAssignment();
        michaelHalesAssignment();
    }
    
}
