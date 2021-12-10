package mist.adventofcode.day05;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day03.Main01.class.getClassLoader().getResourceAsStream("day5/input01.txt");
    //InputStream r = mist.adventofcode.day3.Main01.class.getClassLoader().getResourceAsStream("day5/example.txt");
    Scanner scn = new Scanner(r);
    
    List<Line> lines = new ArrayList<>();
    int floorx = 0;
    int floory = 0;
    while (scn.hasNextLine()) {
      String nextLine = scn.nextLine();
      Line line = new Line(nextLine);
      floorx = Math.max(floorx, Math.max(line.getX1(),line.getX2()));
      floory = Math.max(floory, Math.max(line.getY1(),line.getY2()));
      lines.add(line);
    }
    
    int[][] floor = new int[floorx+1][floory+1];
    for (Line line : lines) {
      if(line.getX1()==line.getX2()){
        int miny = Math.min(line.getY1(), line.getY2());
        int maxy = Math.max(line.getY1(), line.getY2());
        for (int i = miny; i <= maxy; i++) {
          floor[line.getX1()][i]++;
        }
      }else if(line.getY1()==line.getY2()){
        int minx = Math.min(line.getX1(), line.getX2());
        int maxx = Math.max(line.getX1(), line.getX2());
        for (int i = minx; i <= maxx; i++) {
          floor[i][line.getY1()]++;
        }
      }else {
        int x0;
        int y0;
        int x1;
        int y1;
        if(line.getY1() < line.getY2()){
          x0 = line.getX1();
          y0 = line.getY1();
          x1 = line.getX2();
          y1 = line.getY2();
        }else{
          x0 = line.getX2();
          y0 = line.getY2();
          x1 = line.getX1();
          y1 = line.getY1();
        }
        System.out.println(line.toString());
        System.out.println(x0 + "," + y0 + " -> " + x1 + "," + y1);
        
        if(x0 < x1){
          int diff = x1-x0;
          for (int i = 0; i <= diff; i++) {
            floor[x0+i][y0+i]++;
          }
        }else{
          int diff = x0-x1;
          for (int i = 0; i <= diff; i++) {
            floor[x0-i][y0+i]++;
          }
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
    
//    System.out.println();
//    for (int y = 0; y < floor[0].length; y++) {
//      for (int x = 0; x < floor.length; x++) {
//        System.out.print(floor[x][y]==0?".":floor[x][y] + "");
//      }
//      System.out.print("\n");
//    }
//    System.out.print("\n");

    System.out.println(count);

  }
  
}
