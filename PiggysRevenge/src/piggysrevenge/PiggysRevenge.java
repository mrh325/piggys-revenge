/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piggysrevenge;

import cit260.piggysRevenge.model.*;
import cit260.piggysRevenge.control.*;
import cit260.piggysRevenge.view.*;
/**
 *
 * @author hales
 */
public class PiggysRevenge {

//    public static void teamAssignment() {
//        System.out.println("\nTEAM SECTION");
//        System.out.println("*********************\n");
//        Player playerOne = new Player();
//        
//        playerOne.setName("Bob");
//        playerOne.setDistanceToWolf(2);
//        playerOne.setDistanceToPantry(3);
//        playerOne.setDistanceToNearestKey(5);
//        playerOne.setHasEaten(true);
//        
//        String playerInfo = playerOne.toString();
//        System.out.println(playerInfo);
//        
//        System.out.println(GameControl.calcScore(250,35,true,false));
//    }
//    
//    public static void nateBoltonAssignment() {
//        System.out.println("\nNATE SECTION");
//        System.out.println("*********************\n");
//        Backpack myBackpack = new Backpack();
//        
//        myBackpack.setName("Green Backpack");
//        myBackpack.setItemList("Hat1, Hat2, Shoes1");
//        
//        System.out.println(myBackpack.toString());
//        
//        Item myItem = new Item();
//        
//        myItem.setName("key1");
//        myItem.setDescription("This is the first of four keys required to unlock the pantry.");
//        myItem.setItemType("key");
//        myItem.setMovementBonus(0);
//        
//        System.out.println(myItem.toString());
//        
//        Hat myHat = new Hat();
//        
//        myHat.setTargetScene("Empty Scene");
//        
//        System.out.println(myHat.toString());
//        
//        //test miniGameControl functions here
//        //changed MiniGameControl, this code is obsolete
//        //String myString = MiniGameControl.generateComboOrder("Stack Overflow is a community of 6.7 million programmers, just like you, helping each other. Join them; it only takes a minute:",1L);
//        //System.out.println(myString);
//
//        System.out.println(MiniGameControl.checkKeyOrder("54231", "12345"));
//        
//        //quick test prob function
//        System.out.println(MapControl.calculateEventProbability(16, 25, 3, 5));
//        
//    }
//    
//    public static void zacPowellAssignment(){
//        System.out.println("\nZAC SECTION");
//        System.out.println("*********************\n");
//        MiniGame playMiniGame = new MiniGame();
//        
//        playMiniGame.setComboOrder("1234");
//        
//        System.out.println(playMiniGame.toString());
//        
//        Game playGame = new Game();
//        
//        playGame.setTurns(0);
//        playGame.setScore(0);
//        playGame.setMap("myMap");
//        //playGame.setPlayer("Player"); //Game no longer handles player
//        
//        System.out.println(playGame.toString());
//        
//        Wolf myWolf = new Wolf();
//        
//        
//        myWolf.setName("Zeke");
//        
//        System.out.println(myWolf.toString());
//        
//    }
//    
//    public static void michaelHalesAssignment() {
//        System.out.println("\nMICHAEL SECTION");
//        System.out.println("*********************\n");
//        // Scene class
//        
//        Scene currentScene = new Scene();
//        
//        currentScene.setName("Man Cave");
//        currentScene.setDescription("Best room in the house");
//        currentScene.setContainsWolf(false);
//        
//        System.out.println(currentScene.toString());
//        
//        // Map Class
//        
//        Map gameMap = new Map();
//        
//        gameMap.setRowCount(5);
//        gameMap.setColumnCount(5);
//        gameMap.setCurrentPlayerLocation("B2");
//        gameMap.setCurrentWolfLocation("C4");
//        gameMap.setCurrentRow(3);
//        gameMap.setCurrentColumn(2);
//        gameMap.setCurrentScene(currentScene);
//        
//        System.out.println(gameMap.toString());
//        
//        // Location class
//        
//        Location currentLocation = new Location();
//        
//        currentLocation.setColumn("D");
//        currentLocation.setRow("3");
//        currentLocation.setVisited(true);
//        
//        System.out.println(currentLocation.toString());
//        
//    }
    /**
     * @param args the command line arguments
     */
    private static Game currentGame = null;
    private static Player player = null;
    private static House house = null;
    private static Backpack backpack = null;
    
    public static void main(String[] args) {

        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        PiggysRevenge.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        PiggysRevenge.player = player;
    }

    public static House getHouse() {
        return house;
    }

    public static void setHouse(House house) {
        PiggysRevenge.house = house;
    }

    public static Backpack getBackpack() {
        return backpack;
    }

    public static void setBackpack(Backpack backpack) {
        PiggysRevenge.backpack = backpack;
    }

}
