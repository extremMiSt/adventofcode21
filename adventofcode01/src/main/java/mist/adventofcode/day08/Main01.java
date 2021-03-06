package mist.adventofcode.day08;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day08/input01.txt");
    Scanner scn = new Scanner(r);
    
    List<String[]> input = new ArrayList<>();
    List<String[]> output = new ArrayList<>();
    
    while(scn.hasNextLine()){
      String line = scn.nextLine();
      String[] split = line.split("[|]");
      input.add(split[0].trim().split("\\s"));
      output.add(split[1].trim().split("\\s"));
    }
    
    int count1478 = 0;
    for (String[] string : output) {
      for (int i = 0; i < string.length; i++) {
        String element = string[i];
        if (element.length() == 2 || element.length() == 3 || element.length() == 4 || element.length() == 7){
          count1478++;
        }
      }
    }
    
    System.out.println("es sind " + count1478 + " viele 1er, 4er, 7er und 8er");
    
    
  }
  
}
