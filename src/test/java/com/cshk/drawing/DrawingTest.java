package com.cshk.drawing;

import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Coordinates;
import com.cshk.drawing.models.Fill;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawingTest {

  private Drawing drawing;
  private Coordinates lineCoords1;
  private Coordinates lineCoords2;
  private Coordinates invalidLineCoords;
  private Fill starFill;

  @Before
  public void setUp() throws Exception {
    Canvas canvas = new Canvas(20, 4);

    drawing = new Drawing(canvas);
    starFill = new Fill("*");
    lineCoords1 = new Coordinates(1, 2, 6, 2);
    lineCoords2 = new Coordinates(6, 3, 6, 4);
    invalidLineCoords = new Coordinates(5, 3, 6, 4);
  }

  @Test
  public void shouldDrawAHorizontalLineForCoordinates() throws Exception {
    drawing.drawLine(lineCoords1, starFill);
    Canvas currentCanvas = drawing.currentCanvas();

    int xStart = lineCoords1.getX1Coord();
    int xEnd = lineCoords1.getX2Coord();
    int yLine = lineCoords1.getY1Coord();

    Fill[] line = currentCanvas.getFills()[yLine];

    for (int i = xStart; i < xEnd; i++) {
      assertEquals(starFill, line[i]);
    }

    String expectedString = "" +
        " --------------------\n" +
        "|                    |\n" +
        "|******              |\n" +
        "|                    |\n" +
        "|                    |\n" +
        " --------------------";

    assertEquals(expectedString, drawing.toString());
  }

  @Test
  public void shouldDrawAVerticalLineForCoordinates() throws Exception {
    drawing.drawLine(lineCoords2, starFill);
    Canvas currentCanvas = drawing.currentCanvas();

    int xLine = lineCoords2.getX1Coord();
    int yStart = lineCoords2.getY1Coord();
    int yEnd = lineCoords2.getY2Coord();

    Fill[][] fills = currentCanvas.getFills();

    for (int i = 0; i < fills.length; i++) {
      for (int j = 0; j < fills[i].length; j++) {
        if (j == xLine && (i >= yStart && i <= yEnd)) {
          assertEquals(starFill, fills[i][j]);
        }
      }
    }

    String expectedString = "" +
        " --------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|     *              |\n" +
        "|     *              |\n" +
        " --------------------";

    assertEquals(expectedString, drawing.toString());
  }

  @Test
  public void shouldReturnErrorMsgWhileCoordsInvalid() throws Exception {
    drawing.drawLine(invalidLineCoords, starFill);

    String expectedMsg = "Invalid Commands";

    assertEquals(expectedMsg, drawing.toString());
  }

  @Test
  public void shouldRunLineCmdStringDirectly() throws Exception {
    String cmd1 = "L 1 2 6 2";
    String cmd2 = "L 6 3 6 4";

    drawing.run(cmd1);
    drawing.run(cmd2);

    String expectedString = "" +
        " --------------------\n" +
        "|                    |\n" +
        "|******              |\n" +
        "|     *              |\n" +
        "|     *              |\n" +
        " --------------------";

    assertEquals(expectedString, drawing.toString());
//    Check from console
    System.out.print(drawing.toString());
  }
}