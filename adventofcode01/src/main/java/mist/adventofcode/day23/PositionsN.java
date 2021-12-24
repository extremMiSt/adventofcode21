package mist.adventofcode.day23;

import java.util.Arrays;

public class PositionsN implements Comparable<PositionsN> {
  
  public final String[] layer0;
  public final String[][] rooms;
  
  public long cost;
  
  public final PositionsN from;

  public PositionsN(String[] layer0, String[][] rooms, long cost, PositionsN from) {
    this.layer0 = layer0;
    this.rooms = rooms;
    
    this.cost = cost;
    
    this.from = from;
  }

  public PositionsN(String[][] rooms) {
    this.layer0 = new String[]{".",".",".",".",".",".",".",".",".",".","."};
    this.rooms = rooms;
    
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
    for (int k = 0; k < rooms.length; k++) {
      for (int i = 0; i < rooms[k].length; i++) {
        ret = ret + rooms[k][i] + "#";
      }
      ret = ret + "##\n  #";
    }
    ret = ret + "########";
    return ret;
    
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 53 * hash + Arrays.deepHashCode(this.layer0);
    hash = 53 * hash + Arrays.deepHashCode(this.rooms);
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
    final PositionsN other = (PositionsN) obj;
    if (!Arrays.deepEquals(this.layer0, other.layer0)) {
      return false;
    }
    if (!Arrays.deepEquals(this.rooms, other.rooms)) {
      return false;
    }
    return true;
  }

  @Override
  public int compareTo(PositionsN o) {
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
