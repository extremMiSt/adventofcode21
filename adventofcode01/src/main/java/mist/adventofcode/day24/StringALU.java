package mist.adventofcode.day24;

import java.util.HashMap;
import java.util.Map;

public class StringALU {
  
  private final Map<String, String> values;
  
  private final String input;
  private int pos;
  
  public StringALU(String input, String wS, String xS, String yS, String zS){
    values = new HashMap<>();
    values.put("w", wS);
    values.put("x", xS);
    values.put("y", yS);
    values.put("z", zS);
    
    this.input = input;
    pos = 0;
  }

  public void perform(String[] command){
    String par;
    switch (command[0]) {
      case "inp":
        values.put(command[1], input.charAt(pos) /*- 48L*/ +"");
        pos++;
        break;
        
      case "add":
        if(values.containsKey(command[2])){
          par = values.get(command[2]);
        }else {
          par = Long.parseLong(command[2])+"";
        }
        values.put(command[1], "("+values.get(command[1])+"+"+par+")");
        break;
        
      case "mul":
        if(values.containsKey(command[2])){
          par = values.get(command[2]);
        }else {
          par = Long.parseLong(command[2])+"";
        }
        values.put(command[1], "("+values.get(command[1])+"*"+par+")");
        break;
        
      case "div":
        if(values.containsKey(command[2])){
          par = values.get(command[2]);
        }else {
          par = Long.parseLong(command[2])+"";
        }
        values.put(command[1], "("+values.get(command[1])+"/"+par+")");
        break;
        
      case "mod":
        if(values.containsKey(command[2])){
          par = values.get(command[2]);
        }else {
          par = Long.parseLong(command[2])+"";
        }
        values.put(command[1], "("+values.get(command[1])+"%"+par+")");
        break;
        
      case "eql":
        if(values.containsKey(command[2])){
          par = values.get(command[2]);
        }else {
          par = Long.parseLong(command[2])+"";
        }
        values.put(command[1], "("+values.get(command[1])+"=="+par+"?1L:0L)");
        break;
        
      default:
        throw new AssertionError();
    }
  }
  
  public String getW(){
    return values.get("w");
  }
  
  public String getX(){
    return values.get("x");
  }
  
  public String getY(){
    return values.get("y");
  }
  
  public String getZ(){
    return values.get("z");
  }
}
