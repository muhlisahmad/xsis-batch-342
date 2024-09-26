package oop.data;

import java.util.InputMismatchException;

public class SimpleCalculator {
  private float result;
  
  public SimpleCalculator() {
    this.result = 0;
  }
  
  public SimpleCalculator(float result) {
    this.result = result;
  }

  public float getResult() {
    return result;
  }

  public void setResult(float operand, String operation) throws InputMismatchException {
    switch (operation) {
      case "addition" -> result += operand;
      case "substraction" -> result -= operand;
      case "multiplication" -> result *= operand;
      case "division" -> result /= operand;
      default -> throw new InputMismatchException("Operation is not supported");
    }
  }
}
