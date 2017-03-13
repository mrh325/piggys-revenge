/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.piggysRevenge.view;

import cit260.piggysRevenge.control.GameControl;
import cit260.piggysRevenge.model.Player;

/**
 *
 * @author hales
 */
public class StartProgramView extends View {


            
    public StartProgramView() {
        super ( "\nPlease enter your name:");
        this.displayBanner();
        
    
    }

    private void displayBanner() {
        System.out.println(
"\n"
+ "\n ................................(~~~~~~~=MM, ......NM~=~~~~~~O......................................."
+ "\n..............................(~~~~~~~~~~~O~ ...II~~~~~~~~~~~O ....................................."
+ "\n.............................(~~~~~~~~~~~~7....+~~~~~~~~~~~~~~O ...................................."
+ "\n.............................(~~~~~~~~~~~~NMMMMD~=~~~~~~~~~~~~O ...................................."
+ "\n.............................O~~~~~~~~~OM=~~~~~~~MZ=~~~~~~~~~O......................................"
+ "\n..............................O~~~~~~M=~~~=N==~~~~~~M~=~~~~~O......................................."
+ "\n ..............................O~~::Z=======~~Z~~=MONM~N=~~O........................................"
+ "\n................................7:Z.:M+======~~O~~=~~ZMM==O........................................."
+ "\n..................................Z..,..,M====M+=+O,...D~M.........................................."
+ "\n.................................Z8........,.MM,,,...,,M==M........................................."
+ "\n................................M~=.,.......,MM,,...,.I~~~~M,......................................."
+ "\n..............................:7~~~+M,..,..,M~~ZM...,M=~~~~~Z. ....................................."
+ "\n.............................M:~~~~~~=NMMMMMMMMMMMMM7~~~~~~~~~M....................................."
+ "\n............................M=~~~~~~MM=~~~~~~~~~~~~~=~MM~~~~~~~M. .................................."
+ "\n...........................N~~~~~~Z$~==================~8?~~~~~~M..................................."
+ "\n.........................+==~~~~~N=+===MMMM~=====MMMN+===~8=~~~~~=:................................."
+ "\n........................M~~~~~~~+~====MMMMMN====MMMMMM+====:~~~~~~~M................................"
+ "\n.......................M~~~~~~~~M=====MMMMMM8+=MMMMMMM=====M~~~~~~~~M..............................."
+ "\n......................N~~~~~~~~=======MDNMMMM==MMMMMMM=====+~~~~~~~~~8.............................."
+ "\n......................?~~~~~~~~M======MMMMMM+==IMMDMMM======M~~~~~~~~7.............................."
+ "\n.....................M~~~~~~~~~M+===~=NMMMMM====MMMMM8======M~~~~~~~~~M............................."
+ "\n....:M...............+~~~~~~~~~~~M8====?MMM======MMM===:==O~~~~~~~~~~~$..............,NO............"
+ "\n...M~~~MZIM.........:=~~~~~~~~~~~:~~MMD+=============?ZM:=::~~~~~~~~~~+..........M=MM~~~$..........."
+ "\n.,MM~~M~~:~M........,==~~~~~~~~~=~~~~~~~~NMMMMMMMMM=~~~:~~::~~~~~~~~~=+.........M~~~~M==ZM.........."
+ "\n.~~~~D~=M~~M.........M==~~~~~~::~~~~~~MMI~~~~~~~~~~IMM~~~=~~~~~~~~~~==M,........M~~D~:M~~~~N........"
+ "\n,M~~~~O~~~~M...$MMM,MM+==~~~~~=~~:M~+~~~~~~~~~~~~~~~~~~~:M=~~~~~~~~===M7,NMMO....=~~~N~~~~M7........"
+ "\n=~~~MM~~~~~~~~~~~~~~~=M======~=M:~~~~~~~~~~~~~~~~~~~~~~~~~~~M=~~+====M=~=~~~~~~~~~~~~~NM=~~~M......."
+ "\nM+~~?~~~~~~~~~~~~~~~~~+M+===+M~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=M?====M=~~~~~~~~~~~~~+~~~M~~:M........"
+ "\n.....NMO.+N=~~~~~~~~~~~=NM======+=========~~=~~~~~~====+==========MD=~~~~~==~~~~~MN.~MM............."
+ "\n............MNMMMM=~~~~~==MM+===================================MN==~~~~~~~MMMMM,..................."
+ "\n................M~~~~~~~~~==+MMM============================MMM===~~~~~~~~~M........................"
+ "\n................8~~~~~~~~~~~=====OMMNMMD7+========+IDMMMMMO=====~~~~~~~~~~~~~......................."
+ "\n...............M~~~~~~~~~~~~~~~~============================~~~~~~~~~~~~~~~~N......................."
+ "\n...............M~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=......................."
+ "\n..............=~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~M......................"
+ "\n..............D~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~M......................"
+ "\n"
+ "\n" +
" _______   ______   ______    ______   __      __  __   ______  \n" +
"|       \\ |      \\ /      \\  /      \\ |  \\    /  \\|  \\ /      \\ \n" +
"| $$$$$$$\\ \\$$$$$$|  $$$$$$\\|  $$$$$$\\ \\$$\\  /  $$| $$|  $$$$$$\\\n" +
"| $$__/ $$  | $$  | $$ __\\$$| $$ __\\$$  \\$$\\/  $$  \\$ | $$___\\$$\n" +
"| $$    $$  | $$  | $$|    \\| $$|    \\   \\$$  $$       \\$$    \\ \n" +
"| $$$$$$$   | $$  | $$ \\$$$$| $$ \\$$$$    \\$$$$        _\\$$$$$$\\\n" +
"| $$       _| $$_ | $$__| $$| $$__| $$    | $$        |  \\__| $$\n" +
"| $$      |   $$ \\ \\$$    $$ \\$$    $$    | $$         \\$$    $$\n" +
" \\$$       \\$$$$$$  \\$$$$$$   \\$$$$$$      \\$$          \\$$$$$$ \n" +
" \n" +
" _______   ________  __     __  ________  __    __   ______   ________ \n" +
"|       \\ |        \\|  \\   |  \\|        \\|  \\  |  \\ /      \\ |        \\\n" +
"| $$$$$$$\\| $$$$$$$$| $$   | $$| $$$$$$$$| $$\\ | $$|  $$$$$$\\| $$$$$$$$\n" +
"| $$__| $$| $$__    | $$   | $$| $$__    | $$$\\| $$| $$ __\\$$| $$__    \n" +
"| $$    $$| $$  \\    \\$$\\ /  $$| $$  \\   | $$$$\\ $$| $$|    \\| $$  \\   \n" +
"| $$$$$$$\\| $$$$$     \\$$\\  $$ | $$$$$   | $$\\$$ $$| $$ \\$$$$| $$$$$   \n" +
"| $$  | $$| $$_____    \\$$ $$  | $$_____ | $$ \\$$$$| $$__| $$| $$_____ \n" +
"| $$  | $$| $$     \\    \\$$$   | $$     \\| $$  \\$$$ \\$$    $$| $$     \\\n" +
" \\$$   \\$$ \\$$$$$$$$     \\$     \\$$$$$$$$ \\$$   \\$$  \\$$$$$$  \\$$$$$$$$"
        
//+ "\n _______   ______   ______    ______   __      __  __   ______         _______   ________  __     __  ________  __    __   ______   ________ "
//+ "\n|       \\ |      \\ /      \\  /      \\ |  \\    /  \\|  \\ /      \\       |       \\ |        \\|  \\   |  \\|        \\|  \\  |  \\ /      \\ |        \\"
//+ "\n| $$$$$$$\\ \\$$$$$$|  $$$$$$\\|  $$$$$$\\ \\$$\\  /  $$| $$|  $$$$$$\\      | $$$$$$$\\| $$$$$$$$| $$   | $$| $$$$$$$$| $$\\ | $$|  $$$$$$\\| $$$$$$$$"
//+ "\n| $$__/ $$  | $$  | $$ __\\$$| $$ __\\$$  \\$$\\/  $$  \\$ | $$___\\$$      | $$__| $$| $$__    | $$   | $$| $$__    | $$$\\| $$| $$ __\\$$| $$__    "
//+ "\n| $$    $$  | $$  | $$|    \\| $$|    \\   \\$$  $$       \\$$    \\       | $$    $$| $$  \\    \\$$\\ /  $$| $$  \\   | $$$$\\ $$| $$|    \\| $$  \\   "
//+ "\n| $$$$$$$   | $$  | $$ \\$$$$| $$ \\$$$$    \\$$$$        _\\$$$$$$\\      | $$$$$$$\\| $$$$$     \\$$\\  $$ | $$$$$   | $$\\$$ $$| $$ \\$$$$| $$$$$   "
//+ "\n| $$       _| $$_ | $$__| $$| $$__| $$    | $$        |  \\__| $$      | $$  | $$| $$_____    \\$$ $$  | $$_____ | $$ \\$$$$| $$__| $$| $$_____ "
//+ "\n| $$      |   $$ \\ \\$$    $$ \\$$    $$    | $$         \\$$    $$      | $$  | $$| $$     \\    \\$$$   | $$     \\| $$  \\$$$ \\$$    $$| $$     \\"
//+ "\n\\$$       \\$$$$$$  \\$$$$$$   \\$$$$$$      \\$$          \\$$$$$$        \\$$   \\$$ \\$$$$$$$$     \\$     \\$$$$$$$$ \\$$   \\$$  \\$$$$$$  \\$$$$$$$$"
+ "\n"
//+ "\n"
//+ "\n"
//+ "“Piggy’s Revenge” is a text adventure game featuring the sometimes-dysfunctional"
//        + "\nfamily of the five-little piggy’s.  "
//+ "\nYou are the little piggy that had no roast beef and you are engaged in a desperate"
//        + "\nsearch through piggy forest for your roast beef.  "
//+ "\nThe roast beef has been mysteriously hidden (you believe that “this little piggy"
//        + "\nstayed home” was, in fact, out hiding your roast beef!)."
//+ "\nTo find and obtain your roast beef, you must find and visit your four siblings."
//        + "\nUpon finding a sibling, you will have to build"
//+ "\nthem a house before you can have your roast beef.  You will collect bricks as you"
//        + "\nexplore which you will use to build your house."
//+ "\nYour score will be higher if you build a larger house.  Once that house is built,"
//        + "\nyou must guess the correct combo to a treasure"
//+ "\nchest to get to your roast beef.  After liberating the roast beef from its "
//        + "\nprison, you will promptly set it on the glorious path to your stomach!\n"
//+ "\n"
//+ "There is only one big problem:  the Big Bad Wolf!  While you search for your roast"
//        + "\nbeef meal, the wolf is searching for"
//+ "\nhis little piggy meal (that’s you, buddy).  In addition to finding the four piggy"
//        + "\nsiblings and your roast beef, you must"
//+ "\navoid being caught by the wolf.  The wolf, however, is in for a surprise, for little"
//        + "\ndoes he know that when you consume roast beef,"
//+ "\nyou gain the strength of 20 (nay 40!!!) little piggy’s.  After consuming your roast"
//        + "\nbeef, you will have a chance to hunt the wolf"
//+ "\nand banish him from piggy forest forever, securing peace, prosperity, and roast"
//        + "\nbeef for the rest of your days."
//+ "\n"
//+ "\n"
//+ "While travelling through the forest, you will find items that will help you on"
//        + "\nyour quest.  Upgraded shoes will speed your journey "
//+ "\nand magic hats will tell you the distance to your siblings, the pantry, or the wolf."
//+ "\n"
//+ "\n"
//+ "When the game ends, you will receive a score based on how big a house you built,"
//        + "\nwhether you successfully ate the roast beef,"
//+ "\nand whether you captured the wolf.  You will lose points for every turn required"
//        + "\nto accomplish this."
);
                                                                                                                                             

                                                                                                                                
                                                                                                                                                              
         }

//    @Override
//    public void display() {
//
//        boolean done = false;
//        do {
//            //prompt for and get playersName
//            String playersName = this.getPlayersName();
//            if (playersName.toUpperCase().equals("Q")) 
//                return;
//        
//            //do request action and display next view
//            done = this.doAction(playersName);
//        
//        } while (!done);
//
//           
//    }
//
//    private String getPlayersName() {
//       
//        Scanner keyboard = new Scanner(System.in); 
//        String value = "";
//        boolean valid = false;
//
//        while (!valid) {
//            System.out.println("\n" + this.promptMessage);
//
//            value = keyboard.nextLine();
//            value = value.trim();
//
//            if (value.length() < 1) {
//                System.out.println("\nInvalid value: value can not be blank");
//                continue;
//}
//        break;
//}
//    return value;
//}
    

    @Override
    public boolean doAction(String playersName) {
        if (playersName.length() < 2){
            System.out.println("\nInvalid player's name: "
                + "The name must be greater than one character in length");
        return false;
}
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) {
            System.out.println("\nError creating the player.");
            return false;
        }
        
         this.displayNextView(player);

        return true;
    }
        
       

    private void displayNextView(Player player) {
        System.out.println("\n================================="
        + "\n Welcome to the game " + player.getName()
        + "\n We hope you have a lot of fun!"
        + "\n=================================");
    
        
    MainMenuView mainMenuView = new MainMenuView();
            
    mainMenuView.display();
    }

}
