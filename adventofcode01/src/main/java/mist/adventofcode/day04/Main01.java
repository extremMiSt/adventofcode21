package mist.adventofcode.day04;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day04/input01.txt");
    Scanner scn = new Scanner(r);
    
    String inString = scn.nextLine();
    String[] inputs = inString.split(",");
    scn.nextLine();
    
    List<BingoBoard> boards = new ArrayList<>();
    
    while(scn.hasNext()){
      String[][] board = new String[5][5];
      for (int i = 0; i < 5; i++) {
        String line = scn.nextLine();
        String[] split = line.trim().split("\\s+");
        for (int j = 0; j < 5; j++) {
          board[j][i] = split[j];
        }
      }
      boards.add(new BingoBoard(board));
      scn.nextLine();
    }
    //end parsing
    
    for (String input : inputs) {
      for (BingoBoard board : boards) {
        if(board.mark(input)){
          System.out.println(board.value() * Integer.parseInt(input));
          System.exit(0);
        }
      }
    }
  }
  
}
