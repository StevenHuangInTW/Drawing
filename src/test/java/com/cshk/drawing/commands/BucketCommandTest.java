package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Fill;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BucketCommandTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private ICommand bucketCommand;
  private Canvas canvas;
  private Fill starFill;

  @Before
  public void setUp() throws Exception {
    bucketCommand = new BucketCommand();
    canvas = new Canvas(20, 4);
    starFill = new Fill("o");
  }

  @Test
  public void shouldFillBucketOnAnyDrawableObject() throws Exception {
    String[] params = {"10", "3", "o"};

    bucketCommand.exec(canvas, params);

    String expectedString = "" +
        " --------------------\n" +
        "|oooooooooooooooooooo|\n" +
        "|oooooooooooooooooooo|\n" +
        "|oooooooooooooooooooo|\n" +
        "|oooooooooooooooooooo|\n" +
        " --------------------";

    assertEquals(expectedString, canvas.toString());
  }

  @Test
  public void shouldFillBucketWithAnyCharsOnAnyDrawableObject() throws Exception {
    String[] params = {"10", "3", "@"};

    bucketCommand.exec(canvas, params);

    String expectedString = "" +
        " --------------------\n" +
        "|@@@@@@@@@@@@@@@@@@@@|\n" +
        "|@@@@@@@@@@@@@@@@@@@@|\n" +
        "|@@@@@@@@@@@@@@@@@@@@|\n" +
        "|@@@@@@@@@@@@@@@@@@@@|\n" +
        " --------------------";

    assertEquals(expectedString, canvas.toString());
  }


  @Test
  public void shouldThrowExceptionWhileUsingWrongCoords() throws Exception {
    String[] params = {"10", "5", "o"};

    String expectedMsg = "Invalid Coordinates";

    thrown.expect(Exception.class);
    thrown.expectMessage(expectedMsg);

    bucketCommand.exec(canvas, params);
  }
}