/**
 * Created by Rebecca Burke and Mark Campbell
 * The program below is the welcome window for our gaming console. It's a class which allows us to amalgamate
 * and display each of the games within our project. Its main functionality includes welcoming the users, providing
 * them with a selection of games, giving the user some background on each game and executing each game.
 **/

// Importing the necessary libraries
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;//for importing pictures

public class WelcomeWindowV6

{  //importing image icons
   public static ImageIcon smile = new ImageIcon("partyFace.jpeg");
   public static ImageIcon smile1 = new ImageIcon("smile1.png");
   public static ImageIcon think = new ImageIcon("thinking.jpeg");
   public static ImageIcon well = new ImageIcon("continue.jpeg");
   // Declaring the scanner class which will allow us to read and use the users input for testing
   static Scanner keyboard = new Scanner(System.in);

   // Declaring the necessary variables for the class
   // Declaring the variable gameSelection which will store the users choice of game
   private static int gameSelection;
   // Declaring a boolean variable invalid which will be used in do-while loops to prevent the user from moving
   // forward until their entry is valid.
   static boolean invalid = true;
   // Declaring the back option variable which will allow the user to revert back to the welcome window
   static int backOption;

   // Declaring a method which will welcome the user to the gaming application
   private static void welcome(){
      // Welcoming the user to the game application
      JOptionPane.showMessageDialog(null, "Welcome to Divoc Gaming\n","Divoc Gaming",
            JOptionPane.INFORMATION_MESSAGE,smile);
      // Giving a brief description of the application
      JOptionPane.showMessageDialog(null, "Divoc is a console which allows \nyou to play " +
            "drinking games with your \nfriends virtually and safely.","Divoc Gaming",
            JOptionPane.INFORMATION_MESSAGE,smile1);
   }//Method: Welcome


   // Declaring a method which will provide the user with the gaming options available and allow them to make their
   // selection.
   private static void options(){

      // Declaring a do-while loop which will prevent the user from moving forward until their entry is valid
      do
      {
         // Resetting the invalid variable
         invalid = true;

         // Declaring a try-catch statement to prevent the user from entering anything other than the numbers
         // 1, 2, 3, 4, 5 or 6
         try
         {
            // Reading the users entry from the JOptionPane and storing it in the gameSelection variable.
            gameSelection = Integer.parseInt(JOptionPane.showInputDialog(null,
                  "Divoc Gaming supports the games\n" +
                        "1.) BattleShots 2.0\n" +
                        "2.) Most Likely\n" +
                        "3.) Straight Face\n" +
                        "4.) Truth or Drink\n" +
                        "5.) Surprise me!\n" +
                        "6.) Exit\n" +
                        "Please select a game by entering the number\n " +
                        "associated with your chosen game from the menu above.",
                  "Game options", JOptionPane.INFORMATION_MESSAGE));//Question for amount of rounds
            // Declaring an if statement which checks if the entry is one of the menu options and marks it as
            // valid if it is.
            if (Arrays.asList(1,2,3,4,5,6).contains(gameSelection)){
               // Setting the invalid variable to false only if game Selection in list.
               invalid = false;
            };//if
         }//try
         catch (Exception entryError)
         {
            // Informing the user that the system doesn't accept a non-numeric format at this stage and asking them
            // to re-enter.
            JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n"+
                  "Please enter a number from the options provided.","Divoc Gaming",
                  JOptionPane.INFORMATION_MESSAGE,well);
         }//catch

      } while (invalid == true); //do-while: gameSelection

   }// Method: options


   public static void main(String[] args)
   {
      // Calling the welcome method to welcome the user to the application.
      welcome();
      // Calling the gaming options and prompting the user to make their selection.
      options();

      // Setting up a terminator for the following while loop
      String terminator = "play";

      // Declaring a while loop which allows the user to play multiple games/rounds back to back
      while (terminator != "exit")
      {
         // Declaring a switch statement which will call the game that the user has chosen to play
         switch (gameSelection)
         {
            // Calling Mark's game
            case 1:
               // Informing the user that they have selected BattleShots 2.0 and providing them with
               // a brief description of the game.
               ImageIcon ship1 = new ImageIcon("battleship1.jpeg");//image for battleships
               JOptionPane.showMessageDialog(null, "BattleShots 2.0\n" +
                     "In BattleShots2.0 you pick a letter and\na number and find out whats in" +
                     " the box .\nThe player with the most points at the end is the winner\n" +
                           "look out for the Jackpot\nGood luck!!!",
                     "Instructions", JOptionPane.INFORMATION_MESSAGE,ship1);

               // Resetting the invalid variable
               invalid = true;

               // Declaring a do-while loop to prevent the user from moving on until their entry is valid
               do
               {
                  // Declaring a try-catch statement to prevent the user from entering anything other than
                  // the numbers 1 and 2
                  try
                  {
                     // Asking the user if they want to continue with their game selection
                     backOption = Integer.parseInt(JOptionPane.showInputDialog(null,
                           "Would you like to continue with this game?\n" +
                           "Please press 1 to enter the game and 2 to go back to the user menu.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE));

                     // Declaring an if statement which compares the user entry with the list
                     // of acceptable entries
                     if (Arrays.asList(1,2).contains(backOption)){

                        // Setting the invalid variable to false only if backOption is in the list.
                        invalid = false;
                     };//if
                  }//try
                  catch (Exception entryError)
                  {
                     // Informing the user that the game cannot  accept a non-numeric format at this stage.
                     JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n" +
                           "Please enter a number.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,well);
                  }//catch

               } while (invalid == true);//do-while

               // Declaring a switch statement which will run the users selection
               switch (backOption)
               {
                  // If the user selects 1 they will enter the BattleShots 2.0 game
                  case 1:
                     // Informing the user that they are entering BattleShots 2.0
                     JOptionPane.showMessageDialog(null, "You've chosen to enter BattleShots 2.0","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,smile1);
                     BattleShots2 battleshots = new BattleShots2();
                     battleshots.battleshotsStart();
                     break;
                  //If the user selects 2 the will return to the main gaming menu.
                  case 2:
                     // Informing the user that they are returning to the games menu.
                     JOptionPane.showMessageDialog(null, "You've chosen to return to the main menu.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,well);
                     break;
                  default:
                     // Declaring a default message which informs the user that their selection is out of range
                     JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n" +
                           "Please select either 1 to continue or 2 to go back.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,well);
                     break;
               }// inner switch: BattleShots 2.0

               // Calling the options method to bring the user back to the main gaming menu and asking if they
               // wish to select another game
               options();
               break;
// --------------------------------------------------------------------------------------------------------------------
            // Calling Rachel's game to play
            case 2:
               // Informing the user that they have selected Rachel's game and providing them with
               // a brief description of the game.
               ImageIcon embarrassed = new ImageIcon("embarrassed.jpeg");
               JOptionPane.showMessageDialog(null, "Most Likely\n" + "This game consists of " +
                     "9 rounds.\nPlease select a different number from the board for each round.\nEach number " +
                     "represents a round.  \nYou must all vote " +
                     "for one player", "Game Instructions", JOptionPane.INFORMATION_MESSAGE,embarrassed);


               // Resetting the invalid variable to true
               invalid = true;

               // Declaring a do-while loop to prevent the user from moving on until their entry is valid
               do
               {
                  // Declaring a try-catch statement to prevent the user from entering anything other than
                  // the numbers 1 and 2
                  try
                  {
                     // Asking the user if they want to continue with their game selection
                     backOption = Integer.parseInt(JOptionPane.showInputDialog(null,
                           "Would you like to continue with this game?\n" +
                           "Please press 1 to enter the game and 2 to go back to the user menu.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE));

                     // Declaring an if statement which compares the user entry with the list
                     // of acceptable entries
                     if (Arrays.asList(1,2).contains(backOption)){

                        // Setting the invalid variable to false only if backOption is in the list.
                        invalid = false;
                     };//if
                  }//try
                  catch (Exception entryError)
                  {
                     // Informing the user that the game cannot  accept a non-numeric format at this stage.
                     JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n" +
                           "Please enter a number.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,well);
                  }//catch

               } while (invalid == true);//do-while

               // Declaring a switch statement which will run the users selection
               switch (backOption)
               {
                  // If the user selects 1 they will enter the Rachel's game
                  case 1:
                     // Informing the user that they are entering Rachel's game
                     JOptionPane.showMessageDialog(null, "You've chosen to play Most Likely",
                           "Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,smile);
                     MostLikely callGame = new MostLikely();
                     callGame.playMostLikely();


                     break;
                  //If the user selects 2 the will return to the main gaming menu.
                  case 2:
                     // Informing the user that they are returning to the games menu.
                     JOptionPane.showMessageDialog(null, "You've chosen to return to the" +
                           " main menu.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,well);
                     break;
                  default:
                     // Declaring a default message which informs the user that their selection is out of range
                     JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n" +
                           "Please select either 1 to continue or 2 to go back.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,well);
                     break;
               }// inner switch: Rachel's game

               // Calling the options method to bring the user back to the main gaming menu and asking if they
               // wish to select another game
               options();
               break;
// --------------------------------------------------------------------------------------------------------------------
            // Calling Seong's game
            case 3:
               // Informing the user that they have selected Seong's game and providing them with
               // a brief description of the game.
               ImageIcon laugh = new ImageIcon("laugh.jpeg");
               JOptionPane.showMessageDialog(null, "Straight Face\n" + "In this game you" +
                     "must\nkeep a straight face no matter what\ncomes up on the screen","Divoc Gaming",
                     JOptionPane.INFORMATION_MESSAGE,laugh);

               // Resetting the invalid variable to true
               invalid = true;

               // Declaring a do-while loop to prevent the user from moving on until their entry is valid
               do
               {
                  // Declaring a try-catch statement to prevent the user from entering anything other than
                  // the numbers 1 and 2
                  try
                  {
                     // Asking the user if they want to continue with their game selection
                     backOption = Integer.parseInt(JOptionPane.showInputDialog(null,
                           "Would you like to continue with this game?\n" +
                           "Please press 1 to enter the game and 2 to go back to the user menu."
                           ,"Divoc Gaming", JOptionPane.INFORMATION_MESSAGE));

                     // Declaring an if statement which compares the user entry with the list
                     // of acceptable entries
                     if (Arrays.asList(1,2).contains(backOption)){

                        // Setting the invalid variable to false only if backOption is in the list.
                        invalid = false;
                     };//if
                  }//try
                  catch (Exception entryError)
                  {
                     // Informing the user that the game cannot  accept a non-numeric format at this stage.
                     JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n" +
                           "Please enter a number.","Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,think);
                  }//catch

               } while (invalid == true);//do-while

               // Declaring a switch statement which will run the users selection
               switch (backOption)
               {
                  // If the user selects 1 they will enter the Seong's game
                  case 1:
                     // Informing the user that they are entering Seong's game
                     JOptionPane.showMessageDialog(null, "You've chosen to " +
                                 "enter Straight Face","Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,smile);

                        StraightFace startgame = new StraightFace();
                        startgame.plqyStraightFace();

                     break;
                  //If the user selects 2 the will return to the main gaming menu.
                  case 2:
                     // Informing the user that they are returning to the games menu.
                     JOptionPane.showMessageDialog(null, "You've chosen to return to" +
                           " the main menu.","Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,well);
                     break;
                  default:
                     // Declaring a default message which informs the user that their selection is out of range
                     JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n" +
                           "Please select either 1 to continue or 2 to go back.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,well);
                     break;

               }// inner switch: Seong's game

               // Calling the options method to bring the user back to the main gaming menu and asking if they
               // wish to select another game
               options();
               break;
// --------------------------------------------------------------------------------------------------------------------
            // Calling the truth or drink game to play
            case 4:
               // Informing the user that they have selected Truth or Drink and providing them with
               // a brief description of the game.
               ImageIcon shock = new ImageIcon("shock.jpeg");
               JOptionPane.showMessageDialog(null, "Truth or Drink\n" +
                     "In this game you will be provided with a number of questions to which you are expected to\n" +
                     "answer truthfully. If you do not wish to answer the question you may forfeit by taking a drink."
                     ,"Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,shock);

               // Resetting the invalid variable to true
               invalid = true;

               // Declaring a do-while loop to prevent the user from moving on until their entry is valid
               do
               {
                  // Declaring a try-catch statement to prevent the user from entering anything other than
                  // the numbers 1 and 2
                  try
                  {
                     // Asking the user if they want to continue with their game selection
                     backOption = Integer.parseInt(JOptionPane.showInputDialog(null,
                           "Would you like to continue with this game?\n" +
                           "Please press 1 to enter the game and 2 to go back to the user menu."
                           ,"Divoc Gaming", JOptionPane.INFORMATION_MESSAGE));

                     // Declaring an if statement which compares the user entry with the list
                     // of acceptable entries
                     if (Arrays.asList(1,2).contains(backOption)){

                        // Setting the invalid variable to false only if backOption is in the list.
                        invalid = false;
                     };//if
                  }//try
                  catch (Exception entryError)
                  {
                     // Informing the user that the game cannot  accept a non-numeric format at this stage.
                     JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n" +
                           "Please enter a number.","Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,well);
                  }//catch

               } while (invalid == true);//do-while

               // Declaring a switch statement which will run the users selection
               switch (backOption)
               {
                  // If the user selects 1 they will enter the Truth or Drink game
                  case 1:
                     // Informing the user that they are entering Truth or Drink
                     JOptionPane.showMessageDialog(null, "You've chosen to enter " +
                           "the Truth or Drink game","Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,smile1);

                     // Calling the runGame method from the TruthOrDrinkV9 class
                     TruthOrDrinkV9.runGame();
                     break;
                  //If the user selects 2 the will return to the main gaming menu.
                  case 2:
                     // Informing the user that they are returning to the games menu.
                     JOptionPane.showMessageDialog(null, "You've chosen to " +
                           "return to the main menu.","Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,well);
                     break;
                  default:
                     // Declaring a default message which informs the user that their selection is out of range
                     JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n" +
                           "Please select either 1 to continue or 2 to go back.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,well);
                     break;
               }// inner switch: backOption TruthOrDrinkV9

               // Calling the options method to bring the user back to the main gaming menu and asking if they
               // wish to select another game
               options();
               break;
            // Randomly selecting one of the games for the users to play
            case 5:
               /// Informing the user that they have selected surprise me and providing them with
               // a brief description of the game.
               JOptionPane.showMessageDialog(null, "You have chosen to play 'Surprise me!'.\n"+
                     "We will randomly select a game for you to play.","Divoc Gaming",
                     JOptionPane.INFORMATION_MESSAGE,smile);

               // Resetting the invalid variable to true
               invalid = true;

               // Declaring a do-while loop to prevent the user from moving on until their entry is valid
               do
               {
                  // Declaring a try-catch statement to prevent the user from entering anything other than
                  // the numbers 1 and 2
                  try
                  {
                     // Asking the user if they want to continue with their game selection
                     backOption = Integer.parseInt(JOptionPane.showInputDialog(null,
                           "Would you like to continue with this option?\n" +
                           "Please press 1 to enter the game and 2 to go back to the user menu."
                           ,"Divoc Gaming", JOptionPane.INFORMATION_MESSAGE));

                     // Declaring an if statement which compares the user entry with the list
                     // of acceptable entries
                     if (Arrays.asList(1,2).contains(backOption)){

                        // Setting the invalid variable to false only if backOption is in the list.
                        invalid = false;
                     };//if
                  }//try
                  catch (Exception entryError)
                  {
                     // Informing the user that the game cannot  accept a non-numeric format at this stage.
                     JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n" +
                           "Please enter a number.","Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,well);
                  }//catch

               } while (invalid == true);//do

               // Declaring a switch statement which will run the users selection
               switch (backOption)
               {
                  // If the user selects 1 they will enter surprise me
                  case 1:
                     // Informing the user that they are entering BattleShots 2.0
                     JOptionPane.showMessageDialog(null, "You've chosen to a Surprise"
                           ,"Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,smile1);

                     // Declaring an array list containing the game options
                     ArrayList<String> gamesAvailable = new ArrayList<String>();

                     // adding the game options to the array list
                     gamesAvailable.add("Battleshots 2.0");
                     gamesAvailable.add("Most likely");
                     gamesAvailable.add("Straight Face");
                     gamesAvailable.add("Truth or Drink");

                     // Declaring randomSelect as an instance of Random
                     Random randomSelect = new Random();

                     // Randomly selecting a game using randomSelect
                     int gameSelected = randomSelect.nextInt(gamesAvailable.size());

                     // Displaying the selected game to the screen
                     JOptionPane.showMessageDialog(null, "We've chosen...\n"+
                           gamesAvailable.get(gameSelected),"Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,smile);

                     // Accessing the game that has been randomly selected
                     // If the first element in the array list has been selected then we want to play Mark's game
                     if (gameSelected == 0)
                     {
                        gameSelection = 1;
                     }
                     // If the second element in the array list has been selected then we want to play Rachel's game
                     else if (gameSelected == 1)
                     {
                        gameSelection = 2;
                     }
                     // If the third element in the array list has been selected then we want to play Seong's game
                     else if (gameSelected == 2)
                     {
                        gameSelection = 3;
                     }
                     // Else we want to play Rebecca's game
                     else
                     {
                        gameSelection = 4;
                     }

                     break;
                  //If the user selects 2 the will return to the main gaming menu.
                  case 2:
                     // Informing the user that they are returning to the games menu.
                     JOptionPane.showMessageDialog(null, "You've chosen to return to the main" +
                           " menu.","Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,well);
                     // Calling the options method to bring the user back to the main gaming menu and asking if they
                     // wish to select another game
                     options();
                     break;
                  default:
                     // Declaring a default message which informs the user that their selection is out of range
                     JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n" +
                           "Please select either 1 to continue or 2 to go back.","Divoc Gaming",
                           JOptionPane.INFORMATION_MESSAGE,well);
                     // Calling the options method to bring the user back to the main gaming menu and asking if they
                     // wish to select another game
                     options();
                     break;
               }// inner switch: Surprise me


               break;
// --------------------------------------------------------------------------------------------------------------------
            // Exiting the system
            case 6:
               ImageIcon bye = new ImageIcon("bye.jpeg");
               // Informing the user that they are leaving the applicaiton
               JOptionPane.showMessageDialog(null, "We're sorry you're leaving, " +
                     "but thank you for playing!","Divoc Gaming", JOptionPane.INFORMATION_MESSAGE,bye);

               // Setting the terminator to exit so that the while loop will stop
               terminator = "exit";
               break;
            // Declaring a default message for any entries which aren't in the cases
            default:
               // Informing the user that their input is invalid
               JOptionPane.showMessageDialog(null, "Your entry is invalid! " +
                     "Please enter a selection from the options available.","Divoc Gaming",
                     JOptionPane.INFORMATION_MESSAGE,well);

               // Calling the options method to bring the user back to the main gaming menu and asking if they
               // wish to select another game
               options();
               break;
         } // switch statement for accessing the games
      } // While loop for exiting the system
   }//main
}//class
