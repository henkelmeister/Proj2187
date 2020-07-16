package hanoi;

import structures.LinkedStack;
import structures.StackInterface;

/** A {@link StackBasedHanoiPeg} is a {@link HanoiPeg} backed by a {@link LinkedStack} */
public class StackBasedHanoiPeg implements HanoiPeg {
  // TODO: Add any useful instance variables to StackBasedHanoiPeg
  /** Creates a new {@link StackBasedHanoiPeg} that has no rings. */
  private LinkedStack<HanoiRing> peg;

  public StackBasedHanoiPeg() {
    // TODO: Initialize StackBasedHanoiPeg properly
    // Make sure you initialize any instance variables that you declare.
    peg = new LinkedStack<HanoiRing>(); 
  }

  @Override
  public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
    // TODO: Implement the addRing method
      if(peg.isEmpty())peg.push(ring); 
        else if(peg.peek().getSize() > ring.getSize()){
          throw new IllegalHanoiMoveException("Ring on peg is smaller");
        } else{
            peg.push(ring); 
        }
  }

  @Override
  public HanoiRing remove() throws IllegalHanoiMoveException {
    // TODO: Implement the remove method
    if(peg.isEmpty()) throw new IllegalHanoiMoveException("Empty stack");

    return peg.pop();
  }

  @Override
  public HanoiRing getTopRing() throws IllegalHanoiMoveException {
    // TODO: Implement the getTopRing method
    if(peg.isEmpty()) throw new IllegalHanoiMoveException("Empty stack"); 
    
    return peg.peek();
  }

  @Override
  public boolean hasRings() {
    // TODO: Implement the hasRings method
    return !peg.isEmpty();
  }
}
