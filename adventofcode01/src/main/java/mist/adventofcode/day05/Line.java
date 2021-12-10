package mist.adventofcode.day05;

public class Line {
  
  private final int x1;
  private final int y1;
  
  private final int x2;
  private final int y2;
  
  /**
   * x1,y1 -> x2,y2
   * 348,742 -> 620,742
   * @param s 
   */
  public Line(String s){
    int first = s.indexOf(",");
    String sx1 = s.substring(0, first);
    int arrow = s.indexOf(" -> ");
    String sy1 = s.substring(first+1, arrow);
    int second = s.indexOf(",", arrow);
    String sx2 = s.substring(arrow+4, second);
    String sy2 = s.substring(second+1, s.length());
    this.x1 = Integer.parseInt(sx1);
    this.y1 = Integer.parseInt(sy1);
    this.x2 = Integer.parseInt(sx2);
    this.y2 = Integer.parseInt(sy2);
  }

  public Line(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public int getX1() {
    return x1;
  }

  public int getY1() {
    return y1;
  }

  public int getX2() {
    return x2;
  }

  public int getY2() {
    return y2;
  }
  
  public String toString(){
    return x1 + "," + y1 + " -> " + x2 + "," + y2;
  }
  

}
