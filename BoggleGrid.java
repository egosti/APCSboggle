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

public class BoggleGrid {
  
  private BoggleLetter[][] grid;
  private int size;
  private char[] letters = new char[26]; //add a for loop for letters
  private int[] letterCounts = new int[26];
  
  public BoggleGrid(int size) {
    grid = new BoggleLetter[size][size];
    this.size = size;
    fillGrid();
  }
  
  private void setLetters() { //add a for loop to fill letters
    letters[0] = 'A';
    for (int i = 1; i < letters.length; i++) {
      letters[i] = letters[0] + 1;
    }
  }
  
  private void addCount(BoggleLetter bogLet) {
    char letter = bogLet.getLetter();
    int index = -1;
    for (int i = 0; i < letters.length; i++) {
      if (letter == letters[i]) {
        index = i;
      }
    }
    letterCounts[index]++;
  }
  
  private void subtractCount(BoggleLetter bogLet) {
    char letter = bogLet.getLetter();
    int index = -1;
    for (int i = 0; i < letters.length; i++) {
      if (letter == letters[i]) {
        index = i;
      }
    }
    letterCounts[index]--;
  }
    
  
  private void fillGrid() {
    //setLetters
    //fillVowels
    //fillConsonants
    //checkIfTooMany
    //while checkIfTooMany is true, fixTooMany
    //fixTooMany
    //checkQ
    Random rand = new Random(); //check if i need to multiply or add size by anything
    int r.nextInt(); //FIGURE OUT ALGORITHM FOR ASSIGNING VOWELS
    int position;
    //first assign vowels
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (grid[r][c] != '\u0000') { //if a letter is already there (vowel) don't put anything
          char L = getRandomLetter();
          grid[r][c] = new BoggleLetter(L, r, c);
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
            } else if (r == size - 1 && c = 0) { //bottom left corner
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
            }
          }
        }
      }
    }
  }
  
  private char getRandomLetter() {
    Random r = new Random(26);
    int index = r.nextInt() + 1;
    return letters[index];
  }
  
  private boolean checkIfTooMany(BoggleLetter bogLet) { //checks if there are over 20% of the same letter in the grid
    int threshold = Math.round(size * size * 0.2);
    int index = -1;
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] == bogLet.getLetter()) {
        index = i; //find where the letter occurs
      }
    }
    return letterCounts[i] > threshold;
  }
  
  private void fixTooMany(char L) { //find first instance of the letter, replace it with a different letter
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (grid[r][c].getLetter() == L) {
          grid[r][c] = new BoggleLetter(getRandomLetter(), r, c);
        }
      }
    }
  }
  
  private void printGrid() {
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        System.out.print(grid[r][c].getLetter());
      }
      System.out.println();
    }
  }
  
}


