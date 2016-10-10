package com.cshk.drawing.parser;

import com.cshk.drawing.commands.BucketCommand;
import com.cshk.drawing.commands.Command;
import com.cshk.drawing.commands.LineCommand;
import com.cshk.drawing.commands.RectCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CommandParser {
  LINE("^(L|l)\\s(((\\d+)\\s){3}(\\d+))$", new LineCommand()),
  RECT("^(R|r)\\s(((\\d+)\\s){3}(\\d+))$", new RectCommand()),
  BUCKET("^(B|b)\\s(((\\d+)\\s){2}(.{1}))$", new BucketCommand());

  private final static String BY_SPACE_CHAR = " ";
  private final Pattern pattern;
  private final Command command;

  CommandParser(String regex, Command command) {
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

  public static Command process(String cmdString) throws Exception {
    CommandParser commandParser = getExecCommand(cmdString);

    if (commandParser == null) {
      throw new Exception("Invalid Command Format");
    }

    String[] params = commandParser.parseParams(cmdString);

    Command command = commandParser.command;
    command.setParams(params);

    return command;
  }
}
