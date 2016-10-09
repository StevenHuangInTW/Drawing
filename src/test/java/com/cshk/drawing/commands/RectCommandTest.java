package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Coordinates;
import com.cshk.drawing.models.Fill;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class RectCommandTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private ICommand rectCommand;
  private Canvas canvas;
  private Fill starFill;

  @Before
  public void setUp() throws Exception {
    rectCommand = new RectCommand();
    canvas = new Canvas(20, 4);
    starFill = new Fill("x");
  }

  @Test
  public void shouldDrawANormalRectangleOnAnyDrawableObject() throws Exception {
    Coordinates coords = new Coordinates(16, 1, 20, 3);

    rectCommand.exec(canvas, coords, starFill);

    String expectedString = "" +
        " --------------------\n" +
        "|               xxxxx|\n" +
        "|               x   x|\n" +
        "|               xxxxx|\n" +
        "|                    |\n" +
        " --------------------";

    assertEquals(expectedString, canvas.toString());
  }

  @Test
  public void shouldDrawADotAsARectangleOnAnyDrawableObject() throws Exception {
    String[] coords = {"16", "1", "16", "1"};

    rectCommand.exec(canvas, coords);

    String expectedString = "" +
        " --------------------\n" +
        "|               x    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        " --------------------";

    assertEquals(expectedString, canvas.toString());
  }

  @Test
  public void shouldThrowExceptionWhileUsingWrongCoords() throws Exception {
    Coordinates coords = new Coordinates(16, 1, 16, 5);

    String expectedMsg = "Invalid Coordinates";

    thrown.expect(Exception.class);
    thrown.expectMessage(expectedMsg);

    rectCommand.exec(canvas, coords, starFill);
  }
}