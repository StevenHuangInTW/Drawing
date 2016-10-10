package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Coordinates;
import com.cshk.drawing.models.Fill;

public class LineCommand extends Command {

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
    drawLine(canvas, coordinates, starFill);
  }

  private void drawLine(final Canvas canvas, Coordinates coordinates, Fill fill) throws Exception {
    if (!canvas.isValidCoords4Line(coordinates)) {
      throw new Exception("Invalid Coordinates");
    }

    Fill[][] fills = canvas.getFills();

    for (int h = 0; h < fills.length; h++) {
      for (int w = 0; w < fills[h].length; w++) {
        if (
            (
                coordinates.getY1Coord() == h
                    && coordinates.getY2Coord() == h
                    && coordinates.getX1Coord() <= w
                    && coordinates.getX2Coord() >= w
            ) || (
                coordinates.getX1Coord() == w
                    && coordinates.getX2Coord() == w
                    && coordinates.getY1Coord() <= h
                    && coordinates.getY2Coord() >= h
            )) {
          fills[h][w] = fill;
        }
      }
    }

    canvas.setFills(fills);
  }
}
