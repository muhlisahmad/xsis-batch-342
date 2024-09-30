package oop.data;

public class Circle extends Shape {
  private double radius;

  public Circle(double radius) {
    super();
    this.radius = radius;
    if (this.radius <= 0) {
      throw new IllegalArgumentException("Radius dari lingkaran tidak boleh bernilai negatif");
    }
  }

  @Override
  public double calculateArea() {
    this.area = Math.PI * Math.pow(radius, 2);
    return this.area;
  }


  @Override
  public double calculateCircumference() {
    this.circumference = Math.PI * 2 * radius;
    return this.circumference;
  }
  
}
