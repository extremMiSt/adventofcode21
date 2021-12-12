package mist.adventofcode.day11;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day11/input01.txt");
    Scanner scn = new Scanner(r);
    
    int[][] squid = new int[10][10];
    
    for (int i = 0; i < 10; i++) {
      String line = scn.nextLine();
      for (int j = 0; j < 10; j++) {
        squid[j][i] = line.charAt(j)-48;
      }
    }
    
    int blips = 0;
    for (int i = 0; i < 100; i++) {
      
      for (int x = 0; x < 10; x++) {
        for (int y = 0; y < 10; y++) {
          squid[x][y]++;
        }
      }
      
      boolean changed = true;
      while(changed){
        changed = false;
        
        loop:
        for (int x = 0; x < 10; x++) {
          for (int y = 0; y < 10; y++) {
            if(squid[x][y] > 9){
              
              blips++;
              squid[x][y] = 0;
              changed = true;
              
              if (x + 1 < 10 && squid[x+1][y] != 0) squid[x+1][y]++;
              if (x - 1 >= 0 && squid[x-1][y] != 0) squid[x-1][y]++;
              if (y + 1 < 10 && squid[x][y+1] != 0) squid[x][y+1]++;
              if (y - 1 >= 0 && squid[x][y-1] != 0) squid[x][y-1]++;
              
              if (x + 1 < 10 && y + 1 < 10 && squid[x+1][y+1] != 0) squid[x+1][y+1]++;
              if (x + 1 < 10 && y - 1 >= 0 && squid[x+1][y-1] != 0) squid[x+1][y-1]++;
              if (x - 1 >= 0 && y + 1 < 10 && squid[x-1][y+1] != 0) squid[x-1][y+1]++;
              if (x - 1 >= 0 && y - 1 >= 0 && squid[x-1][y-1] != 0) squid[x-1][y-1]++;
              
              break;
            }
          }
        }
      }
      
      for (int y = 0; y < 10; y++) {
        for (int x = 0; x < 10; x++) {
          System.out.print(squid[x][y]);
        }
        System.out.println();
      }
      System.out.println();
    }
    
    System.out.println(blips);
    
  }
  
}
