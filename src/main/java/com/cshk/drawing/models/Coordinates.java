package com.cshk.drawing.models;

public class Coordinates {

  private int x1Coord;
  private int y1Coord;
  private int x2Coord;
  private int y2Coord;

  public Coordinates(final int x1Coord, final int y1Coord) {
    this.x1Coord = x1Coord;
    this.y1Coord = y1Coord;
  }

  public Coordinates(final int x1Coord, final int y1Coord, final int x2Coord, final int y2Coord) {
    this.x1Coord = x1Coord;
    this.y1Coord = y1Coord;
    this.x2Coord = x2Coord;
    this.y2Coord = y2Coord;
  }

  public int getX1Coord() {
    return x1Coord - 1;
  }

  public int getY1Coord() {
    return y1Coord - 1;
  }

  public int getX2Coord() {
    return x2Coord - 1;
  }

  public int getY2Coord() {
    return y2Coord - 1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Coordinates that = (Coordinates) o;

    if (x1Coord != that.x1Coord) return false;
    if (y1Coord != that.y1Coord) return false;
    if (x2Coord != that.x2Coord) return false;
    return y2Coord == that.y2Coord;

  }

  @Override
  public int hashCode() {
    int result = x1Coord;
    result = 31 * result + y1Coord;
    result = 31 * result + x2Coord;
    result = 31 * result + y2Coord;
    return result;
  }
}
