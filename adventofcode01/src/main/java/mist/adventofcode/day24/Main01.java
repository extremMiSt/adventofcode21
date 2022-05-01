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
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day24/test01.txt");
    Scanner scn = new Scanner(r);
    
    List<String[]> programm = new ArrayList<>();
    while(scn.hasNextLine()){
      String line = scn.nextLine();
      programm.add(line.split(" "));
      System.out.println(Arrays.toString(programm.get(programm.size()-1)));
    }

    String s = "1";
    
    long t = System.currentTimeMillis();
    ALU alu = new ALU(s);
    StringALU str = new StringALU(s, "0", "0", "0", "0");
    for (String[] command : programm) {
      alu.perform(command);
      //str.perform(command);
    }
    System.out.println(alu.getW());
    System.out.println(alu.getX());
    System.out.println(alu.getY());
    System.out.println(alu.getZ());
    System.out.println("time:" + (System.currentTimeMillis() - t));
    
    t = System.currentTimeMillis();
    int a=1;
    System.out.println(a);
    System.out.println(((((((0*0)+0)%26)+11)==a?1L:0L)==0?1L:0L));
    System.out.println(((((((((0*0)+25)*((((((0*0)+0)%26)+11)==a?1L:0L)==0?1L:0L))+1)*0)+a)+3)*((((((0*0)+0)%26)+11)==a?1L:0L)==0?1L:0L)));
    System.out.println((((0/1)*((((0*0)+25)*((((((0*0)+0)%26)+11)==a?1L:0L)==0?1L:0L))+1))+((((((((0*0)+25)*((((((0*0)+0)%26)+11)==a?1L:0L)==0?1L:0L))+1)*0)+a)+3)*((((((0*0)+0)%26)+11)==a?1L:0L)==0?1L:0L))));
    System.out.println("time:" + (System.currentTimeMillis() - t));
  }
}
