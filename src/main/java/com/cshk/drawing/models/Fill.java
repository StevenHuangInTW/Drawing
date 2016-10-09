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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Fill fill = (Fill) o;

    return token != null ? token.equals(fill.token) : fill.token == null;

  }

  @Override
  public int hashCode() {
    return token != null ? token.hashCode() : 0;
  }
}
