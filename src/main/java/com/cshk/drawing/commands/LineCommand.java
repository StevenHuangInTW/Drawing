package com.cshk.drawing.commands;

import com.cshk.drawing.Drawing;
import com.cshk.drawing.models.Fill;
import com.cshk.drawing.models.Coordinates;


public class LineCommand implements ICommand {
  @Override
  public void exec(Drawing drawing, Coordinates coords, Fill fill) {
    drawing.drawLine(coords, fill);
  }
}
