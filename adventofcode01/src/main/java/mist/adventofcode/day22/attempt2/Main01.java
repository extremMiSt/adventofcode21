package mist.adventofcode.day22.attempt2;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) {
    InputStream r = Main01.class.getClassLoader().getResourceAsStream("day22/input01.txt");
    Scanner scn = new Scanner(r);
    
    List<Step2> steps = new ArrayList<>();
    
    while(scn.hasNextLine()){
      String line = scn.nextLine();
      
      String change = line.substring(0,line.indexOf(" "));
      String[] coords = line.substring(line.indexOf(" ")+1).split(",");
      String[] xS = coords[0].substring(2).split("\\.\\.");
      String[] yS = coords[1].substring(2).split("\\.\\.");
      String[] zS = coords[2].substring(2).split("\\.\\.");
      int x0 = Integer.parseInt(xS[0]);
      int x1 = Integer.parseInt(xS[1]);
      int y0 = Integer.parseInt(yS[0]);
      int y1 = Integer.parseInt(yS[1]);
      int z0 = Integer.parseInt(zS[0]);
      int z1 = Integer.parseInt(zS[1]);
      if(x0 > x1){
        int sw = x0;
        x0 = x1;
        x1= sw;
      }
      x0 = Math.max(x0, -50);
      x1 = Math.min(x1, 50);
      if(y0 > y1){
        int sw = y0;
        y0 = y1;
        y1 = sw;
      }
      y0 = Math.max(y0, -50);
      y1 = Math.min(y1, 50);
      if(z0 > z1){
        int sw = z0;
        z0 = z1;
        z1= sw;
      }
      z0 = Math.max(z0, -50);
      z1 = Math.min(z1, 50);
      Cuboid2 c = new Cuboid2(x0, x1, y0, y1, z0, z1, true);
      
      if(c.getVolume() != 0){
        steps.add(new Step2(change.equals("on"), c));
      }
    }
    
    long count = 0;
    
    for (int i = 0; i < steps.size(); i++) {
      
      if(!steps.get(i).isChange()) continue; //if this doesn'T turn things on we can ignore it, it has already turned off what it turns off
      
      List<Cuboid2> leftover = new ArrayList<>();
      leftover.add(steps.get(i).getRegion());
      
      for (int j = i+1; j < steps.size(); j++) {
        List<Cuboid2> temp = new ArrayList<>();
        for (Cuboid2 c : leftover) {
          temp.addAll(c.minus(steps.get(j).getRegion()));
        }
        leftover = temp;
      }
      for (Cuboid2 cube : leftover) {
        count += cube.getVolume();
      }
    }
    System.out.println(count);
  }

}
