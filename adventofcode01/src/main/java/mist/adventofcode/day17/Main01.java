package mist.adventofcode.day17;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day15.Main01.class.getClassLoader().getResourceAsStream("day17/input01.txt");
    Scanner scn = new Scanner(r);
    
    
    String line = scn.nextLine();
    
    String xInt = line.substring(line.indexOf("=")+1, line.indexOf(","));
    String[] xIntSplit = xInt.split("\\.\\.");
    int minX = Integer.parseInt(xIntSplit[0]);
    int maxX = Integer.parseInt(xIntSplit[1]);
    
    String yInt = line.substring(line.lastIndexOf("=")+1);
    String[] yIntSplit = yInt.split("\\.\\.");
    int minY = Integer.parseInt(yIntSplit[0]);
    int maxY = Integer.parseInt(yIntSplit[1]);
    
    int max = 0;
    int mX = 0;
    int mY = 0;
    for (int y = 0; y < 10000; y++) {
      for (int x = 0; x < 1000; x++) {
        int highestHit = highestHit(x, y, minX, maxX, minY, maxY);
        if(highestHit > max){
          max = highestHit;
          mX = x;
          mY = y;
        }
      }
    }
    System.out.println(max + " at " + mX + "," + mY);
  }
  
  public static int highestHit(int speedX, int speedY, int minX, int maxX, int minY, int maxY){
    int posX = 0;
    int posY = 0;
    
    int max = 0;
    while(posX < maxX && posY > minY){
      posX += speedX;
      posY += speedY;
      
      if(posY > max) max = posY;
      
      if(speedX != 0) speedX -= 1;
      speedY -= 1;
      if(posX >= minX && posX <= maxX && posY >= minY && posY <= maxY){
        return max;
      }
    }
     
    return -1;
  }
}
