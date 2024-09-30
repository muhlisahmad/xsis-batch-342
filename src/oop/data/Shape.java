package oop.data;

import oop.interfaces.CanHasArea;
import oop.interfaces.CanHasCircumference;

public abstract class Shape implements CanHasArea, CanHasCircumference {
  protected double area;
  protected double circumference;
}
