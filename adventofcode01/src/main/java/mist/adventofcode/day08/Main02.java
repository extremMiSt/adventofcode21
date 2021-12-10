package mist.adventofcode.day08;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static java.util.Map.entry;

public class Main02 {
  
  /*
  this is the number of times the signals of the matching number should appear in
  the inputs.
  yes, suprisingly, this is distinct for all the numbers.
  */
  private static final Map<Integer, String> MAP = Map.ofEntries(entry(42, "0"), 
      entry(17, "1"), entry(34, "2"), entry(39, "3"), entry(30, "4"), 
      entry(37, "5"), entry(41, "6"), entry(25, "7"), entry(49, "8"), 
      entry(45, "9"));

  private static final char[] SIGNAL = new char[]{'a','b','c','d','e', 'f', 'g'};
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day08/input01.txt");
    Scanner scn = new Scanner(r);
    
    List<String> inputs = new ArrayList<>();
    List<String[]> outputs = new ArrayList<>();
    
    int sum = 0;
    while(scn.hasNextLine()){
      String l = scn.nextLine();
      String[] split = l.split("[|]");
      String input = split[0];
      String[] output = split[1].trim().split("\\s");
      
      Map<Character, Integer> count = new HashMap<>();
      
      for (char line : SIGNAL) {
        for (int j = 0; j < input.length(); j++) {
          if(line == input.charAt(j)){
            count.put(line, count.getOrDefault(line, 0)+1);
          }
        }
      }
      
      String out = "";
      for (String string : output) {
        int counter = 0;
        for (int j = 0; j < string.length(); j++) {
          counter += count.get(string.charAt(j));
        }
        out += MAP.get(counter);
      }
      sum += Integer.parseInt(out);
    }
    
    System.out.println(sum);
    
  }
  
}
