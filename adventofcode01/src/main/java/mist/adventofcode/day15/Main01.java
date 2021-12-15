package mist.adventofcode.day15;

import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day15/input01.txt");
    Scanner scn = new Scanner(r);
    
    Node[][] map = new Node[100][100];
    int y = 0;
    while(scn.hasNext()){
      String l = scn.nextLine();
      for (int x = 0; x < 100; x++) {
        map[x][y] = new Node(l.charAt(x)-48, x, y);
      }
      y++;
    }
    
    PriorityQueue<Node> heap = new PriorityQueue<>();
    heap.add(map[0][0]);
    map[0][0].cost = 0;
    while(true){
      System.out.println(heap);
      Node cur = heap.poll();
      cur.found = true;
      if(cur.x == 99 && cur.y == 99){
        break;
      }
      
      if(cur.x > 0 && !map[cur.x-1][cur.y].found && cur.cost+map[cur.x-1][cur.y].weight < map[cur.x-1][cur.y].cost){
        map[cur.x-1][cur.y].cost = cur.cost+map[cur.x-1][cur.y].weight;
        map[cur.x-1][cur.y].from = cur;
        heap.add(map[cur.x-1][cur.y]);
      }
      if(cur.y > 0 && !map[cur.x][cur.y-1].found && cur.cost+map[cur.x][cur.y-1].weight < map[cur.x][cur.y-1].cost){
        map[cur.x][cur.y-1].cost = cur.cost+map[cur.x][cur.y-1].weight;
        map[cur.x][cur.y-1].from = cur;
        heap.add(map[cur.x][cur.y-1]);
      }
      if(cur.x < 99 && !map[cur.x+1][cur.y].found && cur.cost+map[cur.x+1][cur.y].weight < map[cur.x+1][cur.y].cost){
        map[cur.x+1][cur.y].cost = cur.cost+map[cur.x+1][cur.y].weight;
        map[cur.x+1][cur.y].from = cur;
        heap.add(map[cur.x+1][cur.y]);
      }
      if(cur.y < 99 && !map[cur.x][cur.y+1].found && cur.cost+map[cur.x][cur.y+1].weight < map[cur.x][cur.y+1].cost){
        map[cur.x][cur.y+1].cost = cur.cost+map[cur.x][cur.y+1].weight;
        map[cur.x][cur.y+1].from = cur;
        heap.add(map[cur.x][cur.y+1]);
      }
    }
    
    System.out.println(map[99][99]);
    System.out.println(map[99][99].cost);
    Node cur = map[99][99];
    while(cur != null){
      System.out.println("x: " + cur.x + " y: " + cur.y + " cost: " + cur.weight);
      cur = cur.from;
    }
  }
}
