package mist.adventofcode.day10;

import java.io.IOException;
import java.io.InputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day10/input01.txt");
    Scanner scn = new Scanner(r);
    
    int score = 0;
    while(scn.hasNextLine()){
      score += lineScore(scn.nextLine());
    }
    System.out.println(score);
  }
  
  
  public static int lineScore(String line){
    Deque<Character> d = new LinkedList<>();
    for (int i = 0; i < line.length(); i++) {
      char cur = line.charAt(i);
      switch (cur) {
        case '(':
          d.push(cur);
          break;
        case '[':
          d.push(cur);
          break;
        case '{':
          d.push(cur);
          break;
        case '<':
          d.push(cur);
          break;
          
        case ')':
          if(d.pop()!='(') return 3;
          break;
        case ']':
          if(d.pop()!='[') return 57;
          break;
        case '}':
          if(d.pop()!='{') return 1197;
          break;
        case '>':
          if(d.pop()!='<') return 25137;
          break;
        default:
          throw new AssertionError();
      }
    }
    return 0; //ok or incomplete;
  }
  
}
