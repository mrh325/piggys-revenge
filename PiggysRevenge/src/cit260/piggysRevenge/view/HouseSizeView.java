/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

/**
 *
 * @author hales
 */
class HouseSizeView {
    private Integer length;
    private Integer width;
    private Integer height;
    private Integer stories;
    private String promptIntro;
    
    public HouseSizeView() {
        this.promptIntro = "\n"
                + "\n============================="
                + "\n| House Size View            |"
                + "\n=============================";
                
    }

    
    void getInputs() {
        System.out.println("\n"
        + "Please enter the length of the house you will be constructing (between 5 and 20): ");
        
        
    }
    
}
