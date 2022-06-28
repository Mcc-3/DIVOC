/**
 * Created by Rebecca Burke
 * The program below codes the game truth or drink
 * Concept:
 * Players either play with the pre defined mode or enter their own number of truths.
 * Each is then randomly selected from the set for the nominated player.
 * That player then decides whether they wish to truthfully answer the card or whether they want to take a
 * shot.
 * This continues until all questions have been drawn.
 **/
// Importing the classes
import javax.swing.*;
import java.util.*;

public class TruthOrDrinkV9
{
   public static ImageIcon error = new ImageIcon("error.png");
   public static ImageIcon think = new ImageIcon("thinking.jpeg");
   public static ImageIcon evil = new ImageIcon("evil.png");
   public static ImageIcon suspicious = new ImageIcon("suspicious.jpeg");
   public static ImageIcon relax = new ImageIcon("relax.jpeg");
   public static ImageIcon thumb1 = new ImageIcon("thumbs1.jpeg");
   // Declaring the scanner class
   static Scanner keyboard = new Scanner(System.in);

   // Declaring a variable which will hold the number of truths that the user selects
   static private int noTruths;
   // Declaring the counter which will be used to count the number of truths
   static private int counter = 1;
   // Declaring and initialising the gameMode variable which will store the users choice of gaming mode
   static private int gameMode = 0;

   // Declaring a method which prompts the user to select to play with their own questions or pre-defined questions
   public static int modeSelect(){

      // Declaring a variable which will continue the do-while loop until the user enters a valid input
      boolean invalid = true;
      // Declaring a do while loop which will prevent the user from moving forward until their entry is valid
      do
      {
         // Declaring a try catch statement which will throw an error when anything but a number is entered.
         try{
            // Welcoming the user and prompting them to select the mode of game they wish to play.
            gameMode = Integer.parseInt(JOptionPane.showInputDialog(null, "Welcome to Truth or Drink.\n\n"+
                  "Would you like to:\n"+
                  "1.) Play with the preset questions\n"+
                  "2.) Add and play with your own questions\n"+
                  "Please enter your selection:","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE));
            // Setting the invalid variable to false to exit the do-while loop
            invalid = false;
         }//try: modeSelect
         catch (Exception error1){
            // Throwing an error exception when a user enters anything but a number
            JOptionPane.showMessageDialog(null, "ERROR - Non-numeric input found.\n" +
                  "Please enter from the options above.","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,error);
         }//catch: modeSelect

      } while(invalid == true);
      // Returning the gameMode variable
      return gameMode;
   }//Method: modeSelect

   // Declaring a method which prompts the user to select the number of truths to enter for the user-defined game.
   public static int numberOfTruths(){

      // Declaring a variable which will continue the do-while loop until the user enters a valid input
      boolean invalid = true;
      // Declaring a do-while loop which will prevent the user from moving forward until their entry is valid
      do
      {
         // Declaring a try catch statement which will throw an error when anything but a number is entered.
         try
         {
            noTruths = Integer.parseInt(JOptionPane.showInputDialog(null,"How many truths do " +
                  "you want to play with? " +
                  "(Supports up to 25)","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE));

            // Declaring an if statement to ensure entries are 0<entry<25
            if ((noTruths <= 0) || (noTruths >= 26)){
               // Informing the user that their entry is out of bounds
               JOptionPane.showMessageDialog(null, "ERROR - Invalid number entered\n"+
                     "You cannot play with 0 or less questions. Please enter a playable number of questions.",
                     "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,error);
            }//if
            else{
               // Setting the invalid variable to false to exit the do-while loop
               invalid = false;
            }//else
         }//try: numberOfTruths
         catch (Exception error)
         {
            // Throwing an entry error
            JOptionPane.showMessageDialog(null, "Error - Non-numeric input found.\n"+
                  "Please enter a valid integer.","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE);
         }//catch: numberOfTruths

      } while (invalid == true);
      // Returning the number of truths
      return noTruths;
   }// Method: numberOfTruths

   // Declaring a method called changeQuestions which will allow the user to make any changes to their entered questions.
   public static void changeQuestions(int noTruths, ArrayList truths){
      // Declaring and initialising the variable amend questions
      int amendQuestions = 0;

      // Declaring a do-while loop to prevent the user amending more questions than available.
      do
      {
         // Declaring a variable which will continue the do-while loop until the user enters a valid input
         boolean invalid = true;
         // Declaring a do-while loop to prevent the user from moving forward until their entry is valid.
         do
         {
            // Declaring a try-catch statement which will catch any non number entries.
            try
            {
               // Asking the user if there are any questions they want to change before they begin
               amendQuestions = Integer.parseInt(JOptionPane.showInputDialog(null,
                     "Before entering the game are there any questions you would like to change?\n"+
                     "Please enter 1 for yes or 2 for no:","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE));
               // Declaring an if statement to ensure the user can only enter 1 and 2.
               if (Arrays.asList(1,2).contains(amendQuestions)){
                  // Setting the variable invalid to false to exit the do-while loop
                  invalid = false;
               };
            }//try
            catch (Exception entryError)
            {
               // Informing the user that their entry is invalid
               JOptionPane.showMessageDialog(null, "ERROR - Input error.\n"+
                     "Please enter either option 1 for yes or option 2 for no.",
                     "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,error);
            }//catch
         } while (invalid == true);


         // Declaring a switch statement to determine if the user wants to change anything
         switch (amendQuestions)
         {
            case 1:
               // If the user selects yes we want to ask them how many questions they want to change, which questions they are
               // and then let them make the changes

               // Declaring the variable numberOfChanges to store the number of changes.
               int numberOfChanges = 0;

               // Resetting the invalid variable
               invalid = true;

               // Declaring a do-while loop which will ensure the user cannot continue until their entry is valid
               do
               {
                  //Declaring a try-catch statement to catch any non number entries
                  try
                  {
                     // Asking the user how many changes they want to make
                     numberOfChanges = Integer.parseInt(JOptionPane.showInputDialog(null,
                           "How many questions would you like to change?","Truth or Drink V9"
                           ,JOptionPane.INFORMATION_MESSAGE));

                     // Declaring an if statement which ensure the number of changes isn't greater than the
                     // number of questions available.
                     if((numberOfChanges > 0) && (numberOfChanges <= noTruths)){
                        // Setting the invalid variable to false to exit the do-while loop
                        invalid = false;
                     }//if
                     else{
                        // Informing the user that their entry is invalid.
                        JOptionPane.showMessageDialog(null, "Error - Entry Error\n"+
                              "You have entered an invalid number of truths.\n"+
                              "Please enter a valid number of questions to change.",
                              "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,error);
                     }//else
                  }//try
                  catch (Exception entryError)
                  {
                     // Informing the user that their entry is invalid.
                     JOptionPane.showMessageDialog(null,"ERROR - Entry error\n"+
                           "Please enter a number","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,error);
                  }//catch
               } while (invalid == true);

               // Declaring the variable index which will be used within the for loop
               int index = 1;
               // Declaring and initialising the questionNumber variable which will store the question number to be changed
               int questionNumber = -1;
               // Declaring the arrayIndex variable
               int arrayIndex;

               // Declaring a for loop which will iterate through and ask the user which questions they want to change,
               // how and change them.
               for (index = 1; index <= numberOfChanges; index++)
               {
                  // Resetting the variable invalid to true
                  invalid = true;
                  // Declaring a do-while loop which will prevent the user from moving forward until their entry is valid
                  do
                  {
                     // Declaring a try-catch to prevent the user from entering anything other than a number
                     try
                     {
                        // Asking which question to change
                        questionNumber = Integer.parseInt(JOptionPane.showInputDialog(null,
                              "Which question do you want to change?","Truth or Drink V9",
                              JOptionPane.INFORMATION_MESSAGE));
                        // Declaring an if statement which ensures that the question number to change is less
                        // than the number of questions
                        // available
                        if((questionNumber > 0) && (questionNumber <= noTruths)){
                           // Setting the invalid variable to false to exit the do-while loop
                           invalid = false;
                        }
                        else{
                           // Informing the user that their entry is invalid
                           JOptionPane.showMessageDialog(null, "ERROR - Entry out of bounds.\n"+
                                 "You have entered a number greater than the amount of truths available."+
                                 "Please enter a question number smaller than " + noTruths,
                                 "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,error);
                        }
                     }//try
                     catch (Exception entryError)
                     {
                        // Informing the user that their entry is invalid
                        JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n"+
                              "Please enter a number.","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,error);
                     }//catch
                  } while (invalid == true);

                  // Setting the array list index
                  arrayIndex = questionNumber - 1;

                  // Printing the chosen question to the console
                  JOptionPane.showMessageDialog(null,"You have chosen to change: \n"
                        + truths.get(arrayIndex),"Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,think);

                  // Resetting the invalid variable
                  invalid = true;
                  //Declaring a do-while loop to iterate over the process until the users entry is valid
                  do
                  {
                     // Declaring a try-catch to prevent the user entering anything which may crash the application
                     try
                     {
                        // Asking the user to make their changes to the question.
                        String truthChange = JOptionPane.showInputDialog(null,
                              "Make your changes to question " + questionNumber,
                              "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE);
                        // Declaring an if statement which checks that the number of characters is greater than 0
                        if(truthChange.length() > 0){
                           // Setting the element to the list
                           truths.set(arrayIndex, truthChange);
                           // Setting the variable invalid to false to exit the do-while loop
                           invalid = false;
                        }//if
                        else{
                           // Informing the user that their entry was invalid
                           JOptionPane.showMessageDialog(null, "ERROR - Entry Erorr\n"+
                                 "Entry cannot be empty.","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,
                                 error);
                        }//else
                     }//try
                     catch (Exception entryError)
                     {
                        // Informing the user that their entry was invalid
                        JOptionPane.showMessageDialog(null, "ERROR - Entry Error\n"+
                              "What you have entered is invalid. Please try again.",
                              "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,error);
                     }//catch
                  } while (invalid == true); // do

               }//for

               // Thanking and informing the user that they have came to the end of the changes process
               JOptionPane.showMessageDialog(null, "Thank you for making your changes.",
                     "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,evil);
               break;
            case 2:
               // If the user chooses no then ignore this switch statement and continue with the rest of the code
               JOptionPane.showMessageDialog(null, "You're about to enter the game."
                     ,"Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,thumb1);
               break;
            default:
               // Informing the user that their entry was invalid
               JOptionPane.showMessageDialog(null, "ERROR - Invalid entry.\n"+
                     "Your entry is outside the options available.","Truth or Drink V9",
                     JOptionPane.INFORMATION_MESSAGE,error);
         }//switch

      } while ((amendQuestions == 0) || (amendQuestions > noTruths)); //do

   }// Method: changeQuestions

   // Declaring a method which allows the user to play with preset questions.
   public static void preDefined(){

      // Declaring an empty arraylist
      ArrayList<String> truths = new ArrayList<String>();

      // Declaring and entering the preset truths to the arrayList
      truths.add("What’s the worst date you’ve ever had?");
      truths.add("Have you ever kissed anyone in this group?");
      truths.add("What’s the weirdest dream you’ve ever had?");
      truths.add("Have you ever cheated or helped someone else cheat?");
      truths.add("If you suddenly became invisible, what would you do with your newfound transparency?");
      truths.add("Have you ever broken up with someone just before a public holiday so that you didn’t have to buy them a gift?");
      truths.add("What is the most embarrassing thing that you ever done while on a date?");
      truths.add("What's the most embarrassing thing you've done on a night out?");
      truths.add("Read out the last text you sent or have received?");
      truths.add("If you had to choose between walking down the street naked or having your thoughts appear in thought bubbles above your \nhead for everyone to read, which would you choose?");
      truths.add("The majority of the time when you day dream what do you think about?");
      truths.add("Tell us what your first impression of the player following you was.");
      truths.add("If you had to rely on one of the other players in a life or death situation who would you choose and why?");
      truths.add("What is your biggest regret?");
      truths.add("Tell us what your first impression of the player previous to you was.");
      truths.add("Who out of the other players would you not trust to keep a secret?");
      truths.add("Which are better cats or dogs?");
      truths.add("In your opinion who is the most dramatic person in the current group of players?");
      truths.add("In your opinion who is the biggest lightweight in the group of current players?");
      truths.add("Have you ever had a crush or flirted with a member of the current group of players? If so who and when?");

      // Declaring randomSelect as an instance of Random
      Random randomSelect = new Random();

      // Declaring a while statement which will repeat this process until all truths have been asked
      while(truths.size() != 0)
      {
         // Randomly selecting a truth using randomSelect
         int selection = randomSelect.nextInt(truths.size());

         //Shuffling the list to randomize further
         Collections.shuffle(truths);
         //Printing the randomly selected truth
         JOptionPane.showMessageDialog(null,"Your question is:\n" + truths.get(selection) +
               "\nDo you wish to answer truthfully or take a shot?\n\n"+
               "Once you have made and completed your decision press ok to continue.",
               "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,suspicious);

         // Removing the randomly selected truth
         truths.remove(selection);
         // Informing the user that the truth has been removed
         JOptionPane.showMessageDialog(null, "The rest of the players can " +
               "relax now. This truth has been removed from the deck!"+
               "\nNext player, please press enter to draw your truth","Truth or Drink V9"
               ,JOptionPane.INFORMATION_MESSAGE,relax);
      }//While

   }//Method: preDefined

   // Declaring a method which allows the user to play with user defined questions.
   public static void userDefined(int noOftruths){

      // Declaring an empty arraylist
      ArrayList<String> truths = new ArrayList<String>();

      // Declaring a for loop which iterates through and prompts the user to add their truths
      for (counter = 1; counter <= noOftruths; counter = counter + 1){

         // Declaring the variable invalid
         boolean invalid = true;
         //Declaring a do loop to iterate over the process until the users entry is valid
         do
         {
            // Declaring a try-catch to prevent the user entering anything which may crash the application
            try
            {
               // Initializing the array and setting the truths

               String truthText = JOptionPane.showInputDialog(null,"Enter truth "+counter+"?"
                     ,"Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE);
               // Declaring an if statement which checks if the number of characters is greater than 0
               if (truthText.length()>0){
                  // Adds the truths to the arrayList
                  truths.add(truthText);
                  // Setting the variable invalid to false to exit the do-while loop
                  invalid = false;
               }//if
               else{
                  // Informing the user that their entry is invalid
                  JOptionPane.showMessageDialog(null, "ERROR - Entry Error"+
                        "Try again","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,error);
               }//else
            }//try
            catch (Exception entryError)
            {
               // Informing the user that their entry is invalid
               JOptionPane.showMessageDialog(null, "ERROR - Entry Error"+
                     "What you have entered is invalid. Please try again.",
                     "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,error);
            }//catch
         } while (invalid == true); // do
      }//for
      ImageIcon thumb1 = new ImageIcon("thumbs1.jpeg");
      // Thanking the user for entering their questions
      JOptionPane.showMessageDialog(null, "Thank you for entering your questions.",
            "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,thumb1);
      // Calling the changeQuestions
      changeQuestions(noOftruths, truths);
      // Asking the user to assign player order
      JOptionPane.showMessageDialog(null, "Please decide on your player order and " +
            "then press enter to begin.","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,think);

      // Declaring randomSelect as an instance of Random
      Random randomSelect = new Random();

      // Declaring a while statement which will repeat this process until all truths have been asked
      while(truths.size() != 0)
      {
         // Randomly selecting a truth using randomSelect
         int selection = randomSelect.nextInt(truths.size());

         //Shuffling the list to randomize further
         Collections.shuffle(truths);
         //Printing the randomly selected truth
         JOptionPane.showMessageDialog(null, "Your question is:\n" + truths.get(selection)+
               "\nDo you wish to answer truthfully or take a shot?"+
               "\nOnce you have made and completed your decision press enter to continue.",
               "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,suspicious);

         // Removing the randomly selected truth
         truths.remove(selection);
         // Informing the user that the truth has been removed
         JOptionPane.showMessageDialog(null, "The rest of the players can relax now."+
               "\nThis truth has been removed from the deck!"+
               "\nNext player, please press enter to draw your truth",
               "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,relax);
      }//While
   }//Method: userDefined


   // Declaring a method which will run the game in order
   public static void runGame()
   {
      // Declaring the playModeTOD variable which hold the game mode selected by the user
      int playModeTOD;

      // Declaring a do loop which will prevent the user selecting a switch option greater than 2
      do
      {
         // Calling modeSelect method and assigning it to the playModeTOD variable
         playModeTOD = modeSelect();

         // Using a switch statement to enter the method of play selected by the user
         switch (playModeTOD)
         {
            // Entering the preset mode
            case 1:
               // Informing the user that they are entering the preset mode
               JOptionPane.showMessageDialog(null, "You have selected to play " +
                     "with the preset questions.\n"+
                     "Please select your player order and then press enter to begin",
                     "Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,thumb1);
               // Calling the preDefined method
               preDefined();
               // Informing the user that the game has finished
               JOptionPane.showMessageDialog(null, "This is the end of the game.\n"+
                     "Thank you for playing Truth or Drink.","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE);
               break;
            // Entering the user defined mode
            case 2:
               // Informing the user that they are entering the user defined mode
               JOptionPane.showMessageDialog(null, "You have selected to play with your own questions."+
                     "\nYou will now need to decide and enter these into the system."+
                     "\nDon't worry about the order in which you enter them as they will be shuffled before the game begins."
                     ,"Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,evil);
               // Calling the numberOfTruths method
               int noOtruths = numberOfTruths();
               // Calling the user defined method with the users desired number of truths
               userDefined(noOtruths);
               // Informing the user that the game has finished
               JOptionPane.showMessageDialog(null, "This is the end of the game. Thank you " +
                     "for playing.","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE);
               break;
            default:
               // Informing the user that their entry is invalid
               JOptionPane.showMessageDialog(null, "ERROR - Entry is outside the range of" +
                     " options available.\n"+
                     "Please select from the options above.","Truth or Drink V9",JOptionPane.INFORMATION_MESSAGE,
                     error);
         }//Switch

      } while ((gameMode <= 0) || (gameMode > 2)); //do-while

   }//Method: runGame
}//class

