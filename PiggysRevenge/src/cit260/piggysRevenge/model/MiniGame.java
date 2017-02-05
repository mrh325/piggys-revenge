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
public class MiniGame implements Serializable{
    
    private String comboOrder;


    public MiniGame() {
    }
    
    public String getComboOrder() {
        return comboOrder;
    }

    public void setComboOrder(String comboOrder) {
        this.comboOrder = comboOrder;
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.comboOrder);
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
        final MiniGame other = (MiniGame) obj;
        if (!Objects.equals(this.comboOrder, other.comboOrder)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MiniGame{" + "comboOrder=" + comboOrder + '}';
    }
    
    
    
}
