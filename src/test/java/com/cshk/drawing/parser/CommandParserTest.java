package com.cshk.drawing.parser;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CommandParserTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void shouldThrowExceptionWhileUsingInvalidInput() throws Exception {
    String cmd1 = "L 1 2 6 a";

    String expectedMsg = "Invalid Command Format";

    thrown.expect(Exception.class);
    thrown.expectMessage(expectedMsg);

    CommandParser.process(cmd1);
  }
}