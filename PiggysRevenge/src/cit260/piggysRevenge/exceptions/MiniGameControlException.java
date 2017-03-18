/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.exceptions;

/**
 *
 * @author natebolton
 */
public class MiniGameControlException extends Exception {
    
    public MiniGameControlException() {
    }
    
    public MiniGameControlException(String message) {
        super(message);
    }

    public MiniGameControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public MiniGameControlException(Throwable cause) {
        super(cause);
    }

    public MiniGameControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }    
    
}