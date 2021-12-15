package mist.adventofcode.day14;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day14/input01.txt");
    Scanner scn = new Scanner(r);
    
    String template =  scn.nextLine();
    scn.nextLine();
    
    Map<String, String> substs = new HashMap<>();
    while(scn.hasNextLine()){
      String[] split = scn.nextLine().split(" -> ");
      substs.put(split[0], split[1]);
    }
    System.out.println("Template: " + template);
    for (int i = 0; i < 10; i++) {
      String res = "" + template.charAt(0);
      for (int j = 0; j < template.length()-1; j++) {
        String insert = substs.get(template.substring(j, j+2));
        res = res + insert + template.charAt(j+1);
      }
      template = res;
      System.out.println("Round " + (i+1) + ": " + template);
    }
    
    Map<Character, Integer> counts = new HashMap<>();
    for (int i = 0; i < template.length(); i++) {
      char c = template.charAt(i);
      if(counts.containsKey(c)){
        counts.put(c, counts.get(c)+1);
      }else{
        counts.put(c, 1);
      }
    }
    
    List<Map.Entry<Character,Integer>> list = new ArrayList<>(counts.entrySet());
    
    Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>(){
      @Override
      public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        return o2.getValue() - o1.getValue();
      }
    });
    System.out.println(list.get(0).getValue() - list.get(list.size()-1).getValue());
  }
  
}
