package mist.adventofcode.day18;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SnailNumber {
  
  public SnailNumber parent;
  
  public SnailNumber left;
  public SnailNumber right;
  
  public int literal;

  public SnailNumber(SnailNumber parent, int literal) {
    this.parent = parent;
    this.literal = literal;
  }

  public SnailNumber(SnailNumber parent, SnailNumber left, SnailNumber right) {
    this.parent = parent;
    this.left = left;
    this.right = right;
    left.parent = this;
    right.parent = this;
    literal = -1;
  }

  @Override
  public String toString() {
    if(literal == -1){
      return "[" + left + "," + right + "]";
    }else{
      return  literal + "";
    }
  }
  
  public long magnitude(){
    if(literal != -1){
      return literal;
    }
    
    return left.magnitude()*3 + right.magnitude()*2;
  }
  
  public SnailNumber copy(){
    if(literal != -1) {
      return new SnailNumber(null, literal);
    }else{
      SnailNumber l = left.copy();
      SnailNumber r = right.copy();
      return new SnailNumber(null, l, r);
    }
  }
  
  public static SnailNumber fromString(String line){
    Deque<String> d = new LinkedList<>();
    Deque<SnailNumber> s = new LinkedList<>();
    Scanner scn = new Scanner(line);
    scn.useDelimiter("");
    while(scn.hasNext("\\[") || scn.hasNext("\\]") || scn.hasNext(",") || scn.hasNext("[0-9]+")){
      if(scn.hasNext("\\[")){
        scn.next("\\[");
        //this is  just a delim
      }else if(scn.hasNext("\\]")){
        scn.next("\\]");
        SnailNumber right = s.pop();
        SnailNumber left = s.pop();
        s.push(new SnailNumber(null, left, right));
      }else if(scn.hasNext(",")){
        scn.next(",");
        //this is  just a delim
      }else if(scn.hasNext("[0-9]+")){
        int n = Integer.parseInt(scn.next("[0-9]+"));
        s.push(new SnailNumber(null, n));
      }
    }
    return s.getFirst();
  }
  
  public static SnailNumber add(SnailNumber a, SnailNumber b){
    
    SnailNumber addWithout = combine(a.copy(), b.copy());
    boolean changed = true;
    while(changed){
      changed = false;

      SnailNumber explode = findExplode(addWithout, 0);
      if(explode != null){
        SnailNumber left = findLeft(explode);
        if(left != null){
          left.literal = left.literal + explode.left.literal;
        }

        SnailNumber right = findRight(explode);
        if(right != null){
          right.literal = right.literal + explode.right.literal;
        }

        if(explode.parent.left == explode){
          explode.parent.left = new SnailNumber(explode.parent, 0);
        }else{
          explode.parent.right = new SnailNumber(explode.parent, 0);
        }
        changed = true;
      }else{
        SnailNumber split = findSplit(addWithout);
        if(split != null){
          SnailNumber left = new SnailNumber(null, Math.floorDiv(split.literal, 2));
          SnailNumber right = new SnailNumber(null, split.literal - Math.floorDiv(split.literal, 2));
          SnailNumber child = combine(left, right);

          SnailNumber parent = split.parent;
          child.parent = parent;

          if(split.parent.left == split){
            split.parent.left = child;
          }else{
            split.parent.right = child;
          }

          changed = true;
        }
      }
    }
    return addWithout;
  }
  
  public static SnailNumber combine(SnailNumber a, SnailNumber b){
    SnailNumber ret = new SnailNumber(null, a, b);
    a.parent = ret;
    b.parent = ret;
    return ret;
  }
  
    public static SnailNumber findSplit(SnailNumber s){
    if(s.literal != -1) {
      if(s.literal >= 10){
        return s;
      }else{
        return null;
      }
      
    }else{
      SnailNumber left = findSplit(s.left);
      if(left != null){
        return left;
      }
      return findSplit(s.right);
    }
  }
  
  public static SnailNumber findExplode(SnailNumber s, int depth){
    if(s.literal != -1) {
      return null;
    }
    if(depth == 4 && s.literal == -1){
      return s;
    }
    else{
      SnailNumber left = findExplode(s.left, depth+1);
      if(left != null){
        return left;
      }
      return findExplode(s.right, depth+1);
    }
  }
  
  public static SnailNumber findLeft(SnailNumber s){
    SnailNumber old = s;
    while(true){
      s = s.parent;
      if(s == null){
        break;
      }
      if(s.left != old) {
        break;
      }
      old = s;
    }
    if(s == null){
      return null;
    }else{
      old = s.left;
      while (old.literal == -1){
        old = old.right;
      }
      return old;
    }
  }
  
  public static SnailNumber findRight(SnailNumber s){
    SnailNumber old = s;
    while(true){
      s = s.parent;
      if(s == null){
        break;
      }
      if(s.right != old) {
        break;
      }
      old = s;
    }
    if(s == null){
      return null;
    }else{
      old = s.right;
      while (old.literal == -1){
        old = old.left;
      }
      return old;
    }
  }
}
