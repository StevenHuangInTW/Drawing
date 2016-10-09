package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Coordinates;
import com.cshk.drawing.models.Fill;

import java.util.ArrayList;


public class BucketCommand implements ICommand {

  private ArrayList<Coordinates> paintedPoints = new ArrayList();
  private Fill defaultFill = new Fill();

  @Override
  public void exec(final Canvas canvas, String[] params) throws Exception {
    Coordinates coordinates = new Coordinates(
        Integer.valueOf(params[0]),
        Integer.valueOf(params[1])
    );

    Fill circleFill = new Fill(params[2]);
    this.exec(canvas, coordinates, circleFill);
  }

  @Override
  public void exec(final Canvas canvas, Coordinates coords, Fill fill) throws Exception {
    fillBucket(canvas, coords, fill);
  }

  private void fillBucket(final Canvas canvas, Coordinates coords, Fill fill) throws Exception {
    if (!canvas.isCoordsWithinBounds(coords)) {
      throw new Exception("Invalid Coordinates");
    }


    Fill[][] fills = canvas.getFills();

    int x = coords.getX1Coord();
    int y = coords.getY1Coord();

    if (fills[y][x].toString() == defaultFill.toString()) {
      checkAroundCoords(x, y, fills);

      for (Coordinates point : paintedPoints) {
        fills[point.getY1Coord() + 1][point.getX1Coord() + 1] = fill;
      }

      canvas.setFills(fills);
    }
  }


  private void checkAroundCoords(int x, int y, Fill[][] fills) {
    saveValidaCoords(x, y, fills);
    saveValidaCoords(x, y - 1, fills);
    saveValidaCoords(x, y + 1, fills);
    saveValidaCoords(x - 1, y, fills);
    saveValidaCoords(x + 1, y, fills);
  }

  private void saveValidaCoords(int x, int y, Fill[][] fills) {
    int height = fills.length;
    int width = fills[0].length;

    if ((x >= 0 && x < width && y >= 0 && y < height) && fills[y][x].toString() == defaultFill.toString()) {
      if (!paintedPoints.contains(new Coordinates(x, y))) {
        paintedPoints.add(new Coordinates(x, y));
        checkAroundCoords(x, y, fills);
      }
    }
  }
}

