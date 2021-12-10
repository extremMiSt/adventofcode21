package mist.adventofcode.day03;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main02 {

  public static void main(String[] args) throws IOException{
    InputStream r = Main02.class.getClassLoader().getResourceAsStream("day03/input01.txt");
    Scanner scn = new Scanner(r);
    
    ArrayList<String> in = new ArrayList<>();
    while(scn.hasNextLine()){
      String line  = scn.nextLine();
      in.add(line);
    }
    
    String gen = find(in, '0', '1');
    String scrub = find(in, '1', '0');
    
    System.out.println("generator: 0b"+ gen + ", scrubber: 0b" + scrub);
    System.out.println("generator: "+ Integer.parseInt(gen, 2) + ", scrubber: " + Integer.parseInt(scrub, 2));
    System.out.println("life support: " + Integer.parseInt(gen, 2) * Integer.parseInt(scrub, 2));
  }
  
  public static int count(ArrayList<String> in, int i){
    int count = 0;
    for (String num : in) {
      if(num.charAt(i) == '1'){
        count++;
      }
    }
    return count;
  }
  
  public static String find(ArrayList<String> in, char a, char b){
    ArrayList<String> data = new ArrayList<>(in);
    for (int i = 0; i < 12 && data.size() > 1; i++) {
      int count = count(data, i);
      char match = count < data.size()-count ? a:b;
      
      ArrayList<String> survivors = new ArrayList<>();
      for (String string : data) {
        if(string.charAt(i) == match){
          survivors.add(string);
        }
      }
      data = survivors;
    }
    return data.get(0);
  }

}