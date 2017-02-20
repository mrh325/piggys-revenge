/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author powel
 */
public class Game implements Serializable{
    
    private String map;
    //private String player; //player seems to be handled in PiggysRevenge class
    private int turns;
    private double score;

    public Game() {
    }
    
    

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    /*public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }*/

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.map);
        //hash = 53 * hash + Objects.hashCode(this.player);
        hash = 53 * hash + this.turns;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "map=" + map + ", turns=" + turns + ", score=" + score + '}';
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
        if (Double.doubleToLongBits(this.score) != Double.doubleToLongBits(other.score)) {
            return false;
        }
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        return true;
    }
    
}
