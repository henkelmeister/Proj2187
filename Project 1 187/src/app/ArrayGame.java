package app;

import java.util.Arrays;

/**
 * An Array-based implementation of the Guess-A-Number game.
 */
public class ArrayGame {

  // stores the next number to guess
  private boolean[] eliminated;
  private boolean[] priorguesses;
  private int guess;
  private int numGuesses;
  private boolean isFound;

  /********************************************************
   * NOTE: you are allowed to add new methods if necessary, but DO NOT remove any
   * provided method, otherwise your code will fail the JUnit tests. Also DO NOT
   * create any new Java files, as they will be ignored by the autograder!
   *******************************************************/

  // ArrayGame constructor method
  public ArrayGame() {
    // TODO: Implement the ArrayGame() constructor
    guess = 1000;
    priorguesses = new boolean[9000];
    numGuesses = 0;
    eliminated = new boolean[9000];
    isFound = false;
  }

  /**
   * Resets data members and game state so we can play again.
   */
  public void reset() {
    // TODO: Implement the reset() method
    guess = 1000;
    priorguesses = new boolean[9000];
    numGuesses = 0;
    eliminated = new boolean[9000];
    isFound = false;
  }

  /**
   * Returns true if n is a prior guess; false otherwise.
   */
  public boolean isPriorGuess(int n) {
    // TODO: Implement the isPriorGuess() method
    int index = n - 1000;
    return priorguesses[index];
  }

  /**
   * Returns the number of guesses so far.
   */
  public int numGuesses() {
    // TODO: Implement the numGuesses() method
    return numGuesses;
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
   * Returns true if the game is over; false otherwise. The game is over if the
   * number has been correctly guessed or if all candidates have been eliminated.
   */
  public boolean isOver() {
    // TODO: Implement the isOver() method
    if (isFound) {
      return true;
    }
    return false;
  }

  /**
   * Returns the guess number and adds it to the list of prior guesses.
   */
  public int getGuess() {
    // TODO: Implement the getGuess() method
    int index = guess - 1000;
    priorguesses[index] = true;
    numGuesses++;
    return guess;
  }

  /**
   * Updates guess based on the number of matches of the previous guess. If
   * nmatches is 4, the previous guess is correct and the game is over. Check
   * project description for implementation details.
   * 
   * <p>
   * Returns true if the update has no error; false if all candidates have been
   * eliminated (indicating a state of error);
   */
  public boolean updateGuess(int nmatches) {
    // TODO: Implement the updateGuess() method
    if (nmatches == 4) {
      isFound = true;
      return true;
    }
    for (int i = 0; i < 9000; i++) {
      if (eliminated[i]) {
        continue;
      } else {
        if (numMatches(guess, i + 1000) != nmatches) {
          eliminated[i] = true;
        }
      }
    }

    for (int i = 0; i < 9000; i++) {
      if (eliminated[i] != false) {
        continue;
      } else {
        guess = i + 1000;
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the list of guesses so far as an integer array. The size of the array
   * must be the number of prior guesses. Returns null if there has been no prior
   * guess
   */
  public int[] priorGuesses() {
    // TODO: Implement the priorGuesses() method
    if (numGuesses == 0) {
      return null;
    }
    int pointer = 0;
    int[] priorGuessesList = new int[numGuesses];
    for (int i = 0; i < 9000; i++) {
      if (priorguesses[i]) {
        priorGuessesList[pointer] = (i + 1000);
        pointer++;
      }
    }
    return priorGuessesList;
  }
}
