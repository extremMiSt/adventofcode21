package mist.adventofcode.day22;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day22/input01.txt");
    Scanner scn = new Scanner(r);
    
    boolean[][][] reactor = new boolean[101][101][101];
    for (int x = 0; x < reactor.length; x++) { //totally unneccecary, as it's initialized to false anyways
      for (int y = 0; y < reactor[x].length; y++) {
        for (int z = 0; z < reactor[x][y].length; z++) {
          reactor[x][y][z] = false;  
        }
      }
    }
    
    int minX = 0;
    int maxX = 0;
    int minY = 0;
    int maxY = 0;
    int minZ = 0;
    int maxZ = 0;
    while(scn.hasNextLine()){
      String line = scn.nextLine();
      
      String change = line.substring(0,line.indexOf(" "));
      String[] coords = line.substring(line.indexOf(" ")+1).split(",");
      String[] xS = coords[0].substring(2).split("\\.\\.");
      String[] yS = coords[1].substring(2).split("\\.\\.");
      String[] zS = coords[2].substring(2).split("\\.\\.");
      int x0 = Integer.parseInt(xS[0]);
      int x1 = Integer.parseInt(xS[1]);
      int y0 = Integer.parseInt(yS[0]);
      int y1 = Integer.parseInt(yS[1]);
      int z0 = Integer.parseInt(zS[0]);
      int z1 = Integer.parseInt(zS[1]);
      if(x0 > x1){
        int sw = x0;
        x0 = x1;
        x1= sw;
      }
      if(x0 < minX) minX = x0;
      if(x1 > maxX) maxX = x1;
      x0 = Math.max(x0, -50);
      x1 = Math.min(x1, 50);
      if(y0 > y1){
        int sw = y0;
        y0 = y1;
        y1 = sw;
      }
      if(y0 < minY) minY = y0;
      if(y1 > maxY) maxY = y1;
      y0 = Math.max(y0, -50);
      y1 = Math.min(y1, 50);
      if(z0 > z1){
        int sw = z0;
        z0 = z1;
        z1= sw;
      }
      if(z0 < minZ) minZ = z0;
      if(z1 > maxZ) maxZ = z1;
      z0 = Math.max(z0, -50);
      z1 = Math.min(z1, 50);
      
      for (int x = x0; x <= x1; x++) {
        for (int y = y0; y <= y1; y++) {
          for (int z = z0; z <= z1; z++) {
            reactor[x+50][y+50][z+50] = change.equals("on");
          }
        }
      }
    }
    
    int count = 0;
    for (int x = 0; x < reactor.length; x++) { //totally unneccecary, as it's initialized to false anyways
      for (int y = 0; y < reactor[x].length; y++) {
        for (int z = 0; z < reactor[x][y].length; z++) {
          if(reactor[x][y][z]) count++;
        }
      }
    }
    System.out.println(count);
    System.out.println(minX + ".." + maxX +", "+minY + ".." + maxY +", "+  minZ + ".." + maxZ);
  }
  
}
