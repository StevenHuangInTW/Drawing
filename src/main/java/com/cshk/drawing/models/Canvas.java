package com.cshk.drawing.models;

public class Canvas {

  private final int width;
  private final int height;
  private Fill[][] fills;

  public Canvas(final int width, final int height) {
    this.width = width;
    this.height = height;

    fills = new Fill[height][width];
    Fill defaultFill = new Fill();

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        fills[i][j] = defaultFill;
      }
    }
  }

  public void setFills(Fill[][] fills) {
    this.fills = fills;
  }

  public Fill[][] getFills() {
    return fills;
  }

  public boolean isValidCoords4Line(Coordinates coordinates) {
    int x1 = coordinates.getX1Coord();
    int y1 = coordinates.getY1Coord();
    int x2 = coordinates.getX2Coord();
    int y2 = coordinates.getY2Coord();

    return isCoordsWithinBounds(coordinates) && (isXCoordsEqual(x1, x2) || isYCoordsEqual(y1, y2));
  }

  private boolean isCoordsWithinBounds(Coordinates coordinates) {
    int x1 = coordinates.getX1Coord();
    int y1 = coordinates.getY1Coord();
    int x2 = coordinates.getX2Coord();
    int y2 = coordinates.getY2Coord();


    return isXCoordsWithinBounds(x1)
        && isXCoordsWithinBounds(x2)
        && isYCoordsWithinBounds(y1)
        && isYCoordsWithinBounds(y2);
  }

  private boolean isXCoordsWithinBounds(final int xCoords) {
    return xCoords <= this.width - 1;
  }

  private boolean isYCoordsWithinBounds(final int yCoords) {
    return yCoords <= this.height - 1;
  }

  private boolean isXCoordsEqual(final int x1Coords, final int x2Coords) {
    return x1Coords == x2Coords;
  }

  private boolean isYCoordsEqual(final int y1Coords, final int y2Coords) {
    return y1Coords == y2Coords;
  }

  @Override
  public String toString() {
    StringBuilder drawingOutput = new StringBuilder();
    drawingOutput
        .append(" ")
        .append(new String(new char[width]).replace("\0", "-"));

    for (int i = 0; i < fills.length; i++) {
      drawingOutput
          .append("\n")
          .append("|");
      for (int j = 0; j < fills[i].length; j++) {
        drawingOutput.append(fills[i][j]);
      }
      drawingOutput.append("|");
    }

    drawingOutput
        .append("\n")
        .append(" ")
        .append(new String(new char[width]).replace("\0", "-"));

    return drawingOutput.toString();
  }
}
