package com.cshk.drawing.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasTest {

  private Canvas canvas;
  private Coordinates validCoords4Line1;
  private Coordinates validCoords4Line2;
  private Coordinates invalidCoords4Line1;
  private Coordinates invalidCoords4Line2;
  private Fill defaultFill;

  @Before
  public void setUp() throws Exception {
    canvas = new Canvas(20, 4);
    defaultFill = new Fill();

    validCoords4Line1 = new Coordinates(1, 2, 6, 2);
    validCoords4Line2 = new Coordinates(6, 3, 6, 4);
    invalidCoords4Line1 = new Coordinates(6, 5, 6, 4);
    invalidCoords4Line2 = new Coordinates(6, 3, 5, 4);
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