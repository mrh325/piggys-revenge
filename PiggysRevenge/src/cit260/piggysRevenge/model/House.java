/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.model;

/**
 *
 * @author natebolton
 */
public class House {
    
    private int length;
    private int width;
    private int height;
    private int stories;

    public House(int length, int width, int height, int stories) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.stories = stories;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStories() {
        return stories;
    }

    public void setStories(int stories) {
        this.stories = stories;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.length;
        hash = 31 * hash + this.width;
        hash = 31 * hash + this.height;
        hash = 31 * hash + this.stories;
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
        final House other = (House) obj;
        if (this.length != other.length) {
            return false;
        }
        if (this.width != other.width) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        if (this.stories != other.stories) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "House{" + "length=" + length + ", width=" + width + ", height=" + height + ", stories=" + stories + '}';
    }
    
}
