package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class RectCommandTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private Command rectCommand;
  private Canvas canvas;

  @Before
  public void setUp() throws Exception {
    rectCommand = new RectCommand();
    canvas = new Canvas(20, 4);
  }

  @Test
  public void shouldDrawANormalRectangleOnAnyDrawableObject() throws Exception {
    String[] coords = {"16", "1", "20", "3"};
    rectCommand.setParams(coords);

    rectCommand.exec(canvas);

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
    rectCommand.setParams(coords);

    rectCommand.exec(canvas);

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
    String[] coords = {"16", "1", "16", "5"};
    rectCommand.setParams(coords);

    String expectedMsg = "Invalid Coordinates";

    thrown.expect(Exception.class);
    thrown.expectMessage(expectedMsg);

    rectCommand.exec(canvas);
  }
}