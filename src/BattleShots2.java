import javax.swing.*;//for JOption
import java.text.DecimalFormat;//for headings not completely necessary
import java.util.InputMismatchException;//checking for error(try-catch)
import java.util.Scanner;//for keyboard input
import javax.swing.ImageIcon;//for importing pictures

import static java.lang.Character.toUpperCase;//for changing input to capital

/**
 * Created by MarkC on 04/03/2021
 * Final game code for BattleShots
 **/
public class BattleShots2

{
   public static Scanner keyboard = new Scanner(System.in);//scanner class for user input during testing
   public static DecimalFormat df = new DecimalFormat("");// headings keep printing with .0, reason unknown
   public static ImageIcon faceplant = new ImageIcon("faceplant.jpeg");//import error image


   protected static void battleshotsStart()
   {
      char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};//String array for grid position
      int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};//int array for Y axis
      int[][] battleShots2 = makeBoard(letters, numbers);
      ImageIcon ship = new ImageIcon("fireship.jpeg");//import ship image
      ImageIcon simpson = new ImageIcon("simpson.png");//import simpson image
      //welcome window message box
      JOptionPane.showMessageDialog(null, "Welcome to BattleShot 2.0\nTake turns in firing by " +
            "calling out plot \npoints on the grid, Who ever has the most points at the end wins\n" +
            "Please Drink responsibly", "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE, ship);


      int rounds = createRounds();//calling rounds method

      if (rounds > 0)//if loop giving opportunity to leave this game
      {

         int noOfPlayers = createNoOfPlayers();// for numbers of players
         String[] names = createPlayerNames(noOfPlayers);//calling naming players method
         int[] score = new int[noOfPlayers];//creating score array

         ImageIcon excited = new ImageIcon("excited.jpeg");//import ship image
         JOptionPane.showMessageDialog(null, "********Alright then****" +
                     " \n ***Lets play MINEFIELD******", "BattleShots 2.0"
               , JOptionPane.INFORMATION_MESSAGE,excited);//Game time box

         //for loop for the amount of rounds to be played
         for (int a = 0; a < rounds; a++)
         {
            JOptionPane.showMessageDialog(null, "******Round " + (a + 1) +
                  "*********", "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE, ship);//round number heading using a index

            for (int x = 0; x < noOfPlayers; x++)
            {
               char letterIndex = 0;
               int numberIndex = 0;

               String ans = JOptionPane.showInputDialog(null, names[x] +
                     " please pick a letter between A - I and a number " +
                     "between 1 and 9", "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE);
               //user picks their box
               try
               {
                  letterIndex = ans.charAt(0);//letter for index for grid search
                  letterIndex = toUpperCase(letterIndex);//encase user does not use capital letter
                  numberIndex = Character.getNumericValue(ans.charAt(1));//number index for grid search
               } catch (NumberFormatException | StringIndexOutOfBoundsException | NullPointerException errorQ3 )
               {
                  JOptionPane.showMessageDialog(null, "Silly billy\nInput must " +
                              "consist of a letter and a number", "BattleShots 2.0",
                        JOptionPane.INFORMATION_MESSAGE, faceplant);
               }
               //image imports
               ImageIcon shot = new ImageIcon("shot.jpeg");//import shot image
               ImageIcon pint1 = new ImageIcon("pint1.jpeg");//import pint image
               ImageIcon spin = new ImageIcon("Spin.jpeg");//import spin image
               ImageIcon downPint = new ImageIcon("downpint.jpeg");//import pint2 image
               ImageIcon lucky = new ImageIcon("lucky.jpeg");//import luck image
               ImageIcon jackpot = new ImageIcon("Jackpot.jpeg");//import lucky image


               boolean found = false, found2 = false;
               int index = 0;
               int L = 0;
               int N = 0;
               int result;

               while (!(found) && (index < letters.length))
                  for (int i = 0; i < letters.length; i++)
                  {
                     if (letters[i] == letterIndex)
                     {
                        found = true;
                        L = i;
                     }//if to find days array index
                     for (int p = 0; p < numbers.length; p++)
                        if (numbers[p] == numberIndex)
                        {
                           found2 = true;
                           N = p;
                        }//loop to find time array index
                     index++;
                  }

               if (found && found2)
               {
                  result = battleShots2[L][N];

                  switch (result)
                  {
                     case (1):
                        JOptionPane.showMessageDialog(null, "Shot time baby\nWith 5 points"
                              , "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE, shot);
                        score[x] = score[x] + 5;
                        break;

                     case (2):
                        JOptionPane.showMessageDialog(null, "Down 3 fingers for 3 points"
                              , "Battle Shots", JOptionPane.INFORMATION_MESSAGE, pint1);
                        score[x] = score[x] + 3;
                        break;

                     case (3):
                        JOptionPane.showMessageDialog(null, "Stand up and do 3 spins !!!!\n" +
                                    "That will be 7 points for you", "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE,
                              spin);
                        score[x] = score[x] + 7;
                        break;

                     case (4):

                        JOptionPane.showMessageDialog(null, "Down whats left in your glass\n" +
                              "Its Worth 12 points", "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE, downPint);
                        score[x] = score[x] + 12;
                        System.out.println();
                        break;

                     case (5):

                        JOptionPane.showMessageDialog(null, "****** 10 POINT BONUS ******\n" +
                              "You got lucky this time", "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE, lucky);
                        score[x] = score[x] + 10;
                        break;
                     case (6):

                        JOptionPane.showMessageDialog(null, "********JACKPOT*******" +
                              "\n************************\n****30 POINT BONUS****\n************************\n" +
                              "************************", "BattleShots 2.0", JOptionPane.
                              INFORMATION_MESSAGE, jackpot);
                        score[x] = score[x] + 30;

                  }//Switch statement for results

               }//if both values are found
               else
               {
                  JOptionPane.showMessageDialog(null, "Selection not available\n" +
                              "Minus 10 points for being a silly billy "
                        , "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE, faceplant);
                  score[x] = score[x] - 10;
                  System.out.println();
               }//if one of the values is missing or incorrect input
            }
         }
         gameResults(noOfPlayers, score, names);//Calling results
      } else
      {
         ImageIcon sad = new ImageIcon("sad.jpeg");//import sad image
         JOptionPane.showMessageDialog(null, "AWWWWWWW\nOk see you later"
               , "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE, sad);//if user decides to leave
      }
      ImageIcon thumbs = new ImageIcon("thumbs.jpeg");//import nerv image
      JOptionPane.showMessageDialog(null, "Thanks for playing\n" +
            "Please Drink responsibly", "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE, thumbs);

   }//main

   private static int createRounds()
   {
      int rounds = 0;
      boolean pass = false;
      do
      {
         try
         {
            rounds = Integer.parseInt(JOptionPane.showInputDialog(null,
                  "How many rounds would you like to play or type 0 to leave : ",
                  "Battle Shots", JOptionPane.INFORMATION_MESSAGE));//Question for amount of rounds
            if (rounds >= 0)
            {
               pass = true;
            } else
            {
               JOptionPane.showMessageDialog(null,
                     "Input must be 0 or more. Click ok to try again",
                     "Battle Shots", JOptionPane.INFORMATION_MESSAGE, faceplant);//if input rounds less than 0
            }

         } catch (NumberFormatException | InputMismatchException | NullPointerException errorQ2)
         {
            JOptionPane.showMessageDialog(null, "You must " +
                        "input a number eg. 5, Press enter to try again", "Battle Shots",
                  JOptionPane.INFORMATION_MESSAGE, faceplant);//if letter is put ino rounds box
            pass = false;
         }
      }
      while (!pass);

      return rounds;

   }//method for creating the amount of rounds

   private static int[][] makeBoard(char[] letters, int[] numbers)
   {


      final int COLUMNS = 9;//Final int for grid columns
      final int ROWS = 9;//Final int for grid rows


      int[][] battleShots2 = new int[COLUMNS][ROWS];//creating times 2d array

      for (int row = 0; row < ROWS; row++)
      {
         for (int column = 0; column < COLUMNS; column++)
         {
            battleShots2[row][column] = (int) ((Math.random() * 5) + 1);//code to ensure game board is different each time
            battleShots2[(int) (Math.random() + 1)][(int) (Math.random() + 1)] = 6;//For 1 6 in random spot on board
         }
      }//nested for loop to fill grid
//code if you need to print to screen for testing
      /** for (double num : numbers)
       {
       System.out.print("\t");
       System.out.print(df.format(num));
       }//printing the number heading to screen numbers at top of grid

       System.out.println();

       for (int row = 0; row < ROWS; row++)
       {
       System.out.print(letters[row]);
       for (int column = 0; column < COLUMNS; column++)
       {
       System.out.print("\t" + battleShots2[row][column]);
       }
       System.out.println();
       }//for loop printing mineSweeper game to screen to screen
       **/

      //create rounds
      return battleShots2;

   }//method to create game board

   private static int createNoOfPlayers()
   {

      boolean pass = false;
      int noOfPlayers = 0;// for numbers of players

      do
      {
         try
         {
            noOfPlayers = Integer.parseInt(JOptionPane.showInputDialog(null,
                  "Please enter number of players : ", "Battle Shots", JOptionPane.INFORMATION_MESSAGE));
            if (noOfPlayers > 0)
            {
               pass = true;
            } else
            {
               JOptionPane.showMessageDialog(null,
                     "Input must be 0 or more.", "Battle Shots", JOptionPane.INFORMATION_MESSAGE, faceplant);
            }
         } catch (NumberFormatException | InputMismatchException errorQ2)
         {
            JOptionPane.showMessageDialog(null, "You must input a " +
                  "number eg. 7 ", "Battle Shots", JOptionPane.INFORMATION_MESSAGE, faceplant);

            pass = false;
         }
      }
      while (!pass);
      return noOfPlayers;
   }//method to get number of players

   private static String[] createPlayerNames(int noOfPlayers)
   {
      Boolean pass = true;

      String[] names = new String[noOfPlayers]; // creating names array
      for (int i = 0; i < names.length; i++)
      {
         do
         {
            names[i] = JOptionPane.showInputDialog(null,
                  "Please enter player " + (i + 1) + "'s name : ", "Battle Shots"
                  , JOptionPane.INFORMATION_MESSAGE);
            if (names[i]== null || names[i].isBlank())
            {
               JOptionPane.showMessageDialog(null,"You must input a name","BatttleShots2.0",
                     JOptionPane.INFORMATION_MESSAGE,faceplant);
               pass = false;
            }
            else pass = true;
         }while (!pass);
      }

      return names;

   }//method for getting names

   private static void gameResults(int noOfPlayers, int[] score, String[] names)
   {
      ImageIcon nerv = new ImageIcon("Nerv.jpeg");//import nerv image
      ImageIcon simpson = new ImageIcon("simpson.png");//import simpson image
      JOptionPane.showMessageDialog(null, "" +
                  "Thanks the end of the rounds\nand the results are in ............",
            "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE, nerv);
      //Printing box to screen preparing for winner notice
      int winner = score[0];
      int winnerIndex = 0;
      int count = -1;//count for draw loop

      for (int i = 0; i < noOfPlayers; i++)
      {
         if (score[i] > winner)
         {
            winner = score[i];
            winnerIndex = i;
            count = 0;

         } else if (score[i] == winner)
         {
            count++;//draw check
         }
      }//for loop to calculate winner

      if (count > 0)
      {

         JOptionPane.showMessageDialog(null, "We have a draw",
               "BattleShots 2.0", JOptionPane.INFORMATION_MESSAGE, simpson);
      }//print if draw
      else
      {
         JOptionPane.showMessageDialog(null, "And the winner is .." +
               "........\n" + (names[winnerIndex]), "Battle Shots", JOptionPane.INFORMATION_MESSAGE, simpson);
      }//print if only 1 winner

      ImageIcon party = new ImageIcon("party.jpeg");//import lucky image
      String toBeDisplayed = "";
      for (int out = 0; out < noOfPlayers; out++)
      {
         toBeDisplayed += names[out] + "'s score was " + score[out] + "\n";
      }// Make list of scores


      JOptionPane.showMessageDialog(null, toBeDisplayed
            + "\n", "The Final Scores", JOptionPane.INFORMATION_MESSAGE, party);
      //printing out list of scores

   }//Results method
}