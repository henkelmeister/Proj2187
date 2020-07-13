package hanoi;

/** A {@link ArrayBasedHanoiBoard} is a simple implementation of {@link HanoiBoard} */
public class ArrayBasedHanoiBoard implements HanoiBoard {
  // TODO: Add useful instance variables to the ArrayBasedHanoiBoard class

  /**
   * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s and {@code n} rings
   * on peg 0.
   */
  public ArrayBasedHanoiBoard(int n) {
    // TODO: Implement the ArrayBasedHanoiBoard constructor
  }

  @Override
  public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
    // TODO: Implement the doMove method
  }

  @Override
  public boolean isSolved() {
    // TODO: Implement the isSolved method.

    return false;
  }

  /**
   * A {@link HanoiMove} is not legal if either is true:
   *
   * <ul>
   *   <li>The from peg has no rings
   *   <li>The to peg has rings AND the ring to be moved has a size larger than the topmost ring on
   *       the to peg.
   * </ul>
   *
   * Otherwise, the move is legal.
   */
  @Override
  public boolean isLegalMove(HanoiMove move) {
    // TODO: Implement the isLegalMove method

    return false;
  }
}
