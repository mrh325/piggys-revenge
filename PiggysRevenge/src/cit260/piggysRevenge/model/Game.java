/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.model;

import cit260.piggysRevenge.control.GameControl;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author powel
 */
public class Game implements Serializable{
    
    private Map map;
    private int turns;
    private int score;
    private boolean wolfKilled;
    private Player player;
    private House house;
    private Backpack backpack;

    public Game() {
        this.turns = 1;
        this.score = 0;
        this.wolfKilled = false;
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
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.map);
        hash = 97 * hash + this.turns;
        hash = 97 * hash + this.score;
        hash = 97 * hash + Objects.hashCode(this.player);
        hash = 97 * hash + Objects.hashCode(this.house);
        hash = 97 * hash + Objects.hashCode(this.backpack);
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
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.house, other.house)) {
            return false;
        }
        if (!Objects.equals(this.backpack, other.backpack)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "map=" + map + ", turns=" + turns + ", score=" + score + ", player=" + player + ", house=" + house + ", backpack=" + backpack + '}';
    }
    
    
    
}
