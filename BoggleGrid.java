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
  private char[] letters = new char[26]; //add a for loop for letters
  private int[] letterCounts = new int[26];
  
  public BoggleGrid(int size) {
    grid = new BoggleLetter[size][size];
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
    //fixTooMany
    //checkQ
    Random r = new Random(size); //check if i need to multiply or add size by anything
    int r.nextInt(); //FIGURE OUT ALGORITHM FOR ASSIGNING VOWELS
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (grid[r][c] != '\u0000') {
          char L = getRandomLetter();
          grid[r][c] = new BoggleLetter(L, r, c);
          if (L == 'Q') {
          //put U next to it
          }
        }
      }
    }
  }
  
  private char getRandomLetter() {
    //write this method
    Random r = new Random(26);
    int index = r.nextInt() + 1;
    return letters[index];
  }
  
  private boolean checkIfTooMany(BoggleLetter bogLet) { //checks if there are over 20% of the same letter in the grid
    int threshold = Math.round(size * size * 0.2);
    int index = -1;
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] == bogLet.getLetter()) {
        index = i;
      }
    }
    return letterCounts[i] > threshold;
  }
  
}


