package mist.adventofcode.day07;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day03.Main01.class.getClassLoader().getResourceAsStream("day7/input01.txt");
    Scanner scn = new Scanner(r);
    
    String[] crabRaw = scn.nextLine().split(",");
    
    Map<Integer,Integer> crabs = new HashMap<>();
    int maxCrab = 0;
    for (String crab : crabRaw) {
      int crabi = Integer.parseInt(crab);
      
      if(crabs.containsKey(crabi)){
        crabs.put(crabi, crabs.get(crabi)+1);
      }else{
        crabs.put(crabi, 1);
      }
      
      if(maxCrab < crabi) {
        maxCrab = crabi;
      }
    }
    
    int minfuel = Integer.MAX_VALUE;
    for (int i = 0; i <= maxCrab; i++) {
      int fuel = 0;
      for (Map.Entry<Integer, Integer> entry : crabs.entrySet()) {
        fuel += Math.abs(i - entry.getKey())*entry.getValue();
      }
      if(fuel < minfuel){
        minfuel = fuel;
      }
    }
    
    System.out.println(minfuel);
    
  }
  
}
