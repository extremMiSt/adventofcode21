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
    System.out.println("Template: " + template);

    Map<Character, Integer> counts = new HashMap<>();
    for (int i = 0; i < template.length()-1; i++) {
       merge(counts, insert(template.charAt(i), template.charAt(i+1), substs, 0));
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
  
  public static Map<Character, Integer> insert(char a, char b, Map<String, String> substs, int depth){
    
    Map<Character, Integer> counts = new HashMap<>();
    char middle = substs.get(b+""+a).charAt(0);
    counts.put(middle, 1);
    
    if(depth == 10){
      return counts;
    }
    
    counts = merge(counts, insert(a, middle, substs, depth+1));
    counts = merge(counts, insert(middle, b, substs, depth+1));
    
    return counts;
  }
  
  public static <T> Map<T,Integer> merge(Map<T,Integer> m1, Map<T,Integer> m2){
    HashMap<T, Integer> counts = new HashMap<>(m1);
    for (Map.Entry<T, Integer> entry : m2.entrySet()) {
      if(counts.containsKey(entry.getKey())){
        counts.put(entry.getKey(), entry.getValue()+counts.get(entry.getKey()));
      }else{
        counts.put(entry.getKey(), entry.getValue());
      }
    }
    return counts;
  } 
  
}
