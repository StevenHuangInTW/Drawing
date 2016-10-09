package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;
import com.cshk.drawing.models.Coordinates;
import com.cshk.drawing.models.Fill;

public interface ICommand {
  void exec(final Canvas canvas, final String[] params) throws Exception;
  void exec(final Canvas canvas, final Coordinates coords, final Fill fill) throws Exception;
}
