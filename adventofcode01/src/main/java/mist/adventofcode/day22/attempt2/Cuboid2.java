package mist.adventofcode.day22.attempt2;

import java.util.ArrayList;
import java.util.List;

public class Cuboid2 {
  
  private long fromX;
  private long toX;
  
  private long fromY;
  private long toY;
  
  private long fromZ;
  private long toZ;

  public Cuboid2(long fromX, long toX, long fromY, long toY, long fromZ, long toZ) {
    this(fromX, toX, fromY, toY, fromZ, toZ, false);
  }
  
  public Cuboid2(long fromX, long toX, long fromY, long toY, long fromZ, long toZ, boolean incl) {
//    if(!(toX>fromX && toY > fromY && toZ > fromZ)){
//      return;
//    }
    
    if(incl){
      this.fromX = fromX;
      this.toX = toX+1;
      this.fromY = fromY;
      this.toY = toY+1;
      this.fromZ = fromZ;
      this.toZ = toZ+1;
    }else{
      this.fromX = fromX;
      this.toX = toX;
      this.fromY = fromY;
      this.toY = toY;
      this.fromZ = fromZ;
      this.toZ = toZ;
    }
  }
  
  public List<Cuboid2> minus(Cuboid2 other){
    List<Cuboid2> list = new ArrayList<>();
    
    //if I am completely inside the other then I do not matter
    if( this.getFromX() >= other.getFromX() && other.getToX() >= this.getToX() &&
        this.getFromY() >= other.getFromY() && other.getToY() >= this.getToY() &&
        this.getFromZ() >= other.getFromZ() && other.getToZ() >= this.getToZ() ){
      return list;
    }
    
    //if we do not overlap at all then nothing changes
    if( this.getFromX() >= other.getToX() || other.getFromX() >= this.getToX() ||
        this.getFromY() >= other.getToY() || other.getFromY() >= this.getToY() ||
        this.getFromZ() >= other.getToZ() || other.getFromZ() >= this.getToZ() ){
      list.add(this);
      return list;
    }
    
    if(this.getFromX() <= other.getFromX()){
      list.add(new Cuboid2(this.getFromX(), other.getFromX(), this.getFromY(), this.getToY(), this.getFromZ(), this.getToZ()));
    }
    
    if(this.getToX() >= other.getToX()){
      list.add(new Cuboid2(other.getToX(), this.getToX(), this.getFromY(), this.getToY(), this.getFromZ(), this.getToZ()));
    }
    
    if(this.getFromY() <= other.getFromY()){
      long fromX = Math.max(this.getFromX(),other.getFromX());
      long toX = Math.min(this.getToX(),other.getToX());
      list.add(new Cuboid2(fromX, toX, this.getFromY(), other.getFromY(), this.getFromZ(), this.getToZ()));
    }
    
    if(this.getToY() >= other.getToY()){
      long fromX = Math.max(this.getFromX(),other.getFromX());
      long toX = Math.min(this.getToX(),other.getToX());
      list.add(new Cuboid2(fromX, toX, other.getToY(), this.getToY(), this.getFromZ(), this.getToZ()));
    }
    
    if(this.getFromZ() <= other.getFromZ()){
      long fromX = Math.max(this.getFromX(),other.getFromX());
      long toX = Math.min(this.getToX(),other.getToX());
      long fromY = Math.max(this.getFromY(),other.getFromY());
      long toY = Math.min(this.getToY(),other.getToY());
      list.add(new Cuboid2(fromX, toX, fromY, toY, this.getFromZ(), other.getFromZ()));
    }
    
    if(this.getToZ() >= other.getToZ()){
      long fromX = Math.max(this.getFromX(),other.getFromX());
      long toX = Math.min(this.getToX(),other.getToX());
      long fromY = Math.max(this.getFromY(),other.getFromY());
      long toY = Math.min(this.getToY(),other.getToY());
      list.add(new Cuboid2(fromX, toX, fromY, toY, other.getToZ(), this.getToZ()));
    }
    
    return list;
  }
  
  public long getVolume(){
    if(toX>fromX && toY > fromY && toZ > fromZ){
      return (toX-fromX)*(toY-fromY)*(toZ-fromZ);
    }
    return 0;
  }

  public long getFromX() {
    return fromX;
  }

  public long getToX() {
    return toX;
  }

  public long getFromY() {
    return fromY;
  }

  public long getToY() {
    return toY;
  }

  public long getFromZ() {
    return fromZ;
  }

  public long getToZ() {
    return toZ;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = (int) (79 * hash + this.fromX);
    hash = (int) (79 * hash + this.toX);
    hash = (int) (79 * hash + this.fromY);
    hash = (int) (79 * hash + this.toY);
    hash = (int) (79 * hash + this.fromZ);
    hash = (int) (79 * hash + this.toZ);
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
    final Cuboid2 other = (Cuboid2) obj;
    if (this.fromX != other.fromX) {
      return false;
    }
    if (this.toX != other.toX) {
      return false;
    }
    if (this.fromY != other.fromY) {
      return false;
    }
    if (this.toY != other.toY) {
      return false;
    }
    if (this.fromZ != other.fromZ) {
      return false;
    }
    return this.toZ == other.toZ;
  }

  @Override
  public String toString() {
    return "{"+fromX+"-"+toX+", "+fromY+"-"+toY+", "+fromZ+"-"+toZ+"} " + getVolume();
  }
  
  
  
}
