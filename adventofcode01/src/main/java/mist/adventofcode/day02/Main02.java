package mist.adventofcode.day02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main02 {

  public static void main(String[] args) throws IOException{
    InputStream r = Main02.class.getClassLoader().getResourceAsStream("day2/input01.txt");
    Scanner scn = new Scanner(r);
    
    int depth = 0;
    int pos = 0;
    
    int aim = 0;
    System.out.println("aim: " + aim + ", pos: " + pos + ", depth: " + depth);
    
    while(scn.hasNextLine()){
      String line  = scn.nextLine();
      String[] split = line.split(" ");
      int value = Integer.parseInt(split[1]);
      if(split[0].equals("forward")){
        pos += value;
        depth += value*aim;
      }else if (split[0].equals("down")){
        aim += value;
      }else if (split[0].equals("up")){
        aim -= value;
      }else{
        System.exit(-1);
      }
      System.out.println("aim: " + aim + ", pos: " + pos + ", depth: " + depth);
    } 
    
    System.out.println("multiplied: " + (pos*depth));
  }

}
