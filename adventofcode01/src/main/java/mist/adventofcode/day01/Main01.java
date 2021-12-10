package mist.adventofcode.day01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main01 {

  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day01/input01.txt");
    Scanner scn = new Scanner(r);
    
    int result = 0;

    int cur = Integer.parseInt(scn.nextLine());
    
    while(scn.hasNextLine()){
      int next = Integer.parseInt(scn.nextLine());
      if(cur < next){
        result++;
      }
      cur = next;
    } 
    
    System.out.println("we had " + result + " increases");

  }
}
