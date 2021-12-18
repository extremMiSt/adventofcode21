package mist.adventofcode.day18;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day15.Main01.class.getClassLoader().getResourceAsStream("day18/input01.txt");
    Scanner scn = new Scanner(r);
    
    SnailNumber curr = SnailNumber.fromString(scn.nextLine());
    while(scn.hasNextLine()){
      SnailNumber next = SnailNumber.fromString(scn.nextLine());
      
      SnailNumber add = SnailNumber.add(curr, next);
      curr = add;
    }
    System.out.println(curr);
    System.out.println(curr.magnitude());
  }
}
