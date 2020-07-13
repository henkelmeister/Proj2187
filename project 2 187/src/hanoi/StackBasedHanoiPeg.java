package hanoi;

import structures.LinkedStack;
import structures.StackInterface;

/** A {@link StackBasedHanoiPeg} is a {@link HanoiPeg} backed by a {@link LinkedStack} */
public class StackBasedHanoiPeg implements HanoiPeg {
  // TODO: Add any useful instance variables to StackBasedHanoiPeg
  /** Creates a new {@link StackBasedHanoiPeg} that has no rings. */
  public StackBasedHanoiPeg() {
    // TODO: Initialize StackBasedHanoiPeg properly
    // Make sure you initialize any instance variables that you declare.
  }

  @Override
  public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
    // TODO: Implement the addRing method
  }

  @Override
  public HanoiRing remove() throws IllegalHanoiMoveException {
    // TODO: Implement the remove method
    return null;
  }

  @Override
  public HanoiRing getTopRing() throws IllegalHanoiMoveException {
    // TODO: Implement the getTopRing method
    return null;
  }

  @Override
  public boolean hasRings() {
    // TODO: Implement the hasRings method
    return false;
  }
}
