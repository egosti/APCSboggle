import java.util.*;

public class PlayBoggle{

  public static int score = 0;
  public static BoggleGrid grid;
  public static ArrayList<String> guesses = new ArrayList<String>();
  public static int size;
  public static String guess;
  public static ArrayList<String> dictionary = new ArrayList<String>();
  
  /** Get size from user and create grid of that size.
   *  Display grid.
   *  Allow the user to guess as many words as possible.
   */
  public static void main(String[] args){
    Scanner c = new Scanner(System.in);
    Scanner input = new Scanner(new File("blah.txt"));
    String nextWordInDictionary;
    while (input.hasNext()) {
      nextWordInDictionary = input.next().toUpperCase();
      dictionary.add(nextWordInDictionary); //creates arraylist of all the possible words in the English language
    }
    
    System.out.println("Enter size: ");
    size = c.nextInt();
    grid = new BoggleGrid(size);
    System.out.println(grid); //displays grid
    
    String guess = "";
    while (!guess.equals("***")){
      guess = getGuesses(c);
      guesses.add(guess);
      System.out.println(score);
    }
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
         if (checkIfWordMatches(guess, row, col, 0) && doesWordExist(guess)){
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
        System.out.println("Already guessed.");
        return true;
      }
    }
    return false;
  }
  
  public static boolean doesWordExist(String guess) { //binary search for word
    int low = 0; //these numbers are the indexes of the words
    int high = dictionary.size() - 1; //i'm calling the file "dictionary"
    int middle;
    int index = -1; //index of the guess in the dictionary
    while (low <= high) {
      middle = (low + high) / 2;
      if (guess.compareTo(dictionary.get(middle) < 0)) {
        high = middle;
      } else if (guess.compareTo(dictionary.get(middle) > 0)) {
        low = middle;
      } else {
        index = middle;
      }
    }
    return (index != -1);
  }
}
