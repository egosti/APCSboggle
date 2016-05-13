import java.util.*;

public class PlayBoggle{
  public static void main(String[] args){
      Scanner c = new Scanner(System.in);
      BoggleGrid grid = new BoggleGrid(size);
    /* create timer
     * display grid
     * while timer > 0, take input from user getGuesses(c) */
  }
  public static void getGuesses(Scanner c){
    String guess = c.next();
    guess = guess.toUpperCase();
    
      // *** OUTER LOOP*** 
    char c = guess.charAt(0);
      /* go through grid & check if any letter matches char c
       * return position **[r, c]** of letter, otherwise return [-1, -1]
       
       * if YES: 
          checkIfWordMatches(guess, position); */
  }
  public static boolean checkIfWordMatches(String guess, int[] position){
    //recursive function
  }
}


methods:
-main: (import list of valid words)
-timer 
-display grid
-public static boolean guessWord (checks if user input is a solution and hasn't been guessed before)
-addPoint (different point values for words of different lengths)

public class PlayBoggle{
  public static 
  
  
}
