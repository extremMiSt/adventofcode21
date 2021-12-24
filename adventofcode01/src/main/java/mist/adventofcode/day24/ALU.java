package mist.adventofcode.day24;

import java.util.HashMap;
import java.util.Map;

public class ALU {
  
  private final Map<String, Long> values;
  
  private final String input;
  private int pos;
  
  public ALU(String input){
    values = new HashMap<>();
    values.put("w", 0L);
    values.put("x", 0L);
    values.put("y", 0L);
    values.put("z", 0L);
    
    this.input = input;
    pos = 0;
  }

  public void perform(String[] command){
    long par;
    switch (command[0]) {
      case "inp":
        values.put(command[1], input.charAt(pos) - 48L);
        pos++;
        break;
        
      case "add":
        if(values.containsKey(command[2])){
          par = values.get(command[2]);
        }else {
          par = Long.parseLong(command[2]);
        }
        values.put(command[1], values.get(command[1])+par);
        break;
        
      case "mul":
        if(values.containsKey(command[2])){
          par = values.get(command[2]);
        }else {
          par = Long.parseLong(command[2]);
        }
        values.put(command[1], values.get(command[1])*par);
        break;
        
      case "div":
        if(values.containsKey(command[2])){
          par = values.get(command[2]);
        }else {
          par = Long.parseLong(command[2]);
        }
        values.put(command[1], values.get(command[1])/par);
        break;
        
      case "mod":
        if(values.containsKey(command[2])){
          par = values.get(command[2]);
        }else {
          par = Long.parseLong(command[2]);
        }
        values.put(command[1], values.get(command[1])%par);
        break;
        
      case "eql":
        if(values.containsKey(command[2])){
          par = values.get(command[2]);
        }else {
          par = Long.parseLong(command[2]);
        }
        values.put(command[1], values.get(command[1])==par?1L:0L);
        break;
        
      default:
        throw new AssertionError();
    }
  }
  
  public long getW(){
    return values.get("w");
  }
  
  public long getX(){
    return values.get("x");
  }
  
  public long getY(){
    return values.get("y");
  }
  
  public long getZ(){
    return values.get("z");
  }
}
