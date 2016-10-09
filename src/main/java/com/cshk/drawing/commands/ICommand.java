package com.cshk.drawing.commands;

import com.cshk.drawing.Drawing;
import com.cshk.drawing.models.Fill;
import com.cshk.drawing.models.Coordinates;

public interface ICommand {
  void exec(final Drawing drawing, final Coordinates coords, final Fill fill);
}
