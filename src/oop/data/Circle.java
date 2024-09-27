package oop.data;

public class Circle extends Shape {
  private double radius;

  // public Circle() {
  //   if (this.radius <= 0) {
  //     throw new IllegalArgumentException("Radius dari lingkaran tidak boleh bernilai negatif")
  //   }
  // }
  
  // public Circle(radius) {
  //   this.radius = radius;
  //   this();
  // }

  public Circle() {
    if (this.radius <= 0) {
      throw new IllegalArgumentException("Radius dari lingkaran tidak boleh bernilai negatif");
    }
  }

  public Circle(double radius) {
    this.radius = radius;
    if (this.radius <= 0) {
      throw new IllegalArgumentException("Radius dari lingkaran tidak boleh bernilai negatif");
    }
  }

  @Override
  public double calculateArea() {
    return Math.PI * Math.pow(radius, 2);
  }


  @Override
  public double calculateCircumference() {
    return Math.PI * 2 * radius;
  }
  
}
