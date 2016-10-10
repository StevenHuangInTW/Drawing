package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class BucketCommandTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private Command bucketCommand;
  private Canvas canvas;

  @Before
  public void setUp() throws Exception {
    bucketCommand = new BucketCommand();
    canvas = new Canvas(20, 4);
  }

  @Test
  public void shouldFillBucketOnAnyDrawableObject() throws Exception {
    String[] params = {"10", "3", "o"};
    bucketCommand.setParams(params);

    bucketCommand.exec(canvas);

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
    bucketCommand.setParams(params);

    bucketCommand.exec(canvas);

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
    bucketCommand.setParams(params);

    String expectedMsg = "Invalid Coordinates";

    thrown.expect(Exception.class);
    thrown.expectMessage(expectedMsg);

    bucketCommand.exec(canvas);
  }
}