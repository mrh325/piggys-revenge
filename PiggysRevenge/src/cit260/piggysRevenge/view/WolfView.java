/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import java.util.Scanner;
import piggysrevenge.PiggysRevenge;

/**
 *
 * @author natebolton
 */
public class WolfView extends View {

    String wolfAsciiArt = "\n" +
"                       MMMMM.               .                        \n" +
"                        M   .ZM=     MD.. DMMIN                      \n" +
"                        M:MMN.  ?M.:D.MNM  .M==                      \n" +
"                        M = 7 MM. MM .MM MM. N                       \n" +
"                        M M  M.IM    M  MM MM M                      \n" +
"                        .M ZM.          . MM ?O                      \n" +
"                         MMMZ           .  =M.                       \n" +
"                       M            .M.8M,.  MMM                     \n" +
"                        .MM      ,    M:  MDM   M .                  \n" +
"                     .NM     .?IM M  ,  .M8M MM ~+        =MMMM~     \n" +
"                              . M7M. D   M: : ~~M~       M MNOM M    \n" +
"                     M~M.         M.  M. ..M        MM8 M M    M M   \n" +
"                      M DM         MO    :.            :?..M= MM M   \n" +
"                      Z  M Z?        MM MM             .M   ..   M   \n" +
"                        . M,M  M        .:MMMO.M        :M      M?M+ \n" +
"                            =MM M             M         . ,MMMM:.   M\n" +
"                            .   .M  ?MMMM+?.  M            .M       M\n" +
"                              .  N   D      .IM.           8.       M\n" +
"                           .NI MM    D         MM.        +MN   . ~M.\n" +
"                            M +.     .,         . MMMMMMMN   .Z.M    \n" +
"                       .MM7.          M.            D IO      MM     \n" +
"                     MD.              M                        .     \n" +
"                 . M    .ZMM.          M            .                \n" +
"                 M,   $M   M            M         MMM ,MMMZ          \n" +
"              .M$    M   .,             .M       N  .:M.    IM       \n" +
"              MMM      M: M              MMM+.  :. M  .MMD:.IM       \n" +
"             . MMMM      MM              +O   ~MM+  M  M.M.   .      \n" +
"  7M  .?MM      .  MM     M               O      MN:MMD  M           \n" +
"   M.     MZ.        =MM   M.            +M ..  ?    =MM+M           \n" +
" M.         M      .. +D   M              M      M ..D  M            \n" +
" :   .      N,     M ZM    Z               M      .N.                \n" +
"M M  I~      M.    M   MM  M               M                         \n" +
"M:   .M.      M.   M.  M  =N               N                         \n" +
"M     N        MM =D    .M .              M                          \n" +
"       M.           =.. .       ,M       ~Z                          \n" +
"       M              =M.MM      ?      MM+                          \n" +
"       .D            M     M?     M  =MD   M                         \n" +
"        M           M .     M      N  M    ~$                        \n" +
"         MM       ,M        7$     M  O     M                        \n" +
"           8MM..MM          ?$     M  M     M                        \n" +
"                            D      M  M     M                        \n" +
"                           .D     .7 .M     M                        \n" +
"                         . M      M. M      M                        \n" +
"                         I+       M.M.     N.                        \n" +
"                        M,       M :I         ?MMO                   \n" +
"                       M.          ZMMMD          7M                 \n" +
"                     8Z                  OM .  ,M M.M                \n" +
"                    D,                     M   .M M7I                \n" +
"                    ,M.                M  M M                        \n" +
"                       =MMMMMM~+..  .+MMMMMN                         \n" +
"                        .        .                                   \n" +
"                                                                     "
            + "\n\nYOU HAVE ENCOUNTERED THE WOLF!!";
    
    public WolfView() {
        System.out.println(this.wolfAsciiArt);
    }

    @Override
    public void display() {
        try
        {
            Scanner keyIn = new Scanner(System.in);

            System.out.print("Press the enter key to continue");
            keyIn.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }  
        catch(Exception e)
        {}
        if (PiggysRevenge.getPlayer().isHasEaten()) {
            PiggysRevenge.getCurrentGame().setWolfKilled(true);
            System.out.println("You have captured the wolf and rid the forest of"
                    + "\ndanger for the rest of your days.  Great Job!"
                    + "\nBonus points for you!");
        } else {
            System.out.println("Without the superpig strength given to you"
                    + "\nby eating the roast beef, you are overcome by the"
                    + "\nthe wolf and YOU DIE.");            
        }
        //EndGameView endGameView = new EndGameView();
        //endGameView.display();
    }
    
    

    @Override
    public boolean doAction(String value) {
        System.out.println("\n*** doAction() in WolfView called ***");
        return true;
    }
    
}
