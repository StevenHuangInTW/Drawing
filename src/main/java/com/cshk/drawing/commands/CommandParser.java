package com.cshk.drawing.commands;

import com.cshk.drawing.models.Fill;
import com.cshk.drawing.models.Coordinates;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {
  private String cmdString;
  private ICommand command;
  private Coordinates coordinates;
  private Fill fill;

  private final String BY_SPACE_CHAR = " ";

  private Map<String, ICommand> commandMap = new HashMap<String, ICommand>() {
    {
      put("L", new LineCommand());
    }
  };

  public CommandParser(final String cmdString) {
    this.cmdString = cmdString;
  }

  public boolean parse() {
    String[] cmdArray = cmdString.split(BY_SPACE_CHAR);

    command = commandMap.get(cmdArray[0]);
    if (command == null) return false;

    int twoCoordsLength = 5;
    int oneCoordsLength = 4;

    if (cmdArray.length == twoCoordsLength) {
      coordinates = new Coordinates(
          Integer.valueOf(cmdArray[1]),
          Integer.valueOf(cmdArray[2]),
          Integer.valueOf(cmdArray[3]),
          Integer.valueOf(cmdArray[4])
      );

      Fill starFill = new Fill("*");
      fill = starFill;
    } else if (cmdArray.length == oneCoordsLength) {
      coordinates = new Coordinates(
          Integer.valueOf(cmdArray[1]),
          Integer.valueOf(cmdArray[2])
      );

      fill = new Fill(cmdArray[3]);
    } else {
      return false;
    }

    return true;
  }

  public ICommand getCommand() {
    return command;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public Fill getFill() {
    return fill;
  }
}
