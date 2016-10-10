package com.cshk.drawing;

import com.cshk.drawing.models.Canvas;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Runner {
  private Drawing drawing;

  public void run() {
    System.out.println("Initialise canvas with command `C`, eg. C 20 4");

    Scanner in = new Scanner(System.in);
    init(in);
    System.out.println(drawing.toString());

    do {
      String cmdString = in.nextLine();
      try {
        drawing.draw(cmdString);
        System.out.println(drawing.toString());
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    } while (in.hasNextLine());
  }

  private void init(Scanner in) {
    String cmd = in.nextLine();
    drawing = parse(cmd);

    while (drawing == null) {
      System.out.println("Initialise failed, try again");
      init(in);
    }
  }

  private static Drawing parse(String cmd) {
    Matcher m = Pattern.compile("^(C|c)\\s(\\d+)\\s(\\d+)$").matcher(cmd);

    if (m.matches()) {
      Canvas canvas = new Canvas(Integer.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
      return new Drawing(canvas);
    }

    return null;
  }
}
