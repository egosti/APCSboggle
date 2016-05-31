/* pseudocode for the Boggle Grid
//instance variables:
2D array 
list of all possible words
constructor:
-get input from reader for size of board
-create a 2D array with a side = input from reader
-create array of the 26 letters (see letter class)
-for each spot in array, assign a random letter according to guidelines (create a method)
fillGrid method:
-fill in vowels first
-fill in remaining letters randomly, Q can only come in if there's already a U, and Q is limited to the areas around U
-after filling, check. If a letter has surpassed 20% of the board, replace it with another
*/
import java.util.Random;

public class BoggleGrid {
  
  private BoggleLetter[][] grid;
  private int size;
  private char[] letters = new char[31]; //add a for loop for letters, vowels show up twice
  private int[] letterCounts = new int[31];
  
  public BoggleGrid(int size) {
    grid = new BoggleLetter[size][size];
    this.size = size;
    setLetters();
    fillGrid();
  }
  
  private void setLetters() { //add a for loop to fill letters array
    letters[0] = 'A';
    for (int i = 1; i < letters.length; i++) {
      letters[i] = (char) (letters[i - 1] + 1);
    }
    letters[26] = 'A';
    letters[27] = 'E';
    letters[28] = 'I';
    letters[29] = 'O';
    letters[30] = 'U';
  }
  
  private void addCount(char letter) {
    int index = -1;
    for (int i = 0; i < letters.length; i++) {
      if (letter == letters[i]) {
        index = i;
	break;
      }
    }
    letterCounts[index]++;
  }
  
  private void subtractCount(char letter) {
    int index = 0;
    for (int i = 0; i < letters.length; i++) {
      if (letter == letters[i]) {
        index = i;
      break;
      }
    }
    letterCounts[index]--;
  }
    
  
  private void fillGrid() {
    Random rand = new Random(); //check if i need to multiply or add size by anything
    int position;
    //first assign vowels
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
	//  if (grid[r][c].getLetter() != '\u0000') { //if a letter is already there (vowel) don't put anything
          char L = getRandomLetter();
          grid[r][c] = new BoggleLetter(L, r, c);
	  addCount(grid[r][c].getLetter());
          if (L == 'Q') {
            if (r > 0 && r < size - 1 && c > 0 && c < size - 1) { // the letter is not on the edge of the grid
              position = rand.nextInt(8) + 1; //get random number from 1-8
              if (position == 1) {
                grid[r][c-1] = new BoggleLetter('U', r, c-1);
              } else if (position == 2) {
                grid[r-1][c-1] = new BoggleLetter('U', r-1, c-1);
              } else if (position == 3) {
                grid[r-1][c] = new BoggleLetter('U', r-1, c);
              } else if (position == 4) {
                grid[r-1][c+1] = new BoggleLetter('U', r-1, c+1);
              } else if (position == 5) {
                grid[r][c+1] = new BoggleLetter('U', r, c+1);
              } else if (position == 6) {
                grid[r+1][c+1] = new BoggleLetter('U', r+1, c+1);
              } else if (position == 7) {
                grid[r+1][c] = new BoggleLetter('U', r+1, c);
              } else {
                grid[r+1][c-1] = new BoggleLetter('U', r+1, c-1);
              }
            } else if (c == 0 && r > 0 && r < size - 1) { //the letter is on the left side and not in the corner
              position = rand.nextInt(5) + 1;
              if (position == 1) {
                grid[r-1][c] = new BoggleLetter('U', r-1, c);
              } else if (position == 2) {
                grid[r-1][c+1] = new BoggleLetter('U', r-1, c+1);
              } else if (position == 3) {
                grid[r][c+1] = new BoggleLetter('U', r, c+1);
              } else if (position == 4) {
                grid[r+1][c+1] = new BoggleLetter('U', r+1, c+1);
              } else {
                grid[r+1][c] = new BoggleLetter('U', r+1, c);
              }
            } else if (c == size - 1 && r > 0 && r < size - 1) { //the letter is on the right side and not in the corner
              position = rand.nextInt(5) + 1;
              if (position == 1) {
                grid[r-1][c] = new BoggleLetter('U', r-1, c);
              } else if (position == 2) {
                grid[r-1][c-1] = new BoggleLetter('U', r-1, c-1);
              } else if (position == 3) {
                grid[r][c-1] = new BoggleLetter('U', r, c-1);
              } else if (position == 4) {
                grid[r+1][c-1] = new BoggleLetter('U', r+1, c-1);
              } else {
                grid[r+1][c] = new BoggleLetter('U', r+1, c);
              }
            } else if (r == 0 && c > 0 && c < size - 1) { //the letter is on the top of the grid and not in the corner
              position = rand.nextInt(5) + 1;
              if (position == 1) {
                grid[r][c-1] = new BoggleLetter('U', r, c-1);
              } else if (position == 2) {
                grid[r+1][c-1] = new BoggleLetter('U', r+1, c-1);
              } else if (position == 3) {
                grid[r+1][c] = new BoggleLetter('U', r+1, c);
              } else if (position == 4) {
                grid[r+1][c+1] = new BoggleLetter('U', r+1, c+1);
              } else {
                grid[r][c+1] = new BoggleLetter('U', r, c+1);
              }
            } else if (r == size - 1 && c > 0 && c < size - 1) { //the letter is on the bottom of the grid and not in the corner
              position = rand.nextInt(5) + 1;
              if (position == 1) {
                grid[r][c-1] = new BoggleLetter('U', r, c-1);
              } else if (position == 2) {
                grid[r-1][c-1] = new BoggleLetter('U', r-1, c-1);
              } else if (position == 3) {
                grid[r-1][c] = new BoggleLetter('U', r-1, c);
              } else if (position == 4) {
                grid[r-1][c+1] = new BoggleLetter('U', r-1, c+1);
              } else {
                grid[r][c+1] = new BoggleLetter('U', r, c+1);
              }
            } else if (r == 0 && c == 0) { //top left corner
              position = rand.nextInt(3) + 1;
              if (position == 1) {
                grid[r+1][c] = new BoggleLetter('U', r+1, c);
              } else if (position == 2) {
                grid[r+1][c+1] = new BoggleLetter('U', r+1, c+1);
              } else {
                grid[r][c+1] = new BoggleLetter('U', r, c+1);
              }
            } else if (r == size - 1 && c == 0) { //bottom left corner
              position = rand.nextInt(3) + 1;
              if (position == 1) {
                grid[r-1][c] = new BoggleLetter('U', r-1, c);
              } else if (position == 2) {
                grid[r-1][c+1] = new BoggleLetter('U', r-1, c+1);
              } else {
                grid[r][c+1] = new BoggleLetter('U', r, c+1);
              }
            } else if (r == size - 1 && c == size - 1) { //bottom right corner
              position = rand.nextInt(3) + 1;
              if (position == 1) {
                grid[r][c-1] = new BoggleLetter('U', r, c-1);
              } else if (position == 2) {
                grid[r-1][c-1] = new BoggleLetter('U', r-1, c-1);
              } else {
                grid[r-1][c] = new BoggleLetter('U', r-1, c);
              }
            } else { //top right corner
              position = rand.nextInt(3) + 1;
              if (position == 1) {
                grid[r][c-1] = new BoggleLetter('U', r, c-1);
              } else if (position == 2) {
                grid[r+1][c-1] = new BoggleLetter('U', r+1, c-1);
              } else {
                grid[r+1][c] = new BoggleLetter('U', r+1, c);
              }
	      addCount('Q');
            }
	    //  }
        }
      }
    }
    //checkIfTooMany
    //while checkIfTooMany is true, fixTooMany
    //fixTooMany
    boolean isRight = false;
    boolean fixAny;
    while (!isRight) {
      fixAny = false;
      for (int r = 0; r < size; r++) {
	for (int c = 0; c < size; c++) {
	  if (checkIfTooMany(grid[r][c])) {
	    fixTooMany(grid[r][c].getLetter());
	    fixAny = true;
	  }
	}
      }
      if (!fixAny) {
	isRight = true;
      }
    }
  }
  
  private char getRandomLetter() {
    Random r = new Random();
    int index = r.nextInt(31);
    return letters[index];
  }
  
  private boolean checkIfTooMany(BoggleLetter bogLet) { //checks if there are over 20% of the same letter in the grid
    long threshold = Math.round(size * size * 0.2);
    int index = -1;
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] == bogLet.getLetter()) {
        index = i; //find where the letter occurs
      }
    }
    return letterCounts[index] > threshold;
  }
  
  private void fixTooMany(char L) { //find first instance of the letter, replace it with a different letter
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (grid[r][c].getLetter() == L) {
	  subtractCount(L);
          grid[r][c] = new BoggleLetter(getRandomLetter(), r, c);
        }
      }
    }
  }
  
  public String toString() { //needs formatting
    String temp = "";
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        temp = temp + grid[r][c].getLetter() + " ";
      }
      temp = temp + "\n";
    }
    return temp;
  }

  public BoggleLetter getLetterAtPosition(int r, int c){
    return this.grid[r][c];
  }
  
}
