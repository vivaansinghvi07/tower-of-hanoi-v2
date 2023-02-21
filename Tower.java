import java.io.*;
import java.util.*;

public class Tower {
  public ArrayList<Integer> blocks;
  
  public Tower (boolean start, int n) {
    // initializes the blocks arraylist
    this.blocks = new ArrayList<Integer>();

    // if it is the first tower, allow it
    if (start) {
      for (int i = 1; i <= n; i++) {
        this.blocks.add(i);
      }
    }
  }

  // moves a block from one tower to another
  public int transfer(Tower other) {
    // checks if the origin has no blocks to give
    if (this.blocks.size() == 0) {
      return 1; // error code for when there are no blocks to transfer
    }
    // checks if the other tower is empty
    else if (other.blocks.size() == 0) {
      Integer block = this.blocks.remove(0);
      other.blocks.add(block);
      return 0; // successful transfer
    }
    // checks if the top of the other tower is less than the top of the origin tower (the block that will be transfered)
    else if (this.blocks.get(0) > other.blocks.get(0)) {
      return 2; // error code when the origin tower has a larger block than the top of the other tower
    }
    // if none of the restrictions are broken then the transfer can happen
    else {
      Integer block = this.blocks.remove(0);
      other.blocks.add(0, block);
      return 0; // successful transfer
    }
  }
  
  // returns the number of the block that is i above the base - used in the display feature
  public int blockAt(int i) {
    // if the size is not breached, then return the block
    try {
      int s = this.blocks.size();
      return this.blocks.get(s - i - 1);
    }
    // otherwise, since there are no blocks, just return a 0 to represent an empty space
    catch (Exception e) {
      return 0;
    }
  }
}