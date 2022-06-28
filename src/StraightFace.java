

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by Seong on 05/03/2021
 * JOptionPane works in all section - Most complete working version
 **/
public class StraightFace
{

   private static ImageIcon error = new ImageIcon("error.png");
   private static ImageIcon noLaugh = new ImageIcon("nolaugh.jpeg");
   protected static ArrayList<String> quotes = new ArrayList<>(Arrays.asList(
         "I'll be back.",
         "Gotta catch them all!",
         "May the force be with you.",
         "There's no place like home.",
         "I'm the king of the world!",
         "Life is like a box of chocolates.",
         "My precious.",
         "Just keep swimming.",
         "You're gonna need a bigger boat.",
         "Why so serious?",
         "There is no crying in baseball!",
         "E.T. phone home.",
         "You can't handle the truth!",
         "A martini. Shaken, not stirred.",
         "Magic Mirror on the wall, who is the fairest one of all?",
         "The stuff that dreams are made of.",
         "Keep your friends close, but your enemies closer.",
         "I am your father.",
         "Today, I consider myself the luckiest man on the face of the earth.",
         "Bond. James Bond.",
         "You talking to me?",
         "Fasten your seatbelts. It's going to be a bumpy night.",
         "Nobody puts Baby in a corner.",
         "You had me at 'hello'.",
         "To infinity and beyond!",
         "It was beauty killed the beast.",
         "Hasta la vista, baby.",
         "What we've got here is failure to communicate.",
         "Roads? Where we're going we don't need roads.",
         "They may take our lives, but they'll never take our freedom!",
         "Toto, I've a feeling we're not in Kansas anymore.",
         "Houston, we have a problem.",
         "If you build it, he will come.",
         "May the odds be ever in your favor."));

   protected static ArrayList<String> fWords = new ArrayList<>(Arrays.asList("frog", "fart", "fog", "Father Ted",
         "frappe", "fanny"));

   protected static ArrayList<String> pWords = new ArrayList<>(Arrays.asList("panda", "pokemon", "pikachu", "pancake",
         "pants", "poodle", "poop", "piss"));

   protected static ArrayList<String> bWords = new ArrayList<>(Arrays.asList("balls", "boob", "buffoon", "bamboo",
         "beaver", "bog",
         "belly", "boot", "booger", "brother", "butt", "bear", "brain", "baboon", "bomb", "bong"));

   protected static ArrayList<String> randomItems = new ArrayList<>(Arrays.asList("turtles", "dentures", "toilet seat",
         "McVities Digestive", "snails", "strawberries", "ducks", "noodles", "bacteria", "condoms", "toddlers",
         "laxatives", "Weetabix", "dolphins"));

   protected static ArrayList<String> estWords = new ArrayList<>(Arrays.asList("shortest", "loudest", "roundest",
         "longest",
         "horniest", "hairiest"));

   protected static ArrayList<String> places = new ArrayList<>(Arrays.asList("McDonald's drive-thru", "your granny's " +
               "toilet seat",
         "Dominos pizza oven", "Shitty Wok Chinese takeaway", "Belfast PSNI's lockup", "Burger King's bin"));

   protected static ArrayList<String> doingStuff = new ArrayList<>(Arrays.asList("kick", "kiss", "lick", "touch",
         "rub", "hug"
         , "finger", "shave", "snort"));

   protected static ArrayList<String> saidStuff = new ArrayList<>(Arrays.asList("Yee-haw!", "Burp!", "Ouch!", "Bingo!",
         "Yummy" +
               "!", "It sucks", "WTF?"));

   protected static ArrayList<String> gerunds = new ArrayList<>(Arrays.asList("bouncing", "twerking", "drooling",
         "pooping",
         "break dancing", "hopping", "mopping", "farting"));

   protected static ArrayList<String> animalSounds = new ArrayList<>(Arrays.asList("meow", "woof", "gribbit", "twit" +
               "-twoo", "moo",
         "baa", "cock-a-doodle-doo", "oink", "cheep", "tweet", "neigh"));

   protected static ArrayList<String> howMuchToDrink = new ArrayList<>(Arrays.asList("it all", "one normal sip",
         "five normal sips", "three big gulps", "two fingers", "four fingers", "seven tiny sips", "half of what's " +
               "left", "two teaspoons", "three drops", "five licks"));

   private static int welcomeNoOfPlayers()
   {
      boolean pass = false;
      int noOfPlayers = 0;
      do
      {
         try
         {
            noOfPlayers = Integer.parseInt(JOptionPane.showInputDialog(null, "\nWelcome to the " +
                        "drinking game called Straight Face!" + "\nPlayers have to read the sentence out without " +
                        "laughing, whoever laughs drinks!" + "\nHow many eejit(s) here wants to play Straight Face?",
                  "Straight Face",
                  JOptionPane.INFORMATION_MESSAGE));
            if (noOfPlayers > 0)
            {
               pass = true;
            } else
            {
               JOptionPane.showMessageDialog(null, "This game requires 1 or more eejits to play." +
                     " Please enter value more than 0.", "Straight Face", JOptionPane.INFORMATION_MESSAGE, error);
            }
         } catch (NumberFormatException | InputMismatchException error)
         { ImageIcon error2 = new ImageIcon("error.png");//public image not working here unsure why
            JOptionPane.showMessageDialog(null, "You must enter a number.", "Straight Face",
                  JOptionPane.INFORMATION_MESSAGE,error2);
            pass = false;
         }//catch
      } while (!pass);
      return noOfPlayers;
   }//welcomeNoOfPlayers

   private static String[] createPlayerNames(int noOfPlayers)
   {
      Boolean pass = true;

      String[] names = new String[noOfPlayers]; // creating names array
      for (int i = 0; i < names.length; i++)
      {
         do
         {
            names[i] =  JOptionPane.showInputDialog(null, "Please enter eejit " + (i + 1) +
               "'s name: ", "Straight Face", JOptionPane.INFORMATION_MESSAGE);
            if (names[i] == null || names[i].isBlank())
            {
               JOptionPane.showMessageDialog(null, "Surely every eejit has a name??",
                     "Straight Face", JOptionPane.INFORMATION_MESSAGE,error);
               pass = false;
            } else pass = true;
         } while (!pass);
      }

      return names;
   }













      private static void randomlyPickedPlayer(String[] names, ArrayList<String> howMuchToDrink)
   {
      String name = names[(int) (Math.random() * names.length)];
      int howMuchToDrinkArrayListSize = howMuchToDrink.size();
      String volume = howMuchToDrink.get((int) (Math.random() * howMuchToDrinkArrayListSize));
      JOptionPane.showMessageDialog(null,
            "It's " + name + "'s turn!" + "\nWhoever laughs drink " + volume + "!", "Straight " +
                  "Face", JOptionPane.INFORMATION_MESSAGE, noLaugh);
   } //Trying to use this to generate randomly picked player's name

   private static String getQuote()
   {
      int quotesArrayListSize = quotes.size();
      String quote = quotes.get((int) (Math.random() * quotesArrayListSize));
      return quote;
   }//getQuote()

   private static void addAnimalSounds(String sentence)
   {
      int animalSoundsArrayListSize = animalSounds.size();
      String word = animalSounds.get((int) (Math.random() * animalSoundsArrayListSize));
      JOptionPane.showMessageDialog(null, sentence.substring(0, 8) + word + sentence.substring(7),
            "Straight Face", JOptionPane.INFORMATION_MESSAGE);
   }//addAnimalSounds in the middle of sentence

   private static void addAnimalSounds1(String sentence)
   {
      int animalSoundsArrayListSize = animalSounds.size();
      String word = animalSounds.get((int) (Math.random() * animalSoundsArrayListSize));
      JOptionPane.showMessageDialog(null, sentence + " " + word.substring(0, 1).toUpperCase() + word.substring(1) +
            "!", "Straight Face", JOptionPane.INFORMATION_MESSAGE, noLaugh);
   }//addAnimalSounds at the end of sentence

   private static void modification(String quote, String replaceWord, ArrayList<String> arrayName)
   {
      int arrayNameArrayListSize = arrayName.size();
      String replaceString = quote.replace(replaceWord, arrayName.get((int) (Math.random() * arrayNameArrayListSize)));
      addAnimalSounds1(replaceString);
   }

   private static void modification1(String quote, String replaceWord, ArrayList<String> arrayName)
   {
      int arrayNameArrayListSize = arrayName.size();
      String replaceString = quote.replace(replaceWord,
            arrayName.get((int) (Math.random() * arrayNameArrayListSize)).substring(0, 1).toUpperCase() + arrayName.get((int) (Math.random() * arrayNameArrayListSize)).substring(1));
      addAnimalSounds1(replaceString);
   }//Change first letter of words in a String array list to capital letter

   private static void modification2(String quote, String replaceWord, ArrayList<String> arrayName)
   {
      int arrayNameArrayListSize = arrayName.size();
      String replaceString = quote.replace(replaceWord, arrayName.get((int) (Math.random() * arrayNameArrayListSize)).replaceFirst(".$", ""));
      addAnimalSounds1(replaceString);
   }//Remove the last letter of plural words in a String array list

   private static void doubleModification(String quote, String replaceWord1, ArrayList<String> arrayName1,
                                         String replaceWord2, ArrayList<String> arrayName2)
   {
      int arrayName1ArrayListSize = arrayName1.size();
      int arrayName2ArrayListSize = arrayName2.size();
      String replaceString = quote.replace(replaceWord1,
            arrayName1.get((int) (Math.random() * arrayName1ArrayListSize))).replace(replaceWord2,
            arrayName2.get((int) (Math.random() * arrayName2ArrayListSize)));
      addAnimalSounds1(replaceString);
   }//Replace two words in one sentence

  protected static void plqyStraightFace()
   {
      int numberOfPlayers;
      int option = 0;
      ImageIcon error1 = new ImageIcon("error.png");
      numberOfPlayers = welcomeNoOfPlayers();
      String[] names = createPlayerNames(numberOfPlayers);
      boolean pass= true;
      while (option != 3 && pass)
      {
         do
         {

            String code = JOptionPane.showInputDialog(null, "The Drinking Game - Straight Face" + "\n\nMENU" +
                  "\n1. Auto-generate quote" + "\n2. User-entered quote" + "\n3. Back to main menu" + "\nPlease select " +
                  "your option: ", "Straight Face", JOptionPane.OK_OPTION);
            if (code == null)
            {
               option = 3;
               pass = false;
            }//if select cancel
            else if (code.isBlank())
            {
               JOptionPane.showMessageDialog(null, "Seriously, you can't even type anything??", "Straight Face",
                     JOptionPane.OK_OPTION,error);
               pass = false;
            }//if code.isBlank()
            else
            {
               try
               {
                  option = Integer.parseInt(code);
                  if (option <= 0)
                  {
                     JOptionPane.showMessageDialog(null, "Uh...How can I have negative numbers? Can I have one " +
                           "less eejit here?", "Straight Face", JOptionPane.OK_OPTION,error);
                     pass = false;
                  }//if
                  else
                  if (option > 3){
                     JOptionPane.showMessageDialog(null, "Ffs...we have an eejit here who can't count. Try " +
                                 "again?",
                           "Straight Face", JOptionPane.OK_OPTION,error);
                  pass =false;
                  }
                  else
                  {
                    pass = true;// option = option;
                  }//else
               }//try
               catch (Exception e)
               {
                  JOptionPane.showMessageDialog(null, "What the hell...How hard it is to type 1, 2 or 3??",
                        "Straight Face",
                        JOptionPane.OK_OPTION,error);
                  pass=false;
               }//catch
            }//else
         }while (!pass);

            switch (option)
            {
               case 1:
               {
                  String quote = getQuote();
                  if (quote == quotes.get(0))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     addAnimalSounds(quote);
                  }

                  if (quote == quotes.get(1))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "catch", doingStuff);
                  }

                  if (quote == quotes.get(2))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "force", fWords);
                  }

                  if (quote == quotes.get(3) || quote == quotes.get(11))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "home", places);
                  }

                  if (quote == quotes.get(4))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "king", pWords);
                  }

                  if (quote == quotes.get(5))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "chocolates", randomItems);
                  }

                  if (quote == quotes.get(6))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, ".", randomItems);
                  }

                  if (quote == quotes.get(7))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "swimming", gerunds);
                  }

                  if (quote == quotes.get(8))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "boat", bWords);
                  }

                  if (quote == quotes.get(9))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     addAnimalSounds1(quote);
                  }

                  if (quote == quotes.get(10))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "crying", gerunds);
                  }

                  if (quote == quotes.get(12))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "truth", randomItems);
                  }

                  if (quote == quotes.get(13))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification2(quote, "martini", randomItems);
                  }

                  if (quote == quotes.get(14))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "fairest", estWords);
                  }

                  if (quote == quotes.get(15))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "dreams", randomItems);
                  }

                  if (quote == quotes.get(16))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     doubleModification(quote, "friends", randomItems, "enemies", randomItems);
                  }

                  if (quote == quotes.get(17))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "father", fWords);
                  }

                  if (quote == quotes.get(18))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "luckiest", estWords);
                  }

                  if (quote == quotes.get(19))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification1(quote, "Bond", bWords);
                  }

                  if (quote == quotes.get(20))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "talking", gerunds);
                  }

                  if (quote == quotes.get(21))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "seatbelts", randomItems);
                  }

                  if (quote == quotes.get(22))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "Baby", randomItems);
                  }

                  if (quote == quotes.get(23))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "hello", saidStuff);
                  }

                  if (quote == quotes.get(24))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "infinity", randomItems);
                  }

                  if (quote == quotes.get(25))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     doubleModification(quote, "beauty", pWords, "beast", bWords);
                  }

                  //if (quote == quotes.get(26)){ addAnimalSounds1(quote);} //An alternative

                  if (quote == quotes.get(26))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     addAnimalSounds(quote);
                  }

                  if (quote == quotes.get(27))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "failure", pWords);
                  }

                  if (quote == quotes.get(28))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "roads", randomItems);
                  }

                  if (quote == quotes.get(29))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     doubleModification(quote, "freedom", pWords, "lives", bWords);
                  }

                  if (quote == quotes.get(30))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "Kansas", places);
                  }

                  if (quote == quotes.get(31))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "problem", fWords);
                  }

                  if (quote == quotes.get(32))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "build", doingStuff);
                  }

                  if (quote == quotes.get(33))
                  {
                     randomlyPickedPlayer(names, howMuchToDrink);
                     modification(quote, "odds", randomItems);
                  }
               }//case 1
               break;

               case 2:
               {
                  do
                  {
                     String userGeneratedQuote = JOptionPane.showInputDialog(null,
                           "Please enter the quote you want to be " +
                                 "read out: ", "Straight Face", JOptionPane.INFORMATION_MESSAGE);
                     if (userGeneratedQuote == null)
                     {
                        pass = false;

                     } else if (userGeneratedQuote.isBlank())
                     {
                        JOptionPane.showMessageDialog(null, "How can you not say anything to make people laugh? Make " +
                              "a wet fart noise?", "Straight Face", JOptionPane.OK_OPTION,error);
                        pass = false;
                     } else
                     {
                        randomlyPickedPlayer(names, howMuchToDrink);
                        JOptionPane.showMessageDialog(null, userGeneratedQuote, "Straight Face",
                              JOptionPane.INFORMATION_MESSAGE);
                        pass = true;
                     }//case 2
                  }while (!pass);

               }
               break;

               case 3:
               {
                  ImageIcon sad1 = new ImageIcon("sad1.jpeg");//sad face image
                  JOptionPane.showMessageDialog(null, "Sad to see you go...But thank you for playing!", "Straight Face",
                        JOptionPane.INFORMATION_MESSAGE, sad1);
                  //Go back to main menu
               }//case 3
               break;
            }//switch
      }//while
   }//main
}//class