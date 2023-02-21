import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
    
    // prints introduction sequences
    Colors.clear();
    System.out.println(Text.title + "\n");
    Text.smoothPrint(Text.intro + "\n");

    // gets the size of the game
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter your desired game size: ");
    int n = getInput(scan);

    // initializes the game
    Game game = new Game(n); 

    // goes until the game is over
    while (!game.isOver()) {
      game.display();
      game.move();
    }

    // when it is won, display the game and a congratulatory message
    game.display();
    Text.smoothPrint("You won!\n");
    Text.smoothPrint((Math.pow(2, n) - 1 == game.moves) ? "You played the game optimally!\n" : "You did not play optimally.\n");
  }

  // gets the input
  public static int getInput(Scanner scan) {
    // makes sure the input is an integer, if its not, keeping trying over and over
    String inp = scan.nextLine();
    try {
      return Integer.parseInt(inp);
    }
    catch (Exception e) {
      System.out.print("Please enter an integer: ");
      return getInput(scan);
    }
  }
}
