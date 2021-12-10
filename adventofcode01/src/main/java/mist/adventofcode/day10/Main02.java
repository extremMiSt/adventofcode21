package mist.adventofcode.day10;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main02.class.getClassLoader().getResourceAsStream("day10/input01.txt");
    Scanner scn = new Scanner(r);
    
    List<Long> l = new ArrayList<>();
    while(scn.hasNextLine()){
      long score = lineScore(scn.nextLine());
      if(score != -1){
        l.add(score);
      }
    }
    Collections.sort(l);
    System.out.println(l.get(l.size()/2));
  }
  
  
  public static long lineScore(String line){
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
          if(d.pop()!='(') return -1;
          break;
        case ']':
          if(d.pop()!='[') return -1;
          break;
        case '}':
          if(d.pop()!='{') return -1;
          break;
        case '>':
          if(d.pop()!='<') return -1;
          break;
        default:
          throw new AssertionError();
      }
    }
    if(d.isEmpty()){ //it's okay
      return 0;
    }
    
    //it's incomplete
    long score = 0;
    while(!d.isEmpty()){
      score *= 5;
      
      char c = d.pop();
      if(c == '('){
        score+=1;
      }else if(c == '['){
        score+=2;
      }else if(c == '{'){
        score+=3;
      }else if(c == '<'){
        score+=4;
      }
    }
    return score; //ok or incomplete;
  }
  
}
