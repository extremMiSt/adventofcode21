package mist.adventofcode.day22.attempt2;

import java.util.List;

public class Tester {
  
  public static void main(String[] args) {
    //allInside();
    corner0();
    corner1();
    corner2();
    corner3();
    corner4();
    corner5();
    corner6();
    corner7();
  }
  
  public static void allInside(){
    Cuboid2 big1 = new Cuboid2(0, 10, 0, 10, 0, 10);
    Cuboid2 smol1 = new Cuboid2(3, 6, 3, 6, 3, 6);
    List<Cuboid2> leftovers = big1.minus(smol1);
    int volume = 0;
    for (Cuboid2 leftover : leftovers) {
      System.out.println(leftover);
      volume += leftover.getVolume();
    }
    System.out.println(volume);
  }
  
  public static void corner0(){
    Cuboid2 big1 = new Cuboid2(0, 10, 0, 10, 0, 10);
    Cuboid2 smol1 = new Cuboid2(0, 7, 0, 7, 0, 7);
    List<Cuboid2> leftovers = big1.minus(smol1);
    int volume = 0;
    for (Cuboid2 leftover : leftovers) {
      System.out.println(leftover);
      volume += leftover.getVolume();
    }
    System.out.println(volume);
  }
  
  public static void corner1(){
    Cuboid2 big1 = new Cuboid2(0, 10, 0, 10, 0, 10);
    Cuboid2 smol1 = new Cuboid2(3, 10, 0, 7, 0, 7);
    List<Cuboid2> leftovers = big1.minus(smol1);
    int volume = 0;
    for (Cuboid2 leftover : leftovers) {
      System.out.println(leftover);
      volume += leftover.getVolume();
    }
    System.out.println(volume);
  }
  
  public static void corner2(){
    Cuboid2 big1 = new Cuboid2(0, 10, 0, 10, 0, 10);
    Cuboid2 smol1 = new Cuboid2(0, 7, 3, 10, 0, 7);
    List<Cuboid2> leftovers = big1.minus(smol1);
    int volume = 0;
    for (Cuboid2 leftover : leftovers) {
      System.out.println(leftover);
      volume += leftover.getVolume();
    }
    System.out.println(volume);
  }
  
  public static void corner3(){
    Cuboid2 big1 = new Cuboid2(0, 10, 0, 10, 0, 10);
    Cuboid2 smol1 = new Cuboid2(3, 10, 3, 10, 0, 7);
    List<Cuboid2> leftovers = big1.minus(smol1);
    int volume = 0;
    for (Cuboid2 leftover : leftovers) {
      System.out.println(leftover);
      volume += leftover.getVolume();
    }
    System.out.println(volume);
  }
  
  public static void corner4(){
    Cuboid2 big1 = new Cuboid2(0, 10, 0, 10, 0, 10);
    Cuboid2 smol1 = new Cuboid2(0, 7, 0, 7, 3, 10);
    List<Cuboid2> leftovers = big1.minus(smol1);
    int volume = 0;
    for (Cuboid2 leftover : leftovers) {
      System.out.println(leftover);
      volume += leftover.getVolume();
    }
    System.out.println(volume);
  }
  
  public static void corner5(){
    Cuboid2 big1 = new Cuboid2(0, 10, 0, 10, 0, 10);
    Cuboid2 smol1 = new Cuboid2(3, 10, 0, 7, 3, 10);
    List<Cuboid2> leftovers = big1.minus(smol1);
    int volume = 0;
    for (Cuboid2 leftover : leftovers) {
      System.out.println(leftover);
      volume += leftover.getVolume();
    }
    System.out.println(volume);
  }
  
  public static void corner6(){
    Cuboid2 big1 = new Cuboid2(0, 10, 0, 10, 0, 10);
    Cuboid2 smol1 = new Cuboid2(0, 7, 3, 10, 3, 10);
    List<Cuboid2> leftovers = big1.minus(smol1);
    int volume = 0;
    for (Cuboid2 leftover : leftovers) {
      System.out.println(leftover);
      volume += leftover.getVolume();
    }
    System.out.println(volume);
  }
  
  public static void corner7(){
    Cuboid2 big1 = new Cuboid2(0, 10, 0, 10, 0, 10);
    Cuboid2 smol1 = new Cuboid2(3, 10, 3, 10, 3, 10);
    List<Cuboid2> leftovers = big1.minus(smol1);
    int volume = 0;
    for (Cuboid2 leftover : leftovers) {
      System.out.println(leftover);
      volume += leftover.getVolume();
    }
    System.out.println(volume);
  }
  
}
