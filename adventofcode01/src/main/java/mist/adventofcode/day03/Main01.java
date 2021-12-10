package mist.adventofcode.day03;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main01 {

  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day03/input01.txt");
    Scanner scn = new Scanner(r);
    
    int count = 0;
    int[] counts = new int[12];
    
    while(scn.hasNextLine()){
      String line  = scn.nextLine();
      for (int i = 0; i < counts.length; i++) {
        if(line.charAt(i) == '1'){
          counts[i]++;
        }
      }
      count++;
    }
    
    String gammabin = "";
    String epsilonbin = "";
    for (int i = 0; i < counts.length; i++) {
      gammabin = gammabin + (counts[i] < (count-counts[i]) ? "0":"1");
      epsilonbin = epsilonbin + (counts[i] < (count-counts[i]) ? "1":"0");
    }
    System.out.println("gamma: 0b" + gammabin + ", epsilon: 0b" + epsilonbin);
    System.out.println("gamma: " + Integer.parseInt(gammabin, 2) + ", epsilon: " + Integer.parseInt(epsilonbin, 2));
    System.out.println("consumption: " + (Integer.parseInt(gammabin, 2) * Integer.parseInt(epsilonbin, 2)));
  }

}