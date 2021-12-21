package mist.adventofcode.day20;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main01 {
  
  public static void main(String[] args) throws IOException{
    InputStream r = mist.adventofcode.day15.Main01.class.getClassLoader().getResourceAsStream("day20/input01.txt");
    Scanner scn = new Scanner(r);
    
    String[] pattern = scn.nextLine().split("");
    System.out.println(Arrays.toString(pattern));
    scn.nextLine(); //empty line
    
    String[][] img = new String[100][];
    int yS = 0;
    
    while(scn.hasNextLine()){
      String[] split = scn.nextLine().split("");
      img[yS] = split;
      yS++;
    }
    
    
    String inf = ".";
    for (int i = 0; i < 2; i++) {
      img = expand(img, inf);
      String[][] res = new String[img.length][img[0].length];
      
      for (int y = 0; y < img.length; y++) {
        for (int x = 0; x < img[y].length; x++) {
          String s = pattern[toInt(stringAt(img, x, y, inf))];
          res[y][x] = s;
        }
      }
      img = res;
      inf = pattern[toInt(inf+inf+inf+inf+inf+inf+inf+inf+inf)];
    }
    
    int count = 0;
    for (int i = 0; i < img.length; i++) {
      for (int j = 0; j < img[i].length; j++) {
        System.out.print(img[i][j]);
        if(img[i][j].equals("#")){
          count++;
        }
      }
      System.out.println();
    }
    System.out.println(count);
    
  }
  
  public static String stringAt(String[][] img, int x, int y, String inf){
    String s = "";
    if(y-1 >= 0){
      s += x-1 < 0 ? inf: img[y-1][x-1];
      s += img[y-1][x];
      s += x+1 >= img[y].length ? inf: img[y-1][x+1];
    }else{
      s+= inf+inf+inf;
    }
    s += x-1 < 0 ? inf: img[y][x-1];
    s += img[y][x];
    s += x+1 >= img[y].length ? inf: img[y][x+1];

    if(y+1 < img.length){
      s += x-1 < 0 ? inf: img[y+1][x-1];
      s += img[y+1][x];
      s += x+1 >= img[y].length ? inf: img[y+1][x+1];
    }else{
      s+= inf+inf+inf;
    }
    return s;
  }
  
  public static int toInt(String s){
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      res = res<<1;
      res += s.charAt(i)=='#'?1:0;
    }
    return res;
  }
  
  public static String[][] expand(String[][] in, String by){
    String[][] ret = new String[in.length+2][in[0].length+2];
    
    for (int i = 0; i < ret.length; i++) {
      ret[0][i] = by;
      ret[ret.length-1][i] = by;
    }
    for (int i = 0; i < ret[0].length; i++) {
      ret[i][0] = by;
      ret[i][ret.length-1] = by;
    }
    
    for (int i = 0; i < in.length; i++) {
      System.arraycopy(in[i], 0, ret[i+1], 1, in[i].length);
    }
    
    return ret;
  }
}
