package mist.adventofcode.day7;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day3.Main01.class.getClassLoader().getResourceAsStream("day7/input01.txt");
    Scanner scn = new Scanner(r);
    
    String[] crabRaw = scn.nextLine().split(",");
    
    Map<Integer,Integer> crabs = new HashMap<>();
    Integer maxCrab = 0;
    for (String crab : crabRaw) {
      Integer crabi = Integer.parseInt(crab);
      
      if(crabs.containsKey(crabi)){
        crabs.put(crabi, crabs.get(crabi)+1);
      }else{
        crabs.put(crabi, 1);
      }
      
      if(maxCrab < crabi) {
        maxCrab = crabi;
      }
    }
    
    Integer minfuel = Integer.MAX_VALUE;
    for (int i = 0; i <= maxCrab; i++) {
      Integer fuel = 0;
      for (Map.Entry<Integer, Integer> entry : crabs.entrySet()) {
        Integer dist = Math.abs(i - entry.getKey());
        fuel += (dist * (dist+1))/2  * entry.getValue();
      }
      if(fuel < minfuel){
        minfuel = fuel;
      }
    }
    
    System.out.println(minfuel);
  }
  
}
