package mist.adventofcode.day04;

public class BingoBoard {
  
  private final String[][] board;
  private final boolean[][] marked;

  public BingoBoard(String[][] board) {
    this.board = board;  //you should validate that this is a 5x5 array!!!
    this.marked = new boolean[5][5];
    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[x].length; y++) {
        marked[x][y] = false;
      }
    }
    
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[y].length; x++) {
        System.out.print(board[x][y] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
  
  public boolean mark(String num){
    for (int x = 0; x < 5; x++) {
      for (int y = 0; y < 5; y++) {
        if(board[x][y].equals(num)){
          marked[x][y] = true;
        }
      }
    }
    return check();
  }
  
  public boolean check(){
    column:
    for (int x = 0; x < 5; x++) {
      for (int y = 0; y < 5; y++) {
        if(!marked[x][y]) continue column;
      }
      return true;
    }
    
    row:
    for (int y = 0; y < 5; y++) {
      for (int x = 0; x < 5; x++) {
        if(!marked[x][y]) continue row;
      }
      return true;
    }
    
    return false;
  }
  
  public int value(){
    int sum = 0;
    for (int x = 0; x < 5; x++) {
      for (int y = 0; y < 5; y++) {
        if(!marked[x][y]){
          sum += Integer.parseInt(board[x][y]);
        }
       
      }
    }
    return sum;
  }

}
