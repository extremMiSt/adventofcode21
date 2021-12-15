package mist.adventofcode.day15;

public class Node implements Comparable<Node> {
  
  public final int weight;
  public final int x;
  public final int y;
  
  public boolean found;
  public Node from;
  public int cost;

  public Node(int weight, int x, int y)  {
    this.weight = weight;
    this.x = x;
    this.y = y;
    this.found = false;
    this.cost = Integer.MAX_VALUE;
  }

  @Override
  public int compareTo(Node o) {
    return this.cost-o.cost;
  }

  @Override
  public String toString() {
    return x + "," + y + "," + found +  "," + cost;
  }
  
  

}
