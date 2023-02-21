import java.util.*;
import java.io.*;

public class Game {
  
  public static final String[] colors = {Colors.RED_BRIGHT, Colors.GREEN_BRIGHT, Colors.YELLOW_BRIGHT, Colors.BLUE_BRIGHT, Colors.PURPLE_BRIGHT, Colors.CYAN_BRIGHT, Colors.RED, Colors.GREEN, Colors.YELLOW, Colors.BLUE, Colors.PURPLE, Colors.CYAN};
  // contains 12 colors that will be rotated through to assign colors to blocks

  private int size;
  private Tower[] towers;
  public int moves;
  private String square;
  public Game (int n) {
    // creates the game and populates it with towers
    towers = new Tower[3];
    for (int i = 0; i < 3; i++) {
      // adds towers to the thing, if it is the first one you add the starting blocks too
      towers[i] = new Tower(i == 0, n);
    }

    // assigns values
    moves = 0;
    size = n;

    //determines width of the squares based on size of the game
    this.square = (n > 10) ? "█" : "██";
  }

  // displays the game
  public void display() {

    // clears the canvas
    Colors.clear();

    // creates the bases based on the size of the game board
    String out = new String(getBase());

    // creates each row
    for (int i = 0; i < size + 1; i++) {
      String row = new String("");
      // adds the block for each tower
      for (int j = 0; j < 3; j++) {
        Tower temp = towers[j];
        row += printBlock(temp.blockAt(i)) + "   ";
      }
      // adds the row on top of the base
      out = row + "\n" + out;
    }
    System.out.println("\n" + out + "\n");
  }

  // prints the base for each tower
  private String getBase() {
    // stores the color and initializes the string with that color
    String color = Colors.WHITE_BRIGHT; 
    String base = new String(color);

    // creates the base based on the size there are - since there is 1 square for the pole and and n amount on either side 
    for (int i = 0; i < size * 2 + 1; i++) {
      base += this.square;
    }
    return base + "   " + base + "   " + base;
  }

  // prints each block on a tower
  private String printBlock(int n) {
    
    // stores a blank color if there is no tower
    String color = (n > 0) ? colors[(n + 4) % 12] : Colors.RESET;
    String spaces = new String("");
    
    // adds spaces to fill in the remaining space not taken up by the blocks
    for (int i = 0; i < size - n; i++) {
      // controls width of spaces
      spaces += (this.size > 10) ? " " : "  ";
    }
    
    // adds blocks based on the count
    String blocks = new String("");
    for (int i = 0; i < n; i++) {
      blocks += this.square;
    }
    
    // returns a modified string
    return spaces + color + blocks + Colors.WHITE_BRIGHT + this.square + color + blocks + spaces;
  }

  // does a player move
  public void move() {
    
    // gets the input and assigns origin and recipient towers based on it
    int[] nums = getInput();
    Tower origin = towers[nums[0] - 1];
    Tower recipient = towers[nums[1] - 1];

    // gets the int result of the transfer
    int result = origin.transfer(recipient);

    // 0 represents no errors and a successful transfer
    if (result == 0) {
      moves++;
      return;
    }
    else {
      // 1 represents an empty tower
      if (result == 1) {
        System.out.println("This tower has no blocks!");
        move();
      }
      // 2 represents an illegal move
      else if (result == 2) {
        System.out.println("You cannot move a block on top of a smaller one!");
        move();
      }
    }
  }

  public int[] getInput() {

    // creates a scanner and gets input
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter your move here: ");
    String inp = scan.nextLine().trim();

    // if the input is not length 3 and it not 2 numbers, raise an error
    if (inp.length() != 3 || inp.charAt(1) != ' ') {
      System.out.println("Please enter your input in the correct format! (i.e. \"1 2\")");
      return getInput();
    }
    else {
      
      // makes the input a char array and gets the numbers that were inputted
      char[] input = inp.toCharArray();
      int n1 = input[0] - '0';
      int n2 = input[2] - '0';

      // if either are out of bounds, raise an error and redo the function
      if (Math.min(n1, n2) < 1 || Math.max(n1, n2) > 3) {
        System.out.println("Make sure your numbers are within the bounds of 1-3!");
        return getInput();
      }

      // otherwise it is successful
      else {
        int[] out = {n1, n2};
        return out;
      }
    }
  }

  // makes sure the final tower is full - if it is, the game is over and won
  public boolean isOver() {
    Tower check = towers[2];
    return check.blocks.size() == this.size;
  }
}