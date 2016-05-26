import java.util.*;

public static int score = 0;
public static BoggleGrid grid;
public static ArrayList<String> guesses;

public class PlayBoggle{
  
  /** Get size from user and create grid of that size.
   *  Display grid.
   *  Allow the user to guess as many words as possible.
   */
  public static void main(String[] args){
    Scanner c = new Scanner(System.in);
    int size = c.nextInt();
    BoggleGrid grid = new BoggleGrid(size);
    grid.printGrid(); //displays grid
    
    String guess = "";
    while (!guess.equals(***)){
      guess = getGuesses(c);
      guesses.add(guess);
      System.out.println(guess);
    }
  }
  
  /** Get guesses from the user.
   *  Go through entire grid to search for the word.
   */
  public static String getGuesses(Scanner c){
    String guess = c.next();
    if (guess.equals("***") || alreadyGuessed()) return guess;
    guess = guess.toUpperCase();
    //goes through entire grid
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        if (checkIfWordMatches(guess, position, 0)){
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
  public static boolean checkIfWordMatches(String guess, int[] position, int 0){
    int r = position[0];
    int c = position[1];
    
    //assert that the given position exists in the grid
    if (r < guess.length() && r >= 0 && c < guess.length() && c >= 0){
      //base case 1
      if (i == guess.length()){
        return true;
      }
      //base case 2
      else if (guess.charAt(i) != grid[r][c].getLetter()){
        return false;
      }
      //recursive case
      else {
        i++; 
        return 
        checkIfWordMatches(guess, [r-1, c-1], i) ||
        checkIfWordMatches(guess, [r-1, c], i) || 
        checkIfWordMatches(guess, [r-1, c+1], i) ||
        checkIfWordMatches(guess, [r, c-1], i) ||
        checkIfWordMatches(guess, [r, c+1], i) ||
        checkIfWordMatches(guess, [r+1, c-1], i) ||
        checkIfWordMatches(guess, [r+1, c], i) ||
        checkIfWordMatches(guess, [r+1, c+1], i);
      }
    }
  }
  public static boolean alreadyGuessed(){
    for (int i=0; i<guesses.size(); i++){
      if (guess.equals(guesses.get(i)){
        System.out.println("Already guessed.");
        return true;
      }
      else return false;
    }
  }
}
