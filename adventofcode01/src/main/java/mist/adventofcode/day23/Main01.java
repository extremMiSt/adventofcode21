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

public class Main01 {
  
  private static final int[] candidates = new int[]{0,1,3,5,7,9,10};
  private static final Map<String, Integer> roomFor = Map.of("A", 0, "B", 1, "C", 2, "D", 3);
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day15.Main01.class.getClassLoader().getResourceAsStream("day23/input01.txt");
    Scanner scn = new Scanner(r);
    
    scn.nextLine();
    scn.nextLine();
    
    scn.useDelimiter("[#\\s]+");
    String row1 = scn.nextLine();
    String[] s1 = row1.substring(3).split("[#\\s]+");
    String row2 = scn.nextLine();
    String[] s2 = row2.substring(3).split("[#\\s]+");
    
    Positions begin = new Positions(s1, s2);
    System.out.println(begin);
    
    PriorityQueue<Positions> heap = new PriorityQueue<>();
    Set<Positions> done = new HashSet<>();
    heap.add(begin);
    
    Positions res = null;
    while(!heap.isEmpty()){
      Positions cur = heap.poll();
      //System.out.println(cur);
      //if this one is sorted, then we are done;
      if(Arrays.equals(cur.layer1, new String[]{"A", "B", "C", "D"}) &&
          Arrays.equals(cur.layer2, new String[]{"A", "B", "C", "D"})){
        res = cur;
        break;
      }
      done.add(cur);
      
      //for every amphi still in the caves check where it can go
      for (int i = 0; i < cur.layer1.length; i++) {
        for (int j = 0; j < candidates.length; j++) {
          if(!cur.layer1[i].equals(".")){
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
            if(free){
              String[] layer0 = Arrays.copyOf(cur.layer0, cur.layer0.length);
              String[] layer1 = Arrays.copyOf(cur.layer1, cur.layer1.length);
              String[] layer2 = Arrays.copyOf(cur.layer2, cur.layer2.length);
              layer0[target] = layer1[i];
              layer1[i] = ".";
              
              long cost = ((stop+1) - start );
              if(layer0[target].equals("B")){
                cost = cost * 10;
              }else if(layer0[target].equals("C")){
                cost = cost * 100;
              }else if(layer0[target].equals("D")){
                cost = cost * 1000;
              }
              cost = cur.cost + cost;
              
              Positions p = new Positions(layer0, layer1, layer2, cost, cur);
              add(done, heap, p);
            }
          }
        }
      }
      
      for (int i = 0; i < cur.layer2.length; i++) {
        for (int j = 0; j < candidates.length; j++) {
          if(!cur.layer2[i].equals(".") && cur.layer1[i].equals(".")){
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
            if(free){
              String[] layer0 = Arrays.copyOf(cur.layer0, cur.layer0.length);
              String[] layer1 = Arrays.copyOf(cur.layer1, cur.layer1.length);
              String[] layer2 = Arrays.copyOf(cur.layer2, cur.layer2.length);
              layer0[target] = layer2[i];
              layer2[i] = ".";
              
              long cost = ((stop+1) - start) + 1;
              if(layer0[target].equals("B")){
                cost = cost * 10;
              }else if(layer0[target].equals("C")){
                cost = cost * 100;
              }else if(layer0[target].equals("D")){
                cost = cost * 1000;
              }
              cost = cur.cost + cost;
              
              Positions p = new Positions(layer0, layer1, layer2, cost, cur);
              add(done, heap, p);
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
          
//          System.out.println(cur);
//          System.out.println(cur.layer0[i] + " going from " + i + " to " + room + "/" + target);
          
          boolean free = true;
          int obst = -1;
          for (int k = start; k <= stop; k++) {
            if(!cur.layer0[k].equals(".") && cur.layer0[k]!=cur.layer0[i]){
              free = false;
              obst = k;
              break;
            }
          }
//          if(!free){
//            System.out.println("but there is something at " +obst);
//          }
          
          if(free){
            if(cur.layer1[room].equals(".") && cur.layer2[room].equals(cur.layer0[i])){
              String[] layer0 = Arrays.copyOf(cur.layer0, cur.layer0.length);
              String[] layer1 = Arrays.copyOf(cur.layer1, cur.layer1.length);
              String[] layer2 = Arrays.copyOf(cur.layer2, cur.layer2.length);
              layer1[room] = layer0[i];
              layer0[i] = ".";
              
              long cost = ((stop+1) - start);
              if(layer1[room].equals("B")){
                cost = cost * 10;
              }else if(layer1[room].equals("C")){
                cost = cost * 100;
              }else if(layer1[room].equals("D")){
                cost = cost * 1000;
              }
              cost = cur.cost + cost;
              
              Positions p = new Positions(layer0, layer1, layer2, cost, cur);
              add(done, heap, p);
//              if(heap.contains(p)){
//                System.out.println(p);
//              }
            }else if(cur.layer1[room].equals(".") && cur.layer2[room].equals(".")){
              String[] layer0 = Arrays.copyOf(cur.layer0, cur.layer0.length);
              String[] layer1 = Arrays.copyOf(cur.layer1, cur.layer1.length);
              String[] layer2 = Arrays.copyOf(cur.layer2, cur.layer2.length);
              layer2[room] = layer0[i];
              layer0[i] = ".";
              
              long cost = ((stop+1) - start)+1;
              if(layer2[room].equals("B")){
                cost = cost * 10;
              }else if(layer2[room].equals("C")){
                cost = cost * 100;
              }else if(layer2[room].equals("D")){
                cost = cost * 1000;
              }
              cost = cur.cost + cost;
              
              Positions p = new Positions(layer0, layer1, layer2, cost, cur);
              add(done, heap, p);
//              if(heap.contains(p)){
//                System.out.println(p);
//              }
            }
          }
        }
      }
     
    }
    System.out.println(heap.size());
    System.out.println(res);
  }
  
  
  public static void add(Set<Positions> done, PriorityQueue<Positions> heap, Positions n){
    if(done.contains(n)){
      //do nothing, best path already found
    }else if(heap.contains(n)){
      boolean removed = heap.removeIf(new Predicate<Positions>() {
        @Override
        public boolean test(Positions t) {
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
