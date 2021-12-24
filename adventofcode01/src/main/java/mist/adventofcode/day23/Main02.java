package mist.adventofcode.day23;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

public class Main02 {
  
  private static final int[] candidates = new int[]{0,1,3,5,7,9,10};
  private static final Map<String, Integer> roomFor = Map.of("A", 0, "B", 1, "C", 2, "D", 3);
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day15.Main01.class.getClassLoader().getResourceAsStream("day23/input02.txt");
    Scanner scn = new Scanner(r);
    
    scn.nextLine();
    scn.nextLine();
    
    scn.useDelimiter("[#\\s]+");
    String row1 = scn.nextLine();
    String[] s1 = row1.substring(3).split("[#\\s]+");
    String row2 = scn.nextLine();
    String[] s2 = row2.substring(3).split("[#\\s]+");
    String row3 = scn.nextLine();
    String[] s3 = row3.substring(3).split("[#\\s]+");
    String row4 = scn.nextLine();
    String[] s4 = row4.substring(3).split("[#\\s]+");
    
    PositionsN begin = new PositionsN(new String[][]{s1,s2,s3,s4});
    
    PriorityQueue<PositionsN> heap = new PriorityQueue<>();
    Set<PositionsN> done = new HashSet<>();
    heap.add(begin);
    
    PositionsN res = null;
    while(!heap.isEmpty()){
      PositionsN cur = heap.poll();
      boolean fin = true;
      for (String[] room : cur.rooms) {
        if(!Arrays.equals(room, new String[]{"A", "B", "C", "D"})){
          fin =false;
          break;
        }
      }
      
      if(fin){
        res = cur;
        break;
      }
      done.add(cur);
      
      //for every amphi still in the caves check where it can go
      for (int m = 0; m < cur.rooms.length; m++) {
        for (int i = 0; i < cur.rooms[m].length; i++) {
          for (int j = 0; j < candidates.length; j++) {
            if(!cur.rooms[m][i].equals(".")){
              int pos = (i+1)*2;
              int target = candidates[j];
              int start = Math.min(pos, target);
              int stop = Math.max(pos, target);

              boolean free = true;
              for (int k = start; k <= stop; k++) {
                if(!cur.layer0[k].equals(".")){
                  free = false;
                  break;
                }
              }
              for (int k = m-1; k >= 0; k--) {
                if(!cur.rooms[k][i].equals(".")){
                  free = false;
                  break;
                }
              }
              if(free){
                String[] layer0 = Arrays.copyOf(cur.layer0, cur.layer0.length);
                String[][] rooms = new String[cur.rooms.length][];
                for (int k = 0; k < cur.rooms.length; k++) {
                  rooms[k] = Arrays.copyOf(cur.rooms[k], cur.rooms[k].length);
                }
                layer0[target] = rooms[m][i];
                rooms[m][i] = ".";

                long cost = ((stop+1) - start ) + m;
                if(layer0[target].equals("B")){
                  cost = cost * 10;
                }else if(layer0[target].equals("C")){
                  cost = cost * 100;
                }else if(layer0[target].equals("D")){
                  cost = cost * 1000;
                }
                cost = cur.cost + cost;

                PositionsN p = new PositionsN(layer0, rooms, cost, cur);
                add(done, heap, p);
              }
            }
          }
        }
      }
      
      //for every amphi in the corridor check if it can go into their room
      for (int i = 0; i < cur.layer0.length; i++) {
        if(!cur.layer0[i].equals(".")){
          int room = roomFor.get(cur.layer0[i]);
          int target = (room+1)*2;
          int start = Math.min(i, target);
          int stop = Math.max(i, target);

          boolean free = true;
          for (int k = start; k <= stop; k++) {
            if(!cur.layer0[k].equals(".") && cur.layer0[k]!=cur.layer0[i]){
              free = false;
              break;
            }
          }
          
          int depth = -1;
          for (int j = 0; j < cur.rooms.length; j++) {
            if(cur.rooms[j][room].equals(".")){
              depth = j;
            }else if(!cur.rooms[j][room].equals(cur.layer0[i])){
              free = false;
              break;
            }
          }

          if(free){
            if(depth >= 0){
              String[] layer0 = Arrays.copyOf(cur.layer0, cur.layer0.length);
              String[][] rooms = new String[cur.rooms.length][];
              for (int k = 0; k < cur.rooms.length; k++) {
                rooms[k] = Arrays.copyOf(cur.rooms[k], cur.rooms[k].length);
              }
              rooms[depth][room] = layer0[i];
              layer0[i] = ".";
              
              long cost = ((stop+1) - start)+depth;
              if(rooms[depth][room].equals("B")){
                cost = cost * 10;
              }else if(rooms[depth][room].equals("C")){
                cost = cost * 100;
              }else if(rooms[depth][room].equals("D")){
                cost = cost * 1000;
              }
              cost = cur.cost + cost;
              
              PositionsN p = new PositionsN(layer0, rooms, cost, cur);
              add(done, heap, p);

            }
          }
        }
      }
     
    }
    System.out.println(heap.size());
    System.out.println(res);
  }
  
  
  public static void add(Set<PositionsN> done, PriorityQueue<PositionsN> heap, PositionsN n){
    if(done.contains(n)){
      //do nothing, best path already found
    }else if(heap.contains(n)){
      boolean removed = heap.removeIf(new Predicate<PositionsN>() {
        @Override
        public boolean test(PositionsN t) {
          return n.equals(t) && n.cost < t.cost;
        }
      });
      if(removed){
        heap.add(n);
      }
    }else{
      heap.add(n);
    }
  }
}
