package com.cshk.drawing.commands;

import com.cshk.drawing.Drawing;
import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Coordinates;
import com.cshk.drawing.models.Fill;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineCommandTest {
  @Test
  public void shouldDrawALineOnAnyDrawableObject() throws Exception {
    LineCommand lineCommand = new LineCommand();
    Canvas canvas = new Canvas(20, 4);
    Drawing drawing = new Drawing(canvas);
    Fill starFill = new Fill("*");
    Coordinates lineCoords = new Coordinates(1, 2, 6, 2);

    lineCommand.exec(drawing, lineCoords, starFill);

    String expectedString = "" +
        " --------------------\n" +
        "|                    |\n" +
        "|******              |\n" +
        "|                    |\n" +
        "|                    |\n" +
        " --------------------";

    assertEquals(expectedString, drawing.toString());
  }
}