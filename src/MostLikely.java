import javax.swing.*;
import java.util.*;

/**
 * Created by Rachel on
 * A program coding "Most Likely To" game
 * Players select a category which contains 4 questions.
 * The player selected for each question has a random drinking punishment given to them
 **/
public class MostLikely
{  private static ImageIcon evil = new ImageIcon("evil.png");
   private static ImageIcon error = new ImageIcon("error.png");
   private static ImageIcon clown = new ImageIcon("clown.jpeg");
   //declare variables
   static int numOfPlayers = 0, choice = 0, round=1, i=-1;
   String name="";
   final int NUMCATEGORIES = 9 ;


   //creating game object
   protected static MostLikely game = new MostLikely() ;


   //building category objects
   categories cat1 = new categories("A Night out",
         "get arrested for being too drunk?",
         "sneak off to the bar to get everyone a round of shots?",
         "drag their friends to an after party?",
         "check their bank account after a night out and cry?");

   categories cat2 = new categories("Work",
         "fall asleep at work?",
         "turn up wearing two different shoes?",
         "quit on the spot then regret it later?",
         "wing a presentation and do well?");

   categories cat3 = new categories("Relationships",
         "turn up late to their own wedding?",
         "leave their partner and run away with someone they hardly know?",
         "marry someone famous?",
         "get left at the altar?");

   categories cat4 = new categories("Personality ",
         "be indecisive about everything?",
         "be grumpy for no reason?",
         "feel emotional after watching a fiction movie?",
         "laugh at an inappropriate time?");

   categories cat5 = new categories("Family",
         "forget their child's birthday?",
         "turn up to a family event drunk?",
         "embarrass their child in public?",
         "marry someone their family hates?");

   categories cat6 = new categories("Future",
         "live until they are 100",
         "become the richest?",
         "become famous for something stupid?",
         "join a weird futuristic 'Black Mirror' type trial?");

   categories cat7 = new categories("Random",
         "join a circus?",
         "not shower for a week?",
         "get a Guinness World Record for something?",
         "get a bad tattoo for a laugh?");

   categories cat8 = new categories("Style",
         "wear the most unfashionable clothes?",
         "rip their trousers bending over?",
         "turn up to an event in inappropriate clothes?",
         "have the best style?");

   categories cat9 = new categories("Food",
         "burn the dinner?",
         "finish last on 'Come Dine with Me'?",
         "want all the food after a night out?",
         "forget to eat all day?");


   //array containing different drinking punishments
   private static final String[] PUNISHMENT = {"drink 3 fingers of drink", "do two different shots in a row",
         "do a shot of the worst alcoholic drink you can find", "do a shot", "choose someone else to do a shot",
         "another player chooses your punishment", "drink 2 fingers of your drink",
         "drink half your drink" };


   //create array list of players
   public static ArrayList<String> arrOfPlayers = new ArrayList<>();


   //method allowing user to input how many players there are (at least 2)
   private int howManyPlayers()
   {
      boolean exception1 = false ;
      do
      {
         try
         {

            numOfPlayers = Integer.parseInt(JOptionPane.showInputDialog(null,
                  "How many people are playing this game?", "Number Of Players", JOptionPane.QUESTION_MESSAGE));

            if (numOfPlayers >= 2) {
               exception1 = true ;
            }//if ensuring at least 2 players

            else{
               JOptionPane.showMessageDialog(null,
                     "Two or more players are needed to play this game","Error",
                     JOptionPane.ERROR_MESSAGE,error);
            }//else
         }//try

         catch (InputMismatchException | NumberFormatException e)
         {

            JOptionPane.showMessageDialog(null, "Please enter a numerical value",
                  "ERROR",JOptionPane.ERROR_MESSAGE,error);
            exception1 = false ;
         }//catch ensuring a number is entered
      }//do exceptions

      while(!exception1);
      return numOfPlayers ;
   }//how many players method


   //method allowing user to enter players names
   private void buildPlayersArray()
   {
      boolean pass = true;
      for (int loop = 0; loop < numOfPlayers; loop++)
      {
         do
         {
            name = JOptionPane.showInputDialog(null, "Enter the name of player " +
               (loop + 1) + " :", "Players", JOptionPane.QUESTION_MESSAGE);
               arrOfPlayers.add(name); //adding to array list
            pass = true;
            if (name == null || name.isBlank())
            {
               JOptionPane.showMessageDialog(null,"You must input a name","Most Likely",
                     JOptionPane.INFORMATION_MESSAGE,error);
               pass = false;
            }
            else pass = true;
         }while (!pass);


      }//for
   }//players array method


   //method allowing players to select a category
   private int selectPosition()
   {
      //controlling which players turn it is
      if (i<numOfPlayers-1){
         i++ ;
      }//if
      else
         i=0 ;
      boolean exception2 = false;

      do
      {
         try
         {
            choice = Integer.parseInt(JOptionPane.showInputDialog(game.arrOfPlayers.get(i) + " please choose a category: " +
                  "\n1. A night out" +
                  "\n2. Work" +
                  "\n3. Relationships" +
                  "\n4. Personality" +
                  "\n5. Family" +
                  "\n6. Future" +
                  "\n7. Random" +
                  "\n8. Style" +
                  "\n9. Food", JOptionPane.QUESTION_MESSAGE));

            if ((choice >= 1) && (choice <= NUMCATEGORIES))
            {
               exception2 = true;
            }//if ensuring one of the category numbers is chosen

            else {
               JOptionPane.showMessageDialog(null,
                     "The number you have entered has not been found.  " +
                           "Please enter a number between 1-9","Error", JOptionPane.ERROR_MESSAGE,error);
            }//else
         }//try

         catch (InputMismatchException | NumberFormatException error)
         {
            ImageIcon faceplant = new ImageIcon("faceplant.jpeg");
            JOptionPane.showMessageDialog(null, "Please enter a numerical value",
                  "ERROR", JOptionPane.INFORMATION_MESSAGE,faceplant);
            exception2 = false;
         }//catch ensuring a number is entered
      }//do exception

      while (!exception2);
      return  choice ;
   }//select position method

   private void options(){
      String who = "Who is most likely to ";
      switch (choice)
      {
         case 1:
            name = JOptionPane.showInputDialog(null,
                  "Round " + round                                              //outputting round
                        +"\nThe category you have selected is: " + cat1.getCategory()  //output category
                        + "\nQuestion :" + who + cat1.getQ1()                          //output q1
                        + "\nEnter name: ",                                            //enter name
                  cat1.getCategory(), JOptionPane.QUESTION_MESSAGE);                  //output category label

            JOptionPane.showMessageDialog(null,
                  "\n" + name                                                 //output name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil); //outputting a random punishment

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat1.getQ2()
                        + "\nEnter name: ",
                  cat1.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat1.getQ3()
                        + "\nEnter name: ",
                  cat1.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat1.getQ4()
                        + "\nEnter name: ",
                  cat1.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);
            break;

         case 2:
            name = JOptionPane.showInputDialog(null,
                  "Round " + round
                        + "\nThe category you have selected is: " + cat2.getCategory()
                        + "\nQuestion :" + who + cat2.getQ1()
                        + "\nEnter name: ",
                  cat2.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat2.getQ2()
                        + "\nEnter name: ",
                  cat2.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat2.getQ3()
                        + "\nEnter name: ",
                  cat2.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat2.getQ4()
                        + "\nEnter name: ",
                  cat2.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);
            break;

         case 3:
            name = JOptionPane.showInputDialog(null,
                  "Round " + round
                        + "\nThe category you have selected is: " + cat3.getCategory()
                        + "\nQuestion :" + who + cat3.getQ1()
                        + "\nEnter name: ",
                  cat3.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat3.getQ2()
                        + "\nEnter name: ",
                  cat3.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat3.getQ3()
                        + "\nEnter name: ",
                  cat3.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat3.getQ4()
                        + "\nEnter name: ",
                  cat3.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);
            break;

         case 4:
            name = JOptionPane.showInputDialog(null,
                  "Round " + round
                        +"\nThe category you have selected is: " + cat4.getCategory()
                        + "\nQuestion :" + who + cat4.getQ1()
                        + "\nEnter name: ",
                  cat4.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat4.getQ2()
                        + "\nEnter name: ",
                  cat4.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat4.getQ3()
                        + "\nEnter name: ",
                  cat4.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat4.getQ4()
                        + "\nEnter name: ",
                  cat4.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);
            break;

         case 5:
            name = JOptionPane.showInputDialog(null,
                  "Round " + round
                        +" \nThe category you have selected is: " + cat5.getCategory()
                        + "\nQuestion :" + who + cat5.getQ1()
                        + "\nEnter name: ",
                  cat5.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat5.getQ2()
                        + "\nEnter name: ",
                  cat5.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat5.getQ3()
                        + "\nEnter name: ",
                  cat5.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat5.getQ4()
                        + "\nEnter name: ",
                  cat5.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);
            break;

         case 6:
            name = JOptionPane.showInputDialog(null,
                  "Round " + round
                        + "\nThe category you have selected is: " + cat6.getCategory()
                        + "\nQuestion :" + who + cat6.getQ1()
                        + "\nEnter name: ",
                  cat6.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat6.getQ2()
                        + "\nEnter name: ",
                  cat6.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat6.getQ3()
                        + "\nEnter name: ",
                  cat6.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat6.getQ4()
                        + "\nEnter name: ",
                  cat6.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);
            break;

         case 7:
            name = JOptionPane.showInputDialog(null,
                  "Round " + round
                        +"\nThe category you have selected is: " + cat7.getCategory()
                        + "\nQuestion :" + who + cat7.getQ1()
                        + "\nEnter name: ",
                  cat7.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat7.getQ2()
                        + "\nEnter name: ",
                  cat7.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat7.getQ3()
                        + "\nEnter name: ",
                  cat7.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat7.getQ4()
                        + "\nEnter name: ",
                  cat7.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);
            break;

         case 8:
            name = JOptionPane.showInputDialog(null,
                  "Round " + round
                        + "\nThe category you have selected is: " + cat8.getCategory()
                        + "\nQuestion :" + who + cat8.getQ1()
                        + "\nEnter name: ",
                  cat8.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat8.getQ2()
                        + "\nEnter name: ",
                  cat8.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat8.getQ3()
                        + "\nEnter name: ",
                  cat8.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat8.getQ4()
                        + "\nEnter name: ",
                  cat8.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);
            break;

         case 9:
            name = JOptionPane.showInputDialog(null,
                  "Round " + round
                        +"\nThe category you have selected is: " + cat9.getCategory()
                        + "\nQuestion :" + who + cat9.getQ1()
                        + "\nEnter name: ",
                  cat9.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat9.getQ2()
                        + "\nEnter name: ",
                  cat9.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat9.getQ3()
                        + "\nEnter name: ",
                  cat9.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);

            name = JOptionPane.showInputDialog(null,
                  "\nQuestion :" + who + cat9.getQ4()
                        + "\nEnter name: ",
                  cat9.getCategory(), JOptionPane.QUESTION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                  "\n" + name
                        + " your punishment is " + game.getRandomPunishment(PUNISHMENT),"PUNISHMENT",
                  JOptionPane.INFORMATION_MESSAGE,evil);
            break;
      }//switch
   }//method for category options


   //function to select random punishment from array
   private String getRandomPunishment(String [] punishment)
   {
      Random r = new Random() ;
      int randomNumber=r.nextInt(punishment.length); //random option runs through full length of punishment array
      return punishment[randomNumber] ;
   }//get random punishment


   public static void playMostLikely()
   {
      //declaring variables
      int response;


      //creating J Frame for "do you want to continue" option
      JFrame f = new JFrame() ;


      //call method for number of players
      game.howManyPlayers();


      //call method to create players array list and create the board
      game.buildPlayersArray();


      //do loop that runs through game until the user decides to stop or
      // the user has played the max number of rounds
      do
      {
         game.selectPosition(); //method for player to select position on grid

         game.options(); //calling method to select category

         response = (JOptionPane.showConfirmDialog(f,       //continue or leave game
               "Do you want to continue?"));

         round++ ;        //counting rounds
      }//do

      while ((response == JOptionPane.YES_OPTION) && (round != game.NUMCATEGORIES + 1)) ; //option to end game

      //end of game, dialog output
      ImageIcon shot1 = new ImageIcon("shot1.jpeg");
      JOptionPane.showMessageDialog(null, "You have finished the game!! " +
            "\nEveryone should now be starting to see double, but in case you're not...\nEVERYONE TAKE A SHOT!!",
            "End of game", JOptionPane.INFORMATION_MESSAGE,shot1);

   }//main
}//class






