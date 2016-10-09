package com.cshk.drawing.commands;

import com.cshk.drawing.models.Fill;
import com.cshk.drawing.models.Coordinates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandParserTest {

  private Fill starFill;

  @Before
  public void setUp() throws Exception {
    starFill = new Fill("*");

  }

  @Test
  public void shouldParseLineCommand() throws Exception {
    CommandParser commandParser = new CommandParser("L 1 2 6 2");
    commandParser.parse();

    assertTrue(commandParser.getCommand() instanceof LineCommand);
    assertEquals(new Coordinates(1, 2, 6, 2), commandParser.getCoordinates());
    assertEquals(starFill.toString(), commandParser.getFill().toString());
  }

  @Test
  public void shouldParseFail4LineCommand() throws Exception {
    CommandParser commandParser = new CommandParser("X 1 2 4");
    boolean isSucceed = commandParser.parse();

    assertFalse(isSucceed);

    commandParser = new CommandParser("L 1 2");
    isSucceed = commandParser.parse();

    assertFalse(isSucceed);
  }
}