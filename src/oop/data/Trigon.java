package oop.data;

public class Trigon extends Shape {
  private double a, b, c;

  public Trigon(double a) {
    super();
    this.a = this.b = this.c = a;
    if (this.a <= 0 || this.b <= 0 || this.c <= 0) {
      throw new IllegalArgumentException("Semua sisi dari trigon tidak boleh bernilai negatif");
    }
  }
  
  public Trigon(double base, double height) {
    super();
    this.a = base;
    this.b = height;
    this.c = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    if (this.a <= 0 || this.b <= 0 || this.c <= 0) {
      throw new IllegalArgumentException("Semua sisi dari trigon tidak boleh bernilai negatif");
    }
  }
  
  public Trigon(double a, double b, double c) {
    super();
    this.a = a;
    this.b = b;
    this.c = c;
    if (this.a <= 0 || this.b <= 0 || this.c <= 0) {
      throw new IllegalArgumentException("Semua sisi dari trigon tidak boleh bernilai negatif");
    }
  }

  @Override
  public double calculateArea() {
    double semiPerimeter = (a + b + c) / 2;
    this.area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    return this.area;
  }

  @Override
  public double calculateCircumference() {
    this.circumference = a + b + c;
    return this.circumference;
    
  }
}
