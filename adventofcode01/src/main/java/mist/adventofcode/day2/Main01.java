package mist.adventofcode.day2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main01 {

  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day2/input01.txt");
    Scanner scn = new Scanner(r);
    
    int depth = 0;
    int pos = 0;
    System.out.println("pos: " + pos + ", depth: " + depth);
    
    while(scn.hasNextLine()){
      String line  = scn.nextLine();
      String[] split = line.split(" ");
      int value = Integer.parseInt(split[1]);
      if(split[0].equals("forward")){
        pos += value;
      }else if (split[0].equals("down")){
        depth += value;
      }else if (split[0].equals("up")){
        depth -= value;
      }else{
        System.exit(-1);
      }
      System.out.println("pos: " + pos + ", depth: " + depth);
    } 
    
    System.out.println("multiplied: " + (pos*depth));
  }

}
