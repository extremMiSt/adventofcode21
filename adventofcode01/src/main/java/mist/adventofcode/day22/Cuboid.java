package mist.adventofcode.day22;

import java.util.ArrayList;
import java.util.List;

public class Cuboid {
  
  private final long minX;
  private final long maxX;
  private final long minY;
  private final long maxY;
  private final long minZ;
  private final long maxZ;

  public Cuboid(long minX, long maxX, long minY, long maxY, long minZ, long maxZ) {
    
    this.minX = minX;
    this.maxX = maxX;
    this.minY = minY;
    this.maxY = maxY;
    this.minZ = minZ;
    this.maxZ = maxZ;
  }
  
  
  
  public List<Cuboid> minus(Cuboid d){
    
    //if I am completely inside the other then I do not matter
    if(d.getMinX() <= minX && maxX <= d.getMaxX() &&
       d.getMinY() <= minY && maxY <= d.getMaxY() &&
       d.getMinZ() <= minZ && maxZ <= d.getMaxZ()){
      return new ArrayList<>();
    }
    //if I am completely appart from the other, then I do not change
    if(d.getMinX() > maxX || minX > d.getMaxX() &&
       d.getMinY() > maxY || minY > d.getMaxY() &&
       d.getMinZ() > maxZ || minZ > d.getMaxZ()){
      List<Cuboid> l = new ArrayList<>();
      l.add(this);
      return l;
    }
    //now here comes the hard part...
    List<Cuboid> l = new ArrayList<>();
    if(minX < d.getMinX()){
      l.add(new Cuboid(minX, d.minX-1, minY, maxY, minZ, maxZ));
    }
    if(minY < d.getMinY()){
      l.add(new Cuboid(Math.max(d.minX,minX), maxX, minY, d.minY-1, minZ, maxZ));
    }
    if(minZ < d.getMinZ()){
      l.add(new Cuboid(Math.max(d.minX,minX), maxX, Math.max(d.minY,minY), maxY, minZ, d.minZ-1));
    }
    
    if(maxY > d.getMaxY()){
      l.add(new Cuboid(Math.max(d.minX,minX), maxX, d.maxY+1, maxY, Math.max(d.minZ, minZ), maxZ));
    }
    if(maxZ > d.getMaxZ()){
      l.add(new Cuboid(Math.max(d.minX,minX), maxX, Math.max(d.minY,minY), Math.min(d.maxY,maxY), d.maxZ+1, maxZ));
    }
    if(maxX > d.getMaxX()){
      l.add(new Cuboid(d.maxX+1, maxX, Math.max(d.minY,minY), Math.min(d.maxY,maxY), Math.max(d.minZ, minZ), Math.min(d.maxZ, maxZ)));
    }
    return l;
  }

  public long getMinX() {
    return minX;
  }

  public long getMaxX() {
    return maxX;
  }

  public long getMinY() {
    return minY;
  }

  public long getMaxY() {
    return maxY;
  }

  public long getMinZ() {
    return minZ;
  }

  public long getMaxZ() {
    return maxZ;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = (int) (53 * hash + this.minX);
    hash = (int) (53 * hash + this.maxX);
    hash = (int) (53 * hash + this.minY);
    hash = (int) (53 * hash + this.maxY);
    hash = (int) (53 * hash + this.minZ);
    hash = (int) (53 * hash + this.maxZ);
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
    final Cuboid other = (Cuboid) obj;
    if (this.minX != other.minX) {
      return false;
    }
    if (this.maxX != other.maxX) {
      return false;
    }
    if (this.minY != other.minY) {
      return false;
    }
    if (this.maxY != other.maxY) {
      return false;
    }
    if (this.minZ != other.minZ) {
      return false;
    }
    if (this.maxZ != other.maxZ) {
      return false;
    }
    return true;
  }
  
  public long volume(){
    return (getMaxX()-getMinX()+1)*
            (getMaxY()-getMinY()+1)*
            (getMaxZ()-getMinZ()+1);
  }

  @Override
  public String toString() {
    return "Cuboid{" + " minX=" + minX + ", maxX=" + maxX + ", minY=" + minY + ", maxY=" + maxY + ", minZ=" + minZ + ", maxZ=" + maxZ + '}';
  }
  
  

}
