package com.cshk.drawing;

import com.cshk.drawing.commands.CommandParser;
import com.cshk.drawing.commands.ICommand;
import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Coordinates;
import com.cshk.drawing.models.Fill;

public class Drawing {

  private Canvas canvas;
  private boolean isParsingSuccesd = true;
  private boolean isCoordsValid = true;

  public Drawing(final Canvas canvas) {
    this.canvas = canvas;
  }

  public void run(final String cmdString) {
    isParsingSuccesd = true;
    CommandParser commandParser = new CommandParser(cmdString);
    if (!commandParser.parse()) {
      isParsingSuccesd = false;
      return;
    }

    ICommand cmd = commandParser.getCommand();
    Coordinates coords = commandParser.getCoordinates();
    Fill fills = commandParser.getFill();

    cmd.exec(this, coords, fills);
  }

  public void drawLine(Coordinates coordinates, Fill fill) {
    if (!canvas.isValidCoords4Line(coordinates)) {
      this.isCoordsValid = false;
      return;
    }

    this.isCoordsValid = true;
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

    this.canvas.setFills(fills);
  }

  public Canvas currentCanvas() {
    return canvas;
  }

  @Override
  public String toString() {
    if (!this.isCoordsValid) {
      return "Invalid Commands";
    }

    if (!this.isParsingSuccesd) {
      return "Command String Parsing Failed";
    }

    return canvas.toString();
  }
}
