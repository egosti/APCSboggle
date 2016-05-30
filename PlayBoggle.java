import java.util.*;
import java.io.*;

public class PlayBoggle{

  public static int score = 0;
  public static BoggleGrid grid;
  public static ArrayList<String> guesses = new ArrayList<String>();
  public static int size;
  public static String guess;
  public static HashSet<String> dictionary = new HashSet<>();
  
  /** Get size from user and create grid of that size.
   *  Display grid.
   *  Allow the user to guess as many words as possible.
   */
  public static void main(String[] args) throws FileNotFoundException {
    Scanner c = new Scanner(System.in);
    Scanner input = new Scanner(new File("wordsEn.txt"));
    String nextWordInDictionary;
    while (input.hasNext()) {
      nextWordInDictionary = input.next().toUpperCase();
      dictionary.add(nextWordInDictionary); //creates arraylist of all the possible words in the English language
    }

    intro();
    System.out.println("Please enter the size of the grid (5 or higher recommended): ");
    size = c.nextInt();
    grid = new BoggleGrid(size);
    System.out.println(grid); //displays grid
    
    String guess = "";
    while (!guess.equals("***")){
      guess = getGuesses(c);
      guesses.add(guess);
      System.out.println("Your score is " + score);
      System.out.println();
    }
  }

  public static void intro() {
    System.out.println("Welcome to Boggle!\nThis is an untimed game that tests your ability to find English words in a grid of letters. The letters of the words need to be connected to each other either side-by-side or diagonally. Each word you guess correctly increases your total score by the number of letters in the word. Once you run out of words, just enter three stars (***) to exit the game. Happy Boggling!");
  }
  
  /** Get guesses from the user.
   *  Go through entire grid to search for the word.
   */
  public static String getGuesses(Scanner c){
    System.out.println("Enter guess: ");
    guess = c.next();
    if (guess.equals("***") || alreadyGuessed()) return guess;
    guess = guess.toUpperCase();
    //goes through entire grid
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        int[] position = new int[2];
	if (checkIfWordMatches(guess, row, col, 0) && dictionary.contains(guess)) {
          score += guess.length(); //adds length of guess to the score
          break;
        }
      }
    }
    return guess;
  }
  
  /** Recursive function.
   *  Checks if the word is in the grid; returns false if no. 
   */
  public static boolean checkIfWordMatches(String guess, int r, int c, int i){
    //assert that the given position exists in the grid
    if (r < size && r >= 0 && c < size && c >= 0){
      //base case 1
      if (i == guess.length()){
        return true;
      }
      //base case 2
      else if (guess.charAt(i) != grid.getLetterAtPosition(r, c).getLetter()){
        return false;
      } 
      //recursive case
      else {
        i++; 
        return 
        checkIfWordMatches(guess, r-1, c-1, i) ||
        checkIfWordMatches(guess, r-1, c, i) || 
        checkIfWordMatches(guess, r-1, c+1, i) ||
        checkIfWordMatches(guess, r, c-1, i) ||
        checkIfWordMatches(guess, r, c+1, i) ||
        checkIfWordMatches(guess, r+1, c-1, i) ||
        checkIfWordMatches(guess, r+1, c, i) ||
        checkIfWordMatches(guess, r+1, c+1, i);
      }
    }
    else return false;
  }
  
  public static boolean alreadyGuessed(){
    for (int i=0; i<guesses.size(); i++){
      if (guess.equals(guesses.get(i))){
        System.out.println("You've already guessed this word!");
        return true;
      }
    }
    return false;
  }

}
