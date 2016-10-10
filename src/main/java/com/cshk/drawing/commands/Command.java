package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;

public abstract class Command {
  private String[] params;

  public void setParams(String[] params) {
    this.params = params;
  }
  public String[] getParams() {
    return params;
  }

  public abstract void exec(final Canvas canvas) throws Exception;
}
