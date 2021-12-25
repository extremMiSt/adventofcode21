package mist.adventofcode.day24;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main01 {
  
  /*
   * I honestly have no idea how to solve this..
   */
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day24/input01.txt");
    Scanner scn = new Scanner(r);
    
    List<String[]> programm = new ArrayList<>();
    while(scn.hasNextLine()){
      String line = scn.nextLine();
      programm.add(line.split(" "));
      System.out.println(Arrays.toString(programm.get(programm.size()-1)));
    }

    String s = "22222222222222";
      
    ALU alu = new ALU(s);
    for (String[] command : programm) {
      alu.perform(command);
    }
    System.out.println(alu.getW());
    System.out.println(alu.getX());
    System.out.println(alu.getY());
    System.out.println(alu.getZ());

  }
}
