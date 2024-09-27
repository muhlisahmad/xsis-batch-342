package oop.data;

public class Tetragon extends Shape {
  private double side1, side2, side3, side4, diagonal1, diagonal2;

  public Tetragon(double side1, double side2, double side3, double side4, double diagonal1, double diagonal2) {
    if (side1 <= 0 || side2 <= 0 || side3 <= 0 || side4 <= 0 || diagonal1 <= 0 || diagonal2 <= 0) {
      throw new IllegalArgumentException("Semua sisi dan diagonal dari quadrilateral tidak boleh bernilai negatif");
    }

    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
    this.side4 = side4;
    this.diagonal1 = diagonal1;
    this.diagonal2 = diagonal2;

    if (!isValidQuadrilateral()) {
      throw new IllegalArgumentException("sisi dan diagonal yang diberikan tidak dapat membentuk quadrilateral yang valid");
    }
  }

  private boolean isValidQuadrilateral() {
    double s = (side1 + side2 + side3 + side4) / 2;
    double areaSquared = (s - side1) * (s - side2) * (s - side3) * (s - side4) - 0.25 * (side1*side3 + side2*side4 + diagonal1*diagonal2) * (side1*side3 + side2*side4 - diagonal1*diagonal2);
    return areaSquared >= 0;
  }

  @Override
  public double calculateArea() {
    double s = (side1 + side2 + side3 + side4) / 2;
    return Math.sqrt((s - side1) * (s - side2) * (s - side3) * (s - side4) - 0.25 * (side1*side3 + side2*side4 + diagonal1*diagonal2) * (side1*side3 + side2*side4 - diagonal1*diagonal2));
  }

  @Override
  public double calculateCircumference() {
    return side1 + side2 + side3;
  }
  
}
