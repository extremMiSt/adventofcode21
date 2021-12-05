package mist.adventofcode.day5;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day3.Main01.class.getClassLoader().getResourceAsStream("day5/input01.txt");
    Scanner scn = new Scanner(r);
    
    List<Line> lines = new ArrayList<>();
    int floorx = 0;
    int floory = 0;
    while (scn.hasNextLine()) {
      String nextLine = scn.nextLine();
      Line line = new Line(nextLine);
      if(line.getX1() == line.getX2() || line.getY1() == line.getY2()){
        floorx = Math.max(floorx, Math.max(line.getX1(),line.getX2()));
        floory = Math.max(floory, Math.max(line.getY1(),line.getY2()));
        lines.add(line);
      }
    }
    
    int[][] floor = new int[floorx+1][floory+1];
    for (Line line : lines) {
      if(line.getX1()==line.getX2()){
        int miny = Math.min(line.getY1(), line.getY2());
        int maxy = Math.max(line.getY1(), line.getY2());
        for (int i = miny; i <= maxy; i++) {
          floor[line.getX1()][i]++;
        }
      }
      if(line.getY1()==line.getY2()){
        int minx = Math.min(line.getX1(), line.getX2());
        int maxx = Math.max(line.getX1(), line.getX2());
        for (int i = minx; i <= maxx; i++) {
          floor[i][line.getY1()]++;
        }
      }
    }
    
    int count = 0;
    for (int x = 0; x < floor.length; x++) {
      for (int y = 0; y < floor[x].length; y++) {
        int i = floor[x][y];
        if(i > 1){
          count++;
        }
      }
    }
    System.out.println(count);
  }
  
}
