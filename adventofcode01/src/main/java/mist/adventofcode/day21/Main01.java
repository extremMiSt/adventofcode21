package mist.adventofcode.day21;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day21/input01.txt");
    Scanner scn = new Scanner(r);
    
    int[] pos = new int[2];
    String l1 = scn.nextLine();
    pos[0] = Integer.parseInt(l1.substring(l1.lastIndexOf(":")+1).trim());
    String l2 = scn.nextLine();
    pos[1] = Integer.parseInt(l2.substring(l2.lastIndexOf(":")+1).trim());
    
    DeterministicDice dice = new DeterministicDice();
    
    int player = 0;
    
    int score[] = new int[]{0,0};
    
    int count = 0;
    
    while(score[0] < 1000 && score[1] < 1000){
      count += 3;
      
      int d1 = dice.getNext();
      int d2 = dice.getNext();
      int d3 = dice.getNext();
      
      System.out.print("Player " + (player+1) + " rolles " + d1 + "+" +d2 + "+" +d3);
      
      pos[player] = pos[player] + (d1+d2+d3)%10;
      if(pos[player] > 10){
        pos[player] = pos[player] -10;
      }
      
      score[player] = score[player] + pos[player];
      
      System.out.println(" and moves to space " + pos[player] + " for a total score of "+score[player]+".");
      
      player = 1-player;
    }
    
    System.out.println(count + "; " + score[0] + " " + score[1]);
    System.out.println(count * (score[0]<score[1]?score[0]:score[1]));
  }
  
}
