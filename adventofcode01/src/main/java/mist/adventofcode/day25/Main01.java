package mist.adventofcode.day25;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day25/input01.txt");
    Scanner scn = new Scanner(r);
    
    char[][] field = new char[139][137];
    //char[][] field = new char[10][9];
    
    int l = 0;
    while(scn.hasNextLine()){
      String line = scn.nextLine();
      for (int i = 0; i < line.length(); i++) {
        field[i][l] = line.charAt(i);
      }
      l++;
    }
    
    int rounds = 0;
    boolean moved = true;
    while(moved){
      //make copy
      char[][] field2 = new char[field.length][];
      for (int x = 0; x < field2.length; x++) {
        field2[x] = Arrays.copyOf(field[x], field[x].length);
      }

      //determine what can move to the East, then move
      Set<Point> canMoveEast = new HashSet<>();
      for (int x = 0; x < field2.length; x++) {
        for (int y = 0; y < field2[x].length; y++) {
          if(field2[x][y] == '>' && field2[(x+1)%field2.length][y]=='.'){
            canMoveEast.add(new Point(x, y));
          }
        }
      }
      for (Point p : canMoveEast) {
        field2[p.x][p.y] = '.';
        field2[(p.x+1)%field2.length][p.y]='>';
      }

      //determine what can move to the South, then move
      Set<Point> canMoveSouth = new HashSet<>();
      for (int x = 0; x < field2.length; x++) {
        for (int y = 0; y < field2[x].length; y++) {
          if(field2[x][y] == 'v' && field2[x][(y+1)%field2[x].length]=='.'){
            canMoveSouth.add(new Point(x, y));
          }
        }
      }
      for (Point p : canMoveSouth) {
        field2[p.x][p.y] = '.';
        field2[p.x][(p.y+1)%field2[p.x].length]='v';
      }
      
      field = field2;
      moved = !canMoveEast.isEmpty() /*|| !canMoveSouth.isEmpty()*/;
      rounds++;
      
      
//      for (int y = 0; y < field[0].length; y++) {
//        for (int x = 0; x < field.length; x++) {
//          System.out.print(field[x][y]);
//        }
//        System.out.println("");
//      }
//      System.out.println("");
      //System.out.println(canMoveEast.size() + "e: " + canMoveEast+"\n"+canMoveSouth.size() + "s: "+canMoveSouth);
    }
    System.out.println("we stopped after " + rounds);
  }
}
