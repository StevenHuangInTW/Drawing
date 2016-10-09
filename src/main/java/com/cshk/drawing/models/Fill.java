package com.cshk.drawing.models;

public class Fill {
  private final String token;

  public Fill() {
    this.token = " ";
  }

  public Fill(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return token;
  }
}
