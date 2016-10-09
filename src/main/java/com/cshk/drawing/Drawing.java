package com.cshk.drawing;

import com.cshk.drawing.commands.CommandParser;
import com.cshk.drawing.models.Canvas;

public class Drawing {

  private Canvas canvas;

  public Drawing(final Canvas canvas) {
    this.canvas = canvas;
  }

  public void run(final String cmdString) {
    try {
      CommandParser.process(this.canvas, cmdString);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return canvas.toString();
  }
}
