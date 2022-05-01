package mist.adventofcode.day22.attempt2;

public class Step2 {
  
  private final boolean change;
  private final Cuboid2 region;

  public Step2(boolean change, Cuboid2 region) {
    this.change = change;
    this.region = region;
  }

  public boolean isChange() {
    return change;
  }

  public Cuboid2 getRegion() {
    return region;
  }

}
