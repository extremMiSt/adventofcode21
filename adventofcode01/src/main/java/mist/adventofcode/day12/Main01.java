package mist.adventofcode.day12;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day12/input01.txt");
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
      return 1;
    }
    
    int count = 0;
    List<String> neighbours = graph.get(path.get(path.size()-1));
    for (String neighbour : neighbours) {
      if(isLarge(neighbour) || !path.contains(neighbour)){
        List<String> l = new ArrayList<>(path);
        l.add(neighbour);
        System.out.println(l);
        count += paths(graph, l);
      }
    }
    return count;
  }
  
  public static boolean isLarge(String s){
    return s.toUpperCase().equals(s);
  }
  
}
