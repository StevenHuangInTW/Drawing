package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class LineCommandTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void shouldDrawAHorizontalLineOnAnyDrawableObject() throws Exception {
    Command lineCommand = new LineCommand();

    Canvas canvas = new Canvas(20, 4);
    String[] coords = {"1", "2", "6", "2"};
    lineCommand.setParams(coords);

    lineCommand.exec(canvas);

    String expectedString = "" +
        " --------------------\n" +
        "|                    |\n" +
        "|xxxxxx              |\n" +
        "|                    |\n" +
        "|                    |\n" +
        " --------------------";

    assertEquals(expectedString, canvas.toString());
  }

  @Test
  public void shouldDrawAVerticalLineOnAnyDrawableObject() throws Exception {
    Command lineCommand = new LineCommand();

    Canvas canvas = new Canvas(20, 4);
    String[] coords = {"6", "3", "6", "4"};
    lineCommand.setParams(coords);

    lineCommand.exec(canvas);

    String expectedString = "" +
        " --------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|     x              |\n" +
        "|     x              |\n" +
        " --------------------";

    assertEquals(expectedString, canvas.toString());
  }

  @Test
  public void shouldThrowExceptionWhileUsingWrongCoords() throws Exception {
    Command lineCommand = new LineCommand();

    Canvas canvas = new Canvas(20, 4);
    String[] invalidCoords = {"1", "2", "6", "3"};
    lineCommand.setParams(invalidCoords);

    String expectedMsg = "Invalid Coordinates";

    thrown.expect(Exception.class);
    thrown.expectMessage(expectedMsg);

    lineCommand.exec(canvas);
  }
}