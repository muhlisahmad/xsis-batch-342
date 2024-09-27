package oop.data;

public class Trigon extends Shape {
  private double a, b, c;


  public Trigon(double a) {
    this.a = this.b = this.c = a;
    if (this.a <= 0 || this.b <= 0 || this.c <= 0) {
      throw new IllegalArgumentException("Semua sisi dari trigon tidak boleh bernilai negatif");
    }
  }
  
  public Trigon(double base, double height) {
    this.a = base;
    this.b = height;
    this.c = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    if (this.a <= 0 || this.b <= 0 || this.c <= 0) {
      throw new IllegalArgumentException("Semua sisi dari trigon tidak boleh bernilai negatif");
    }
  }
  
  public Trigon(double a, double b, double c) {
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
    return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
  }

  @Override
  public double calculateCircumference() {
    return a + b + c;
    
  }
}
