package mist.adventofcode.day15;

import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main02.class.getClassLoader().getResourceAsStream("day15/input01.txt");
    Scanner scn = new Scanner(r);
    
    Node[][] tile = new Node[100][100];
    int y = 0;
    while(scn.hasNext()){
      String l = scn.nextLine();
      for (int x = 0; x < 100; x++) {
        tile[x][y] = new Node(l.charAt(x)-48, x, y);
      }
      y++;
    }
    
    Node[][] map = new Node[tile.length*5][tile[0].length*5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        
        
        for (int x = 0; x < tile.length; x++) {
          for (int yi = 0; yi < tile[x].length; yi++) {
            int val = tile[x][yi].weight + i + j;
            if (val >= 10) val = val %10 +1;
            map[i*100 + x][j*100 +yi] = new Node(val, i*100 + x, j*100 +yi);
          }
        }
        
        
      }
    }
    
    PriorityQueue<Node> heap = new PriorityQueue<>();
    heap.add(map[0][0]);
    map[0][0].cost = 0;
    while(true){
      //System.out.println(heap);
      Node cur = heap.poll();
      cur.found = true;
      if(cur.x == 499 && cur.y == 499){
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
      if(cur.x < 499 && !map[cur.x+1][cur.y].found && cur.cost+map[cur.x+1][cur.y].weight < map[cur.x+1][cur.y].cost){
        map[cur.x+1][cur.y].cost = cur.cost+map[cur.x+1][cur.y].weight;
        map[cur.x+1][cur.y].from = cur;
        heap.add(map[cur.x+1][cur.y]);
      }
      if(cur.y < 499 && !map[cur.x][cur.y+1].found && cur.cost+map[cur.x][cur.y+1].weight < map[cur.x][cur.y+1].cost){
        map[cur.x][cur.y+1].cost = cur.cost+map[cur.x][cur.y+1].weight;
        map[cur.x][cur.y+1].from = cur;
        heap.add(map[cur.x][cur.y+1]);
      }
    }
    
    System.out.println(map[499][499]);
    System.out.println(map[499][499].cost);
    Node cur = map[499][499];
    while(cur != null){
      System.out.println("x: " + cur.x + " y: " + cur.y + " cost: " + cur.weight);
      cur = cur.from;
    }
  }
}
