package com.cshk.drawing.commands;

import com.cshk.drawing.models.Canvas;

public abstract class Command {

  private String[] params;

  public abstract void exec(final Canvas canvas) throws Exception;

  public void setParams(String[] params) {
    this.params = params;
  }
  public String[] getParams() {
    return params;
  }

  public boolean isInRange(int target, int num1, int num2) {
    return Math.min(num1, num2) <= target && target <= Math.max(num1, num2);
  }
}
