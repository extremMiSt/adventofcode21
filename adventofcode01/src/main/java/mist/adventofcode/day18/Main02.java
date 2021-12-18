package mist.adventofcode.day18;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day15.Main01.class.getClassLoader().getResourceAsStream("day18/input01.txt");
    Scanner scn = new Scanner(r);
    
    List<SnailNumber> numbers = new ArrayList<>();
    
    while(scn.hasNextLine()){
      numbers.add(SnailNumber.fromString(scn.nextLine()));
    }
    System.out.println(numbers);
    
    long max = 0;
    for (SnailNumber number0 : numbers) {
      for (SnailNumber number1 : numbers) {
        SnailNumber sum = SnailNumber.add(number0, number1);
        long mag = sum.magnitude();
        if(mag > max)  max = mag;
      }
    }
    
    System.out.println(max);
  }
}
