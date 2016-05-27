public class BoggleLetter{
 
 private boolean isVowel;
 private int[] position;
 private char letter;
 
 public BoggleLetter(char L, int r, int c){
  position = new int[2];
  letter = L;
  position[0] = r;
  position[1] = c;
  isVowel = checkVowel(L);
 }
 private static boolean checkVowel(char L){
  return (L == 'A' || L == 'E' || L == 'I' || L == 'O' || L == 'U');
 }
 public char getLetter(){
  return this.letter;
 }
 public int[] getPosition(){
  return this.position;
 }
 public boolean getIsVowel(){
  return this.isVowel;
 }
 
 public String toString() {
  String temp = "" + letter;
  return temp;
 }
 
}
