package mist.adventofcode.day22;

public class Step {
  
  public final String change;
  
  public final Cuboid cube;

  public Step(String change, Cuboid c) {
    this.change = change;
    cube = c;
  }
}
