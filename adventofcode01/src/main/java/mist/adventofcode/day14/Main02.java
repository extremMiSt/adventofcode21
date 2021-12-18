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

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main02.class.getClassLoader().getResourceAsStream("day14/input01.txt");
    Scanner scn = new Scanner(r);
    
    String template =  scn.nextLine();
    scn.nextLine();
    
    Map<String, String> substs = new HashMap<>();
    while(scn.hasNextLine()){
      String[] split = scn.nextLine().split(" -> ");
      substs.put(split[0], split[1]);
    }
    
    Map<String, Long> duplets = new HashMap<>();
    for (int i = 0; i < template.length()-1; i++) {
      add(duplets, template.substring(i,i+2), 1);
    }
    
    for (int i = 0; i < 40; i++) {
      Map<String, Long> duplets2 = new HashMap<>();
      for (String string : duplets.keySet()) {
        String middle = substs.get(string);
        add(duplets2, string.charAt(0)+middle, duplets.get(string));
        add(duplets2, middle+string.charAt(1), duplets.get(string));
      }
      duplets = duplets2;
    }
    
    Map<Character,Long> counts = new HashMap<>();
    add(counts, template.charAt(0), 1);
    for (String string : duplets.keySet()) {
      add(counts, string.charAt(1), duplets.get(string));
    }
    
    
    List<Map.Entry<Character,Long>> list = new ArrayList<>(counts.entrySet());
    
    Collections.sort(list, new Comparator<Map.Entry<Character, Long>>(){
      @Override
      public int compare(Map.Entry<Character, Long> o1, Map.Entry<Character, Long> o2) {
        long diff = o2.getValue() - o1.getValue();
        return  diff > 0 ? 1 :(diff < 0 ? -1: 0);
      }
    });
    System.out.println(list.get(0).getValue() - list.get(list.size()-1).getValue());
    
  }
  
  public static <T> void add(Map<T, Long> counters, T key, long count){
    if(counters.containsKey(key)){
      counters.put(key, counters.get(key)+count);
    }else{
      counters.put(key, count);
    }
  }
  
  
  
}
