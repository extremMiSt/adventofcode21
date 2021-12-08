package mist.adventofcode.day8;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static java.util.Map.entry;

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day3.Main01.class.getClassLoader().getResourceAsStream("day8/input01.txt");
    Scanner scn = new Scanner(r);
    
    List<String> inputs = new ArrayList<>();
    List<String[]> outputs = new ArrayList<>();
    
    while(scn.hasNextLine()){
      String line = scn.nextLine();
      String[] split = line.split("[|]");
      inputs.add(split[0]);
      outputs.add(split[1].trim().split("\\s"));
    }
    
    
    Map<Integer, String> map = Map.ofEntries(entry(42, "0"), entry(17, "1"), 
        entry(34, "2"), entry(39, "3"), entry(30, "4"), entry(37, "5"), 
        entry(41, "6"), entry(25, "7"), entry(49, "8"), entry(45, "9"));
    
    char[] lines = new char[]{'a','b','c','d','e', 'f', 'g'};
    
    int sum = 0;
    for (int i = 0; i < inputs.size(); i++) {
      Map<Character, Integer> count = new HashMap<>();
      
      String input = inputs.get(i);
      for (char line : lines) {
        for (int j = 0; j < input.length(); j++) {
          if(line == input.charAt(j)){
            count.put(line, count.getOrDefault(line, 0)+1);
          }
        }
      }
      
      String[] output = outputs.get(i);
      String out = "";
      for (String string : output) {
        int counter = 0;
        for (int j = 0; j < string.length(); j++) {
          counter += count.get(string.charAt(j));
        }
        out += map.get(counter);
      }
      sum += Integer.parseInt(out);
    }
    System.out.println(sum);
    
  }
  
}
