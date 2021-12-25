package mist.adventofcode.day22;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main02 {
  
  //2758514936282235
  //2595373017598592
  
  public static void main(String[] args) throws IOException{
    InputStream r = Main02.class.getClassLoader().getResourceAsStream("day22/input01.txt");
    Scanner scn = new Scanner(r);
    List<Step> steps = new ArrayList<>();
    
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
      if(y0 > y1){
        int sw = y0;
        y0 = y1;
        y1 = sw;
      }
      if(z0 > z1){
        int sw = z0;
        z0 = z1;
        z1= sw;
      }
      steps.add(new Step(change, new Cuboid(x0, x1, y0, y1, z0, z1)));
      
    }
    
    long res = 0;
    for (int j = 0; j < steps.size(); j++) {
      System.out.println(j);
      if(steps.get(j).change.equals("off")){
        continue;
      }
      List<Cuboid> c = new ArrayList<>();
      c.add(steps.get(j).cube);
      for (int i = j+1; i < steps.size(); i++) {
        List<Cuboid> d = new ArrayList<>();
        for (Cuboid cuboid : c) {
          d.addAll(cuboid.minus(steps.get(i).cube));
        }
        c = d;
      }
      long on = 0;
      for (Cuboid cube : c) {
        on += cube.volume();
      }
      res+=on;
    }
    System.out.println(res);
  }
  
}
