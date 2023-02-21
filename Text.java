public class Text {
  // the art for the title
  public static final String title = "████████╗░█████╗░░██╗░░░░░░░██╗███████╗██████╗░  ░█████╗░███████╗  ██╗░░██╗░█████╗░███╗░░██╗░█████╗░██╗"+
  "\n╚══██╔══╝██╔══██╗░██║░░██╗░░██║██╔════╝██╔══██╗  ██╔══██╗██╔════╝  ██║░░██║██╔══██╗████╗░██║██╔══██╗██║"+
  "\n░░░██║░░░██║░░██║░╚██╗████╗██╔╝█████╗░░██████╔╝  ██║░░██║█████╗░░  ███████║███████║██╔██╗██║██║░░██║██║"+
  "\n░░░██║░░░██║░░██║░░████╔═████║░██╔══╝░░██╔══██╗  ██║░░██║██╔══╝░░  ██╔══██║██╔══██║██║╚████║██║░░██║██║"+
  "\n░░░██║░░░╚█████╔╝░░╚██╔╝░╚██╔╝░███████╗██║░░██║  ╚█████╔╝██║░░░░░  ██║░░██║██║░░██║██║░╚███║╚█████╔╝██║"+
  "\n░░░╚═╝░░░░╚════╝░░░░╚═╝░░░╚═╝░░╚══════╝╚═╝░░╚═╝  ░╚════╝░╚═╝░░░░░  ╚═╝░░╚═╝╚═╝░░╚═╝╚═╝░░╚══╝░╚════╝░╚═╝";

  // stores the introduction phrase
  public static final String intro = "Welcome to Tower of Hanoi. The objective of this game is to move all the pieces from tower 1 to tower 3, with all of them being prefectly stacked on tower 3. To move the uppermost piece from one tower to another, type the origin tower number, followed by a space, and then the recipient tower number. For example, a turn would be \"1 3\". Enjoy!";
  // waits between each character when printing
  public static void smoothPrint(String prompt) {
    for (char c : prompt.toCharArray()) {
      System.out.print(c);
      try {
        Thread.sleep(20);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}