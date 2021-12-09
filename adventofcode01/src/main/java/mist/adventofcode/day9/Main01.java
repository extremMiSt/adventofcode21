package mist.adventofcode.day9;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day3.Main01.class.getClassLoader().getResourceAsStream("day9/input01.txt");
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
    
    int risksum = 0;
    
    for (int x = 0; x < floor.length; x++) {
      for (int y = 0; y < floor[x].length; y++) {
        
        int me = floor[x][y];
        int up = y+1<100?floor[x][y+1]:10;
        int down = y-1>=0?floor[x][y-1]:10;
        int left = x+1<100?floor[x+1][y]:10;
        int right = x-1>=0?floor[x-1][y]:10;
        
        if( me < up && me < down &&
            me < left && me < right){
          risksum += me+1;
        }
        
      }
    }
    System.out.println(risksum);
    
  }
  
}
