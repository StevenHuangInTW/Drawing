package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Coordinates;
import com.cshk.drawing.models.Fill;

public class RectCommand extends Command {

  @Override
  public void exec(final Canvas canvas) throws Exception {
    String[] params = this.getParams();

    Coordinates coordinates = new Coordinates(
        Integer.valueOf(params[0]),
        Integer.valueOf(params[1]),
        Integer.valueOf(params[2]),
        Integer.valueOf(params[3])
    );

    Fill starFill = new Fill("x");
    drawRect(canvas, coordinates, starFill);
  }

  private void drawRect(final Canvas canvas, Coordinates coords, Fill fill) throws Exception {
    if (!canvas.isCoordsWithinBounds(coords)) {
      throw new Exception("Invalid Coordinates");
    }

    Fill[][] fills = canvas.getFills();
    int x1Coord = coords.getX1Coord();
    int x2Coord = coords.getX2Coord();
    int y1Coord = coords.getY1Coord();
    int y2Coord = coords.getY2Coord();

    for (int h = 0; h < fills.length; h++) {
      for (int w = 0; w < fills[h].length; w++) {
        if ((x1Coord == w || x2Coord == w) && isInRange(h, y1Coord, y2Coord)
            || (y1Coord == h || y2Coord == h) && isInRange(w, x1Coord, x2Coord)
            ) {
          fills[h][w] = fill;
        }
      }
    }

    canvas.setFills(fills);
  }
}
