/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author powel
 */
public class Game implements Serializable{
    
    private Map map;
    private int turns;
    private int turnsRemaining;
    private int score;
    private boolean wolfKilled;
    private Player player;
    private Wolf wolf;
    private House house;
    private Backpack backpack;
    private ArrayList<HighScore> highScores;

    public Game() {
        this.turns = 1;
        this.score = 0;
        this.wolfKilled = false;
        this.highScores = new ArrayList<>();
        this.turnsRemaining = -1;
    }
    
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public int getTurnsRemaining() {
        return turnsRemaining;
    }

    public void setTurnsRemaining(int turnsRemaining) {
        this.turnsRemaining = turnsRemaining;
    }
    
    public void incrementTurns() {
        this.turns++;
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isWolfKilled() {
        return wolfKilled;
    }

    public void setWolfKilled(boolean wolfKilled) {
        this.wolfKilled = wolfKilled;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Wolf getWolf() {
        return wolf;
    }

    public void setWolf(Wolf wolf) {
        this.wolf = wolf;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public  Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public ArrayList<HighScore> getHighScores() {
        return highScores;
    }

    public void setHighScores(ArrayList<HighScore> highScores) {
        this.highScores = highScores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.map);
        hash = 29 * hash + this.turns;
        hash = 29 * hash + this.turnsRemaining;
        hash = 29 * hash + this.score;
        hash = 29 * hash + (this.wolfKilled ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.player);
        hash = 29 * hash + Objects.hashCode(this.wolf);
        hash = 29 * hash + Objects.hashCode(this.house);
        hash = 29 * hash + Objects.hashCode(this.backpack);
        hash = 29 * hash + Objects.hashCode(this.highScores);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.turns != other.turns) {
            return false;
        }
        if (this.turnsRemaining != other.turnsRemaining) {
            return false;
        }
        if (this.score != other.score) {
            return false;
        }
        if (this.wolfKilled != other.wolfKilled) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.wolf, other.wolf)) {
            return false;
        }
        if (!Objects.equals(this.house, other.house)) {
            return false;
        }
        if (!Objects.equals(this.backpack, other.backpack)) {
            return false;
        }
        if (!Objects.equals(this.highScores, other.highScores)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "map=" + map + ", turns=" + turns + ", turnsRemaining=" + turnsRemaining + ", score=" + score + ", wolfKilled=" + wolfKilled + ", player=" + player + ", wolf=" + wolf + ", house=" + house + ", backpack=" + backpack + ", highScores=" + highScores + '}';
    }    
        
}
