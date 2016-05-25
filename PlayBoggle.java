import java.util.*;

public class PlayBoggle{
  public static void main(String[] args){
      Scanner c = new Scanner(System.in);
      BoggleGrid grid = new BoggleGrid(size);
      grid.printGrid(); //displays grid
      getGuesses(c, grid);
    /* create timer
     * while timer > 0, take input from user getGuesses(c) */
  }
  public static void getGuesses(Scanner c, BoggleGrid grid){
    String guess = c.next();
    guess = guess.toUpperCase();
    
      // *** OUTER LOOP*** 
    char ch = guess.charAt(0);
      /* go through grid & check if any letter matches char c
       * return position **[r, c]** of letter, otherwise return [-1, -1]
       * also need a way to check the next instance of c if the first one doesn't work
       
       * if YES: 
          checkIfWordMatches(guess, position, 1); */
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        if (grid[row][col].getLetter() == guess) {
          checkIfWordMatches(guess, position, 1);
        }
        else {
          getGuesses(c, grid); //how do we see if there are any more of the same letter?
        }
      }
    }
  }
  public static boolean checkIfWordMatches(String guess, int[] position, int i){
    //base case 1
    if (i == guess.length()){
      return true;
    }
    //base case 2
    else if (guess.charAt(i) != /****letter @ grid position*/ ){
      return false;
    }
    //recursive case
    else {
      i++; 
      return 
      checkIfWordMatches(guess, [r-1, c-1], i+1);
    
    //recursive function
  }
}


methods:
-main: (import list of valid words)
-timer 
-public static boolean guessWord (checks if user input is a solution and hasn't been guessed before)
-addPoint (different point values for words of different lengths)
  
}
