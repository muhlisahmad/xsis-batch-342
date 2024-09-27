package oop.data;

import oop.interfaces.CanHasArea;
import oop.interfaces.CanHasCircumference;

public abstract class Shape implements CanHasArea, CanHasCircumference {
  @Override
  abstract public double calculateArea();

  @Override
  abstract public double calculateCircumference();  
}
