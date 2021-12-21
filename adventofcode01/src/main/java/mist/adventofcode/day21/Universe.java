package mist.adventofcode.day21;

public class Universe {
  
  private final int[] pos;
  private final int score[];
  private int player;
  
  private long count;

  public Universe(int pos0, int pos1, int score0, int score1, int player, long count) {
    this.pos = new int[]{pos0,pos1};
    this.score = new int[]{score0,score1};
    this.player = player;
    this.count = count;
  }

  public int[] getPos() {
    return pos;
  }

  public int[] getScore() {
    return score;
  }

  public int getPlayer() {
    return player;
  }

  public void setPlayer(int player) {
    this.player = player;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }
  
  
  
}
