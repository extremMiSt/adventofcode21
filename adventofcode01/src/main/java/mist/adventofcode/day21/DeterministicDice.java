package mist.adventofcode.day21;

public class DeterministicDice {
  
  private int usage = 0;
  private int res = 1;
  
  public int getNext(){
    usage++;
    int result = res;
    res++;
    if(res > 100){
      res = 1;
    }
    return result;
  }

  public int getUsage() {
    return usage;
  }
  
  

}
