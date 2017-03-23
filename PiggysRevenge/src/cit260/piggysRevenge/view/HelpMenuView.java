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
class HelpMenuView extends View{


private String menu;
private String menuG;
private String menuH;
private String menuS;
    
    public HelpMenuView() {
        super ("\n"
                + "\n======================================="
                + "\n| Help Menu                           |"
                + "\n======================================="
                + "\nG - (G)ame description"
                + "\nM - How to (M)ove"
                + "\nS - (S)coring"
                + "\nB - (B)ack to the previous menu"
                + "\n=======================================");
        this.menuG = "\n------------------------------------------------------------------------------"
                        +"\nGame Description:"
                        + "\n\n"
                        + "“Piggy’s Revenge” is a text adventure game featuring the sometimes-dysfunctional"
        + "\nfamily of the five-little piggy’s.  "
+ "\nYou are the little piggy that had no roast beef and you are engaged in a desperate"
        + "\nsearch through piggy forest for your roast beef.  "
+ "\nThe roast beef has been mysteriously hidden (you believe that “this little piggy"
        + "\nstayed home” was, in fact, out hiding your roast beef!)."
+ "\nTo find and obtain your roast beef, you must find and visit your four siblings."
        + "\nUpon finding a sibling, you will have to build"
+ "\nthem a house before you can have your roast beef.  You will collect bricks as you"
        + "\nexplore which you will use to build your house."
+ "\nYour score will be higher if you build a larger house.  Once that house is built,"
        + "\nyou must guess the correct combo to a treasure"
+ "\nchest to get to your roast beef.  After liberating the roast beef from its "
        + "\nprison, you will promptly set it on the glorious path to your stomach!\n"
+ "\n"
+ "There is only one big problem:  the Big Bad Wolf!  While you search for your roast"
        + "\nbeef meal, the wolf is searching for"
+ "\nhis little piggy meal (that’s you, buddy).  In addition to finding the four piggy"
        + "\nsiblings and your roast beef, you must"
+ "\navoid being caught by the wolf.  The wolf, however, is in for a surprise, for little"
        + "\ndoes he know that when you consume roast beef,"
+ "\nyou gain the strength of 20 (nay 40!!!) little piggy’s.  After consuming your roast"
        + "\nbeef, you will have a chance to hunt the wolf"
+ "\nand banish him from piggy forest forever, securing peace, prosperity, and roast"
        + "\nbeef for the rest of your days."
+ "\n"
+ "\n"
+ "While travelling through the forest, you will find items that will help you on"
        + "\nyour quest.  Upgraded shoes will speed your journey "
+ "\nand magic hats will tell you the distance to your siblings, the pantry, or the wolf."
+ "\n"
+ "\n"
+ "When the game ends, you will receive a score based on how big a house you built,"
        + "\nwhether you successfully ate the roast beef,"
+ "\nand whether you captured the wolf.  You will lose points for every turn required"
        + "\nto accomplish this."
+"\n------------------------------------------------------------------------------";
        this.menuH = 
"\n------------------------------------------------------------------------------"
                        + "\nHow to move:"
                        + "\n\n"
                        + "To move choose the Move menu, then choose Up, Down, Left or Right."
                        + "\nInvalid moves will not show up."
+"\n------------------------------------------------------------------------------";
        this.menuS =
"\n------------------------------------------------------------------------------"
                         + "\nScoring:"
                         + "\n\n"
                         + "Scoring is based on how big your house is (ie. how many"
                         + "\nbricks were required), plus a bonus for eating"
                         + "\nthe roast beef, plus a bonus for capturing the wolf,"
                         + "\nminus points per turn required to end the gam."
+"\n------------------------------------------------------------------------------";
    }
    
    @Override
    public boolean doAction(String menuOption) {
        // this.console.println("\n*** doAction() function called ***");
        
        menuOption = menuOption.toUpperCase();
        
        switch (menuOption) {
            case "G":
                this.displayGameHelp();
                break;
            case "M":
                this.displayMoveHelp();
                break;
            case "S":
                this.displayScoreHelp();
                break;
            case "B":
            case "Q":
                return true;
            default:
                this.console.println("\n*** Invalid selection *** Try again ***");
                break;
        }
        return false;    
    }
    
    private void displayGameHelp() {
        this.console.println(this.menuG);  //Game Description
    }
    
    private void displayMoveHelp() {
        this.console.println(this.menuH); // Move description
    }
    
    private void displayScoreHelp() {
        this.console.println(this.menuS); // Score description
    }
} 

