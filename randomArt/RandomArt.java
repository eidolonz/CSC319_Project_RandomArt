/**
 * @Auther Mr.Peerapon & Ms.Vipavee
 * @ID:    55130500222 & 551305002227
 * */

package randomArt;

import java.util.Scanner;

public class RandomArt{
  public static void main(String[] args){
    Scanner kb = new Scanner(System.in);
    System.out.print("Widgth :"); System.out.flush();
    int widgth = kb.nextInt();
    System.out.print("Height :"); System.out.flush();
    int height = kb.nextInt();
    Frame frame = new Frame(widgth, height);
    frame.run();
  }
}