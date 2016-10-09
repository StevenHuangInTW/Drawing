package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Coordinates;
import com.cshk.drawing.models.Fill;


public class RectCommand implements ICommand {

  @Override
  public void exec(final Canvas canvas, String[] params) throws Exception {
    Coordinates coordinates = new Coordinates(
        Integer.valueOf(params[0]),
        Integer.valueOf(params[1]),
        Integer.valueOf(params[2]),
        Integer.valueOf(params[3])
    );

    Fill starFill = new Fill("*");
    this.exec(canvas, coordinates, starFill);
  }

  @Override
  public void exec(final Canvas canvas, Coordinates coords, Fill fill) throws Exception {
    drawRect(canvas, coords, fill);
  }

  private void drawRect(final Canvas canvas, Coordinates coords, Fill fill) throws Exception {
    if (!canvas.isValidCoords4Rect(coords)) {
      throw new Exception("Invalid Coordinates");
    }

    Fill[][] fills = canvas.getFills();

    for (int h = 0; h < fills.length; h++) {
      for (int w = 0; w < fills[h].length; w++) {
        if (
            (
                (coords.getX1Coord() == w || coords.getX2Coord() == w)
                    && coords.getY1Coord() <= h
                    && coords.getY2Coord() >= h)
                || (
                (coords.getY1Coord() == h || coords.getY2Coord() == h)
                    && coords.getX1Coord() <= w
                    && coords.getX2Coord() >= w)
            ) {
          fills[h][w] = fill;
        }
      }
    }

    canvas.setFills(fills);
  }
}
