package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CommandParser {
  LINE("^(L)\\s(((\\d+)\\s){3}(\\d+))$", new LineCommand()),
  RECT("^(R)\\s(((\\d+)\\s){3}(\\d+))$", new RectCommand());

  private final static String BY_SPACE_CHAR = " ";

  private final Pattern pattern;
  private final ICommand command;

  CommandParser(String regex, ICommand command) {
    this.pattern = Pattern.compile(regex);
    this.command = command;
  }

  private static CommandParser getExecCommand(String cmdString) {
    for (CommandParser cmd : CommandParser.values()) {
      Matcher m = cmd.pattern.matcher(cmdString);

      if (m.matches()) {
        return cmd;
      }
    }

    return null;
  }

  private String[] parseParams(String cmdString) {
    Matcher m = this.pattern.matcher(cmdString);

    m.matches();
    return m.group(2).split(BY_SPACE_CHAR);
  }

  public static void process(Canvas canvas, String cmdString) throws Exception {
    CommandParser commandParser = getExecCommand(cmdString);

    if (commandParser == null) {
      throw new Exception("Invalid Command Format");
    }

    String[] params = commandParser.parseParams(cmdString);

    commandParser.command.exec(canvas, params);
  }
}
