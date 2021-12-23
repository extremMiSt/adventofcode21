package mist.adventofcode.day22;

import java.util.List;

public class Scratch {
  
  public static void main(String[] args){    

    Cuboid a = new Cuboid(0, 10, 0, 10, 0, 10);
    System.out.println(a.volume());
    int xoff = 10;
    int yoff = 10;
    int zoff = 0;
    Cuboid b = new Cuboid(0+xoff, 10+xoff, 0+yoff, 10+yoff, 0+zoff, 10+zoff);
    System.out.println(b.volume());
    List<Cuboid> c = a.minus(b);
    int volume = 0;
    for (Cuboid cube : c) {
      volume += cube.volume();
    }
    System.out.println(volume);
    System.out.println(c.size());
    System.out.println(c);
    
  }

}
