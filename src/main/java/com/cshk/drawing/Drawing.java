package com.cshk.drawing;

import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.parser.CommandParser;

import static java.lang.System.exit;

class Drawing {

  private Canvas canvas;

  Drawing(final Canvas canvas) {
    this.canvas = canvas;
  }

  void run(final String cmdString) throws Exception {
    if (cmdString.toUpperCase().equals("Q")) {
      exit(1);
    }

    CommandParser.process(this.canvas, cmdString);
  }

  @Override
  public String toString() {
    return canvas.toString();
  }
}
