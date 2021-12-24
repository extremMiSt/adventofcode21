package mist.adventofcode.day23;

import java.util.Arrays;

public class Positions implements Comparable<Positions> {
  
  public final String[] layer0;
  public final String[] layer1;
  public final String[] layer2;
  
  public long cost;
  
  public final Positions from;

  public Positions(String[] layer0, String[] layer1, String[] layer2, long cost, Positions from) {
    this.layer0 = layer0;
    this.layer1 = layer1;
    this.layer2 = layer2;
    
    this.cost = cost;
    
    this.from = from;
  }

  public Positions(String[] layer1, String[] layer2) {
    this.layer0 = new String[]{".",".",".",".",".",".",".",".",".",".","."};
    this.layer1 = layer1;
    this.layer2 = layer2;
    
    this.cost = 0;
    
    this.from = null;
  }

  @Override
  public String toString() {
    String ret = "#" + cost + "#\n#";
    for (int i = 0; i < layer0.length; i++) {
      ret = ret + layer0[i];
    }
    ret = ret + "#\n###";
    for (int i = 0; i < layer1.length; i++) {
      ret = ret + layer1[i] + "#";
    }
    ret = ret + "##\n  #";
    for (int i = 0; i < layer2.length; i++) {
      ret = ret + layer2[i] + "#";
    }
    ret = ret + "\n  #########";
    return ret;
    
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 53 * hash + Arrays.deepHashCode(this.layer0);
    hash = 53 * hash + Arrays.deepHashCode(this.layer1);
    hash = 53 * hash + Arrays.deepHashCode(this.layer2);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Positions other = (Positions) obj;
    if (!Arrays.deepEquals(this.layer0, other.layer0)) {
      return false;
    }
    if (!Arrays.deepEquals(this.layer1, other.layer1)) {
      return false;
    }
    if (!Arrays.deepEquals(this.layer2, other.layer2)) {
      return false;
    }
    return true;
  }

  @Override
  public int compareTo(Positions o) {
    long diff = this.cost-o.cost;
    if(diff == 0){
      return 0;
    }else if(diff < 0){
      return -1;
    }else{
      return 1;
    }
  }
  
  

}
