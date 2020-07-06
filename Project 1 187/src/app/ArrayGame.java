package app;
import java.util.Arrays;

/**
 * An Array-based implementation of the Guess-A-Number game.
 */
public class ArrayGame {

  // stores the next number to guess
  private static int guess;
  private int[] priorguesses;
  private int numguess;
  private int tail;
  private boolean isfound;

  /********************************************************
   * NOTE: you are allowed to add new methods if necessary, but DO NOT remove any
   * provided method, otherwise your code will fail the JUnit tests. Also DO NOT
   * create any new Java files, as they will be ignored by the autograder!
   *******************************************************/

  // ArrayGame constructor method
  public ArrayGame() {
    // TODO: Implement the ArrayGame() constructor
    guess = 0;
    priorguesses = new int[1];
    numguess = 0;
    tail = 0;
    isfound = false;

  }

  /**
   *  Resets data members and game state so we can play again.
   */
  public void reset() {
    // TODO: Implement the reset() method
    isfound = false;
    priorguesses = new int[1];
    numguess = 0;
    tail = 0; 
    isfound = false; 

  }

  /**
   * Returns true if n is a prior guess; false otherwise.
   */
  public boolean isPriorGuess(int n) {
    // TODO: Implement the isPriorGuess() method
    for (int i = 0; i < priorguesses.length; i++) {
      if (n != priorguesses[i]) {
        continue;
      } else {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the number of guesses so far.
   */
  public int numGuesses() {
    // TODO: Implement the numGuesses() method
    return numguess;
  }

  /**
   * Returns the number of matches between integers a and b. You can assume that
   * both are 4-digits long (i.e. between 1000 and 9999). The return value must be
   * between 0 and 4.
   * 
   * <p>
   * A match is the same digit at the same location. For example: 1234 and 4321
   * have 0 match; 1234 and 1114 have 2 matches (1 and 4); 1000 and 9000 have 3
   * matches (three 0's).
   */
  public static int numMatches(int a, int b) { // DO NOT remove the static qualifier
    // TODO: Implement the numMatches() method
    int[] aArray = new int[4];
    int[] bArray = new int[4];
    int numright = 0; 
    guess = a; 
    

    aArray[0] = a % 10;
    aArray[1] = a / 10 % 10;
    aArray[2] = a / 100 % 10;
    aArray[3] = a / 1000 % 10;

    bArray[0] = b % 10;
    bArray[1] = b / 10 % 10;
    bArray[2] = b / 100 % 10;
    bArray[3] = b / 1000 % 10;

    for (int i = 0; i < 4; i++) {
      if (aArray[i] == bArray[i])
        numright++;
    }
    return numright;
  }

  /**
   * Returns true if the game is over; false otherwise.
   * The game is over if the number has been correctly guessed
   * or if all candidates have been eliminated.
   */
  public boolean isOver() {
    // TODO: Implement the isOver() method
    if(isfound){
      return true; 
    }
    return false;
  }

  /**
   *  Returns the guess number and adds it to the list of prior guesses.
   */
  public int getGuess() {
    // TODO: Implement the getGuess() method   
    
    int[] temparr = new int[priorguesses.length + 1];
      tail++;
      for(int i=0; i < priorguesses.length;i++){
        temparr[i] = priorguesses[i];
      }
      temparr[tail] = guess;

      priorguesses = temparr; 
      
    return guess;
  }

  /**
   * Updates guess based on the number of matches of the previous guess.
   * If nmatches is 4, the previous guess is correct and the game is over.
   * Check project description for implementation details.
   * 
   * <p>Returns true if the update has no error; false if all candidates
   * have been eliminated (indicating a state of error);
   */
  public boolean updateGuess(int nmatches) {
    // TODO: Implement the updateGuess() method
    return false;
  }

  /**
   * Returns the list of guesses so far as an integer array.
   * The size of the array must be the number of prior guesses.
   * Returns null if there has been no prior guess
   */
  public int[] priorGuesses() {
    // TODO: Implement the priorGuesses() method
    return priorguesses;
  }
}
