package mist.adventofcode.day06;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day06/input01.txt");
    Scanner scn = new Scanner(r);
    String[] squidsRaw = scn.nextLine().split(",");
    int[] squidsAge = new int[9];
    for (String string : squidsRaw) {
      squidsAge[Integer.parseInt(string)]++;
    }
    System.out.println("Initial: " + Arrays.toString(squidsAge));
    
    for (int i = 1; i <= 80; i++) {
      //each squid gets a day older
      int day0s = squidsAge[0];
      for (int j = 1; j < squidsAge.length; j++) {
        squidsAge[j-1] = squidsAge[j];
      }
      squidsAge[squidsAge.length-1] = 0;
      
      //squids that were at 0 get back to 6
      squidsAge[6] += day0s;
      //squids that were at 0 get a child at 8
      squidsAge[8] += day0s;
      System.out.println("After " + i + " days: " +  Arrays.toString(squidsAge));
    }
    
    System.out.println("Final: " + Arrays.toString(squidsAge));
    int total = 0;
    for (int i = 0; i < squidsAge.length; i++) {
      total += squidsAge[i];
    }
    System.out.println("Total: " + total);
  }
  
}
