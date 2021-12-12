package mist.adventofcode.day12;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main02.class.getClassLoader().getResourceAsStream("day12/input01.txt");
    Scanner scn = new Scanner(r);
    
    Map<String, List<String>> graph = new HashMap<>();
    
    while(scn.hasNextLine()){
      String line = scn.nextLine();
      String[] edge = line.split("-");
      
      if(graph.containsKey(edge[0])){
        graph.get(edge[0]).add(edge[1]);
      }else{
        graph.put(edge[0], new ArrayList<>());
        graph.get(edge[0]).add(edge[1]);
      }
      
      if(graph.containsKey(edge[1])){
        graph.get(edge[1]).add(edge[0]);
      }else{
        graph.put(edge[1], new ArrayList<>());
        graph.get(edge[1]).add(edge[0]);
      }
    }
    
    List<String> l = new ArrayList<>();
    l.add("start");
    System.out.println(l);
    int paths = paths(graph, l);
    System.out.println(paths);
  }
  
  public static int paths(Map<String,List<String>> graph, List<String> path){
    if(path.get(path.size()-1).equals("end")){
      System.out.println(path);
      return 1;
    }
    
    int count = 0;
    List<String> neighbours = graph.get(path.get(path.size()-1));
    for (String neighbour : neighbours) {
      if(canAdd(path, neighbour)){
        List<String> l = new ArrayList<>(path);
        if(!isLarge(neighbour) && l.contains(neighbour)){
          l.set(0, l.get(0).toUpperCase());
        }
        l.add(neighbour);
        count += paths(graph, l);
      }
    }
    return count;
  }
  
  public static boolean canAdd(List<String> path, String s){
    if(isLarge(s)){
      return true;
    }else{
      if(s.equals("start")){
        return false;
      }else if(isLarge(path.get(0)) && !isLarge(s) && path.contains(s)){
        return false;
      }
      return true;
    }
  }
  
  
  public static boolean isLarge(String s){
    return s.toUpperCase().equals(s);
  }
  
}
