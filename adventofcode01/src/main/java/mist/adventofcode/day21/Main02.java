package mist.adventofcode.day21;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day15.Main01.class.getClassLoader().getResourceAsStream("day21/input01.txt");
    Scanner scn = new Scanner(r);
    
    Deque<Universe> universes = new LinkedList<>();
    long[] wins = new long[]{0,0};
    
    int[] multiplier = new int[]{0,0,0,1,3,6,7,6,3,1};
    
    int[] pos = new int[2];
    String l1 = scn.nextLine();
    pos[0] = Integer.parseInt(l1.substring(l1.lastIndexOf(":")+1).trim());
    String l2 = scn.nextLine();
    pos[1] = Integer.parseInt(l2.substring(l2.lastIndexOf(":")+1).trim());
    universes.add(new Universe(pos[0], pos[1], 0, 0, 0, 1));

    
    while(!universes.isEmpty()){
      Universe uni = universes.pop();
      if(uni.getScore()[0] >= 21 || uni.getScore()[1] >= 21){
        if(uni.getScore()[0] < uni.getScore()[1]){
          wins[1] += uni.getCount();
        }else{
          wins[0] += uni.getCount();
        }
        continue;
      }
        
      for (int d = 3; d <= 9; d++) {
        Universe n = new Universe(uni.getPos()[0], uni.getPos()[1],  
            uni.getScore()[0], uni.getScore()[1], uni.getPlayer(), uni.getCount());
        
        n.getPos()[n.getPlayer()] = n.getPos()[n.getPlayer()] + d;
        if(n.getPos()[n.getPlayer()] > 10){
          n.getPos()[n.getPlayer()] = n.getPos()[n.getPlayer()] - 10;
        }

        n.getScore()[n.getPlayer()] = n.getScore()[n.getPlayer()] + n.getPos()[n.getPlayer()];

        n.setPlayer(1-n.getPlayer());
        n.setCount(n.getCount()*multiplier[d]);
        universes.addLast(n);
      }
    }
    System.out.println(Arrays.toString(wins));
    System.out.println(Long.max(wins[0], wins[1]));
  }
  
}
