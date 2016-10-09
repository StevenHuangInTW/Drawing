package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Coordinates;
import com.cshk.drawing.models.Fill;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class LineCommandTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void shouldDrawAHorizontalLineOnAnyDrawableObject() throws Exception {
    LineCommand lineCommand = new LineCommand();

    Canvas canvas = new Canvas(20, 4);
    String[] coords = {"1", "2", "6", "2"};

    lineCommand.exec(canvas, coords);

    String expectedString = "" +
        " --------------------\n" +
        "|                    |\n" +
        "|******              |\n" +
        "|                    |\n" +
        "|                    |\n" +
        " --------------------";

    assertEquals(expectedString, canvas.toString());
  }

  @Test
  public void shouldDrawAVerticalLineOnAnyDrawableObject() throws Exception {
    LineCommand lineCommand = new LineCommand();

    Canvas canvas = new Canvas(20, 4);
    Fill starFill = new Fill("*");
    Coordinates coords = new Coordinates(6, 3, 6, 4);

    lineCommand.exec(canvas, coords, starFill);

    String expectedString = "" +
        " --------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|     *              |\n" +
        "|     *              |\n" +
        " --------------------";

    assertEquals(expectedString, canvas.toString());
  }

  @Test
  public void shouldThrowExceptionWhileUsingWrongCoords() throws Exception {
    LineCommand lineCommand = new LineCommand();

    Canvas canvas = new Canvas(20, 4);
    String[] invalidCoords = {"1", "2", "6", "3"};

    String expectedMsg = "Invalid Coordinates";

    thrown.expect(Exception.class);
    thrown.expectMessage(expectedMsg);

    lineCommand.exec(canvas, invalidCoords);
  }
}