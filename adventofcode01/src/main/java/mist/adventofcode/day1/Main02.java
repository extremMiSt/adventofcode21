package mist.adventofcode.day1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main02 {

  public static void main(String[] args) throws IOException{
    InputStream r = Main02.class.getClassLoader().getResourceAsStream("day1/input01.txt");
    Scanner scn = new Scanner(r);
    
    int result = 0;

    int cur0 = Integer.parseInt(scn.nextLine());
    int cur1 = Integer.parseInt(scn.nextLine());
    int cur2 = Integer.parseInt(scn.nextLine());
    
    while(scn.hasNextLine()){
      int next = Integer.parseInt(scn.nextLine());
      int sum0 = cur0 + cur1 + cur2;
      int sum1 = cur1 + cur2 + next;
      
      if(sum0 < sum1){
        result++;
      }
      cur0 = cur1;
      cur1 = cur2;
      cur2 = next;
    } 
    
    System.out.println("we had " + result + " increases");

  }
}
