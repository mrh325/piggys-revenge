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
 * @author hales
 */
public class Map implements Serializable {
    
    private Integer rowCount;
    private Integer columnCount;
    private String currentPlayerLocation;
    private String currentWolfLocation;

    public Map() {
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public Integer getColumnCount() {
        return columnCount;
    }

    public String getCurrentPlayerLocation() {
        return currentPlayerLocation;
    }

    public String getCurrentWolfLocation() {
        return currentWolfLocation;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    public void setCurrentPlayerLocation(String currentPlayerLocation) {
        this.currentPlayerLocation = currentPlayerLocation;
    }

    public void setCurrentWolfLocation(String currentWolfLocation) {
        this.currentWolfLocation = currentWolfLocation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.rowCount);
        hash = 37 * hash + Objects.hashCode(this.columnCount);
        hash = 37 * hash + Objects.hashCode(this.currentPlayerLocation);
        hash = 37 * hash + Objects.hashCode(this.currentWolfLocation);
        return hash;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + ", currentPlayerLocation=" + currentPlayerLocation + ", currentWolfLocation=" + currentWolfLocation + '}';
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
        final Map other = (Map) obj;
        if (!Objects.equals(this.rowCount, other.rowCount)) {
            return false;
        }
        if (!Objects.equals(this.columnCount, other.columnCount)) {
            return false;
        }
        if (!Objects.equals(this.currentPlayerLocation, other.currentPlayerLocation)) {
            return false;
        }
        if (!Objects.equals(this.currentWolfLocation, other.currentWolfLocation)) {
            return false;
        }
        return true;
    }
    
    
    
}
