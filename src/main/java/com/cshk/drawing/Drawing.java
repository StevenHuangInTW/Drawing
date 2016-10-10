package com.cshk.drawing;

import com.cshk.drawing.commands.Command;
import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.parser.CommandParser;

import static java.lang.System.exit;

class Drawing {

  private Canvas canvas;

  Drawing(final Canvas canvas) {
    this.canvas = canvas;
  }

  void draw(final String cmdString) throws Exception {
    if (cmdString.toUpperCase().equals("Q")) {
      exit(1);
    }

    Command command = CommandParser.process(cmdString);
    command.exec(canvas);
  }

  @Override
  public String toString() {
    return canvas.toString();
  }
}
