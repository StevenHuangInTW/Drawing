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

    drawing.draw(cmd1);
    drawing.draw(cmd2);

    String expectedString = "" +
        " --------------------\n" +
        "|                    |\n" +
        "|xxxxxx              |\n" +
        "|     x              |\n" +
        "|     x              |\n" +
        " --------------------";

    assertEquals(expectedString, drawing.toString());

    // For Interview Verify
    System.out.println(drawing.toString());
  }

  @Test
  public void shouldRunCmdStringOneByOneDirectly() throws Exception {
    String cmd1 = "R 16 1 20 3";

    drawing.draw(cmd1);

    String expectedString = "" +
        " --------------------\n" +
        "|               xxxxx|\n" +
        "|               x   x|\n" +
        "|               xxxxx|\n" +
        "|                    |\n" +
        " --------------------";

    assertEquals(expectedString, drawing.toString());

    // For Interview Verify
    System.out.println(drawing.toString());
  }

  @Test
  public void shouldRunRectCmdStringDirectly() throws Exception {
    String cmd1 = "L 1 2 6 2";
    String cmd2 = "L 6 3 6 4";
    String cmd3 = "R 16 1 20 3";
    String cmd4 = "B 10 3 o";

    drawing.draw(cmd1);
    drawing.draw(cmd2);
    drawing.draw(cmd3);
    drawing.draw(cmd4);

    String expectedString = "" +
        " --------------------\n" +
        "|oooooooooooooooxxxxx|\n" +
        "|xxxxxxooooooooox   x|\n" +
        "|     xoooooooooxxxxx|\n" +
        "|     xoooooooooooooo|\n" +
        " --------------------";

    assertEquals(expectedString, drawing.toString());

    // For Interview Verify
    System.out.println(drawing.toString());
  }
}