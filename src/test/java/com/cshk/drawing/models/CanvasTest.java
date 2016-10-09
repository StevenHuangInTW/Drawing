package com.cshk.drawing.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasTest {

  private Canvas canvas;
  private Fill defaultFill;

  private Coordinates validCoords4Line1;
  private Coordinates validCoords4Line2;
  private Coordinates invalidCoords4Line1;
  private Coordinates invalidCoords4Line2;

  private Coordinates validCoords4Rect1;
  private Coordinates validCoords4Rect2;
  private Coordinates invalidCoords4Rect1;
  private Coordinates invalidCoords4Rect2;

  @Before
  public void setUp() throws Exception {
    canvas = new Canvas(20, 4);
    defaultFill = new Fill();

    validCoords4Line1 = new Coordinates(1, 2, 6, 2);
    validCoords4Line2 = new Coordinates(6, 3, 6, 4);
    invalidCoords4Line1 = new Coordinates(6, 5, 6, 4);
    invalidCoords4Line2 = new Coordinates(6, 3, 5, 4);

    validCoords4Rect1 = new Coordinates(16, 1, 20, 3);
    validCoords4Rect2 = new Coordinates(16, 1, 16, 1);
    invalidCoords4Rect1 = new Coordinates(16, 1, 21, 3);
    invalidCoords4Rect2 = new Coordinates(16, 1, 20, 5);
  }

  @Test
  public void shouldGenerate2DimensionArraysWithDefaultFills() throws Exception {
    Fill[][] fills = canvas.getFills();

    Assert.assertEquals(4, fills.length);

    for (int h = 0; h < fills.length; h++) {
      for (int w = 0; w < fills[h].length; w++) {
        assertEquals(defaultFill.toString(), fills[h][w].toString());
      }
    }
  }

  @Test
  public void shouldVerifyValidaCoordsForLine() throws Exception {
    assertTrue(canvas.isValidCoords4Line(validCoords4Line1));
    assertTrue(canvas.isValidCoords4Line(validCoords4Line2));
  }

  @Test
  public void shouldVerifyInvalidaCoordsForLine() throws Exception {
    assertFalse(canvas.isValidCoords4Line(invalidCoords4Line1));
    assertFalse(canvas.isValidCoords4Line(invalidCoords4Line2));
  }

  @Test
  public void shouldVerifyValidaCoordsForRect() throws Exception {
    assertTrue(canvas.isCoordsWithinBounds(validCoords4Rect1));
    assertTrue(canvas.isCoordsWithinBounds(validCoords4Rect2));
  }

  @Test
  public void shouldVerifyInvalidaCoordsForRect() throws Exception {
    assertFalse(canvas.isCoordsWithinBounds(invalidCoords4Rect1));
    assertFalse(canvas.isCoordsWithinBounds(invalidCoords4Rect2));
  }

  @Test
  public void shouldPrintCorrectFillsWithBoders() throws Exception {
    String expectedString = "" +
        " --------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        " --------------------";

    assertEquals(expectedString, canvas.toString());
  }
}