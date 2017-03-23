/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import java.io.PrintWriter;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author hales
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = PiggysRevenge.getOutFile();
    private static final PrintWriter logFile = PiggysRevenge.getLogFile();
    
    public static void display(String className, String errorMessage){
        
        errorFile.println(
            "-----------------------------------------------------------------"
            + "\n- ERROR - " + errorMessage
            + "\n-----------------------------------------------------------------");
        
        logFile.println(className + " - " + errorMessage);
    }
    
}
