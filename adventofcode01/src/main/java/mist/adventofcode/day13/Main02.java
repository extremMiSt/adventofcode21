package mist.adventofcode.day13;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main02 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main02.class.getClassLoader().getResourceAsStream("day13/input01.txt");
    Scanner scn = new Scanner(r);
    
    Set<Point> points = new HashSet<>();
    List<String> folds = new ArrayList<>();
    
    boolean isPoints = true;
    while(scn.hasNextLine()){
      String line = scn.nextLine();
      if(line.equals("")){
        isPoints = false;
        continue;
      }
      
      if(isPoints){
        String[] split = line.split(",");
        points.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
      }else{
        folds.add(line);
      }
    }
    
    int sizeX = 0;
    int sizeY = 0;
    for (String fold : folds) {
      String[] split = fold.split("=");
      if(split[0].contains("x")){
        sizeX = Integer.parseInt(split[1]);
        points = foldX(points, sizeX);
      }else{
        sizeY = Integer.parseInt(split[1]);
        points = foldY(points, sizeY);
      }
    }
    
    for (int y = 0; y < sizeY; y++) {
      for (int x = 0; x < sizeX; x++) {
        if(points.contains(new Point(x, y))){
          System.out.print("█");
        }else{
          System.out.print(" ");
        }
      }
      System.out.println(" ");
    }
  }
  
  public static Set<Point> foldX(Set<Point> points, int x){
    Set<Point> result = new HashSet<>();
    for (Point point : points) {
      if(point.x > x){
        result.add(new Point(x-(point.x-x), point.y));
      }else{
        result.add(point);
      }
    }
    return result;
  }
  
  public static Set<Point> foldY(Set<Point> points, int y){
    Set<Point> result = new HashSet<>();
    for (Point point : points) {
      if(point.y > y){
        result.add(new Point(point.x, y-(point.y-y)));
      }else{
        result.add(point);
      }
    }
    return result;
  }
}
