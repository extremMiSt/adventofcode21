package mist.adventofcode.day09;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day03.Main01.class.getClassLoader().getResourceAsStream("day9/input01.txt");
    Scanner scn = new Scanner(r);
    
    int[][] floor = new int[100][100];
    
    int xf = 0;
    while(scn.hasNextLine()){
      String line = scn.nextLine();
      for (int i = 0; i < line.length(); i++) {
        floor[xf][i] = line.charAt(i)-48;
      }
      xf++;
    }
    
    List<Point> low = new ArrayList<>();
    
    for (int x = 0; x < floor.length; x++) {
      for (int y = 0; y < floor[x].length; y++) {
        
        int me = floor[x][y];
        int up = y+1<100?floor[x][y+1]:10;
        int down = y-1>=0?floor[x][y-1]:10;
        int left = x+1<100?floor[x+1][y]:10;
        int right = x-1>=0?floor[x-1][y]:10;
        
        if( me < up && me < down &&
            me < left && me < right){
          low.add(new Point(x, y));
        }
      }
    }
    
    List<Integer> sizes = new ArrayList<>();
    for (Point point : low) {
      sizes.add(basinSize(point,floor));
    }
    
    Collections.sort(sizes);
    Collections.reverse(sizes);
    System.out.println(sizes.get(0)*sizes.get(1)*sizes.get(2));
  }
  
  //depth-first search because I can't be arsed to do anything else
  static int visited = 1 << 30;
  public static int basinSize(Point p, int[][] floor){
    floor[p.x][p.y] = floor[p.x][p.y] ^ visited;

    int up = ((p.y+1<100) && (floor[p.x][p.y+1] != 9) && (floor[p.x][p.y+1] & visited) == 0)?basinSize( new Point(p.x, p.y+1),floor):0;
    int down = ((p.y-1>=0) && (floor[p.x][p.y-1] != 9) && (floor[p.x][p.y-1] & visited) == 0)?basinSize( new Point(p.x, p.y-1),floor):0;
    int left = ((p.x+1<100) && (floor[p.x+1][p.y] != 9) && (floor[p.x+1][p.y] & visited) == 0)?basinSize( new Point(p.x+1, p.y),floor):0;
    int right = ((p.x-1>=0) && (floor[p.x-1][p.y] != 9) && (floor[p.x-1][p.y] & visited) == 0)?basinSize( new Point(p.x-1, p.y),floor):0;

    return up + down + left + right + 1;
  }
  
  
  
}
