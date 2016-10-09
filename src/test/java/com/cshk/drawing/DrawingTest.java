package com.cshk.drawing;

import com.cshk.drawing.models.Canvas;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrawingTest {

  private Drawing drawing;

  @Before
  public void setUp() throws Exception {
    Canvas canvas = new Canvas(20, 4);

    drawing = new Drawing(canvas);
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