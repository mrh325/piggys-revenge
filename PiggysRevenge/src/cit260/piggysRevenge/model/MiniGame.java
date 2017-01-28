/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.model;

import java.io.Serializable;

/**
 *
 * @author powel
 */
public class MiniGame implements Serializable{
    
    private int key1order;
    private int key2order;
    private int key3order;
    private int key4order;

    public MiniGame() {
    }
    
    

    public int getKey1order() {
        return key1order;
    }

    public void setKey1order(int key1order) {
        this.key1order = key1order;
    }

    public int getKey2order() {
        return key2order;
    }

    public void setKey2order(int key2order) {
        this.key2order = key2order;
    }

    public int getKey3order() {
        return key3order;
    }

    public void setKey3order(int key3order) {
        this.key3order = key3order;
    }

    public int getKey4order() {
        return key4order;
    }

    public void setKey4order(int key4order) {
        this.key4order = key4order;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.key1order;
        hash = 97 * hash + this.key2order;
        hash = 97 * hash + this.key3order;
        hash = 97 * hash + this.key4order;
        return hash;
    }

    @Override
    public String toString() {
        return "MiniGame{" + "key1order=" + key1order + ", key2order=" + key2order + ", key3order=" + key3order + ", key4order=" + key4order + '}';
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
        final MiniGame other = (MiniGame) obj;
        if (this.key1order != other.key1order) {
            return false;
        }
        if (this.key2order != other.key2order) {
            return false;
        }
        if (this.key3order != other.key3order) {
            return false;
        }
        if (this.key4order != other.key4order) {
            return false;
        }
        return true;
    }
    
    
    
    
}
